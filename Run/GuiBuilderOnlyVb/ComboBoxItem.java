// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 10/22/2012 11:09:44 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ComboBoxItem.java


public class ComboBoxItem
{

    public ComboBoxItem(String dbName, String driverClass, String url, String user, String password)
    {
        this.dbName = dbName;
        this.driverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getDBName()
    {
        return dbName;
    }

    public String getDriverClass()
    {
        return driverClass;
    }

    public String getURL()
    {
        return url;
    }

    public String getUser()
    {
        return user;
    }

    public String getPassword()
    {
        return password;
    }

    public String toString()
    {
        return dbName;
    }

    private String dbName;
    private String driverClass;
    private String url;
    private String user;
    private String password;
}
