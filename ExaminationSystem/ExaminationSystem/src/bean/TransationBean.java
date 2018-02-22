package bean;
// ** author @Jay K  **//

public class TransationBean{
  // Variables declaration - do not modify
    private int studentId;
    private int transationId;
    private java.util.Date transationDate;
    private int certifacateId;
    private java.util.Date dateOfRecieve;
    private String remarks;




//Setter Methods Generated
    public void setStudentId(int studentId){
        this.studentId = studentId ;
    }
    public void setTransationId(int transationId){
        this.transationId = transationId ;
    }
    public void setTransationDate(java.util.Date transationDate){
        this.transationDate = transationDate ;
    }
    public void setCertifacateId(int certifacateId){
        this.certifacateId = certifacateId ;
    }
    public void setDateOfRecieve(java.util.Date dateOfRecieve){
        this.dateOfRecieve = dateOfRecieve ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getStudentId(){
        return this.studentId ;
    }
    public int getTransationId(){
        return this.transationId ;
    }
    public java.util.Date getTransationDate(){
        return this.transationDate ;
    }
    public int getCertifacateId(){
        return this.certifacateId ;
    }
    public java.util.Date getDateOfRecieve(){
        return this.dateOfRecieve ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return transationDate.toString();
       }
}
