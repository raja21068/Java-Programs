
public class YearBean {
    private int yearId;
    private int year;
    private int currentAmount;
    private String remarks;
    
    // Setter Methods**
    public void setYearId(int id){
       yearId = id; 
    }
    public void setYear(int year){
       this.year = year;
    }
    public void setCurrentAmount(int amount){
       this.currentAmount = amount;
    }
    public void setRemarks(String remark){
        this.remarks = remark;
    }
    //Getter Methods**
    public int getYearId(){
       return this.yearId; 
    }
    public int getYear(){
       return  this.year;
    }
    public int getCurrentAmount(){
       return this.currentAmount;
    }
    public String getRemarks(){
        return this.remarks;
    }
    public String toString(){
        return ""+this.year;
    }
    
}
