/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsread;

import java.util.Enumeration;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.pim.Contact;
import javax.microedition.pim.ContactList;
import javax.microedition.pim.PIM;
import javax.microedition.pim.PIMException;
/**
 * @author Jay Kumar
 */
public class Midlet extends MIDlet implements CommandListener{

    private List listContacts;
    // Holds reference to the currently opened contact list.
    private ContactList contactList;
    private static final Command BACK_COMMAND = new Command("Back", Command.BACK, 0);
    private Display display;
    
    int noOfContacts;
    String s;
    
    public Midlet(){
        display = Display.getDisplay(this);
        listContacts = new List("Contact list", Choice.IMPLICIT);
        listContacts.addCommand(BACK_COMMAND);
        listContacts.setCommandListener(this);
    }
    
    public void startApp() {
        openContactList();
    }
    
    public void pauseApp() {}
    
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
    
    public void commandAction(Command c , Displayable d){
        notifyDestroyed();
    }
    
/**
 * Fills listContacts fith data read from PIM database and brings
 * the list to the foreground.
 */
private void openContactList() {
    fillContactList();
//    display.setCurrent(listContacts);
    exceptionHandle(null);
}
 
/**
 * Reads contacts list from PIM database 'Contacts' and fills listContacts
 * with contact 'name' field value.
 */
    private void fillContactList() {
        try {
            
          String[] str = PIM.getInstance().listPIMLists(PIM.CONTACT_LIST);
            s = ""+str.length+"\n";
            for(int i=0;i<str.length;i++){
                System.out.println(">> "+str[i]);
                s+= "\n"+str[i];
           
            contactList = (ContactList)PIM.getInstance().openPIMList(PIM.CONTACT_LIST, PIM.READ_WRITE, str[i]);
            
            Enumeration contacts = contactList.items();
            Contact contact = null;
            
            while (contacts.hasMoreElements()) {
                
                try{
                    contact = (Contact)contacts.nextElement();
                    String contactInfo = contact.getStringArray(Contact.NAME,Contact.ATTR_NONE)[Contact.NAME_GIVEN];
                    if (contactInfo != null) {
                    listContacts.append(contactInfo, null);
                    }
                    noOfContacts++;
                }catch(Exception ex){}
            }
          }
        } catch(Exception ex) {
            //exceptionHandle(ex);
            ex.printStackTrace();
            return;
        }
    }

    public void exceptionHandle(Exception ob){
        StringItem item = new StringItem("Contacts:",s+"\n"+noOfContacts);
        Form f = new Form("Exception");
        f.append(item);
        f.addCommand(BACK_COMMAND);
        f.setCommandListener(this);
        display.setCurrent(f);
        
    }
}
