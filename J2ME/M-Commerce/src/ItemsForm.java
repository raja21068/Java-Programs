import java.io.*;
import java.util.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;


public class ItemsForm implements CommandListener,ItemStateListener{
	
	Form form;
	
	Displayable parentForm;
	Display display;
	Command back;
	Command add;
	
	HttpConnection conn;
	
	DataInputStream in;
	DataOutputStream out;
	
	TextField selectedTf;
	
	Hashtable itemsTable;
	
	Vector purchasedItems;
	
	public ItemsForm(String url,Displayable p, Display d,Vector pItems){
		parentForm = p;
		display = d;
		purchasedItems = pItems;
		
		form = new Form("Items");
		back =  new Command("back",Command.BACK,0);
		add =  new Command("add into cart",Command.OK,1);
		
		itemsTable = new Hashtable();
		
		form.addCommand(back);
		form.addCommand(add);
		form.setCommandListener(this);
		form.setItemStateListener(this);
		
		try{
			connect(url);
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Error Occured at the Constructor of ItemsForm");
		}
		
		display.setCurrent(form);
		
	}
	
	public void connect(String url)throws Exception{
		                   System.out.println("http://"+Server.SERVER_IP_ADDRESS+":"+Server.SERVER_PORT+"/"+Server.PROJECT_NAME+"/"+url);
		conn = (HttpConnection)Connector.open("http://"+Server.SERVER_IP_ADDRESS+":"+Server.SERVER_PORT+"/"+Server.PROJECT_NAME+"/"+url);
		System.out.println("Conneced With Server.."+conn);
		int rc = conn.getResponseCode();
		if (rc != HttpConnection.HTTP_OK) {
			System.out.println("Error in reponse Code at ItemForm");
		}
		else{
			in = new DataInputStream(conn.openInputStream());
			int ch;
			StringBuffer b = new StringBuffer(); 
			while((ch=in.read())!= -1){
				if(ch == '\n'){
					System.out.println(b);
					String s = b.toString();
					String name = s.substring(0,s.indexOf('~'));
					String price = s.substring(s.indexOf('~')+1,s.indexOf("~",s.indexOf('~')+1));
					String id = (s.substring(s.lastIndexOf('~')+1).trim());
					TextField tf = new TextField(name+" : "+price,"",3,TextField.NUMERIC); 
					itemsTable.put(tf,id);
					form.append(tf);
					b = new StringBuffer();
				}else{
					b.append((char)ch);
				}
			}
		}
	
	}
	
	
	public void commandAction(Command c, Displayable d){
		if(c == back){
			display.setCurrent(parentForm);
		}
		if(c == add){
			String quantity = selectedTf.getString();
			if(quantity.trim().equals("")){return;}
			String label = selectedTf.getLabel();
			String productName = label.substring(0,label.indexOf(':')-1);
			String price = label.substring(label.indexOf(':')+2);
			String id = (String)itemsTable.get(selectedTf);
			
			System.out.println("productName : "+productName);
			System.out.println("price : "+price);
			System.out.println("Id: "+id);
			
			bean.ItemBean bean = new bean.ItemBean();
			bean.setQuantity(quantity);
			bean.setPrice(price);
			bean.setName(productName);
			bean.setId(id);
			
			purchasedItems.addElement(bean);
			selectedTf.setString("");
		}
	
	}
	
	public void itemStateChanged(Item item){
		System.out.println("Item state changed..");
		selectedTf = (TextField)item;
	}
}