/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messagesent;

import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author Jay Kumar
 */
public class Midlet extends MIDlet implements CommandListener{

    Display display;
    Form form;
    TextField noTF , nameTF;
    TextBox box;
    Command send , add , exit , viewRecords , back;
    RecordManagement rm;
    ViewContacts vc;
    
    public Midlet(){
        form = new Form("Msg Sending Agent");
        noTF = new TextField("Mobile No","", 14, TextField.PHONENUMBER);
        nameTF = new TextField("Name","", 600, TextField.ANY);
        send = new Command("send", Command.OK, 1);
        add = new Command("Add", Command.OK,1); 
        exit = new Command("Exit", Command.EXIT,0);
        back = new Command("back", Command.EXIT,0);
        viewRecords = new Command("View", Command.ITEM,1);
        display =  Display.getDisplay(this);
        box = new TextBox("Message", "", 200,TextField.ANY);
        try{ 
            rm = new RecordManagement();
            vc = new ViewContacts(display, form, rm.conName , rm.conNo);

        }catch(Exception ex){
            exceptionHandler("Error Ocuured During Creating Records Of Contacts.."+ex,form);
        }
        
        
        form.append(noTF);
        form.append(nameTF);
        form.addCommand(add);
        form.addCommand(send);
        form.addCommand(viewRecords);
        form.addCommand(exit);
        form.setCommandListener(this);
    
        box.addCommand(send);
        box.addCommand(back);
        box.setCommandListener(this);
    }
    
    public void startApp() {
        display.setCurrent(form);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    public void commandAction(Command c, Displayable d) {
        if(c == exit){
            destroyApp(true);
        }
        if(d == form ){
            if(c == add){
                if(rm != null){
                    try{
                        rm.add(noTF.getString(), nameTF.getString());
                    }catch(Exception ex){
                        exceptionHandler("Error Ocuured During Creating Records Of Contacts.."+ex,form);
                    }
                 }else{
                    exceptionHandler("Error Ocuured During Creating Records Of Contacts..",form);
                 }
            }
            else if(c == send){
                display.setCurrent(box);
            }
            else if(c == viewRecords){
                vc.show();
            }
        }else if(d == box){
            if(c == send){
                send();
            }
        }
        
    }
    
    public void exceptionHandler(String msg , Displayable d){
        display.setCurrent(new Alert(msg), d);
    }
    
    public void send(){       
        try{
            Vector v = rm.getAllContact();
            for(int i=0;i<v.size();i++ ){
                ContactBean b =(ContactBean) v.elementAt(i);
                MessageComm.send(b.getContactNumber(), box.getString());
                Thread.sleep(1000);
            }
        }catch(Exception ex){
            exceptionHandler(ex.getMessage(), form);
        }
    }
}
