package messagesent;

import java.util.Vector;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;

/**
 *
 * @author Jay Kumar
 */
public class RecordManagement {
    
    RecordStore conNo;
    RecordStore conName;
    
    public RecordManagement()throws Exception{
        conNo = RecordStore.openRecordStore("contactNumber", true);
        conName = RecordStore.openRecordStore("contactName", true);        
    }
    
    public void add(String number, String name)throws Exception{
        byte[] a = number.getBytes();
        byte[] b = name.getBytes();
        
        conNo.addRecord(a, 0, a.length);
        conName.addRecord(b, 0, b.length);
    }
    
    public Vector getAllContact()throws Exception{
        Vector v = new Vector();
        
        RecordEnumeration nos = conNo.enumerateRecords(null, null , false);
        
        while(nos.hasNextElement()){
            int id = nos.nextRecordId();
            v.addElement(new ContactBean(new String(conNo.getRecord(id)) ,new String(conName.getRecord(id)) ) );
        }
        
        return v; 
    }
}
