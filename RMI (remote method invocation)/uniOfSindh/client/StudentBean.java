import java.io.*;
/**
 *
 * @author Jay Kumar
 */
public class StudentBean implements Serializable{
    private int batchID;
    private int studentID;
    private String stdName;
    private String fName;
    private String surname;
    private String cnic;
    private String rollNo;
    private String group;
    private String shift;
    private String address;
    private String remarks;
    public void setBatchId(int id){
        batchID = id;
    }
    public void setStudentId(int id){
        studentID = id;
    }
    public void setStudentName(String name){
         stdName = name;
    }
    public void setFName(String fname){
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
    public void setGroup(String grp){
        this.group = grp;
    }
    public void setShift(String shift){
        this.shift = shift;
    }
    public void setAddress(String addr){
        this.address = addr;
    }
    public void setRemarks(String remarks){
     this.remarks = remarks;
  }
    
    public int getBatchId(){
        return batchID;
    }
    public int getStudentID(){
        return studentID;
    }
    public String getStudentName(){
        return stdName;
    }
    public String getFName(){
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
    public String getGroup(){
        return this.group;
    }
    public String getShift(){
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
