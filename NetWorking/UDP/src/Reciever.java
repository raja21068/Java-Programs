/**
 *
 * @author jay
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Reciever {
    public static void main(String args[])throws Exception{
        DatagramSocket socket = new DatagramSocket(9090);
        byte data[] = new byte[500];
        DatagramPacket packet = new DatagramPacket(data,0 ,data.length);
        socket.receive(packet);
        String str = new String(data,0,data.length);
        System.out.println(str);
    }
}
