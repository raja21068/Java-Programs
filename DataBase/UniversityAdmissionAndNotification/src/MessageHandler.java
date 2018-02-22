
import java.util.Date;
import java.util.Enumeration;

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
        }catch(Exception ex){}

        if(message.trim().equalsIgnoreCase("format")){SmsSender.connection.send(phone, "Purpose<space>rollNo<space>cardNumber"); return;}
        if(message.equals("0")){ SmsSender.infoTable.remove(phone);return; }
        if(message.trim().length()<3 && message.contains("1")){
            try {
                System.out.println("processing..");
                BiodataBean bean = SmsSender.infoTable.get(phone);
                if(bean==null){return;}
                
                DatabaseManager.UpdateScratchCard(bean.getScratchCardBean().getScratchCardId(),
                        bean.getScratchCardBean().getAmount(),Constant.USED , bean.getScratchCardBean().getScratchCardNo(),bean.getScratchCardBean().getPurpose() ,
                        DateFormatter.dateToStringMonthFormat(bean.getScratchCardBean().getValidUptoDate()), "");
                
                DatabaseManager.updateStudentPartRegistration(bean.getStudentPartRegId(),Constant.LEGAL,bean.getScratchCardBean().getScratchCardId(),
                        DateFormatter.dateToStringMonthFormat(new java.util.Date()) , "");
                
                SmsSender.connection.send(phone, "Your fees is succesfully paid..");
                SmsSender.infoTable.remove(phone);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if(message.length()>14 && (message.contains("Admin")||message.contains("Exam")||message.contains("Self"))){
            System.out.println("Entered in large condition");
            if(SmsSender.infoTable.contains(phone)){
                SmsSender.connection.send(phone, "You are already in process..");
                return;
            }
            try{
                String token[] = message.split(" ");
                String purpose = token[0];
                String rollNo = token[1];
                String cardNo = token[2];
            
                BiodataBean bioBean =DatabaseManager.getBiodata(rollNo);
                if(bioBean==null){SmsSender.connection.send(phone,"Process failurre..Invalid RollNo.. ");return;}
                if(bioBean.getMessage().contains("paid")){ SmsSender.connection.send(phone, "Your fees is already paid.."); return;}
                if(bioBean.getMessage().contains("error")){ SmsSender.connection.send(phone, "Your previous fees is not paid..contact with department.."); return;}
                
                
                int stdFacId = DatabaseManager.getStudentFacultyId(bioBean.getStudentId());
                ScratchCardBean scrCard = DatabaseManager.verifyCard(cardNo, TypeEncoder.encode(purpose.trim()), stdFacId , DateFormatter.dateToStringMonthFormat(new java.util.Date()));
                if(scrCard==null){SmsSender.connection.send(phone,"Invalid cardNo.."); return;}
                
                bioBean.setFacultyName(DatabaseManager.getFacultyName(stdFacId)); 
                
                bioBean.setScratchCardBean(scrCard);
                bioBean.setTime(DateFormatter.toDateAndTime(new Date()));
                SmsSender.infoTable.put(phone, bioBean);
                SmsSender.connection.send(phone,bioBean.getStudentName()+"\n"+bioBean.getFatherName()+"\n"+bioBean.getSurname()+"\n"+bioBean.getRollNo()+"\n for addmission in Part "+
                        "Part "+bioBean.getPart()+""+bioBean.getFacultyName()+" Do you like to proccess reply 1 for yes 0 for no");
                
            }catch(Exception ex){ex.printStackTrace();}
            
        }
    }
}
