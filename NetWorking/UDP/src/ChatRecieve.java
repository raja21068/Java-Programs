/**
 *
 * @author jay
 */
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.util.Scanner;

public class ChatRecieve {
    public static void main(String arg[])throws Exception{
        Scanner scan = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket(9090);
        byte data[] = new byte[500];
        String s="";
        do{
            DatagramPacket packet = new DatagramPacket(data,0,data.length);
            socket.receive(packet);
            s = new String(data,0,data.length);
            System.out.println(s);
           
            s=scan.nextLine();
            data = s.getBytes();
            DatagramPacket packet2 = new DatagramPacket(data,0,data.length ,packet.getAddress(),packet.getPort());
            socket.send(packet2);
        }while(true);
    }
}
