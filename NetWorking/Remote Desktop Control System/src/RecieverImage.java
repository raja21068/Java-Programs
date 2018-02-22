import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RecieverImage implements MouseMotionListener,MouseListener{
    JFrame frame;
    DataInputStream in;
    DataOutputStream out;
    JLabel picLabel;
    int imageHeight = 0;
    int imageWidth = 0;
    public RecieverImage()throws Exception{
        frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.addMouseMotionListener(this);
        frame.addMouseListener(this);
        picLabel = new JLabel();
        
        frame.getContentPane().add(picLabel);
        frame.setSize(600,600);
        frame.setVisible(true);
        
        ServerSocket server =new ServerSocket(9090);
        Socket socket = server.accept();
        System.out.println("connected with ...");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
         do{  
            int size = Integer.parseInt(in.readLine());
             byte data[] = new byte[size];
            in.readFully(data, 0, data.length);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(data));
            imageHeight = image.getHeight();
            imageWidth = image.getWidth();
            if(image!=null){
//                Graphics2D grph = image.createGraphics();
//                grph.scale(200, 200);
                picLabel.setSize(new Dimension(frame.getWidth()-20,frame.getHeight()-40));
                picLabel.setIcon(new ImageIcon(image.getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), 1)));
//                 picLabel.paint(grph);
//                System.out.println("Image seted");
                picLabel.repaint();
            }
        }while(true);
        
    }
    public static void main(String arg[])throws Exception{
        new RecieverImage();
    }
        @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        System.out.println("x: "+x+" , y: "+y);
        try{
        out.writeUTF(""+x);
        out.writeUTF(""+y);
        }catch(Exception ex){ex.printStackTrace();}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int labelWidth = picLabel.getWidth();
        float perW = d.width/labelWidth;
        int labelHeight = picLabel.getHeight();
        float perH = d.height/labelHeight;
        System.out.println("x:"+x+" , y:"+y);
        System.out.println( "imageWidth: "+imageWidth+",labelWidth: "+labelWidth+" , imageHeigth:"+imageHeight+" labelHeight:"+labelHeight);
        int temp;
        try{
            temp = (int)(x*perW);
            out.writeUTF(""+temp);
        System.out.println("x: "+(x*perW)+" , y: "+(y*perH));
            temp=(int)(y*perH);
            out.writeUTF(""+temp);
        }catch(Exception ex){ex.printStackTrace();}
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse"+e.getButton());
        try{
            if(e.getButton()==MouseEvent.BUTTON1)
                out.writeUTF("-1");
            else
                out.writeUTF("-2");
        }catch(Exception ex){ex.printStackTrace();}
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released:"+e.getButton());    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
//        System.out.println("x: "+x+" , y: "+y);
        try{
        out.writeUTF(""+x);
        out.writeUTF(""+y);
        }catch(Exception ex){ex.printStackTrace();}
    }

    @Override
    public void mouseExited(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        System.out.println("x: "+x+" , y: "+y);
        try{
        out.writeUTF(""+x);
        out.writeUTF(""+y);
        }catch(Exception ex){ex.printStackTrace();}
        
    }
}
