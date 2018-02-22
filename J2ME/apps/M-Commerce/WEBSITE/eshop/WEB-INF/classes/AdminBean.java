public class AdminBean{
	private int adminId;
	private String adminName;
	private String adminPassword;
	private String adminPrivilage;
	
	// Getter methods
	public int getAdminId(){
		return adminId;
	}
	public String getAdminName(){
		return adminName;
	}
	public String getAdminPassword(){
		return adminPassword;
	}
	public String getAdminPrivilage(){
		return adminPrivilage;
	}
	
	//Setter methods
	public void setAdminId(int adminId){
		this.adminId = adminId;
	}
	public void setAdminName(String adminName){
		this.adminName = adminName;
	}
	public void setAdminPassword(String adminPassword){
		this.adminPassword = adminPassword;
	}
	public void setAdminPrivilage(String adminPrivilage){
		this.adminPrivilage = adminPrivilage;
	}
	
}