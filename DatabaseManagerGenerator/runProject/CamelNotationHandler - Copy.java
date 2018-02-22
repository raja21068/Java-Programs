/*
 * @author Jay Kumar
 */
public class CamelNotationHandler {
    
    public static String getTableType(String tableName){
        String[] pieces = tableName.split("_");
        tableName ="";
        for(String val: pieces ){
            tableName+=firstLetterCapital(val);
        }
        return tableName;
    }
    
    public static String firstLetterCapital(String str){
        String firstLetter = (""+str.charAt(0)).toUpperCase();
        String tailPortion = str.substring(1);
        str = firstLetter+tailPortion;
        return str;
    }
    
    public static String firstLetterSmall(String str){
        String firstLetter = (""+str.charAt(0)).toLowerCase();
        String tailPortion = str.substring(1);
        str = firstLetter+tailPortion;
        return str;
    }
    
    public static String getVariableType(String str){
        str = getTableType(str);
        str = firstLetterSmall(str);
        return str;
    }
    
    
}
