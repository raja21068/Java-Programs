
public class ScratchCardBean {
    private int facultyId;
    private int scratchCardId;
    private int amount;
    private int status;
    private int purpose;
    private String cardNo;
    private String remarks;
    private java.util.Date validate;
    
  //** SETTER METHODS  
  public void setFacultyId(int id){
      this.facultyId = id;
  }

  public void setAmount(int amount){
      this.amount = amount;
  }
  
  public void setScratchCardId(int scratchCardId){
      this.scratchCardId = scratchCardId;
  }
  
  public void setPurpose(int purpose){
      this.purpose = purpose;
  }
  
  public void setStatus(int status){
      this.status = status;
  }
  
  public void setScratchCardNo(String cardNo){
        this.cardNo = cardNo;
  }
  
  public void setValidUptoDate(java.util.Date validate){
        this.validate = validate;
  }
  
  public void setRemarks(String remarks){
        this.remarks = remarks;
   }
  
  //** GETTER METHODS  
  public int getFacultyId(){
      return facultyId;
  } 

  public int getAmount(){
      return amount;
  } 
  
  public int getScratchCardId(){
      return scratchCardId;
  } 
  
  public int getStatus(){
      return status;
  } 
  
  public int getPurpose(){
      return purpose;
  } 
  public String getScratchCardNo(){
        return cardNo;
    }
  
   public java.util.Date getValidUptoDate(){
       return this.validate; 
    }
 
   public String getRemarks(){
        return remarks;
    }
   
   public String toString(){
    return this.cardNo;
    }
}
