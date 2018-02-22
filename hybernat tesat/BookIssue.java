class BookIssue{
  // Variables declaration - do not modify
    private int issueId;
    private int catDetailId;
    private java.util.Date dateOfIssue;
    private java.util.Date dateOfReturn;
    private int fineAmount;
    private int stdId;
    private String remarks;

    public BookIssue(){}
public BookIssue(int catDetailId, java.util.Date dateOfIssue, java.util.Date dateOfReturn, int fineAmount, int stdId, String remarks){
this.catDetailId = catDetailId;
this.dateOfIssue = dateOfIssue;
this.dateOfReturn = dateOfReturn;
this.fineAmount = fineAmount;
this.stdId = stdId;
this.remarks = remarks;}



//Setter Methods Generated
    public void setIssueId(int issueId){
        this.issueId = issueId ;
    }
    public void setCatDetailId(int catDetailId){
        this.catDetailId = catDetailId ;
    }
    public void setDateOfIssue(java.util.Date dateOfIssue){
        this.dateOfIssue = dateOfIssue ;
    }
    public void setDateOfReturn(java.util.Date dateOfReturn){
        this.dateOfReturn = dateOfReturn ;
    }
    public void setFineAmount(int fineAmount){
        this.fineAmount = fineAmount ;
    }
    public void setStdId(int stdId){
        this.stdId = stdId ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getIssueId(){
        return this.issueId ;
    }
    public int getCatDetailId(){
        return this.catDetailId ;
    }
    public java.util.Date getDateOfIssue(){
        return this.dateOfIssue ;
    }
    public java.util.Date getDateOfReturn(){
        return this.dateOfReturn ;
    }
    public int getFineAmount(){
        return this.fineAmount ;
    }
    public int getStdId(){
        return this.stdId ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
