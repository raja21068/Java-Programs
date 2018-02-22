import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class PicChangeCoding implements ActionListener {
	
	JButton[] btn = new JButton[24];
	int[] btnValue= new int[24];
	int temp; int second=1; int btnNo;
	JFrame frame;
	PicChangeCoding(){
		frame = new JFrame();
		frame.setLayout(new GridLayout(6,4));
		frame.setDefaultCloseOperation(3);
		frame.setBounds(200,200,400,400);
		for(int i=0; i<btn.length; i++)btn[i]= new JButton();
		for(int i=0; i<btn.length; i++){
			frame.getContentPane().add(btn[i]);
			btn[i].addActionListener(this);
		}
		frame.show();
		randomValue();
	}

	public void actionPerformed(ActionEvent e){
		int i=0;
		for( ; i<btnValue.length ; i++){
			if(e.getSource()==btn[i]){ btn[i].setText(""+btnValue[i]); break;}
		}
		if(second==1){ second=2; btnNo=i; temp=btnValue[i]; }
		else if(second==2){ 
			if(btnValue[i]==temp){JOptionPane.showMessageDialog(null,"Bingo"); btn[i].setEnabled(false); btn[btnNo].setEnabled(false); btn[i].setBackground(Color.green);btn[btnNo].setBackground(Color.green);} 
			try{Thread.sleep(1000);}catch(Exception e1){}
			for(int j=0;j<btn.length; j++){btn[j].setText("");}
			randomValue();
			second=1;
		}
	}//end of action performed
	 void randomValue(){
		System.out.println("*******NEW RANDOM**********");
		 for(int i=0 ; i<btn.length; i++){
			 int rand =(int) (Math.random()*5)+1;
			 System.out.println(i+"==>"+rand);
			 btnValue[i]=rand;
		 }
	 }

}
