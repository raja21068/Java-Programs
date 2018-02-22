/**
 *
 * @author Yougeshwar Khatri
 */
public class TypeCasting {
    public static String getJavaType(String dbType){
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
        else if(dbType.equals("DATETIME")) return "java.util.Date";
        else if(dbType.equals("CURRENCY")) return "String";
        else if(dbType.equals("BIT")) return "boolean";
        else if(dbType.equals("LONGBINARY")) return "Object";
        return dbType; 
    }
}