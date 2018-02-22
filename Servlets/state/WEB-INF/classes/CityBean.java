
public class CityBean{
    private int cityId;
    private String cityName;
    private String remarks;


    /*Setter Methods*/
    public void setCityId(int cityId){
        this.cityId = cityId;
    }
    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getCityId(){
        return this.cityId;
    }
    public String getCityName(){
        return this.cityName;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return "";
    }
}
