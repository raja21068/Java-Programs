package message;


import forms.SmsSender;
import bean.BiodataBean;
import bean.CertificateBean;
import bean.ScratchCardBean;
import bean.StudentBean;
import database.DatabaseManager;
import forms.ScratchCardForm;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import utility.DateFormatter;

/**
 *
 * @author DELL
 */
public class MessageHandler extends Thread{
    
    String phone , message;
    public MessageHandler(String phoneNumber , String message){
        this.phone = "+"+phoneNumber;
        this.message = message;
        
    }
    @Override
    public void run(){
        System.out.println("Message Handler >>"+phone+"\n Message:"+message.trim() );
        System.out.println("Message Size >>"+message.trim().length() );
        
        //deleting expire data from Hashtable
         try{
            deleteExpireRequestFromHashTable();
        }catch(Exception ex){
            ex.printStackTrace();
        }
         
         try{
             BiodataBean b = (BiodataBean)SmsSender.infoTable.get(phone);
             // If client's first request
             if(b == null){
                 String s[] = message.trim().split(" ");
                 System.out.println(""+s.length);

                //Verify SMS Format
                if(s.length == 2 && s[1].length() == ScratchCardForm.CARD_DIGITS){
                    System.out.println("Entered into process...");
                    ScratchCardBean bean = DatabaseManager.getScratchCard(s[1]);
                    Date d = new Date();
                    Date cal = new Date(d.getYear(), d.getMonth(), d.getDate());

                    // if scratch card not found
                    if(bean == null){
                        System.out.println("Invalid Card No.");
                        SmsSender.connection.send(phone,"Invalid Card No..." );                     
                    }
                    // valid card
                    else if(bean.getDateOfUsed() == null && ( (cal.before(bean.getDateOfExpire())) || (cal.equals(bean.getDateOfExpire())) ) ){
                        System.out.println("Valid card..");
                        StudentBean stdBean = DatabaseManager.getStudent(s[0].toUpperCase());
                        if(stdBean != null){
                            System.out.println("Every thing is OK, Now process starts..");
                            String sms = ""+stdBean.getName()+"\n"+stdBean.getFname()+"\n"+stdBean.getRollNo();
                            ArrayList list = DatabaseManager.getAllCertificate(bean.getAmount());
                            BiodataBean biodata = new BiodataBean();
                            Hashtable<Integer,Integer> hash = new Hashtable<Integer,Integer>();
                            for(int i=0; i < list.size(); i++){
                                CertificateBean certificate = (CertificateBean)list.get(i);
                                sms += "\n"+(i+1)+"."+certificate.getCertificateName();
                                hash.put(i+1, certificate.getCertificateId());
                            }
                            System.out.println(""+sms);
                            sms += "\n Reply with any option..";
                            biodata.setStudentId(stdBean.getStudentId());
                            biodata.setTime(DateFormatter.toDateAndTime(new Date()));
                            biodata.setMessage(message);
                            biodata.setScratchCardBean(bean);
                            biodata.setChoices(hash);
                            SmsSender.infoTable.put(phone, biodata);
                            System.out.println("Added in Hastable.. \n sending SMS to "+phone);
                            SmsSender.connection.send(phone, sms);
                        }else{
                            SmsSender.connection.send(phone,"Invalid RollNo" );
                            System.out.println("Invalid RollNo");
                        }
                    }else if( (bean.getDateOfUsed() == null) && new Date().after(bean.getDateOfExpire()) ){
                        SmsSender.connection.send(phone,"Your Card is Expired.." );
                        System.out.println("Your card is Expired..");
                    }else{
                        SmsSender.connection.send(phone,"Your Card is already used.." );
                        System.out.println("Your is already used..");
                    }
                }
             }
             // If client's response on already succesfful request..
             else{
                 try{
                    Integer choice = Integer.parseInt(message.trim());
                    Hashtable h = b.getChoices();
                    Integer certificateId =(Integer) h.get(choice);
                    int studentId = b.getStudentId();
                    String today = DateFormatter.dateToStringYMD(new Date());
                    int scratchCardId = b.getScratchCardBean().getScratchCardId();
                    DatabaseManager.updateScratchCard(scratchCardId, today);
                    DatabaseManager.addTransation(studentId, today, certificateId, today,"");
                    SmsSender.infoTable.remove(phone);
                    SmsSender.connection.send(phone, "Your certificate is underprocess..");
                 }catch(Exception ex){
                     ex.printStackTrace();
                     //SmsSender.connection.send(phone, "Some Problem Ocuured,Try again process..");
                     //SmsSender.infoTable.remove(phone);
                 }
                }
         }catch(Exception ex){
             ex.printStackTrace();
         }
    }
    
    public void deleteExpireRequestFromHashTable(){
        Enumeration<String> en = SmsSender.infoTable.keys();
        String today = DateFormatter.toDateAndTime(new Date());
        int date = Integer.parseInt(today.split(",")[0]);
        int month = Integer.parseInt(today.split(",")[1]);
        int hour = Integer.parseInt(today.split(",")[2]);
        int min = Integer.parseInt(today.split(",")[3]);
        for(int i=0;i<SmsSender.infoTable.size();i++){
            String key = en.nextElement();
            BiodataBean b = SmsSender.infoTable.get(key);
            if(b==null)continue;
            String day = b.getTime();
            int dat = Integer.parseInt(day.split(",")[0]);
            int mon = Integer.parseInt(day.split(",")[1]);
            if(month!=mon){SmsSender.infoTable.remove(key);continue;}
            if(date>dat){SmsSender.infoTable.remove(key);continue;}
            int h = Integer.parseInt(day.split(",")[2]);
            int m = Integer.parseInt(day.split(",")[3]);
            if(hour>h && min>m){SmsSender.infoTable.remove(key);continue;}
        }
    }
    
}
