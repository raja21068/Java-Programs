import com.sun.jna.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
interface CLibrary extends Library {
    CLibrary INSTANCE = (CLibrary) Native.loadLibrary("user32", CLibrary.class);
    //int MessageBoxA(int parentHandle, String message,String caption, int buttons);
	short GetAsyncKeyState(int key);
	//int GetKeyboardState(int j);
	}
public class jnatest {
    public static void main(String[] args) {
        try {
			
			//Example of MessageBox
			//int j=CLibrary.INSTANCE.MessageBoxA(0,"HELLO BOY","DEMO",1);	
			
			
			//Example of ACTIVE Typing Character
			JFrame f=new JFrame();
			JTextArea area=new JTextArea();
			f.add(area);
			f.setSize(500,500);
			f.setVisible(true);
			boolean isOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
						
			for(;true;){
				for(int i=0;i<256;i++){
					int j=CLibrary.INSTANCE.GetAsyncKeyState(i);	
					if(j==-32767){
						if(i>=65 && i<=91 && isOn==true){
							area.append(""+(char)i);
						}
						
						if(i>=65 && i<=91 && isOn==false){
							int tempchar=i+32;
							area.append(""+(char)tempchar);
						}
						//32 bole tou code of space button
						if(i==32){
							area.append(" ");
						}
						//13 bole tou code of enter button
						if(i==13){
							area.append("\n");
						}
						
						if(i==96 || i==48){
							area.append("0");
						}
						if(i==97 || i==49){
							area.append("1");
						}
						if(i==98|| i==50){
							area.append("2");
						}
						if(i==99|| i==51){
							area.append("3");
						}
						if(i==100|| i==52){
							area.append("4");
						}
						if(i==101|| i==53){
							area.append("5");
						}
						if(i==102|| i==54){
							area.append("6");
						}
						if(i==103|| i==55){
							area.append("7");
						}
						if(i==104|| i==56){
							area.append("8");
						}
						if(i==105|| i==57){
							area.append("9");
						}
						//8 bole tou code of backSpace button
						if(i==8){
							String totaltext=area.getText();
							area.setText("");
							for(int k=0;k<totaltext.length()-1;k++){
								area.append(""+totaltext.charAt(k));
							}
						}
						//20 bole tou code of caplock button
						if(i==20){
							isOn=!isOn;
						}
						
					}
				}
			}
			
		
		} 
		catch (Exception e) {
            System.out.println("Exception" + e);
        }
	}
}