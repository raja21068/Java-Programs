import java.awt.datatransfer.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;

public class Client
 {
    String serverIPAddress="localhost";//by default current system

    DataOutputStream output;
    DataInputStream input;
    
  Client()
     { 
       try{
            Socket socket=new Socket(serverIPAddress,2000); //it is server IP address

            input  = new DataInputStream   ( socket.getInputStream()  );
            output = new DataOutputStream  ( socket.getOutputStream() );

         //   String userName="Sadia Shaikh ";  //System.getProperty("user.name");
            String userName=System.getProperty("user.name");
            output.writeBytes("AddClient~"+userName+"\n"); //send name to server

            MyThread t=new MyThread();
            t.start();

         }catch(Exception e)
          {
            System.out.println("Constructor :"+e);
          }
    }//end constructor............

 class MyThread extends Thread
  {
     StringTokenizer tokens;    
 
    public void run()
      {
         try{
                String msg;
                do{
                     msg= input.readLine();  
                     tokens=new StringTokenizer(msg,"~");

                     String commandStr = tokens.nextToken();

                     if(commandStr.equals("Utilities"))          utilities();
                     if(commandStr.equals("BrodCastMessaging"))  brodCastMessaging();

                     if(commandStr.equals("Chatting"))      chatting();
                     if(commandStr.equals("RemoveFile"))    removeFile();
                     if(commandStr.equals("CreatingFile"))  creatingFile();
                     if(commandStr.equals("OpenWebsites"))  openWebsites();
                     if(commandStr.equals("Clipboard"))  setClipboard();

                  }while(true);
          }catch(Exception e)
           {
              System.out.println("run :-"+e);
           } 
  }//end run...

private void chatting()
  {
    try{
           String messageStr=tokens.nextToken();
           JOptionPane.showMessageDialog(null,messageStr,"Chat Message...",JOptionPane.PLAIN_MESSAGE);

           String msgStr=JOptionPane.showInputDialog("Enter Chat Message For Adiminstrator?");

           msgStr+="\n";
           output.writeBytes("Message~"+msgStr);

      }catch(Exception e)
       {
         System.out.println("chatMessage:"+e);
       }
  }


private void removeFile()
 {
   try{
         String filePath = tokens.nextToken();
         File file=new File(filePath);

      boolean fileExists =file.exists();

      if(fileExists)
       {
         boolean b=file.delete();

         if(b)
            output.writeBytes("Message~[ "+filePath+" ]  is successfully deleted...\n");
         else
            output.writeBytes("Message~File is read only or currently in use, that's why is it will never deleted : ["+filePath+"]\n");
       }
      else
       output.writeBytes("Message~Wrong File Name or Path ["+filePath+"] File is not available.\n");

       System.out.println("remove file :"+filePath);


  }catch(Exception e)
   {
     System.out.println("chatMessage:"+e);
   }
}

 private void creatingFile()
  {
    try{
      String filePath = tokens.nextToken();
      String fileData = tokens.nextToken();
          
      int index =filePath.lastIndexOf("\\");

      String dirPath=filePath.substring(0,index);

      String fileName=filePath.substring(index+1,filePath.length());

      File ff=new File(filePath);
      boolean b=ff.exists();

      if(b)
        {
          output.writeBytes("Message~[ "+fileName+" ]  is already exists please on [ "+dirPath+" ] Folder change the File Name.\n");
          return;
        }

      File file=new File(dirPath);
      file.mkdirs();

      FileOutputStream f=new FileOutputStream(filePath);
      DataOutputStream ob=new DataOutputStream(f);
      
      ob.writeBytes(fileData);
      ob.close();

      output.writeBytes("Message~[ "+filePath+" ]  is successfully created and saved.\n");

 }catch(Exception e)
  {
    System.out.println("Error durring Create Directory And file Service: "+e);
  }
}

 private void openWebsites()
  {
    try{
         String urlName=tokens.nextToken();

           Runtime run=Runtime.getRuntime();
           Process p=run.exec("explorer "+urlName);

           output.writeBytes("Message~ ["+urlName+"] is sucessfuly open\n");
       }catch(Exception e)
         {
           System.out.println("OpenWebService: "+e);
         }
}



 private void setClipboard()
  {
   try{
        String message=tokens.nextToken();

        System.out.println(message);

        Toolkit kit =Toolkit.getDefaultToolkit();
        Clipboard clip=kit.getSystemClipboard();

        String str=""+message;
        StringSelection sSel=new StringSelection(str);
        clip.setContents(sSel,null);

        output.writeBytes("Message~\""+str +"\" successfully set in clipboard of client\n");

     }catch(Exception e)
      {
        System.out.println("message:"+e);
     }
  }

 private void utilities()
 {
    try{
         String utilName=tokens.nextToken();
         String command=null;

if(utilName.equals("Shutdown"))   command="RUNDLL32.EXE shell32.dll,SHExitWindowsEx 0x1";
if(utilName.equals("Restart"))        command="RUNDLL32.EXE shell32.dll,SHExitWindowsEx 0x2";
if(utilName.equals("LogOff"))       command="RUNDLL.EXE shell32.dll,SHExitWindowsEx 0";
if(utilName.equals("Notepad"))      command="notepad";
if(utilName.equals("Calculator"))   command="calc";
if(utilName.equals("ControllPanel"))        command="control";
if(utilName.equals("WordPade"))              command="C:\\Program Files\\Accessories\\WORDPAD.EXE";
if(utilName.equals("DesktopProperties"))command="C:\\WINDOWS\\CONTROL.EXE Desk.cpl, Display,0";
if(utilName.equals("SystemDateTime"))  command="Explorer c:\\windows\\system\\timedate.cpl";
if(utilName.equals("PaintBrush"))            command="pbrush";
if(utilName.equals("DesktopBackground"))command="C:\\WINDOWS\\CONTROL.EXE Desk.cpl, Display,0";
if(utilName.equals("ScanDisk"))                  command="scandskw";
if(utilName.equals("ColorSetting"))             command="C:\\WINDOWS\\CONTROL.EXE Desk.cpl, Display,3";
if(utilName.equals("ScreenSaver"))             command="C:\\WINDOWS\\CONTROL.EXE Desk.cpl, Display,1";
if(utilName.equals("DesktopAppearance"))command="C:\\WINDOWS\\CONTROL.EXE Desk.cpl, Display,2";
if(utilName.equals("DeviceManagerProperties")) command="control.exe sysdm.cpl,system,1";
if(utilName.equals("SystemInformation"))            command="control.exe sysdm.cpl,system,0";
if(utilName.equals("HardwareProfile"))                command="control.exe sysdm.cpl,system,2";
if(utilName.equals("SystemProformance"))          command="control.exe sysdm.cpl,system,3";
if(utilName.equals("Explorer"))                             command="Explorer.exe";
if(utilName.equals("MediaPlayer"))                      command="mplayer";
if(utilName.equals("SoliTaireGame"))                  command="sol";
if(utilName.equals("CrazyCalculatorPaint"))       {crazy();return;}
if(utilName.equals("CommandPrompt"))             command="start command c:";
if(utilName.equals("InternetExplorer"))               command="explorer http://www.yahoo.com";
if(utilName.equals("OpenEmail"))                       command="explorer mailto:sadia@yahoo.com";
if(utilName.equals("OpenCDDoor"))              command=System.getProperty("user.dir")+"\\utilities\\CDdoorOpen.exe";
if(utilName.equals("CloseCDDoor"))            command=System.getProperty("user.dir")+"\\utilities\\CDdoorClose.exe";

if(utilName.equals("DisableALT+CLT+DEL"))      command=System.getProperty("user.dir")+"\\utilities\\lock.exe";

if(utilName.equals("EnabledALT+CLT+DEL"))      command=System.getProperty("user.dir")+"\\utilities\\unlock.exe";

if(utilName.equals("SnapShotOfRemoteSystem"))  {snapShot();return;}
if(utilName.equals("GetSystemTime"))                    {getTime();return;}
if(utilName.equals("GetSystemDate"))                     {getDate();return;}

Runtime run=Runtime.getRuntime();
Process process=run.exec(command);

//         output.writeBytes("Message~works sucessfuly done...\n");

}catch(Exception e)
    {
       System.out.println(e);
    }
  }// utitilies method ..............


 private void snapShot()
  {
    try{
         String command=System.getProperty("user.dir")+"\\utilities\\snapShot.exe";
         Runtime run=Runtime.getRuntime();
         Process process=run.exec(command);
         Thread.sleep(4000);

         String origionPath= System.getProperty("user.dir")+"\\utilities\\Desktop.bmp";

            Calendar c=Calendar.getInstance();

            String timeStr    = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
            String newPath    = System.getProperty("user.dir")  +"\\utilities\\Picture\\desk"+   (int)(Math.random()*1000) +".bmp";

           // newPath=""+newPath.replace(':','_');

         System.out.println(newPath );

         File file1=new File(origionPath);
         File file2=new File(newPath);


         boolean b=file1.renameTo(file2);
       
         if(b)
            output.writeBytes("Message~ Client successfully captured...\n");
         else
            output.writeBytes("Message~ File save with prevouse name\n");

         //run.exec("pbrush "+command);

       }catch(Exception e)
        {
         System.out.println("Snapshot: "+e);
        }
  }

private void brodCastMessaging()
  {
    try{
         String messageStr=tokens.nextToken();
         JOptionPane.showMessageDialog(null,messageStr,"BrodCastMessaging...",JOptionPane.PLAIN_MESSAGE);

       }catch(Exception e)
       {
         System.out.println("brodCastMessaging:"+e);
       }
  }//end brodCastMessaging method......


private void getTime()
  {
       try{
            Calendar c=Calendar.getInstance();
            String timeStr =c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
            output.writeBytes("Time~"+timeStr+"\n");

          }catch(Exception e)
            {
               System.out.println("getTime: "+e);
            }
 
  }//end getTime()...

private void getDate()
  {
       try{
           Calendar c=Calendar.getInstance();

           String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

           String dateStr =months[ c.get(Calendar.MONTH) ]+" "+c.get(Calendar.DATE)+" "+c.get(Calendar.YEAR);

           output.writeBytes("Date~"+dateStr+"\n");
         }catch(Exception e)
         {
           System.out.println("getDate: "+e);
         }
  }//end getDate()...

private void crazy()
   {
     try{
         for(int i=1; i<=10; i++)
          {
            Runtime run=Runtime.getRuntime();
            run.exec("pbrush");
            run.exec("calc");
          }
        }catch(Exception e)
         {
           System.out.println("crazy: "+e);
         }
   }

}//end MyThread

 public static void main(String arg[])
  {
    Client c=new Client();
  }
}//end Client class .........
