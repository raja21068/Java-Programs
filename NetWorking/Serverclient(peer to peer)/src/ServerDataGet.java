/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay Kumar
 */

import java.io.*;
import java.net.*;

import java.util.logging.Level;
import java.util.logging.Logger;


class ServerDataGet {
Socket socket;

    ServerDataGet()
    {
        new Thread()
        {
            public void run()
            {
                try {
                    ServerSocket server=new ServerSocket(9000);	
                    while(true){
                        System.out.println("Waiting for Connect");
                        socket=server.accept();
                        new Downloader(socket).start();
                        
		javax.swing.JOptionPane.showMessageDialog(null,"An Other Client want to Connected to u");
                             System.out.println("Connected");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServerDataGet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }
    
//public static void main(String args[])throws Exception{
//
//
//
//    new ServerDataGet();
//	
//}




}
