/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay K
 */
public class User {

    private int id;
    private String userName;
    private String password;
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public int getId(){
        return id;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return userName; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
