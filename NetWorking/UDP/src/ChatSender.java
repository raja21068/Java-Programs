/**
 *
 * @author jay
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatSender {
    public static void main(String args[])throws Exception{
        DatagramSocket socket = new DatagramSocket();
        Scanner scan = new Scanner(System.in);
        InetAddress address = InetAddress.getByName("localhost");
        String s ="";
        byte[] data;
        do{
            s = scan.nextLine();
            data = s.getBytes();
            DatagramPacket packet = new DatagramPacket(data,0,data.length,address,9090);
            socket.send(packet);
            
            byte[] dataR = new byte[100];
            DatagramPacket packet2 = new DatagramPacket(dataR,0,dataR.length,address,9090);
            socket.receive(packet2);
            s = new String(dataR , 0,dataR.length);
            System.out.println(s);
        }while(true);
    }
}
