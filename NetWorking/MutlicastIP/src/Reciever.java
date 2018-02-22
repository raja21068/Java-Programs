import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Jay Kumar
 */
public class Reciever {
    public static void main(String args[])throws Exception{
        MulticastSocket socket = new MulticastSocket(9090);
        byte[] data = new byte[200];
        DatagramPacket packet = new DatagramPacket(data,0,data.length);
        socket.joinGroup(InetAddress.getByName("224.0.0.10"));
        do{
            socket.receive(packet);
            String str = new String(packet.getData(),0,packet.getLength());
            System.out.println(str);
        }while(true);
    }
}
