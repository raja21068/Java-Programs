package hello;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import javax.wireless.messaging.*;
import javax.microedition.io.*;


public class HelloMIDlet extends MIDlet implements CommandListener {
      Display display;
      private TextField toWhom;
      private TextField message;
      private Alert alert;
      private Command send,exit;
      MessageConnection clientConn;
      private Form compose;

      public HelloMIDlet() {

            display=Display.getDisplay(this);
            compose=new Form("Compose Message");
            toWhom=new TextField("To","",10,TextField.PHONENUMBER);
            message=new TextField("Message","",600,TextField.ANY);
            send=new Command("Send",Command.BACK,0);
            exit=new Command("Exit",Command.SCREEN,5);

            compose.append(toWhom);
            compose.append(message);
            compose.addCommand(send);
            compose.addCommand(exit);
            compose.setCommandListener(this);

            new SMSReceiver().start();
      }


      class SMSReceiver extends Thread{
         public void run(){
          try{
            MessageConnection conn = (MessageConnection) Connector.open("sms://:50001");
            conn.setMessageListener(new MessageListener() {
                    public void notifyIncomingMessage(MessageConnection conn) {
                           try{
                            Message msg = conn.receive();
                            if(msg instanceof TextMessage) {
                                    TextMessage tmsg = (TextMessage) msg;
                                    compose.setTitle(tmsg.getPayloadText());
                                    System.out.println(tmsg.getPayloadText());
                            }
                           }catch(java.io.IOException ee){ee.printStackTrace();}
                   }
           });
          }catch(Exception e){
             e.printStackTrace();
          }
         }//end run
      }//end class




      public void startApp() {
            display.setCurrent(compose);
      }
      public void pauseApp() {
      }
      public void destroyApp(boolean unconditional) {
            notifyDestroyed();
      }
      public void commandAction(Command cmd,Displayable disp) {
            if(cmd==exit) {
                  destroyApp(false);
            }
            if(cmd==send) {
                  String mno=toWhom.getString();
                  String msg=message.getString();
                  if(mno.equals("")) {
                        alert = new Alert("Alert");
                        alert.setString("Enter Mobile Number!!!");
                        alert.setTimeout(2000);
                        display.setCurrent(alert);
                  }
                  else {
                        try {
                              clientConn=(MessageConnection)Connector.open("sms://"+mno);
                        }
                        catch(Exception e) {
                              alert = new Alert("Alert");
                              alert.setString("Unable to connect to Station because of network problem");
                              alert.setTimeout(2000);
                              display.setCurrent(alert);
                        }
                        try {
                              TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
                              textmessage.setAddress("sms://"+mno);
                              textmessage.setPayloadText(msg);
                              clientConn.send(textmessage);
                        }
                        catch(Exception e)
                        {
                              Alert alert=new Alert("Alert","",null,AlertType.INFO);
                              alert.setTimeout(Alert.FOREVER);
                              alert.setString("Unable to send");
                              display.setCurrent(alert);
                        }
                  }
            }
      }
}
