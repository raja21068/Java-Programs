package Exapmle;
import java.util.zip.*;
import java.io.*;

public class ZipFileTest {
   public static void zipFile(String src , String dest)throws Exception{
        String destination = dest+".zip";
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(destination));
        
        zipFileHelper(src , zipOut , "");//Method FileHelper\\\**
        
        zipOut.close();
        
        System.out.println("File is zipped....");
    }
    /////************************************************************\\\\
    public static void UnzipFile(String src ,String dest)throws Exception{
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
    public static void zipFolder(String src , String des)throws Exception{
        String destination = des+".zip";
        System.out.println(destination);
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(destination));
        String[] files = new File(src).list(); 
        
        for(int i =0 ; i<files.length ; i++){
            
            if(new File(src+"/"+files[i]).isDirectory()){
                System.out.println("zipFolder Directory: "+src+"/"+files[i]);
             zipFolderHelper(src+"/"+files[i] , zipOut , files[i]);   
            }
            else{
                System.out.println("zipFolder File: "+src+"/"+files[i]);
                zipFileHelper(src+"/"+files[i] , zipOut , "");
            }
        }
        zipOut.close();
    }
   private static void zipFolderHelper(String src ,ZipOutputStream zipOut , String path)throws Exception{
     
       String files[] = new File(src).list();
       System.err.println("folder elper files length : "+files.length);
       if(files.length!=0){
           for(int i = 0 ; i<files.length ; i++ ){
              if(new File(src+"/"+files[i]).isDirectory()){
                System.out.println("Folder Helper : "+src+"/"+files[i]);
                zipFolderHelper(src+"/"+files[i],zipOut , path+"/"+files[i]);
              }
              else{
               System.out.println("Folder Helper : "+src+"/"+files[i]);
               zipFileHelper(src+"/"+files[i] , zipOut , path+"/"+files[i]);
              }
          }
       }
       else{
           zipOut.putNextEntry(new ZipEntry(path+"/"));
       }
       
   }
   private static void zipFileHelper(String src,ZipOutputStream zipOut , String path)throws Exception{
       System.out.println("File Helper : "+src);
       FileInputStream fileRead = new FileInputStream(src);
       File f = new File(src);
       
       byte[] b = new byte[1024];
       int buffer;
       
       zipOut.putNextEntry(new ZipEntry(path+f.getName()));
       while((buffer = fileRead.read(b))> 0){
           zipOut.write(b, 0, buffer);
       }
       fileRead.close();
   }
////*******************************************************\\\\
   
   public static void unzipFolder(String src , String dest)throws Exception{
       ZipInputStream zipRead = new ZipInputStream(new FileInputStream(src));
       File file = new File(src);
       //FileOutputStream fileWrite = new FileOutputStream(dest);
       ZipEntry entry = zipRead.getNextEntry();
       while((entry = zipRead.getNextEntry())!=null){
           //System.out.println(dest+"/"+entry.getName());
           unzipFolderHelper(dest+"/"+entry.getName() , zipRead);
       }
       zipRead.close();
   }
   private static void unzipFolderHelper(String entryName ,ZipInputStream zipRead)throws Exception{
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
   
   //<*********************************************************************>\\
    public static void main(String args[]){
        String src = "C:/Users/jay/Desktop/Test.zip";
        String des = "C:/Users/jay/Desktop/Test";
        //String src = "D:/abc.zip";
        try{
            
            ZipFileTest.unzipFolder(src, des);
        }
        catch(Exception e){e.printStackTrace();}
    }
}
