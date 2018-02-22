class SCRATCHCARD{
  // Variables declaration - do not modify
    private int scratchCardId;
    private int facId;
    private int amount;
    private String status;
    private String cardNo;
    private String purpose;
    private java.util.Date vaildUpToDate;
    private String remarks;

    public SCRATCHCARD(){}
public SCRATCHCARD(int facId, int amount, String status, String cardNo, String purpose, java.util.Date vaildUpToDate, String remarks){
this.facId = facId;
this.amount = amount;
this.status = status;
this.cardNo = cardNo;
this.purpose = purpose;
this.vaildUpToDate = vaildUpToDate;
this.remarks = remarks;}



//Setter Methods Generated
    public void setScratchCardId(int scratchCardId){
        this.scratchCardId = scratchCardId ;
    }
    public void setFacId(int facId){
        this.facId = facId ;
    }
    public void setAmount(int amount){
        this.amount = amount ;
    }
    public void setStatus(String status){
        this.status = status ;
    }
    public void setCardNo(String cardNo){
        this.cardNo = cardNo ;
    }
    public void setPurpose(String purpose){
        this.purpose = purpose ;
    }
    public void setVaildUpToDate(java.util.Date vaildUpToDate){
        this.vaildUpToDate = vaildUpToDate ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getScratchCardId(){
        return this.scratchCardId ;
    }
    public int getFacId(){
        return this.facId ;
    }
    public int getAmount(){
        return this.amount ;
    }
    public String getStatus(){
        return this.status ;
    }
    public String getCardNo(){
        return this.cardNo ;
    }
    public String getPurpose(){
        return this.purpose ;
    }
    public java.util.Date getVaildUpToDate(){
        return this.vaildUpToDate ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
