
public class VehicleBean{
    private int id;
    private String company;
    private String model;
    private String color;
    private String register;
    private String price;
    private boolean ac;
    private boolean cng;
    private boolean powerWindow;
    private int transmission;
    private String owner;
    private String contactNo;
    private String email;
    private String address;
    private String pictures;

    /*Constructor*/
    public VehicleBean() {}

    /*Setter Methods*/
    public void setId(int id){
        this.id = id;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setRegister(String register){
        this.register = register;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public void setAc(boolean ac){
        this.ac = ac;
    }
    public void setCng(boolean cng){
        this.cng = cng;
    }
    public void setPowerWindow(boolean powerWindow){
        this.powerWindow = powerWindow;
    }
    public void setTransmission(int transmission){
        this.transmission = transmission;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPictures(String pictures){
        this.pictures = pictures;
    }

    /*Getter Methods*/
    public int getId(){
        return this.id;
    }
    public String getCompany(){
        return this.company;
    }
    public String getModel(){
        return this.model;
    }
    public String getColor(){
        return this.color;
    }
    public String getRegister(){
        return this.register;
    }
    public String getPrice(){
        return this.price;
    }
    public boolean getAc(){
        return this.ac;
    }
    public boolean getCng(){
        return this.cng;
    }
    public boolean getPowerWindow(){
        return this.powerWindow;
    }
    public int getTransmission(){
        return this.transmission;
    }
    public String getOwner(){
        return this.owner;
    }
    public String getContactNo(){
        return this.contactNo;
    }
    public String getEmail(){
        return this.email;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPictures(){
        return this.pictures;
    }

    //@Override
    public String toString(){
        return "";
    }
}
