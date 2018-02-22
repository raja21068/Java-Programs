/**
 *
 * @author Yougeshwar Khatri
 */
public class ComboBoxItem {    
    private String dbName;
    private String driverClass;
    private String url;
    private String user;
    private String password;
    
    public ComboBoxItem(String dbName, String driverClass, String url, String user, String password){
        this.dbName = dbName;
        this.driverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    public String getDBName(){
        return this.dbName;
    }
    public String getDriverClass(){
        return this.driverClass;
    }
    public String getURL(){
        return this.url;
    }
    public String getUser(){
        return this.user;
    }
    public String getPassword(){
        return this.password;
    }
    
    @Override
    public String toString(){
        return this.dbName;
    }    
}
