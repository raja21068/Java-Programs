/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package localdevicedetector;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author JAY KUMAR
 */
public class MyServer {

    public static void main(String arg[])throws Exception{
//        ServerSocket server = new ServerSocket(9090);
//        Socket socket = server.accept();
//        System.out.println("Accepted: "+socket);
//        socket.close();
        Socket socket = new Socket("192.168.1.7",9090);
        socket.getOutputStream().write("Hello darling\n".getBytes());
        socket.getOutputStream().flush();
        socket.close();
    }
    
}
