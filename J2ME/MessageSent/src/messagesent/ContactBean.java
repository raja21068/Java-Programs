
package messagesent;

/**
 *
 * @author Jay Kumar
 */
public class ContactBean {

    private String contactNumber;
    private String contactName;
    
    
    public ContactBean(){
    
    }
    
    public ContactBean(String no ,String name){
        contactNumber = no;
        contactName = name;
    }
    
    public String getContactNumber(){
        return contactNumber;
    }
    
    public String getContactName(){
        return contactName;
    }
    
    public void setContactName(String str){
        this.contactName = str;
    }
    
    public void setContactNumber(String str){
        this.contactNumber = str;
    }
}   
