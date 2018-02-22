// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 10/22/2012 11:09:03 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DatabaseManager.java

import java.io.PrintStream;
import java.sql.*;
import java.util.Hashtable;
import java.util.Vector;

public class DatabaseManager
{

    public DatabaseManager(String classPath, String url, String user, String password)
        throws Exception
    {
        tablesName = new Vector();
        columnsName = new Hashtable();
        columnsType = new Hashtable();
        primeryKeys = new Hashtable();
        Class.forName(classPath);
        con = DriverManager.getConnection(url, user, password);
        getTablesName();
    }

    private void getTablesName()
        throws Exception
    {
        ResultSet result;
        DatabaseMetaData md = con.getMetaData();
        result = md.getTables(null, null, "%", new String[] {
            "TABLE"
        });
        while(result.next()) 
        {
            String tableName = result.getString(3);
            System.out.println(tableName);
            tablesName.addElement(tableName);
            getColumnsName(tableName);
        }
        if(result == null)
           result.close();
//        break MISSING_BLOCK_LABEL_98;
//       Exception exception;
//        exception;
//        if(result != null)
//            result.close();
//        throw exception;
    }

    private void getColumnsName(String tableName)
        throws Exception
    {
        String query;
        Statement st;
        ResultSet result;
        ResultSet rsPrimeryKey;
        query = (new StringBuilder()).append("SELECT * FROM ").append(tableName).toString();
        System.out.println(query);
        st = null;
        result = null;
        ResultSetMetaData mdColumnsName = null;
        rsPrimeryKey = null;
        st = con.createStatement();
        result = st.executeQuery(query);
        mdColumnsName = result.getMetaData();
        rsPrimeryKey = con.getMetaData().getIndexInfo(null, null, tableName, false, false);
        Vector columnsName = new Vector();
        Vector columnsType = new Vector();
        for(int i = 1; i <= mdColumnsName.getColumnCount(); i++)
        {
            columnsName.addElement(mdColumnsName.getColumnName(i));
            columnsType.addElement(mdColumnsName.getColumnTypeName(i));
        }

        do
        {
            if(!rsPrimeryKey.next())
                break;
            String rel = rsPrimeryKey.getString("INDEX_NAME");
            String col = rsPrimeryKey.getString("COLUMN_NAME");
            if(rel != null && col != null && (rel.equals("PrimaryKey") || rel.equals("PRIMARY")))
                primeryKeys.put(tableName, col);
        } while(true);
        this.columnsName.put(tableName, columnsName);
        this.columnsType.put(tableName, columnsType);
//        if(result != null)
//            result.close();
//        if(rsPrimeryKey != null)
//            rsPrimeryKey.close();
//        if(st != null)
//            st.close();
//        break MISSING_BLOCK_LABEL_328;
//        Exception exception;
//        exception;
//        if(result != null)
//            result.close();
//        if(rsPrimeryKey != null)
//            rsPrimeryKey.close();
//        if(st != null)
//            st.close();
//        throw exception;
    }

    public Vector getTable()
    {
        return tablesName;
    }

    public Hashtable getColumn()
    {
        return columnsName;
    }

    public Hashtable getColumnType()
    {
        return columnsType;
    }

    public String getPrimeryKeyColumn(String table)
    {
        return (String)primeryKeys.get(table);
    }

    private Connection con;
    private Vector tablesName;
    private Hashtable columnsName;
    private Hashtable columnsType;
    private Hashtable primeryKeys;
}
