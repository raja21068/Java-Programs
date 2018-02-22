import java.io.*;

public class BiodataBean implements Serializable{
    private String studentName;
    private String subject;
    private String rollNo;
    public void setStudentName(String name){
	studentName = name;
    }
    public void setSubject(String sub){
	subject = sub;
   }
    public void setRollNo(String no){
	rollNo = no;
   }

    public String getStudentName(){
	return studentName;
    }
    public String getSubject(){
	return subject;
    }
    public String getRollNo(){
	return rollNo;
    }

   public String toString(){
	return studentName;
   }
}