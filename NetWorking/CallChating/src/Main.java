/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay Kumar
 */
import java.net.*;
import javax.swing.*;

public class Main {
    public static void main(String arg[]){ 
        ClientFrame client=new ClientFrame();
        client.setVisible(true);
                try{
                    ServerSocket server= new ServerSocket(); 	
                    do{
			Socket socket = server.accept();
			System.out.println("Connected with : "+socket.getInetAddress());
                        PlayTone tonePlay=new PlayTone(new java.io.File("call.wav"));
                        int i=JOptionPane.showConfirmDialog(null, socket.getInetAddress().getCanonicalHostName()+" is Calling You , want to accept?");
                        
                        if(i==0){ 
                            new InputThreadOfServer(socket).start();
                            tonePlay.stop();
                        }
                        else {socket.close();
                        tonePlay.stop();}
                        
    		}while(true);
    	}catch(Exception e){e.printStackTrace();}
}
}
