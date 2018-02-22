/**
 *
 * @author Jay Kumar
 */
public class TypeHandler {
    public static String getJavaType(String type){
        if(type.equals("BIT"))            { return "boolean";        }
        if(type.equals("BYTE"))           { return "byte";           }
        else if(type.equals("COUNTER"))   { return "int";            }
        else if(type.equals("CURRENCY"))  { return "String";         }
        else if(type.equals("DATETIME"))  { return "Date";           }
        else if(type.equals("DECIMAL"))   { return "double";         }
        else if(type.equals("DOUBLE"))    { return "int";            }
        else if(type.equals("LONGBINARY")){ return "byte[]";         }
        else if(type.equals("LONGCHAR"))  { return "String";         }
        else if(type.equals("LONGINTEGER")){ return "int";           }
        else if(type.equals("INTEGER"))   { return "int";            }
        else if(type.equals("INT"))       { return "int";            }
        else if(type.equals("SMALLINT"))  { return "int";            }
        else if(type.equals("VARCHAR"))   { return "String";         }
        return type;
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
    public static String getVbType(String dbType){
        if(dbType.equals("COUNTER")) return "As Integer";
        if(dbType.equals("INT")) return "As Integer";
        else if(dbType.equals("VARCHAR")) return "As String";
        else if(dbType.equals("LONGCHAR")) return "As String";
        else if(dbType.equals("LONGINTEGER")) return "As long";
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
}
