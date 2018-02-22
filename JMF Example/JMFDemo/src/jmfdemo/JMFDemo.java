/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmfdemo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.media.Player;
import javax.media.Manager;
import javax.swing.JFrame;
import java.net.URL;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.NoDataSourceException;
import javax.media.NoPlayerException;
import javax.media.format.VideoFormat;
import javax.media.protocol.DataSource;

public class JMFDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, NoPlayerException, CannotRealizeException, NoDataSourceException {
        
        JFrame frame = new JFrame("Player Example");
        frame.setSize(500,500);
        
        Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
//        Manager.setHint(Manager.PLUGIN_PLAYER, true);
//        System.out.println(Manager.getCacheDirectory());
//        
        javax.swing.JFileChooser choose = new javax.swing.JFileChooser();
        choose.showOpenDialog(frame);
        URL url = new URL("file://"+choose.getSelectedFile().getAbsolutePath());
//        System.out.println();
//        Player player = Manager.createRealizedPlayer(new URL("file://C:/Users/DELL/Desktop/test.avi"));
//        java.io.File mediafile = new java.io.File("C:/Users/DELL/Desktop/test.avi");
//        DataSource source = Manager.createDataSource(new javax.media.MediaLocator(mediafile.toURL())); 
//        Player player = Manager.createRealizedPlayer(url);
        Player player = Manager.createPlayer(url);
//        Player player = Manager.createPlayer(source); 
//        javax.media.Control controls[] = player.getControls();
//        for (int i=0;i<controls.length;i++){
//            System.out.println(controls[i]);
//            try{
//            frame.getContentPane().add(controls[i].getControlComponent());
//            }catch(Exception ex){ex.printStackTrace();}
//        }
        
        player.realize();
        player.prefetch();
//        
        Component screen = player.getVisualComponent();
        Component control = player.getControlPanelComponent();
        Component gain = player.getGainControl().getControlComponent();
        
        if(screen!=null) {
            frame.getContentPane().add(screen , BorderLayout.CENTER);
        }
        if(control!=null) {
            frame.getContentPane().add(control, BorderLayout.SOUTH);
        }
//        if(gain!=null) {
//            frame.getContentPane().add(gain,BorderLayout.WEST);
//        }
        
//      
//        CaptureDeviceInfo info = CaptureDeviceManager.getDevice("vfw://1");
//        System.out.println(info.getName());
       
//        java.util.Vector info = CaptureDeviceManager.getDeviceList(new javax.media.format.RGBFormat());
//        java.util.Vector info = CaptureDeviceManager.getDeviceList(new javax.media.format.VideoFormat(VideoFormat.YUV));
//        java.util.Vector info = CaptureDeviceManager.getDeviceList(new javax.media.format.AudioFormat("linear", 44100, 16, 2 ));
//        System.out.println(info.size());
//        for (int i=0;i<info.size();i++){
//            System.out.println(info);
//        }
//        javax.media.bean.playerbean.MediaPlayer player = new javax.media.bean.playerbean.MediaPlayer();
//        
//        player.setMediaLocation(choose.getSelectedFile().getAbsolutePath());
//        Component com = player.getVisualComponent();
//        Component control = player.getControlPanelComponent();
//          if(com!=null) {
//            frame.getContentPane().add(com , BorderLayout.CENTER);
//        }
//        if(control!=null) {
//            frame.getContentPane().add(control, BorderLayout.SOUTH);
//        }
//        player.start();
        
        frame.setVisible(true);
    }
}
