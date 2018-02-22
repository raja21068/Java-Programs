/**
 *
 * @author Jay Kumar
 */
public class StudentBean {
    private int batchId;
    private int studentId;
    private String stdName;
    private String fName;
    private String surname;
    private String cnic;
    private String rollNo;
    private String cellNo;
    private int group;
    private int shift;
    private String address;
    private String remarks;
    public void setBatchId(int id){
        batchId = id;
    }
    
    public void setStudentId(int id){
        studentId = id;
    }
    
    public void setStudentName(String name){
         stdName = name;
    }
    
    public void setFatherName(String fname){
         fName = fname;
  }
    
    public void setSurname(String sName){
         surname = sName;
  }
    
    public void setCNIC(String nic){
         this.cnic = nic;
    }
    
    public void setRollNo(String no){
         rollNo = no;
  }
    
    public void setCellNo(String no){
         cellNo = no;
  }
    
    public void setGroup(int grp){
        this.group = grp;
    }
    
    public void setShift(int shift){
        this.shift = shift;
    }
    
    public void setAddress(String addr){
        this.address = addr;
    }
    
    public void setRemarks(String remarks){
     this.remarks = remarks;
  }
    
    
    public int getBatchId(){
        return batchId;
    }
    
    public int getStudentId(){
        return studentId;
    }
    
    public String getStudentName(){
        return stdName;
    }
    
    public String getFatherName(){
        return fName;
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
    
    public String getCellNo(){
        return cellNo;
    }
    
    public int getGroup(){
        return this.group;
    }
    public int getShift(){
        return this.shift;
    }
    public String getAddress(){
        return this.address;
    }
    public String getRemarks(){
        return remarks;
    }
    public String toString(){
        return stdName;
    }
}
