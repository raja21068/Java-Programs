import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;

public class ViewBasket implements CommandListener{
	
	Vector purchasedItems;
	
	Command details;
	Command delete;
	Command purchase;
	Command back;
	Command detailAll;
	
	Display display;
	Displayable parentForm;
	
	Alert alert;
	List list;
	
	Purchase purchaseForm;
	public ViewBasket(Display d , Displayable dp, Vector v){
		purchasedItems = v;
		display = d;
		parentForm = dp;
		
		list = new List("Basket",List.IMPLICIT);
		alert = new Alert("Detials");
		
		details = new Command("Details",Command.ITEM,1);
		delete = new Command("Delete",Command.ITEM,1);
		purchase = new Command("Purchase",Command.ITEM,1);
		back = new Command("back",Command.BACK,0);
		detailAll = new Command("All Detail",Command.BACK,0);
		
		purchaseForm = new Purchase(display,dp,v);
		
		list.addCommand(details);
		list.addCommand(delete);
		list.addCommand(purchase);
		list.addCommand(back);
		list.addCommand(detailAll);
		
		list.setCommandListener(this);
	}
	
	public void show(){
		list.deleteAll();
		System.out.println();
		if(purchasedItems.size()>0){
			for(int i=0;i<purchasedItems.size();i++){
				list.append(purchasedItems.elementAt(i).toString(),null);
			}
			display.setCurrent(list);
		}else{
			alert.setTitle("Basket?");
			alert.setString("No any Item..");
			display.setCurrent(alert,parentForm);
		}
	}
	
	public void commandAction(Command c , Displayable d){
		System.out.println("Entered in command action of view basket");
		String label = c.getLabel();
		if(label.equals("back")){
			display.setCurrent(parentForm);
		}
		else if(label.equals("Details")){
			System.out.println(">> Entered in details");
			bean.ItemBean bean=(bean.ItemBean) purchasedItems.elementAt(list.getSelectedIndex());
			alert.setTitle(bean.toString()+"  Details");
			alert.setTimeout(Alert.FOREVER);
			alert.setString("Name: "+bean.getName()+"\nPrice: "+bean.getPrice()+"\nQuantity: "+bean.getQuantity());
			display.setCurrent(alert,list);
		}
		else if(label.equals("Delete")){
			purchasedItems.removeElementAt(list.getSelectedIndex());
			show();
		}
		else if(label.equals("Purchase")){
			purchaseForm.show();
		}
		else if(label.equals("All Detail")){
			alert.setTitle(" All Details");
			alert.setTimeout(Alert.FOREVER);
			String str="";
			double total = 0;
			for (int i=0;i < purchasedItems.size();i++){
				bean.ItemBean bean=(bean.ItemBean) purchasedItems.elementAt(i);
				str += "\nName: "+bean.getName()+"\nPrice: "+bean.getPrice()+"\nQuantity: "+bean.getQuantity()+"\n";
				total+= Double.parseDouble(bean.getPrice().trim()) * Double.parseDouble(bean.getQuantity().trim());
			}
			alert.setString(str+"_______________\n Total : "+total);
			display.setCurrent(alert,list);
		}	
	}
}