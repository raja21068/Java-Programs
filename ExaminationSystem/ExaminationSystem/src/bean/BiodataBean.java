package bean;

import java.util.Hashtable;

/**
 *
 * @author DELL
 */
public class BiodataBean{
    private int studentId;
    private String message;
    private ScratchCardBean cardNo;
    private String time;
    private Hashtable<Integer,Integer> choices; // < ChoiceNumber, CertificateId >

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public void setMessage(String msg){
        this.message = msg;
    }
    public void setScratchCardBean(ScratchCardBean card){
        this.cardNo = card;
    }
    
    public void setTime(String t){
        this.time = t;
    }
    
    public void setChoices(Hashtable<Integer , Integer> choiceID){
        this.choices = choiceID;
    }


    public int getStudentId() {
        return studentId;
    }
    
    public String getMessage(){
        return message;
    }
   
    public ScratchCardBean getScratchCardBean(){
        return cardNo;
    }
    
   public String getTime(){
        return time;
    }
   
   public Hashtable<Integer , Integer> getChoices(){
       return choices;
   }
}
