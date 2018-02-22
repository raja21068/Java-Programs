
import java.util.zip.*;
import java.io.*;
import javax.swing.*;

public class ZipClass {
    JProgressBar progressBar;
    JProgressBar fileProgressBar;
    ZipClass(JProgressBar bar){
        progressBar = bar;
    }
    ZipClass(JProgressBar bar , JProgressBar fileBar){
        progressBar = bar;
        fileProgressBar = fileBar;
    }
    public void zipFile(String src , String dest)throws Exception{
        String destination = dest+".zip";
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(destination));
        fileHelper(src , zipOut , "");
        zipOut.close();
        
        System.out.println("File is zipped....");
    }
    /////************************************************************\\\\
    public void UnzipFile(String src ,String dest)throws Exception{
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(src));
        
        ZipEntry entry = zipIn.getNextEntry();

        FileOutputStream fileOut = new FileOutputStream(dest+"/"+entry.getName());
        byte[] b = new byte[1024];
        int buffer;
        while( (buffer=zipIn.read(b)) > 0){
            fileOut.write(b, 0, buffer);
        }
        zipIn.close();
        fileOut.close();
        System.out.println("file unzipping complete....");
    }
    //////******************************************************************\\\\\\\
    public void zipFolder(String src , String des)throws Exception{
        String destination = des+".zip";
        System.out.println(destination);
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(destination));
        String[] files = new File(src).list(); 
        progressBar.setMinimum(0);
        progressBar.setMaximum(files.length-1);
        for(int i =0 ; i<files.length ; i++){
            progressBar.setValue(i);
            if(new File(src+"/"+files[i]).isDirectory()){
                System.out.println("zipFolder Directory: "+src+"/"+files[i]);
             folderHelper(src+"/"+files[i] , zipOut , files[i]);   
            }
            else{
                System.out.println("zipFolder File: "+src+"/"+files[i]);
                fileHelper(src+"/"+files[i] , zipOut , "");
            }
        }
        zipOut.close();
    }
   private void folderHelper(String src ,ZipOutputStream zipOut , String path)throws Exception{
     
       String files[] = new File(src).list();
       System.err.println("folder elper files length : "+files.length);
       if(files.length!=0){
           for(int i = 0 ; i<files.length ; i++ ){
              if(new File(src+"/"+files[i]).isDirectory()){
//                System.out.println("Folder Helper : "+src+"/"+files[i]);
                folderHelper(src+"/"+files[i],zipOut , path+"/"+files[i]);
              }
              else{
               System.out.println("Folder Helper : "+src+"/"+files[i]);
               fileHelper(src+"/"+files[i] , zipOut , path+"/"+files[i]);
              }
          }
       }
       else{
           zipOut.putNextEntry(new ZipEntry(path+"/"));
       }
       
   }
   private void fileHelper(String src,ZipOutputStream zipOut , String path)throws Exception{
       System.out.println("File Helper : "+src);
       FileInputStream fileRead = new FileInputStream(src);
       File f = new File(src);
       int progressValue=0;
       fileProgressBar.setMinimum(0);
       fileProgressBar.setMaximum(fileRead.available());
       byte[] b = new byte[1024];
       int buffer;
       
       zipOut.putNextEntry(new ZipEntry(path+f.getName()));
       while((buffer = fileRead.read(b))> 0){
           zipOut.write(b, 0, buffer);
           progressValue+=buffer;
           fileProgressBar.setValue(progressValue);
       }
       fileRead.close();
   }
////*************************************************************************\\\\
     
   public void unzipFolder(String src , String dest)throws Exception{
       ZipInputStream zipRead = new ZipInputStream(new FileInputStream(src));
       ZipEntry entry;
       int count = 0;
       progressBar.setMinimum(0);
       while((entry = zipRead.getNextEntry())!=null){
            count++;
        }
       progressBar.setMaximum(count);
       zipRead.close();
       count = 0;
       zipRead = new ZipInputStream(new FileInputStream(src));
       while((entry = zipRead.getNextEntry())!=null){
           //System.out.println(dest+"/"+entry.getName());
           unzipFolderHelper(dest+"/"+entry.getName() , zipRead);
           progressBar.setValue(++count);
       }
       zipRead.close();
   }
   private void unzipFolderHelper(String entryName ,ZipInputStream zipRead)throws Exception{
       int index = entryName.lastIndexOf('/');
       String file = entryName.substring(index+1);
       String path = entryName.substring(0 , index+1);
       System.out.println(path);
       new File(path).mkdirs();
       System.err.println(file);

       FileOutputStream fileWrite = new FileOutputStream(path+file);
       byte[] b= new byte[1024];
       int buffer;
       while((buffer=zipRead.read(b))>0){
           fileWrite.write(b, 0, buffer);
       }
       fileWrite.close();
   }
    
}
