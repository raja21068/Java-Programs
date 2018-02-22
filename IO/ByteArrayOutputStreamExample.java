import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Java ByteArrayOutputStream example
 * Writing byte array to a stream/file
 */
public class ByteArrayOutputStreamExample {
    
   public static void main(String[] args) {
     ByteArrayOutputStream out = null;
     FileOutputStream file = null;
     
     try {
        file = new FileOutputStream("e://file.txt");
        out = new ByteArrayOutputStream();
        out.write("This text has been\nwritten to a file".getBytes());
        out.writeTo(file);
        out.flush();       
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (SecurityException e) { //file permissions error
         e.printStackTrace();
     } catch (IOException e) { //other IO errors
         e.printStackTrace();
     }
     finally {
          //close the stream to release system resources
            try {
                if (out != null) {
                    //closing ByteArrayOutputStream has no effect
                    //but it is a good practice to close all streams
                    out.close();
                }
                if (out != null) {
                    file.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
     
   }
}