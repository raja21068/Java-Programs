import java.util.*;
import java.net.*;
public class ServerClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
                new Thread(){ 
    			public void run(){
    				new MainFrame().setVisible(true);
    			}
    		}.start();
    		try{
    		ServerSocket server= new ServerSocket(9000); 	
    		do{
				Socket socket = server.accept();
				System.out.println("Connected with : "+socket.getInetAddress());
				Vector v = DBManager.getAllIps();
				if(v.contains(socket.getInetAddress().getHostAddress())){
					socket.close();
				}
				else{
				new InputThread(socket).start();}
    		}while(true);
    	}catch(Exception e){}

	}

}
