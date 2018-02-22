
public class AccountBean {
    private int account_id;
    private String account_name;
    private String address;
    private int account_type;
    private String remarks;
    
    // Setter Methods**
    public void setAccountId(int id){
       this.account_id = id; 
    }
    public void setAccountName(String name){
        this.account_name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setAccountType(int type){
       this.account_type = type; 
    }
    public void setRemarks(String remark){
        this.remarks = remark;
    }
    // Getter Methods**
    public int getAccountId(){
       return this.account_id ; 
    }
    public String getAccountName(){
        return this.account_name;
    }
    public String getAddress(){
        return this.address;
    }
    public int getAccountType(){
       return this.account_type; 
    }
    public String getRemarks(){
        return this.remarks;
    }
     public String toString(){
        return this.account_name;
    }
   
}
