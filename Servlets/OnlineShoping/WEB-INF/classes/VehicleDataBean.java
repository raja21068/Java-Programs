
/**
 * This bean is for the searching purpose..
 * @author Jay Kumar
 */
public class VehicleDataBean extends VehicleBean{
    private String name;
    private String contact;
    private String city;
    private String email;
    
    //Setter methods
    public void setName(String Name){
        this.name = Name;
    }
    
    public void setContactNo(String contactNo){
        this.contact = contactNo;
    }
     
    public void setCity(String city){
        this.city = city;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    //Getter methods
    public String getUserName(){
        return this.name;
    }
    
    public String getContactNo(){
        return this.contact;
    }
    
    public String getCity(){
        return this.city;
    }

    public String getEmail(){
        return this.email;
    }    
}
