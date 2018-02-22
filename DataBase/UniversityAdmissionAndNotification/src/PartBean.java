
public class PartBean {
    private int partId;
    private int batchId;
    private int part;
    private int partYear;
    private String remarks;
    
    public int getPartId(){
        return partId;
    }
    public int getBatchId(){
        return batchId;
    }
    public int getPart(){
        return part;
    }
    public int getPartYear(){
        return partYear;
    }
    public String getRemarks(){
        return remarks;
    }    
    
    public void setPartId(int id){
        partId = id;
    }
    public void setBatchId(int id){
        batchId = id;
    }
    public void setPart(int part){
        this.part = part;
    }
    public void setPartYear(int year){
        partYear = year;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    public String toString(){
        return ""+part;
    }
}
