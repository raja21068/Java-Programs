
public class StudentPartRegistrationBean {
    private int studentId;
    private int parId;
    private int studentPartRegId;
    private int sratchCardId;
    private int status;
    private int challanNo;
    private java.util.Date dateOfPaid;
    private String remarks;
    private String studentName;
    private String fatherName;
    private String surname;
    private String cnic;
    private String rollNo;
    private int part;
    private int amount;
    
    public String toString(){
        return this.rollNo;
    }
    
    //**SETTER METHODS
    public void setStudentId(int id){
        studentId = id;
    }
    
    public void setParId(int id){
        parId = id;
    }
    
    public void setStudentPartRegId(int id){
        studentPartRegId = id;
    }
    
    public void setSratchCardId(int id){
        sratchCardId = id;
    }

    public void setStatus(int status){
      this.status = status;
    }
    public void setChallanNo(int challanNo){
      this.challanNo = challanNo;
    }
    
    public void setDateOfPaid(java.util.Date dateOfPaid){
        this.dateOfPaid = dateOfPaid;
    }

    public void setRemarks(String remarks){
     this.remarks = remarks;
    }
    
    public void setStudentName(String name){
         studentName = name;
    }
    
    public void setFatherName(String name){
        fatherName = name;
    }
    
     public void setSurname(String surname){
         this.surname = surname;
    }
    
    public void setCNIC(String nic){
         this.cnic = nic;
    }
    
    public void setRollNo(String no){
         this.rollNo = no;
    }
    
    public int getPart(){
        return part;
    }

    
    public void setAmount(int amount){
      this.amount = amount;
    }
     //**GETTER METHODS
    public int getStudentId(){
        return studentId;
    }    
    
    public int getParId(){
        return parId;
    }    
    
    public int getStudentPartRegId(){
        return studentPartRegId;
    }    
    
    public int getScratchCardId(){
        return sratchCardId;
    }    
    
    public int getStatus(){
      return status;
  }
    public int getChallanNo(){
      return challanNo;
  }
    
    public java.util.Date getDateOfPaid(){
       return this.dateOfPaid; 
    }
    
    public String getRemarks(){
        return remarks;
    }
    
    public String getStudentName(){
        return studentName;
    }
    
    public String getFatherName(){
        return fatherName;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getCNIC(){
         return this.cnic;
    }
    
    public String getRollNo(){
        return rollNo;
    }
    
    public void setPart(int part){
        this.part = part;
    }
        
    public int getAmount(){
      return amount;
    }
    
}
