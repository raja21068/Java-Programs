
public class AreaBean{
    private int areaId;
    private int cityId;
    private String areaName;
    private String remarks;

    /*Setter Methods*/
    public void setAreaId(int areaId){
        this.areaId = areaId;
    }
    public void setCityId(int cityId){
        this.cityId = cityId;
    }
    public void setAreaName(String areaName){
        this.areaName = areaName;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getAreaId(){
        return this.areaId;
    }
    public int getCityId(){
        return this.cityId;
    }
    public String getAreaName(){
        return this.areaName;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return "";
    }
}
