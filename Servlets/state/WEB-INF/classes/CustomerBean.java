
public class CustomerBean{
    private int customerId;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String contactNo;
    private String email;
    private String user;
    private String password;

    /*Constructor*/
    public CustomerBean() {}

    /*Setter Methods*/
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setPassword(String password){
        this.password = password;
    }

    /*Getter Methods*/
    public int getCustomerId(){
        return this.customerId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getCity(){
        return this.city;
    }
    public String getAddress(){
        return this.address;
    }
    public String getContactNo(){
        return this.contactNo;
    }
    public String getEmail(){
        return this.email;
    }
    public String getUser(){
        return this.user;
    }
    public String getPassword(){
        return this.password;
    }

    //@Override
    public String toString(){
        return "";
    }
}
