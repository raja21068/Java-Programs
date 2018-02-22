import java.net.*;
import java.io.*;

public class Client {
    public static void main(String arg[])throws Exception{
        Socket socket = new Socket();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        do{
            String str = in.readUTF();
            String clients[] = str.split(",");
            for(int i=0 ; i<clients.length; i++){
                System.out.println(clients[i]);
            }
            System.out.println();
        }while(true);
    }
}
