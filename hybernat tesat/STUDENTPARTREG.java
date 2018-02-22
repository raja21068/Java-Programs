class STUDENTPARTREG{
  // Variables declaration - do not modify
    private int stdPartRegId;
    private int partId;
    private int stdId;
    private int scractchCardId;
    private int status;
    private java.util.Date dataOfPaid;
    private String remarks;
    private String chalanNo;
    private int amount;

    public STUDENTPARTREG(){}
public STUDENTPARTREG(int partId, int stdId, int scractchCardId, int status, java.util.Date dataOfPaid, String remarks, String chalanNo, int amount){
this.partId = partId;
this.stdId = stdId;
this.scractchCardId = scractchCardId;
this.status = status;
this.dataOfPaid = dataOfPaid;
this.remarks = remarks;
this.chalanNo = chalanNo;
this.amount = amount;}



//Setter Methods Generated
    public void setStdPartRegId(int stdPartRegId){
        this.stdPartRegId = stdPartRegId ;
    }
    public void setPartId(int partId){
        this.partId = partId ;
    }
    public void setStdId(int stdId){
        this.stdId = stdId ;
    }
    public void setScractchCardId(int scractchCardId){
        this.scractchCardId = scractchCardId ;
    }
    public void setStatus(int status){
        this.status = status ;
    }
    public void setDataOfPaid(java.util.Date dataOfPaid){
        this.dataOfPaid = dataOfPaid ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }
    public void setChalanNo(String chalanNo){
        this.chalanNo = chalanNo ;
    }
    public void setAmount(int amount){
        this.amount = amount ;
    }




//Getter Methods Generated
    public int getStdPartRegId(){
        return this.stdPartRegId ;
    }
    public int getPartId(){
        return this.partId ;
    }
    public int getStdId(){
        return this.stdId ;
    }
    public int getScractchCardId(){
        return this.scractchCardId ;
    }
    public int getStatus(){
        return this.status ;
    }
    public java.util.Date getDataOfPaid(){
        return this.dataOfPaid ;
    }
    public String getRemarks(){
        return this.remarks ;
    }
    public String getChalanNo(){
        return this.chalanNo ;
    }
    public int getAmount(){
        return this.amount ;
    }

    public String toString(){
        return "";
       }
}
