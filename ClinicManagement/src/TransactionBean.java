/*
* TransactionBean.java
*
* Created on 02-May-2013 10:21:55 AM
*
*
* @author Raja Kumar
*/

public class TransactionBean{
    private int transactionId;
    private int dayId;
    private int doctorId;
    private String patientName;
    private String dispancy;
    private String disease;
    private String dignosic;
    private String lab;
    private int payment;

    /*Constructor*/
    public TransactionBean() {}

    /*Setter Methods*/
    public void setTransactionId(int transactionId){
        this.transactionId = transactionId;
    }
    public void setDayId(int dayId){
        this.dayId = dayId;
    }
    public void setDoctorId(int doctorId){
        this.doctorId = doctorId;
    }
    public void setPatientName(String patientName){
        this.patientName = patientName;
    }
    public void setDispancy(String dispancy){
        this.dispancy = dispancy;
    }
    public void setDisease(String disease){
        this.disease = disease;
    }
    public void setDignosic(String dignosic){
        this.dignosic = dignosic;
    }
    public void setLab(String lab){
        this.lab = lab;
    }
    public void setPayment(int payment){
        this.payment = payment;
    }

    /*Getter Methods*/
    public int getTransactionId(){
        return this.transactionId;
    }
    public int getDayId(){
        return this.dayId;
    }
    public int getDoctorId(){
        return this.doctorId;
    }
    public String getPatientName(){
        return this.patientName;
    }
    public String getDispancy(){
        return this.dispancy;
    }
    public String getDisease(){
        return this.disease;
    }
    public String getDignosic(){
        return this.dignosic;
    }
    public String getLab(){
        return this.lab;
    }
    public int getPayment(){
        return this.payment;
    }

    //@Override
    public String toString(){
        return "";
    }
}
