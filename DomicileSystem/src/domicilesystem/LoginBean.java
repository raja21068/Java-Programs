/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domicilesystem;

/**
 *
 * @author Jetander
 */
public class LoginBean {
    private int id;
    private String user;
    private String password;
    
    @Override
    public String toString(){
    return user;
    }
    
    public int getId(){
    return id;
    }
    public void setId(int id){
    this.id = id;
    }
    
    public String getUser(){
    return user;
    }
    public void setUser(String user){
    this.user = user;
    }
    
    public String getPassword(){
    return password;
    }
    public void setPassword(String password){
    this.password = password;
    }
    
}
