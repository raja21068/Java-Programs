package ngram;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author Administrator
 */
public class UnicodeString{
     private String s;
     
     public UnicodeString(byte b[]){
        try {
            s = new String(b, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
     }
     
     public String getString(){
         return s;
     }
}
