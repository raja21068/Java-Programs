import java.util.zip.*;
import java.io.*;

public class ZipTest {
    public static void main(String arg[])throws Exception{
        String source = "E:/photos/boat.jpg";
        String destination = "D:/boat.zip";
        File f = new File(source);
        FileInputStream fileRead = new FileInputStream(source);
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(destination));
        
        zipOut.putNextEntry(new ZipEntry(f.getName()));
        byte b[] = new byte[1024];
        int buffer;
        while((buffer=fileRead.read(b,0,b.length))>0){
            zipOut.write(b, 0, buffer);
        }
        fileRead.close();
        zipOut.close();
    }
}
