/**
 *
 * @author Jay Kumar
 */
import javax.swing.*;
import java.awt.event.*;
public class Test {
        SoundTest sound;
        
        JFrame frame; 
        JButton recordButton;
        JButton stopButton;
    
        Test(){
            frame = new JFrame();
        recordButton = new JButton();
        stopButton = new JButton();
        
        frame.setBounds(100, 100, 200, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        recordButton.setText("Record");
        recordButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sound = new SoundTest();
                sound.start();
                stopButton.setEnabled(true);
              recordButton.setEnabled(false);
            }
        });
        stopButton.setText("Stop");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              sound.stopCapture();
              sound.stop();
              stopButton.setEnabled(false);
              recordButton.setEnabled(true);
            }
        });
        frame.getContentPane().add(recordButton);
        frame.getContentPane().add(stopButton);
        recordButton.setBounds(10,10,80,30);
        stopButton.setBounds(40,40,80,30);
        frame.setVisible(true);
    }
    public static void main(String arg[]){
     new Test();   
    }
}
