/**
 *
 * @author Jay Kumar
 */
public class FacultyBean {
  private int facultyId;
  private String facultyName;
  private String remarks;
  
  public void setFacultyId(int id){
      this.facultyId = id;
  }
 
  public void setFacultyName(String name){
      facultyName = name;
  }
  public void setRemarks(String remarks){
      this.remarks = remarks;
  }
  public int getFacultyId(){
      return facultyId;
  } 
  public String getFacultyName(){
      return facultyName;
  }
  public String getRemarks(){
      return remarks;
  }
  public String toString(){
      return facultyName;
  }
}
