import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


class AbcAudio extends Frame implements KeyListener {
	ImageIcon icon=new ImageIcon("abc.jpg");
	JLabel pic=new JLabel(icon);
	AbcAudio(){
		//FlowLayout b=new FlowLayout();
		//setLayout(null);
		setBounds(0,0,500,800);
		addKeyListener(this);
		add(pic);
		show();
	}
	



	public void play(String FileName) throws Exception{
	File f=new File(FileName);
	System.out.println(f.exists());
	AudioClip clip=Applet.newAudioClip(f.toURL());
	clip.play();
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		char ch=e.getKeyChar();
		try{
		switch(ch){
		case 'a':
		case 'A': play("A.wav"); break;	
		case 'b':
		case 'B': play("B.wav"); break;
		case 'c':
		case 'C': play("C.wav"); break;	
		case 'd':
		case 'D': play("D.wav"); break;
		case 'e':
		case 'E': play("E.wav"); break;	
		case 'f':
		case 'F': play("F.wav"); break;
		case 'g':
		case 'G': play("G.wav"); break;	
		case 'h':
		case 'H': play("H.wav"); break;
		case 'i':
		case 'I': play("J.wav"); break;	
		case 'j':
		case 'J': play("K.wav"); break;
		case 'k':
		case 'K': play("K.wav"); break;	
		case 'l':
		case 'L': play("L.wav"); break;
		case 'm':
		case 'M': play("M.wav"); break;	
		case 'n':
		case 'N': play("N.wav"); break;
		case 'o':
		case 'O': play("O.wav"); break;	
		case 'p':
		case 'P': play("P.wav"); break;
		case 'q':
		case 'Q': play("Q.wav"); break;	
		case 'r':
		case 'R': play("R.wav"); break;
		case 's':
		case 'S': play("S.wav"); break;	
		case 't':
		case 'T': play("T.wav"); break;
		case 'u':
		case 'U': play("U.wav"); break;	
		case 'v':
		case 'V': play("V.wav"); break;
		case 'w':
		case 'W': play("W.wav"); break;	
		case 'x':
		case 'X': play("X.wav"); break;
		case 'y':
		case 'Y': play("Y.wav"); break;	
		case 'z':
		case 'Z': play("Z.wav"); break;
		}
		}catch(Exception e1){e1.printStackTrace();}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new AbcAudio();
	}
}
