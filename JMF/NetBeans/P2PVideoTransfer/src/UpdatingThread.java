
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay Kumar
 */
public class UpdatingThread extends Thread{
   JList list;
   String ip;
   ClientFrame clientFram;
    UpdatingThread(JList l , String ip , ClientFrame cf){
        list = l;
        this.ip = ip;
        clientFram =cf;
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(e.getSource()==null){ return; }
                Object ob = list.getSelectedValue();
                String s = (String)ob;
                System.out.println(s);
            }
        });
    }
    public void run(){
        try{
        Socket socket = new Socket(ip,PortConfig.REGISTRY_PORT);
        System.out.println("connected....");
        DataInputStream in = new DataInputStream(socket.getInputStream());
        int size;
        do{
            Vector v = new Vector();
            Thread.sleep(1000);
            String s = in.readUTF();
            size = Integer.parseInt(s);
            for(int i =0 ;i<size;i++){
                v.addElement(in.readUTF());
            }
            list.removeAll();
            list.setListData(v);
        }while(true);
        }catch(Exception e){ JOptionPane.showMessageDialog(null,"Server is Closed....");
        }
        System.exit(0);
    }
    
}
