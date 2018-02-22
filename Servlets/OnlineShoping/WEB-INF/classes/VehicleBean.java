/*
* VehicleBean.java
*
* Created on 09-Mar-2013 11:16:36 AM
*
*
* @author Raja Kumar
*/

public class VehicleBean{
    private int vehicalId;
    private int userId;
    private String companyMake;
    private String vehicalName;
    private String vehicalType;
    private String modelYear;
    private String color;
    private String registeredYear;
    private String registeredCity;
    private int priceDemand;
    private boolean ac;
    private String fuleType;
    private boolean powerWindow;
    private String transmission;
    private String condition;
    private String mileage;
    private String doorCount;
    private String engineType;
    private String remarks;
    private java.util.Date dateOfUpload;

    /*Constructor*/
    public VehicleBean() {}

    /*Setter Methods*/
    public void setVehicalId(int vehicalId){
        this.vehicalId = vehicalId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public void setCompanyMake(String companyMake){
        this.companyMake = companyMake;
    }
    public void setVehicalName(String vehicalName){
        this.vehicalName = vehicalName;
    }
    public void setVehicalType(String vehicalType){
        this.vehicalType = vehicalType;
    }
    public void setModelYear(String modelYear){
        this.modelYear = modelYear;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setRegisteredYear(String registeredYear){
        this.registeredYear = registeredYear;
    }
    public void setRegisteredCity(String registeredCity){
        this.registeredCity = registeredCity;
    }
    public void setPriceDemand(int priceDemand){
        this.priceDemand = priceDemand;
    }
    public void setAc(boolean ac){
        this.ac = ac;
    }
    public void setFuleType(String fuleType){
        this.fuleType = fuleType;
    }
    public void setPowerWindow(boolean powerWindow){
        this.powerWindow = powerWindow;
    }
    public void setTransmission(String transmission){
        this.transmission = transmission;
    }
    public void setCondition(String condition){
        this.condition = condition;
    }
    public void setMileage(String mileage){
        this.mileage = mileage;
    }
    public void setDoorCount(String doorCount){
        this.doorCount = doorCount;
    }
    public void setEngineType(String engineType){
        this.engineType = engineType;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    public void setDateOfUpload(java.util.Date dateOfUpload){
        this.dateOfUpload = dateOfUpload;
    }

    /*Getter Methods*/
    public int getVehicalId(){
        return this.vehicalId;
    }
    public int getUserId(){
        return this.userId;
    }
    public String getCompanyMake(){
        return this.companyMake;
    }
    public String getVehicalName(){
        return this.vehicalName;
    }
    public String getVehicalType(){
        return this.vehicalType;
    }
    public String getModelYear(){
        return this.modelYear;
    }
    public String getColor(){
        return this.color;
    }
    public String getRegisteredYear(){
        return this.registeredYear;
    }
    public String getRegisteredCity(){
        return this.registeredCity;
    }
    public int getPriceDemand(){
        return this.priceDemand;
    }
    public boolean getAc(){
        return this.ac;
    }
    public String getFuleType(){
        return this.fuleType;
    }
    public boolean getPowerWindow(){
        return this.powerWindow;
    }
    public String getTransmission(){
        return this.transmission;
    }
    public String getCondition(){
        return this.condition;
    }
    public String getMileage(){
        return this.mileage;
    }
    public String getDoorCount(){
        return this.doorCount;
    }
    public String getEngineType(){
        return this.engineType;
    }
    public String getRemarks(){
        return this.remarks;
    }
    public java.util.Date getDateOfUpload(){
        return this.dateOfUpload;
    }

    //@Override
    public String toString(){
        return "";
    }
}
