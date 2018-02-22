import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class CalculateMIDlet extends MIDlet implements CommandListener{
	
	Form mainForm;
	List menuList;
	Command exitCommand;
	Command menuCommand;
	Command addCommand;
	Command subCommand;
	Command mulCommand;
	Command divCommand;
	Command remCommand;
	Command backCommand;
	
	TextField tf1,tf2;
	Alert alert;
	String message = "";
			
	public CalculateMIDlet(){
		mainForm = new Form("Calculate");
		menuList = new List("Menu",Choice.IMPLICIT);
		
		exitCommand = new Command("Exit",Command.EXIT,0);
		menuCommand = new Command("Menu",Command.ITEM,1);
		addCommand = new Command("Add",Command.ITEM,1);
		subCommand = new Command("Sub",Command.ITEM,1);
		mulCommand = new Command("Mul",Command.ITEM,1);
		divCommand = new Command("Div",Command.ITEM,1);
		remCommand = new Command("Rem",Command.ITEM,1);
		backCommand = new Command("Back",Command.BACK,1);
		
		tf1 = new TextField("Enter 1st Value,","0",5,TextField.NUMERIC);
		tf2 = new TextField("Enter 2nd Value,","0",5,TextField.NUMERIC);
		
		mainForm.append(tf1);
		mainForm.append(tf2);
		mainForm.addCommand(exitCommand);	
		mainForm.addCommand(menuCommand);
		
		menuList.append("Add",null);
		menuList.append("Sub",null);
		menuList.append("Div",null);
		menuList.append("Mul",null);
		menuList.append("Rem",null);
		menuList.addCommand(backCommand);
		
		mainForm.setCommandListener(this);
		menuList.setCommandListener(this);
	}
	
	public void startApp(){
		Display.getDisplay(this).setCurrent(mainForm);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	
	public void commandAction(Command c, Displayable s){
		if(c == exitCommand){  notifyDestroyed(); }
		else if ( c == menuCommand ){ Display.getDisplay(this).setCurrent(menuList); }	
		else if ( c == backCommand ){ Display.getDisplay(this).setCurrent(mainForm); }
		else{ 
			List menu = (List)Display.getDisplay(this).getCurrent();
			int option = menu.getSelectedIndex();
			int result=0;
			if(option == 0){ message = "Addition :"; result = Integer.parseInt(tf1.getString())+Integer.parseInt(tf2.getString()); }
			else if(option == 1){ message = "Substraction :"; result = Integer.parseInt(tf1.getString())-Integer.parseInt(tf2.getString()); }
			else if(option == 2){ message = "Division :"; result = Integer.parseInt(tf1.getString())/Integer.parseInt(tf2.getString()); }
			else if(option == 3){ message = "Multiplication :"; result = Integer.parseInt(tf1.getString())*Integer.parseInt(tf2.getString()); }
			else if(option == 4){ message = "Remainder :"; result = Integer.parseInt(tf1.getString())%Integer.parseInt(tf2.getString()); }
			alert = new Alert("This is new alert",message+result,null,AlertType.INFO);
			alert.setTimeout(Alert.FOREVER);
			Display.getDisplay(this).setCurrent(alert);
		}
	}
}