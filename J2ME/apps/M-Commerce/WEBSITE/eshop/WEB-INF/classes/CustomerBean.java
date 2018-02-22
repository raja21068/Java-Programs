public class CustomerBean{
	private int customerId;
	private String firstName;
	private String lastName;
	private String city;
	private String street;
	private String state;
	private String country;
	private String address1;
	private String address2;
	private String email;
	private String contactNo;
	private java.util.Date dateOfRegistry;
	private String userName;
	private String userPassword;
	private String remarks;
	
	//setter methods
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}
	public void setFirstName(String firstName){
		this. firstName= firstName;
	}
	public void setLastName(String lastName){
		this. lastName= lastName;
	}
	public void setCity(String city){
		this.city = city;
	}
	public void setStreet(String street){
		this.street = street;
	}
	public void setState(String state){
		this.state = state;
	}
	public void setCountry(String country){
		this. country= country;
	}
	public void setAddress1(String address1){
		this.address1 = address1;
	}
	public void setAddress2(String address2){
		this.address2 = address2;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setContactNo(String contactNo){
		this.contactNo = contactNo;
	}
	public void setDateOfRegistry(java.util.Date dateOfRegistry){
		this.dateOfRegistry = dateOfRegistry;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}

	
	//getter methods
	public int getCustomerId(){
		return customerId;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getCity(){
		return city;
	}
	public String getStreet(){
		return street;
	}
	public String getState(){
		return state;
	}
	public String getCountry(){
		return country;
	}
	public String getAddress1(){
		return address1;
	}
	public String getAddress2(){
		return address2;
	}
	public String getEmail(){
		return email;
	}
	public String getContactNo(){
		return contactNo;
	}
	public java.util.Date getDateOfRegistry(){
		return dateOfRegistry;
	}
	public String getUserName(){
		return userName;
	}
	public String getUserPassword(){
		return userPassword;
	}
	public String getRemarks(){
		return remarks;
	}
	
}