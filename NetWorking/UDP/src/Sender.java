/**
 *
 * @author jay
 */
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Sender {
    public static void main(String arg[])throws Exception{
    
        String s = "Hello Netlync Students";
        byte data[] =s.getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(data , 0 ,data.length ,address ,9090);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
    }
}
