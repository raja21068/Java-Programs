import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Sender {
    public static void main(String arg[])throws Exception{
        
        String s = "Hello java students..";
        byte[] data= s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.10");
        DatagramPacket packet = new DatagramPacket(data,0,data.length,address,9090);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
    }
}
