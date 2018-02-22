import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Calculator implements CommandListener{

Form mainForm;
	public List menuList;
	Command gotoParentCommand;
	Command addCommand;
	Command subCommand;
	Command mulCommand;
	Command divCommand;
	Command remCommand;
	
	TextField tf1,tf2,resultTf;
	Alert alert;
	String message = "";
	Display display;
	Screen parent;
			
	public Calculator(Display d , Screen sc){
		display = d;
		parent = sc;
		mainForm = new Form("Calculate");
		
		gotoParentCommand = new Command("Main Menu",Command.EXIT,0);
		addCommand = new Command("Add",Command.ITEM,1);
		subCommand = new Command("Sub",Command.ITEM,1);
		mulCommand = new Command("Mul",Command.ITEM,1);
		divCommand = new Command("Div",Command.ITEM,1);
		remCommand = new Command("Rem",Command.ITEM,1);
		
		tf1 = new TextField("Enter 1st Value,","0",5,TextField.NUMERIC);
		tf2 = new TextField("Enter 2nd Value,","0",5,TextField.NUMERIC);
		resultTf = new TextField("Result,","0",5,TextField.NUMERIC);
		
		mainForm.append(tf1);
		mainForm.append(tf2);
		mainForm.append(resultTf);
		mainForm.addCommand(gotoParentCommand);	
		mainForm.addCommand(addCommand);
		mainForm.addCommand(subCommand);
		mainForm.addCommand(divCommand);
		mainForm.addCommand(mulCommand);
		mainForm.addCommand(remCommand);
		
		
		mainForm.setCommandListener(this);
	}
	
	public void commandAction(Command c, Displayable s){
		if(c == gotoParentCommand){  display.setCurrent(parent);
		}
		else{ 
			
			int result=0;
			if( c == addCommand){ result = Integer.parseInt(tf1.getString())+Integer.parseInt(tf2.getString()); }
			if( c == subCommand){ result = Integer.parseInt(tf1.getString())-Integer.parseInt(tf2.getString());}
			if( c == mulCommand){ result = Integer.parseInt(tf1.getString())*Integer.parseInt(tf2.getString()); }
			if( c == divCommand){ result = Integer.parseInt(tf1.getString())/Integer.parseInt(tf2.getString()); }
			if( c == remCommand){ result = Integer.parseInt(tf1.getString())%Integer.parseInt(tf2.getString());}
			resultTf.setString(""+result);
			display.setCurrent(mainForm);
		}
	}
	
}