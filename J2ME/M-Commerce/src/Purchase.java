import java.util.*;
import java.io.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;

public class Purchase implements CommandListener{

	Alert alert;
	
	Form form;
	
	Command back;
	Command login;

	TextField userTf;
	TextField passTf;
	TextField cardNoTf;
	TextField reCardNoTf;
	
	StringItem message;
	
	Display display;
	Displayable parentForm;
	Vector purchasedItems;
	
	ChoiceGroup group;
	
	HttpConnection conn;
	DataInputStream in;
	
	Hashtable cardNameValue;
	
	public Purchase(Display d ,Displayable pf , Vector v){
		display = d;
		parentForm =  pf;
		purchasedItems = v;
		
		form = new Form("Login");
		
		userTf = new TextField("Username","",30,TextField.ANY);
		passTf = new TextField("Password","",30,TextField.ANY);
		cardNoTf = new TextField("Credit Card No","",30,TextField.ANY);
		reCardNoTf = new TextField("Re-Credit Card No","",30,TextField.ANY);
		
		back = new Command("back",Command.BACK,0);
		login = new Command("Login",Command.OK,1);
		
		message = new StringItem("","");
		group = new ChoiceGroup("Cards",Choice.EXCLUSIVE);
		
		cardNameValue = new Hashtable();
		
		alert = new Alert("Successfully...!");
		alert.setTimeout(Alert.FOREVER);
		
		form.append(userTf);
		form.append(passTf);
		form.append(cardNoTf);
		form.append(reCardNoTf);
		form.append(group);
		form.append(message);
		form.addCommand(back);
		form.addCommand(login);
		
		form.setCommandListener(this);
		try{
			connect();
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Exception in Constructor of Purchase..");}
	
	}
	
	public void show(){
		display.setCurrent(form);
	}
	
	public void connect()throws Exception{
		conn = (HttpConnection)Connector.open("http://"+Server.SERVER_IP_ADDRESS+":"+Server.SERVER_PORT+"/"+Server.PROJECT_NAME+"/PurchaseServlet");
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
					System.out.println(b);
					String str = b.toString();
					String id = str.substring(0,str.indexOf('~'));
					String name = str.substring(str.indexOf('~')+1,str.length());
					group.append(name,null);
					
					cardNameValue.put(name,id);
					System.out.println(name+" : "+id);
					
					b = new StringBuffer();
					
				}else{
					b.append((char)ch);
				}
			}
		}
	}
	
	public void send()throws Exception{
	
		String user = userTf.getString();
		String pass = passTf.getString();
		String carNo = cardNoTf.getString();
		String reCarNo = reCardNoTf.getString();
		if(user.equals("") || pass.equals("") || carNo.equals("") || reCarNo.equals("") ){
			message.setText("Please fillout all fields..!");
			return;
		}
		if(!reCarNo.equals(carNo)){
			message.setText("Both Card No you entered are not same..!");
			return;
		}
		
		String id = (String)cardNameValue.get(group.getString(group.getSelectedIndex()));
		System.out.println(id);
		
		double total = 0;
		String beans = "";
		for (int i=0;i < purchasedItems.size();i++){
			bean.ItemBean bean=(bean.ItemBean) purchasedItems.elementAt(i);
			total+= Double.parseDouble(bean.getPrice().trim()) * Double.parseDouble(bean.getQuantity().trim());
			beans += bean.getId()+"~"+bean.getPrice().trim()+"~"+bean.getQuantity().trim()+"`"; 
		}
		System.out.println(beans);
		conn = (HttpConnection)Connector.open("http://"+Server.SERVER_IP_ADDRESS+":"+Server.SERVER_PORT+"/"+Server.PROJECT_NAME+"/Verification?username="+user+"&pass="+pass+"&creditcardno="+carNo+"&cardid="+id+"&total="+total+"&beans="+beans);
		System.out.println("Conneced With Server..");
		int rc = conn.getResponseCode();
		if (rc != HttpConnection.HTTP_OK) {
			System.out.println("Error in reponse Code");
		}else{
			in = new DataInputStream(conn.openInputStream());
			int ch;
			StringBuffer b = new StringBuffer(); 
			while((ch=in.read())!= -1){
				b.append((char)ch);
			}
				if((b.toString().indexOf("Success")) != -1){
					alert.setString(b.toString());
					display.setCurrent(alert,parentForm);
				}else{
					message.setText(b.toString());
				}
		}
	}
	
	public void commandAction(Command c , Displayable d){
		String label = c.getLabel();
		
		if(label.equals("back")){
			display.setCurrent(parentForm);
		}
		else if(label.equals("Login")){
			try{
				send();
			}catch(Exception ex){
				ex.printStackTrace();
				System.out.println("Exception Occured at commandAction in Purchase..!");
			}
		}
	}
}