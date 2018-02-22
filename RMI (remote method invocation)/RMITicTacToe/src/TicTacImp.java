
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

class TicTacImp implements TicTacInterface{
     Server server; 
     TicTacImp(Server c){
	server = c;
     }
  public void setButton(String s , int button)throws RemoteException{
	if(button==1){
            server.button1.setText(s);
            server.button1.setEnabled(false);
        }
	if(button==2){
            server.button2.setText(s);
            server.button2.setEnabled(false);
        }
	if(button==3){
            server.button3.setText(s);
            server.button3.setEnabled(false);
        }
	if(button==4){
            server.button4.setText(s);
            server.button4.setEnabled(false);
        }
	if(button==5){
            server.button5.setText(s);
            server.button5.setEnabled(false);
        }
	if(button==6){
            server.button6.setText(s);
            server.button6.setEnabled(false);
        }
	if(button==7){
            server.button7.setText(s);
            server.button7.setEnabled(false);
        }
	if(button==8){
            server.button8.setText(s);
            server.button8.setEnabled(false);
        }
	if(button==9){
            server.button9.setText(s);
            server.button9.setEnabled(false);
        }
     }
      public void winMessage(String s)throws RemoteException{
          JOptionPane.showMessageDialog(null, "\" "+s+" \" won the Game");
      }
}