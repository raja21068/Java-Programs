/*
* UsersBean.java
*
* Created on 09-Mar-2013 11:16:36 AM
*
*
* @author Raja Kumar
*/

public class UsersBean{
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private String address;
    private String contactNo;
    private String city;
    private String state;
    private String country;

    /*Constructor*/
    public UsersBean() {}

    /*Setter Methods*/
    public void setUserId(int userId){
        this.userId = userId;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setCountry(String country){
        this.country = country;
    }

    /*Getter Methods*/
    public int getUserId(){
        return this.userId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getAddress(){
        return this.address;
    }
    public String getContactNo(){
        return this.contactNo;
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public String getCountry(){
        return this.country;
    }

    //@Override
    public String toString(){
        return "";
    }
}
