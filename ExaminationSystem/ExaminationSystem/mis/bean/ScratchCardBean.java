package bean;
// ** author @Jay K  **

public class ScratchCardBean{
  // Variables declaration - do not modify
    private int scratchCardId;
    private String scratchCardNo;
    private int amount;
    private java.util.Date dateOfCreate;
    private java.util.Date dateOfExpire;
    private java.util.Date dateOfUsed;
    private String remarks;




//Setter Methods Generated
    public void setScratchCardId(int scratchCardId){
        this.scratchCardId = scratchCardId ;
    }
    public void setScratchCardNo(String scratchCardNo){
        this.scratchCardNo = scratchCardNo ;
    }
    public void setAmount(int amount){
        this.amount = amount ;
    }
    public void setDateOfCreate(java.util.Date dateOfCreate){
        this.dateOfCreate = dateOfCreate ;
    }
    public void setDateOfExpire(java.util.Date dateOfExpire){
        this.dateOfExpire = dateOfExpire ;
    }
    public void setDateOfUsed(java.util.Date dateOfUsed){
        this.dateOfUsed = dateOfUsed ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getScratchCardId(){
        return this.scratchCardId ;
    }
    public String getScratchCardNo(){
        return this.scratchCardNo ;
    }
    public int getAmount(){
        return this.amount ;
    }
    public java.util.Date getDateOfCreate(){
        return this.dateOfCreate ;
    }
    public java.util.Date getDateOfExpire(){
        return this.dateOfExpire ;
    }
    public java.util.Date getDateOfUsed(){
        return this.dateOfUsed ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
