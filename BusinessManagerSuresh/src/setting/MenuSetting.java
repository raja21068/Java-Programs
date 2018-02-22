package setting;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author JAY KUMAR
 */
public class MenuSetting {
    
    public static String ACCOUNT="Accounts=";
    public static String CATEGORY="Category=";
    public static String YEAR="Year=";
    public static String DAY="Day=";
    public static String PRODUCTS="Products=";
    public static String MEASUREMENTUNIT="MeasurementUnit=";
    public static String SALESBOOK="SalesBook=";
    public static String PURCHASEBOOK="PurchaseBook=";
    public static String CASHBOOK="CashBook=";
    public static String CHEQUEBOOK="ChequeBook=";
    public static String TRANSACTIONSUMMARY="TransactionSummary=";

    public static void createSettingFile()throws Exception{
        PrintStream out  = new PrintStream(new FileOutputStream(new File("settingConfig.properties")));
        out.println(ACCOUNT+"true");
        out.println(CATEGORY+"false");
        out.println(YEAR+"true");
        out.println(DAY+"true");
        out.println(PRODUCTS+"true");
        out.println(MEASUREMENTUNIT+"false");
        out.println(SALESBOOK+"true");
        out.println(PURCHASEBOOK+"true");
        out.println(CASHBOOK+"true");
        out.println(CHEQUEBOOK+"true");
        out.println(TRANSACTIONSUMMARY+"true");
        out.close();
    }
    
    public static String[] getAllFrameVisiblityString()throws Exception{
        DataInputStream in = new DataInputStream(new FileInputStream(new File("settingConfig.properties")));
        String[] s = new String[11];
        String str = "";
        int index = 0;
        while(in.available() >0 ){
            char i = (char)in.read();
            if(i == '\n'){
                s[index] = str;
                str="";
                index++;
                if(index == s.length)break;
            }else{
                str += i;
            }
        }
        return s;
    }
    
    private static void setAllFrameVisiblity(String[] str)throws Exception{
        PrintStream out  = new PrintStream(new FileOutputStream(new File("settingConfig.properties")));
        for(int i =0;i<str.length;i++){
            out.println(str[i]);
        }
    }
    
    public static boolean getFrameVisiblity(String frame)throws Exception{
       String[] str = getAllFrameVisiblityString();
       if(frame.equals(ACCOUNT)){
           String s = str[0].trim().replace(ACCOUNT,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(CATEGORY)){
           String s = str[1].trim().replace(CATEGORY,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(YEAR)){
           String s = str[2].trim().replace(YEAR,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(DAY)){
           String s = str[3].trim().replace(DAY,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(PRODUCTS)){
           String s = str[4].trim().replace(PRODUCTS,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(MEASUREMENTUNIT)){
           String s = str[5].trim().replace(MEASUREMENTUNIT,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(SALESBOOK)){
           String s = str[6].trim().replace(SALESBOOK,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(PURCHASEBOOK)){
           String s = str[7].trim().replace(PURCHASEBOOK,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(CASHBOOK)){
           String s = str[8].trim().replace(CASHBOOK,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(CHEQUEBOOK)){
            String s = str[9].trim().replace(CHEQUEBOOK,"").trim();
            if(s.equals("true")){
                return true;
            }
       }else if(frame.equals(TRANSACTIONSUMMARY)){
           String s = str[10].trim().replace(TRANSACTIONSUMMARY,"").trim();
            if(s.equals("true")){
                return true;
            }
       }
       
       return false;
    }
    
    public static void setFrameVisiblity(String frame, boolean b)throws Exception{
       String[] str = getAllFrameVisiblityString();
       if(frame.equals(ACCOUNT)){
           str[0] = ACCOUNT+b;
            
       }else if(frame.equals(CATEGORY)){
           str[1] = CATEGORY+b;
           
       }else if(frame.equals(YEAR)){
           str[2] = YEAR+b;
           
       }else if(frame.equals(DAY)){
           str[3] = DAY+b;
           
       }else if(frame.equals(PRODUCTS)){
           str[4] = PRODUCTS+b;
           
       }else if(frame.equals(MEASUREMENTUNIT)){
           str[5] = MEASUREMENTUNIT+b;
           
       }else if(frame.equals(SALESBOOK)){
           str[6] = SALESBOOK+b;
            
       }else if(frame.equals(PURCHASEBOOK)){
           str[7] = PURCHASEBOOK+b;
            
       }else if(frame.equals(CASHBOOK)){
           str[8] = CASHBOOK+b;
          
       }else if(frame.equals(CHEQUEBOOK)){
            str[9] = CHEQUEBOOK+b;
            
       }else if(frame.equals(TRANSACTIONSUMMARY)){
           str[10] = TRANSACTIONSUMMARY+b;
       }
       
       setAllFrameVisiblity(str);
    }
}
