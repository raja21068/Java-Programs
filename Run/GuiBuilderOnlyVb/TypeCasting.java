// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 10/22/2012 11:12:24 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TypeCasting.java


public class TypeCasting
{

    public TypeCasting()
    {
    }

    public static String getQuatation(String dbType, String columnName)
    {
        if(dbType.equals("VARCHAR"))
            return (new StringBuilder()).append("'\"+").append(columnName).append("+\"'").toString();
        if(dbType.equals("LONGCHAR"))
            return (new StringBuilder()).append("'\"+").append(columnName).append("+\"'").toString();
        if(dbType.equals("DATETIME"))
            return (new StringBuilder()).append("#\"+").append(columnName).append("+\"#").toString();
        else
            return (new StringBuilder()).append("\"+").append(columnName).append("+\"").toString();
    }

    public static String getResultSetType(String dbType)
    {
        if(dbType.equals("COUNTER"))
            return "Int";
        if(dbType.equals("INT"))
            return "Int";
        if(dbType.equals("VARCHAR"))
            return "String";
        if(dbType.equals("LONGCHAR"))
            return "String";
        if(dbType.equals("INTEGER"))
            return "Int";
        if(dbType.equals("DOUBLE"))
            return "Double";
        if(dbType.equals("DECIMAL"))
            return "Float";
        if(dbType.equals("SMALLINT"))
            return "Short";
        if(dbType.equals("BYTE"))
            return "Byte";
        if(dbType.equals("DATETIME"))
            return "Date";
        if(dbType.equals("CURRENCY"))
            return "String";
        if(dbType.equals("BIT"))
            return "Boolean";
        if(dbType.equals("LONGBINARY"))
            return "Object";
        else
            return dbType;
    }

    public static String getJavaType(String dbType)
    {
        if(dbType.equals("COUNTER"))
            return "int";
        if(dbType.equals("INT"))
            return "int";
        if(dbType.equals("VARCHAR"))
            return "String";
        if(dbType.equals("LONGCHAR"))
            return "String";
        if(dbType.equals("LONGINTEGER"))
            return "long";
        if(dbType.equals("INTEGER"))
            return "int";
        if(dbType.equals("DOUBLE"))
            return "double";
        if(dbType.equals("DECIMAL"))
            return "float";
        if(dbType.equals("SMALLINT"))
            return "short";
        if(dbType.equals("BYTE"))
            return "byte";
        if(dbType.equals("DATETIME"))
            return "java.util.Date";
        if(dbType.equals("CURRENCY"))
            return "String";
        if(dbType.equals("BIT"))
            return "boolean";
        if(dbType.equals("LONGBINARY"))
            return "Object";
        else
            return dbType;
    }
    
    public static String getJavaMethodType(String dbType)
    {
        if(dbType.equals("COUNTER"))
            return "Int";
        if(dbType.equals("INT"))
            return "Int";
        if(dbType.equals("VARCHAR"))
            return "String";
        if(dbType.equals("LONGCHAR"))
            return "String";
        if(dbType.equals("LONGINTEGER"))
            return "Long";
        if(dbType.equals("INTEGER"))
            return "Int";
        if(dbType.equals("DOUBLE"))
            return "Double";
        if(dbType.equals("DECIMAL"))
            return "Float";
        if(dbType.equals("SMALLINT"))
            return "Short";
        if(dbType.equals("BYTE"))
            return "Byte";
        if(dbType.equals("DATETIME"))
            return "Date";
        if(dbType.equals("CURRENCY"))
            return "String";
        if(dbType.equals("BIT"))
            return "Boolean";
        if(dbType.equals("LONGBINARY"))
            return "Object";
        else
            return dbType;
    }
    
    public static String getVbType(String dbType){
        if(dbType.equals("COUNTER")) return "As Integer";
        if(dbType.equals("INT")) return "As Integer";
        else if(dbType.equals("VARCHAR")) return "As String";
        else if(dbType.equals("LONGCHAR")) return "As String";
        else if(dbType.equals("LONGINTEGER")) return "As Long";
        else if(dbType.equals("INTEGER")) return "As Integer";
        else if(dbType.equals("DOUBLE")) return "As Double";
        else if(dbType.equals("DECIMAL")) return "As Decimal";
        else if(dbType.equals("SMALLINT")) return "As Short";
        else if(dbType.equals("BYTE")) return "As Byte";
        else if(dbType.equals("DATETIME")) return "As Date";
        else if(dbType.equals("CURRENCY")) return "As String";
        else if(dbType.equals("BIT")) return "As Boolean";
        else if(dbType.equals("LONGBINARY")) return "As Object";
        return dbType; 
    }
    
    public static String getVbMethodType(String dbType){
        if(dbType.equals("COUNTER")) return "Int32";
        if(dbType.equals("INT")) return "Int32";
        else if(dbType.equals("VARCHAR")) return "String";
        else if(dbType.equals("LONGCHAR")) return "String";
        else if(dbType.equals("LONGINTEGER")) return "Int64";
        else if(dbType.equals("INTEGER")) return "Int32";
        else if(dbType.equals("DOUBLE")) return "Double";
        else if(dbType.equals("DECIMAL")) return "Float";
        else if(dbType.equals("SMALLINT")) return "Short";
        else if(dbType.equals("BYTE")) return "Byte";
        else if(dbType.equals("DATETIME")) return "DateTime";
        else if(dbType.equals("CURRENCY")) return "String";
        else if(dbType.equals("BIT")) return "Boolean";
        else if(dbType.equals("LONGBINARY")) return "LifetimeService";
        return dbType; 
    }
    public static String getCSharpType(String dbType){
        if(dbType.equals("COUNTER")) return "int";
        if(dbType.equals("INT")) return "int";
        else if(dbType.equals("VARCHAR")) return "String";
        else if(dbType.equals("LONGCHAR")) return "String";
        else if(dbType.equals("LONGINTEGER")) return "long";
        else if(dbType.equals("INTEGER")) return "int";
        else if(dbType.equals("DOUBLE")) return "double";
        else if(dbType.equals("DECIMAL")) return "float";
        else if(dbType.equals("SMALLINT")) return "short";
        else if(dbType.equals("BYTE")) return "byte";
        else if(dbType.equals("DATETIME")) return "DateTime";
        else if(dbType.equals("CURRENCY")) return "String";
        else if(dbType.equals("BIT")) return "boolean";
        else if(dbType.equals("LONGBINARY")) return "Object";
        return dbType; 
    }
}
