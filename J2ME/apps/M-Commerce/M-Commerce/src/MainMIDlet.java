import java.io.*;
import java.util.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MainMIDlet extends MIDlet implements CommandListener{
	
	List categoryList;
	Vector catValues;
	
	Vector puchasedItems;
	
	HttpConnection conn;
	DataInputStream in;
	DataOutputStream out;
	
	Command exit;
	Command purchase;
	
	ItemsForm itemForm;
	
	Display display;
	
	ViewBasket viewBasket;
	
	public MainMIDlet(){
		categoryList = new List("M-Commerce",List.IMPLICIT);
		exit = new Command("Exit",Command.EXIT,0);
		purchase = new Command("view basket",Command.ITEM,1);
		display = Display.getDisplay(this);
		
		categoryList.addCommand(exit);
		categoryList.addCommand(purchase);
		categoryList.setCommandListener(this);
		
		catValues = new Vector();
		puchasedItems = new Vector();
		
		viewBasket = new ViewBasket(display,categoryList, puchasedItems);
		try{
			connect();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	
	public void startApp(){
		display.setCurrent(categoryList);
	} 
	public void pauseApp(){} 
	public void destroyApp(boolean b){} 

	public void connect()throws Exception{
		
		conn = (HttpConnection)Connector.open("http://"+Server.SERVER_IP_ADDRESS+":"+Server.SERVER_PORT+"/"+Server.PROJECT_NAME+"/MenuServlet");
		System.out.println("Conneced With Server..");
		int rc = conn.getResponseCode();
		if (rc != HttpConnection.HTTP_OK) {
			System.out.println("Error in reponse Code");
		}else{
			in = new DataInputStream(conn.openInputStream());
			int ch;
			StringBuffer b = new StringBuffer(); 
			while((ch=in.read())!= -1){
				if(ch == '\n'){
					String cat = b.toString();
					String name = cat.substring(0,cat.indexOf('~'));
					String url = cat.substring(cat.indexOf('~')+1,cat.length());
					System.out.println("name: "+name);
					System.out.println("URL: "+url);
					categoryList.append(name,null);
					catValues.addElement(url);
					b = new StringBuffer();
					
				}else{
					b.append((char)ch);
				}
			}
		}
					
	}
	
	public void commandAction(Command c , Displayable d){
		
		if(c == exit){
			notifyDestroyed();
		}
		else if(c == purchase){
			viewBasket.show();
		}
		
		else if(d == categoryList){
			System.out.println("Any category is selected..!");
			for(int i =0 ; i<catValues.size(); i++ ){
				if( categoryList.getSelectedIndex() == i){
					String url = (String)catValues.elementAt(i);
					System.out.println(url);
					itemForm = new ItemsForm(url , categoryList, display,puchasedItems);
				}
			}
		}
		
		
	}
}