package clonevideotransmission;

import java.io.*;
import java.net.*;

/**
 * Title:        Multicast Video Transmission System
 * Description:  This program will demostrate u to transfer video to multiple clients at the same time
 * Copyright:    Copyright (c) 2005
 * Company:      Institute of Information Tecehnology, University Sindh, Jamshoro
 * @author Sachal Joyo
 * @version 1.0
 */

public class TransmitHandlerClient extends Thread{

  private int mediaPort;
  private boolean isClone;
  private String ipAddress;

  public TransmitHandlerClient(int mediaPort,String ipAddress,boolean isClone) {
     this.mediaPort=mediaPort;
     this.isClone=isClone;
     this.ipAddress=ipAddress;
  }//end of cons.

  public void run(){
   try{
        Socket socket=new Socket(ipAddress,9000);
        
        System.out.println(">> Run method in TramitHandlerClient: 1");
        
        DataInputStream input=new DataInputStream(socket.getInputStream());
        DataOutputStream output=new DataOutputStream(socket.getOutputStream());
        
        System.out.println(">> Run method in TramitHandlerClient: 2");
        
        String header=mediaPort+"[]"+ (isClone ? "Clone":"DataSource");
        output.writeBytes(header+"\n");
        
        System.out.println(">> Run method in TramitHandlerClient: 3");
        
   }catch(Exception e){
     e.printStackTrace();
   }
  }//end run()
}//end class