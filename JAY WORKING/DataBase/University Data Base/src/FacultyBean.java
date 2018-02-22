/**
 *
 * @author Jay Kumar
 */
public class FacultyBean {
  int factID;
  String factName;
  String remarks;
 
  public void setFactName(String name){
      factName = name;
  }
  public void setRemarks(String remarks){
      this.remarks = remarks;
  }
  public int getFactID(){
      return factID;
  } 
  public String getFactName(){
      return factName;
  }
  public String getRemarks(){
      return remarks;
  }
  public String toString(){
      return factName;
  }
}
