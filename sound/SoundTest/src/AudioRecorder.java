/**
 *
 * @author Jay Kumar
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import java.applet.*;

public class AudioRecorder extends JFrame{

  AudioFormat audioFormat;
  TargetDataLine targetDataLine;

  JButton captureBtn = new JButton("Capture",new ImageIcon("record.png"));
  JButton stopBtn = new JButton("Stop",new ImageIcon("stop.png"));
  JButton playBtn = new JButton("Play",new ImageIcon("play.png"));
  JButton saveBtn=new JButton("Save",new ImageIcon("save.png"));

  JPanel btnPanel = new JPanel();
  ButtonGroup btnGroup = new ButtonGroup();
  JRadioButton aifcBtn =
                        new JRadioButton("AIFC");
  JRadioButton aiffBtn =
                        new JRadioButton("AIFF");
  JRadioButton auBtn =//selected at startup
                     new JRadioButton("AU",true);
  JRadioButton sndBtn =
                         new JRadioButton("SND");
  JRadioButton waveBtn =
                        new JRadioButton("WAVE");

  public static void main( String args[]){
    new AudioRecorder();
  }//end main

  public AudioRecorder(){//constructor
    captureBtn.setEnabled(true);
    stopBtn.setEnabled(false);

    //Register anonymous listeners
    captureBtn.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          captureBtn.setEnabled(false);
          stopBtn.setEnabled(true);
          //Capture input data from the
          // microphone until the Stop button is
          // clicked.
          captureAudio();
        }//end actionPerformed
      }//end ActionListener
    );//end addActionListener()

    stopBtn.addActionListener(
      new ActionListener(){
        public void actionPerformed(
                                  ActionEvent e){
          captureBtn.setEnabled(true);
          stopBtn.setEnabled(false);
          //Terminate the capturing of input data
          // from the microphone.
          targetDataLine.stop();
          targetDataLine.close();
        }//end actionPerformed
      }//end ActionListener
    );//end addActionListener()

   playBtn.addActionListener(
	new ActionListener(){
		public void actionPerformed(ActionEvent e){
			AudioClip clip;
			try{
				
				clip= Applet.newAudioClip(new File("junk.au").toURL());
				System.out.println("played");
				clip.play();
				
			}catch(Exception e1){
				
			}
		}
	}//end of actionListener	   
   );//end of addActionListener
   
   saveBtn.addActionListener(
		   new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   Frame win=new Frame();
					FileDialog dialog=new FileDialog(win,"open....",FileDialog.SAVE);
					dialog.show();
					String desti=dialog.getDirectory() + dialog.getFile();
					 try{
						 DataInputStream in = new DataInputStream(new FileInputStream("junk.au"));
						 File f=new File(desti+".au");
						 f.createNewFile();
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
					 }catch(Exception e1){}
			   }
		   });
    
    //Put the buttons in the JFrame
    getContentPane().add(captureBtn);
    getContentPane().add(stopBtn);
    getContentPane().add(playBtn);
    getContentPane().add(saveBtn);
    
    //Include the radio buttons in a group
    btnGroup.add(aifcBtn);
    btnGroup.add(aiffBtn);
    btnGroup.add(auBtn);
    btnGroup.add(sndBtn);
    btnGroup.add(waveBtn);

    //Add the radio buttons to the JPanel
   //TODO btnPanel.add(aifcBtn);
    //TODO btnPanel.add(aiffBtn);
    btnPanel.add(auBtn);
    //TODO btnPanel.add(sndBtn);
    //TODO btnPanel.add(waveBtn);

    //Put the JPanel in the JFrame
    getContentPane().add(btnPanel);

    //Finish the GUI and make visible
    getContentPane().setLayout(new FlowLayout());
    setTitle("Recording....  (Jay Kumar)");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(450,120);
    setIconImage(Toolkit.getDefaultToolkit().getImage("radio.png"));
    setVisible(true);
  }//end constructor

  //This method captures audio input from a
  // microphone and saves it in an audio file.
  private void captureAudio(){
    try{
      //Get things set up for capture
      audioFormat = getAudioFormat();
      DataLine.Info dataLineInfo =
                          new DataLine.Info(
                            TargetDataLine.class,
                            audioFormat);
      targetDataLine = (TargetDataLine)
               AudioSystem.getLine(dataLineInfo);

      //Create a thread to capture the microphone
      // data into an audio file and start the
      // thread running.  It will run until the
      // Stop button is clicked.  This method
      // will return after starting the thread.
      new CaptureThread().start();
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end captureAudio method

  //This method creates and returns an
  // AudioFormat object for a given set of format
  // parameters.  If these parameters don't work
  // well for you, try some of the other
  // allowable parameter values, which are shown
  // in comments following the declarations.
  private AudioFormat getAudioFormat(){
    float sampleRate = 8000.0F;
    //8000,11025,16000,22050,44100
    int sampleSizeInBits = 16;
    //8,16
    int channels = 1;
    //1,2
    boolean signed = true;
    //true,false
    boolean bigEndian = false;
    //true,false
    return new AudioFormat(sampleRate,
                           sampleSizeInBits,
                           channels,
                           signed,
                           bigEndian);
  }//end getAudioFormat
//=============================================//

//Inner class to capture data from microphone
// and write it to an output audio file.
class CaptureThread extends Thread{
  public void run(){
    AudioFileFormat.Type fileType = null;
    File audioFile = null;

    //Set the file type and the file extension
    // based on the selected radio button.
    if(aifcBtn.isSelected()){
      fileType = AudioFileFormat.Type.AIFC;
      audioFile = new File("junk.aifc");
    }else if(aiffBtn.isSelected()){
      fileType = AudioFileFormat.Type.AIFF;
      audioFile = new File("junk.aif");
    }else if(auBtn.isSelected()){
      fileType = AudioFileFormat.Type.AU;
      audioFile = new File("junk.au");
    }else if(sndBtn.isSelected()){
      fileType = AudioFileFormat.Type.SND;
      audioFile = new File("junk.snd");
    }else if(waveBtn.isSelected()){
      fileType = AudioFileFormat.Type.WAVE;
      audioFile = new File("junk.wav");
    }//end if

    try{
      targetDataLine.open(audioFormat);
      targetDataLine.start();
      AudioSystem.write(new AudioInputStream(targetDataLine), fileType, audioFile);
    }catch (Exception e){
      e.printStackTrace();
    }//end catch

  }//end run
}//end inner class CaptureThread
//=============================================//

}//end outer class AudioRecorder02.java