/**
 * @author Jay
 */
public class StudentBean {
    private String name;
    private String subject;
    private String rollno;
    private String marks;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    public void setRollno(String rollno){
        this.rollno = rollno;
    }
    
    public void setMarks(String marks){
        this.marks = marks;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSubject(){
        return subject;
    }
    
    public String getRollNo(){
        return rollno;
    }
    
    public String getMarks(){
        return marks;
    }
}
