import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class ThreadTutorial extends Thread implements ActionListener{

	JButton startBtn;
	JButton suspendBtn;
	JButton resumeBtn;
	JButton demoBtn;
	JButton stopBtn;
	JFrame frame;
	static int move=1;
	static int startMove=1;
	static int resumeMove=1;
	StartMove smb=new StartMove();
	ResumeMove rmb= new ResumeMove();
	
	ThreadTutorial(){
		frame = new JFrame("Thread Tutorial");
		startBtn =new JButton("Start");
		suspendBtn = new JButton("Suspend");
		resumeBtn = new JButton("Resume");
		stopBtn = new JButton("Stop");
		demoBtn = new JButton("Demo");
		
		frame.setBounds(40,40,600,700);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(3);
		frame.show();
		
		startBtn.setBounds(20,20,200,100);
		suspendBtn.setBounds(20,140,200,100);
		resumeBtn.setBounds(20,260,200,100);
		stopBtn.setBounds(20,380,200,100);
		demoBtn.setBounds(20,500,150,100);
		
		frame.getContentPane().add(startBtn);
		frame.getContentPane().add(suspendBtn);
		frame.getContentPane().add(resumeBtn);
		frame.getContentPane().add(stopBtn);
		frame.getContentPane().add(demoBtn);
	
		startBtn.addActionListener(this);
		suspendBtn.addActionListener(this);
		resumeBtn.addActionListener(this);
		
	}
	
	public void run(){
		smb.start();
		rmb.start();
		while(true){
			if(move==1)
				{for(int i=demoBtn.getX();i<(frame.getWidth()-150);i++ ){
				demoBtn.setBounds(i,demoBtn.getY(),150,100);
				frame.show();
				try{ sleep(10); }catch(Exception e){}	
				}move=2;
				}//end of if 
			if( move==2){
				for(int i=(frame.getWidth()-150);i>0;i-- ){
					demoBtn.setBounds(i,demoBtn.getY(),150,100);
					frame.show();
					try{ sleep(10); }catch(Exception e){}
					
					}move=1;
			}
		}
	}
	class StartMove extends Thread{
		public void run(){
			while(true){
				if(startMove==1)
					{for(int i=startBtn.getX();i<(frame.getWidth()-200);i++ ){
					startBtn.setBounds(i,startBtn.getY(),200,100);
					frame.show();
					try{ sleep(5); }catch(Exception e){}	
					}startMove=2;
					}//end of if 
				if( startMove==2){
					for(int i=(frame.getWidth()-200);i>0;i-- ){
						startBtn.setBounds(i,startBtn.getY(),200,100);
						frame.show();
						try{ sleep(5); }catch(Exception e){}
						
						}startMove=1;
				}
			}	
		}
	}
	
	class ResumeMove extends Thread{

		public void run(){
			while(true){
				if(resumeMove==1)
					{for(int i=resumeBtn.getX();i<(frame.getWidth()-200);i++ ){
					resumeBtn.setBounds(i,resumeBtn.getY(),200,100);
					frame.show();
					try{ sleep(3); }catch(Exception e){}	
					}resumeMove=2;
					}//end of if 
				if( resumeMove==2){
					for(int i=(frame.getWidth()-200);i>0;i-- ){
						resumeBtn.setBounds(i,resumeBtn.getY(),200,100);
						frame.show();
						try{ sleep(3); }catch(Exception e){}
						
						}resumeMove=1;
				}
			}	
		}
	}
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==startBtn){ this.start(); }
		else if(e.getSource()==suspendBtn){ this.suspend(); smb.suspend();  suspendBtn.setEnabled(false);  resumeBtn.setEnabled(true); }
		else if(e.getSource()==resumeBtn){ this.resume(); smb.resume();  suspendBtn.setEnabled(true);  resumeBtn.setEnabled(false);}
		else if(e.getSource()==stopBtn){ this.stop(); smb.stop(); rmb.stop(); }
		}//end of action performed
	
	public static void main(String[] args) {
		new ThreadTutorial();
	}

}
