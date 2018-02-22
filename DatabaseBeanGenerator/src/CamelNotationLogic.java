/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yougeshwar Khatri
 */
public class CamelNotationLogic {
    private static String removeCharAt(String word, int pos){    
        StringBuilder builder=new StringBuilder(word);
        builder.deleteCharAt(pos);
        return builder.toString();
    }
    
    public static String getClass(String value){
        String str[] = value.split("_");
        value = "";
        for(int i = 0; i < str.length; i++){
            String ch = ("" + str[i].charAt(0)).toUpperCase();
            
            str[i] = removeCharAt(str[i], 0).toLowerCase();
            value += ch + str[i];
        }
        return value;
    }
    public static String getVaraible(String value){
        String str[] = value.split("_");
        
        String ch = ("" + str[0].charAt(0)).toLowerCase();
        
        str[0] = removeCharAt(str[0], 0).toLowerCase();
        value = ch + str[0];
        
        for(int i = 1; i < str.length; i++){
            ch = ("" + str[i].charAt(0)).toUpperCase();
            
            str[i] = removeCharAt(str[i], 0).toLowerCase();
            value += ch + str[i];
        }
        return value;
    }
}
