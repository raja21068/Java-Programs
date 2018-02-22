
public class PropertyDetailBean{
    private int propertyDatailId;
    private int areaId;
    private String areaSquareFeet;
    private String singleDoubleStory;
    private String numberRoom;
    private String kitchen;
    private String propertyType;
    private String location;
    private String price;
    private String dateUpload;
    private String description;
    private String forWhat;
    private String address;
    private int customerId;


    /*Setter Methods*/
    public void setPropertyDatailId(int propertyDatailId){
        this.propertyDatailId = propertyDatailId;
    }
    public void setAreaId(int areaId){
        this.areaId = areaId;
    }
    public void setAreaSquareFeet(String areaSquareFeet){
        this.areaSquareFeet = areaSquareFeet;
    }
    public void setSingleDoubleStory(String singleDoubleStory){
        this.singleDoubleStory = singleDoubleStory;
    }
    public void setNumberRoom(String numberRoom){
        this.numberRoom = numberRoom;
    }
    public void setKitchen(String kitchen){
        this.kitchen = kitchen;
    }
    public void setPropertyType(String propertyType){
        this.propertyType = propertyType;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public void setDateUpload(String dateUpload){
        this.dateUpload = dateUpload;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setForWhat(String forWhat){
        this.forWhat = forWhat;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    /*Getter Methods*/
    public int getPropertyDatailId(){
        return this.propertyDatailId;
    }
    public int getAreaId(){
        return this.areaId;
    }
    public String getAreaSquareFeet(){
        return this.areaSquareFeet;
    }
    public String getSingleDoubleStory(){
        return this.singleDoubleStory;
    }
    public String getNumberRoom(){
        return this.numberRoom;
    }
    public String getKitchen(){
        return this.kitchen;
    }
    public String getPropertyType(){
        return this.propertyType;
    }
    public String getLocation(){
        return this.location;
    }
    public String getPrice(){
        return this.price;
    }
    public String getDateUpload(){
        return this.dateUpload;
    }
    public String getDescription(){
        return this.description;
    }
    public String getForWhat(){
        return this.forWhat;
    }
    public String getAddress(){
        return this.address;
    }
    public int getCustomerId(){
        return this.customerId;
    }

    //@Override
    public String toString(){
        return "";
    }
}
