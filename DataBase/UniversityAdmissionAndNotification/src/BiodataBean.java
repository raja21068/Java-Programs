/**
 *
 * @author DELL
 */
public class BiodataBean extends StudentBean{
    private int studentPartRegId;
    private int status;    
    private String message="";
    private ScratchCardBean cardNo;
    private int part;
    private String facultyName;
    private String time;
    
    public void setStudentPartRegId(int id){
        studentPartRegId = id;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
        
    public void setMessage(String msg){
        this.message = msg;
    }
    public void setScratchCardBean(ScratchCardBean card){
        this.cardNo = card;
    }

    public void setPart(int p){
        part = p;
    }
        
    public void setFacultyName(String fac){
        this.facultyName = fac;
    }
        
    public void setTime(String t){
        this.time = t;
    }
    
    
    
    
    public int getStudentPartRegId(){
        return studentPartRegId;
    }
    
    public int getStatus(){
      return status;
  }
    
    public String getMessage(){
        return message;
    }
   
    public ScratchCardBean getScratchCardBean(){
        return cardNo;
    }
  
    public int getPart(){
        return part;
  }
    
    public String getFacultyName(){
        return facultyName;
    }
    
    public String getTime(){
        return time;
    }
}
