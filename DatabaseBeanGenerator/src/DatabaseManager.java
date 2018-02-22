/**
 *
 * @author Yougeshwar Khatri
 */

import java.sql.*;
import java.util.*;

public class DatabaseManager {
    private Connection con;
    private Vector<String> tablesName = new Vector<String>();
    private Hashtable<String, Vector<String>> columnsName = new Hashtable<String, Vector<String>>();
    private Hashtable<String, Vector<String>> columnsType = new Hashtable<String, Vector<String>>();
    
    public DatabaseManager(String classPath, String url, String user, String password)throws Exception{
        Class.forName(classPath);
        con = DriverManager.getConnection(url,user, password);
        getTablesName();
    }
    
    private void getTablesName()throws Exception{
        DatabaseMetaData md = con.getMetaData();
        ResultSet result = md.getTables(null, null, null, new String[]{"TABLE"});
        
        try{
            while(result.next()){
                String tableName = result.getString(3);
                tablesName.addElement(tableName);
                this.getColumnsName(tableName);
            }
        }finally{
            if(result != null) result.close();
        }        
    }
    
    private void getColumnsName(String tableName)throws Exception{
        Statement st = con.createStatement();        
        ResultSet result = st.executeQuery("SELECT * FROM "+tableName);
        ResultSetMetaData md = result.getMetaData();
        
        try{
            Vector<String> columnsName = new Vector<String>();
            Vector<String> columnsType = new Vector<String>();
            
            for (int i = 1; i <= md.getColumnCount(); i++){
                columnsName.addElement(md.getColumnName(i));
                columnsType.addElement(md.getColumnTypeName(i));
            }
            
            this.columnsName.put(tableName, columnsName);
            this.columnsType.put(tableName, columnsType);
            
        }finally{
            if(result != null) result.close();
            if(st != null) st.close();
        }
        
    }
    
    public Vector<String> getTable(){
        return this.tablesName;
    }
    public Hashtable<String, Vector<String>> getColumn(){
        return this.columnsName;
    }
    public Hashtable<String, Vector<String>> getColumnType(){
        return this.columnsType;
    }
}
