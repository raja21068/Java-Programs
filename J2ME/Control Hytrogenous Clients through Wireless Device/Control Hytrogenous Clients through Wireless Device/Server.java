import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;

class MyServer
 {
   Vector inputVector       = new Vector();
   Vector outputVector      = new Vector();
   Vector nameVector        = new Vector();

   MyServer()throws Exception
    {
       ServerSocket ss=new ServerSocket(2000);
       System.out.println("Server started........");
       do{
           Socket socket=ss.accept();

           DataInputStream    in  = new DataInputStream  (socket.getInputStream());
           DataOutputStream   out = new DataOutputStream (socket.getOutputStream());

           HandelClientThread t=new HandelClientThread(in,out);
           t.start();

         }while(true);

    }


class HandelClientThread extends Thread
 {
   DataOutputStream out;
   DataInputStream  in;

   StringTokenizer tokens;
  
   String name;

   HandelClientThread(DataInputStream in,DataOutputStream out)
    {
      this.in=in;
      this.out=out;
    }//end HandelClientThread Constructor.......

  public void run()
   {
     try{
          do{
               String msg = in.readLine();
               tokens=new StringTokenizer(msg,"~");

               String command=tokens.nextToken();

               if(command.equals("Chatting"))      chatting();
               if(command.equals("RemoveFile"))    removeFile();
               if(command.equals("CreatingFile"))  creatingFile();
               if(command.equals("OpenWebsites"))  openWebsites();
               if(command.equals("Clipboard"))  setClipboard();

               if(command.equals("Shutdown"))                utilities("Shutdown");
               if(command.equals("Restart"))                 utilities("Restart");
               if(command.equals("LogOff"))                  utilities("LogOff");
               if(command.equals("Notepad"))                 utilities("Notepad");
               if(command.equals("Calculator"))              utilities("Calculator");
               if(command.equals("ControllPanel"))           utilities("ControllPanel");
               if(command.equals("WordPade"))                utilities("WordPade");
               if(command.equals("InternetExplorer"))        utilities("InternetExplorer");
               if(command.equals("DesktopProperties"))       utilities("DesktopProperties");
               if(command.equals("SystemDateTime"))          utilities("SystemDateTime");
               if(command.equals("PaintBrush"))              utilities("PaintBrush");
               if(command.equals("DesktopBackground"))       utilities("DesktopBackground");
               if(command.equals("ScanDisk"))                utilities("ScanDisk");
               if(command.equals("ColorSetting"))            utilities("ColorSetting");
               if(command.equals("ScreenSaver"))             utilities("ScreenSaver");
               if(command.equals("DesktopAppearance"))       utilities("DesktopAppearance");
               if(command.equals("DeviceManagerProperties")) utilities("DeviceManagerProperties");
               if(command.equals("SystemInformation"))       utilities("SystemInformation");
               if(command.equals("HardwareProfile"))         utilities("HardwareProfile");
               if(command.equals("SystemProformance"))       utilities("SystemProformance");
               if(command.equals("Explorer"))                utilities("Explorer");
               if(command.equals("OpenCDDoor"))              utilities("OpenCDDoor");
               if(command.equals("CloseCDDoor"))             utilities("CloseCDDoor");
               if(command.equals("MediaPlayer"))             utilities("MediaPlayer");
               if(command.equals("SoliTaireGame"))           utilities("SoliTaireGame");
               if(command.equals("GetSystemTime"))           utilities("GetSystemTime");
               if(command.equals("GetSystemDate"))           utilities("GetSystemDate");
               if(command.equals("CrazyCalculatorPaint"))    utilities("CrazyCalculatorPaint");
               if(command.equals("OpenEmail"))               utilities("OpenEmail");
               if(command.equals("DisableALT_CLT_DEL"))      utilities("DisableALT_CLT_DEL");
               if(command.equals("SnapShotOfRemoteSystem"))  utilities("SnapShotOfRemoteSystem");
               if(command.equals("EnabledALT+CLT+DEL"))      utilities("EnabledALT+CLT+DEL");
               if(command.equals("CommandPrompt"))           utilities("CommandPrompt");

               if(command.equals("ClientList"))              clientList();
               if(command.equals("ChatMessage"))             chatMessage();
               if(command.equals("AddClient"))               addClient();
               if(command.equals("DelLogin"))                delLogin();
               if(command.equals("BrodCastMessaging"))       brodCastMessaging();
               if(command.equals("Date"))                    sendDateToW();
               if(command.equals("Time"))                    sendTimeToW();
               if(command.equals("Message"))                 sendMessageToW();

           }while(true);

        }catch(Exception e)
          {
             delLogin();
             System.out.println("Disconnect :"+name);
          }
  }//end of run method.........

private void chatting()
   {  try{
              String clientName  = tokens.nextToken();
              String chatMessage = tokens.nextToken();
                 
              String msg="Chatting~"+chatMessage+"\n";

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg);

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("chatting: "+e);
         }
    }

   private void removeFile()
   {  try{
              String clientName  = tokens.nextToken();
              String filePath    = tokens.nextToken();
                 
              String msg="RemoveFile~"+filePath+"\n";

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg);

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("removeFile: "+e);
         }
    }


   private void creatingFile()
   {  try{
              String clientName  = tokens.nextToken();
              String filePath    = tokens.nextToken();
              String fileData    = tokens.nextToken();
                 
              String msg="CreatingFile~"+filePath+"~"+fileData+"\n";

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg);

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("creatingFile: "+e);
         }
    }

   private void openWebsites()
   {  try{
              String clientName  = tokens.nextToken();
              String websiteName = tokens.nextToken();
                 
              String msg="OpenWebsites~"+websiteName+"\n";

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg);

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("openWebsites: "+e);
         }
    }

   private void setClipboard()
   {  try{
              String clientName  = tokens.nextToken();
              String data = tokens.nextToken();
                 
              String msg="Clipboard~"+data+"\n";

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg);

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("setClipboard: "+e);
         }
    }


   private void sendDateToW()
    {

      try{

          String dateStr = tokens.nextToken();
          String msg="Date~"+dateStr;

          int index = nameVector.indexOf("WirelessDevice");
          DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);
          output.writeBytes(msg+"\n");
         System.out.println("send Date to wireless device ");
         }catch(Exception e)

          {
            System.out.println("sendDateToW: "+e);
          }
    }//end sendDateToW class.......
//********************************************************
   private void sendTimeToW()
   {
      try{

          String timeStr = tokens.nextToken();
          String msg="Time~"+timeStr;

          int index = nameVector.indexOf("WirelessDevice");
          DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);
          output.writeBytes(msg+"\n");
         }catch(Exception e)
          {
            System.out.println("sendDateToW: "+e);
          }
    }

   private void sendMessageToW()
   {
      try{

          String msgStr = tokens.nextToken();
          String msg="Message~"+msgStr;

          int index = nameVector.indexOf("WirelessDevice");
          DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);
          output.writeBytes(msg+"\n");

         }catch(Exception e)
          {
            System.out.println("Message: "+e);
          }
   }

private void clientList() 
   {
     try{                       
          String msg="";

          String command=tokens.nextToken();

                             
          if(command.equals("Chatting"))       msg="Chatting";
          if(command.equals("RemoveFile"))     msg="RemoveFile";
          if(command.equals("CreatingFile"))   msg="CreatingFile";
          if(command.equals("OpenWebsites"))   msg="OpenWebsites";
          if(command.equals("Clipboard"))      msg="Clipboard";

          if(command.equals("Shutdown"))          msg="Shutdown";
          if(command.equals("Restart"))           msg="Restart";
          if(command.equals("LogOff"))            msg="LogOff";
          if(command.equals("Notepad"))           msg="Notepad";
          if(command.equals("Calculator"))        msg="Calculator";
          if(command.equals("ControllPanel"))     msg="ControllPanel";
          if(command.equals("WordPade"))          msg="WordPade";
          if(command.equals("InternetExplorer"))  msg="InternetExplorer";
          if(command.equals("DesktopProperties")) msg="DesktopProperties";
          if(command.equals("SystemDateTime"))    msg="SystemDateTime";
          if(command.equals("PaintBrush"))        msg="PaintBrush";
          if(command.equals("DesktopBackground")) msg="DesktopBackground";
          if(command.equals("ScanDisk"))          msg="ScanDisk";
          if(command.equals("ColorSetting"))      msg="ColorSetting";
          if(command.equals("ScreenSaver"))       msg="ScreenSaver";
          if(command.equals("DesktopAppearance")) msg="DesktopAppearance";
          if(command.equals("SystemInformation")) msg="SystemInformation";
          if(command.equals("HardwareProfile"))   msg="HardwareProfile";
          if(command.equals("SystemProformance")) msg="SystemProformance";
          if(command.equals("Explorer"))          msg="Explorer";
          if(command.equals("OpenCDDoor"))        msg="OpenCDDoor";
          if(command.equals("CloseCDDoor"))       msg="CloseCDDoor";
          if(command.equals("MediaPlayer"))       msg="MediaPlayer";
          if(command.equals("SoliTaireGame"))     msg="SoliTaireGame";
          if(command.equals("GetSystemTime"))           msg="GetSystemTime";
          if(command.equals("GetSystemDate"))           msg="GetSystemDate";
          if(command.equals("CrazyCalculatorPaint"))    msg="CrazyCalculatorPaint";
          if(command.equals("OpenEmail"))               msg="OpenEmail";
          if(command.equals("DisableALT_CLT_DEL"))      msg="DisableALT_CLT_DEL";
//        if(command.equals("BrodCastMessaging"))       msg="BrodCastMessaging";
          if(command.equals("SnapShotOfRemoteSystem"))  msg="SnapShotOfRemoteSystem";
          if(command.equals("EnabledALT_CLT_DEL"))      msg="EnabledALT_CLT_DEL";
          if(command.equals("CommandPrompt"))           msg="CommandPrompt";
          if(command.equals("DeviceManagerProperties")) msg="DeviceManagerProperties";
          
          if(command.equals("ClientList"))              msg="ClientList";
              
       
          for(int i=0; i<nameVector.size(); i++)
            {
               String nameClient=(String) nameVector.elementAt(i);

               if(!"WirelessDevice".equals(nameClient))
                 msg+="~"+nameClient;
            }

           int index = nameVector.indexOf("WirelessDevice");
           DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);
           output.writeBytes(msg+"\n");

        }catch(Exception e)
         {
           System.out.println("ClientList: "+e);
         }
  }//end ClientList method.......

private void brodCastMessaging()
   {
     try{                       

          String msg=tokens.nextToken();
          String messageStr="BrodCastMessaging~"+msg;

          for(int i=0; i<nameVector.size(); i++)
            {
               String nameClient=(String) nameVector.elementAt(i);

               if("WirelessDevice".equals(nameClient));
               else
                {
                   int index = nameVector.indexOf(nameClient);
                   DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);
                   output.writeBytes(messageStr+"\n");
                }
            }//end forloop.....

        }catch(Exception e)
         {
           System.out.println("brodCastMessaging: "+e);
         }
  }//end brodCastMessaging method.......

private void addClient()
   {
     try{
           name = tokens.nextToken();

           inputVector  .addElement(in);    
           outputVector .addElement(out);     
           nameVector   .addElement(name);      

           System.out.println("Client Connect :"+name);
           System.out.println("nameVector     :"+nameVector.size());
       }catch(Exception e)
        {
          System.out.println("addClient :"+e);
        }
   }//end addClient method.......


private void utilities(String command)
   {
     try{
              String clientName = tokens.nextToken();
                 
              String msg="Utilities~"+command;

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg+"\n");

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("utilities: "+e);
         }
   }//end utilities method.......


private void shutdown()
   {
     try{
              String clientName = tokens.nextToken();
                 
              String msg="Utilities~Shutdown";

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg+"\n");

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("Shutdown: "+e);
         }
   }//end shutdown method.......


private void restart()
   {
     try{
              String clientName = tokens.nextToken();

               String msg="Utilities~Restart";

               int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg+"\n");
              System.out.println("ssssssss"+msg);
 
        }catch(Exception e)
         {
           System.out.println("Restart: "+e);
         }
   }//end restart method.......


private void logOff()
   {
     try{
              String clientName = tokens.nextToken();
                 
              String msg="Utilities~LogOff";

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg+"\n");

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("logOff: "+e);
         }
   }//end logOff method.......


private void notepad()
   {
     try{
              String clientName = tokens.nextToken();
                 
              String msg="Utilities~Notepad";

              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg+"\n");

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("Notepad: "+e);
         }
   }//end Notepad method.......
 

private void calculator()
   {
     try{
              String clientName = tokens.nextToken();
                 
              String msg="Utilities~Calculator";
                             
              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);

              output.writeBytes(msg+"\n");

              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("Calculator: "+e);
         }
   }//end Calculator method.......


private void controllPanel()
   {
     try{
              String clientName = tokens.nextToken();
                 
              String msg="Utilities~ControllPanel";
                             
              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);
              output.writeBytes(msg+"\n");
              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("ControllPanel: "+e);
         }
   }//end ControllPanel method.......


private void wordPade()
   {
     try{
              String clientName = tokens.nextToken();
                 
              String msg="Utilities~WordPade";
                             
              int index=nameVector.indexOf(clientName);

              DataOutputStream  output  =(DataOutputStream)outputVector.elementAt(index);
              output.writeBytes(msg+"\n");
              System.out.println(msg);

        }catch(Exception e)
         {
           System.out.println("WordPade: "+e);
         }
   }//end WordPade method.......


private void delLogin()
 {
   try{
        int index=nameVector .indexOf(name);

        nameVector       .remove(index);
        outputVector   .remove(index);
        inputVector    .remove(index);

        clientList();

       }catch(Exception e)
        {
           System.out.println("delLogin :"+e);
        }
 }//end delLogin method........................................

private void chatMessage()  //message for  Client
  {
    try{

         String senderName    = tokens.nextToken();
         String receiverName  = tokens.nextToken();
         String chatText      = tokens.nextToken();

         int index=nameVector.indexOf(receiverName);

         DataOutputStream output=(DataOutputStream)outputVector.elementAt(index);

         String msg="ChatMessage~"+senderName+"~"+chatText;

         output.writeBytes(msg+"\n");
       }catch(Exception e)
        {
         System.out.println("ChatMessage: "+e);
        }
 }//end ChatMessage...............................


}//end HandelClientThread class...........

}//end server class....


public class Server
 {
  public static void main(String arg[])throws Exception
   {
     MyServer server=new MyServer();
   }//end main method...........
}//end main class.....................
