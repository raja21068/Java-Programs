package bean;

/**
 *
 * @author Jay Kumar
 */
public class TransactionDetailBean extends TransationBean{
    
    String certificateName;
    String rollNumber;
    String studentName;
    
    public void setCertificateName(String name){
        this.certificateName = name;
    }
    
    public void setRollNumber(String no){
        this.rollNumber = no;
    }
    
    public void setStudentName(String name){
        this.studentName = name;
    }
    public String getStudentName(){
        return studentName;
    }
    
    public String getCertificateName(){
        return certificateName;
    }
    
    public String getRollNumber(){
        return rollNumber;
    }

    @Override
    public String toString() {
        return certificateName+" - "+rollNumber;
    }
    
    
}
