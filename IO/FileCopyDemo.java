import java.io.*;

class FileCopyDemo{
public static void main(String arg[])throws Exception{
    //Source
    DataInputStream in = new DataInputStream(new FileInputStream("E:/328.jpg"));

    //Destination
    File f = new File("D:/328.jpg");
    if(!f.exists()) f.createNewFile();
    PrintStream out = new PrintStream(new FileOutputStream(f));

    int size = in.available();
    int packetSize = 10000;
    int totalPackets = size / packetSize;
    int lastPacketSize = size % packetSize;
   
    byte b[] = new byte[packetSize];
    int i;
    for(i=1; i<=totalPackets; i++){
        in.readFully(b, 0, b.length);
        out.write(b, 0, b.length);
        System.out.println("Packet : " + i);
    }

    System.out.println("Last Packet : " + i);
    in.readFully(b, 0, lastPacketSize);
    out.write(b, 0, lastPacketSize);

    System.out.println("File Size     : " + size);
    System.out.println("Last Packet   : " + lastPacketSize);

    System.out.println("File Copied Successfully...");
}
} 