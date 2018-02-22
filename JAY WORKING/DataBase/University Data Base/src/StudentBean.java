/**
 *
 * @author Jay Kumar
 */
public class StudentBean {
    int studentID;
    String stdName;
    String fName;
    String surname;
    String rollNo;
    String remarks;
    public void setName(String name){
         stdName = name;
    }
    public void setFName(String fname){
         fName = fname;
  }
    public void setSurname(String sName){
         surname = sName;
  }
    public void setRollNo(String no){
         rollNo = no;
  }
    public void setRemarks(String remarks){
     this.remarks = remarks;
  }
    
    public int getID(){
        return studentID;
    }
    public String getName(){
        return stdName;
    }
    public String getFName(){
        return fName;
    }
    public String getSurname(){
        return surname;
    }
    public String getRollNo(){
        return rollNo;
    }
    public String getRemarks(){
        return remarks;
    }
    public String toString(){
        return stdName;
    }
}
