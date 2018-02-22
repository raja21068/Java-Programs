import javax.swing.*;
class BackgroundMove extends JFrame{
	ImageIcon Image1;
	ImageIcon Image2;
	ImageIcon helicopterIcon;
	JLabel Image1Label;
	JLabel Image2Label;
	JLabel helicopterLabel;
	
	BackgroundMove(){
		setLayout(null);
		setBounds(200,200,700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Image1=new ImageIcon("A1.jpg");
		Image1Label=new JLabel(Image1);
		Image2=new ImageIcon("A2.jpg");
		Image2Label=new JLabel(Image2);
		helicopterIcon=new ImageIcon("helicopter.png");
		helicopterLabel=new JLabel(helicopterIcon);
		
		Image1Label.setBounds(0,0,getWidth(),getHeight());
		Image1Label.setBounds(500,0,getWidth(),getHeight());
		helicopterLabel.setBounds(50,50,200,100);
		getContentPane().add(helicopterLabel);
		getContentPane().add(Image1Label);
		getContentPane().add(Image2Label);
		
		try {picMove();} catch(Exception e){}
		
		show();
	}
	
	public static void main(String arg[]){
		new BackgroundMove();
	}
	
	void picMove()throws Exception{
		for(int i=0,j=700;i>-700;i--,j--){
			Image1Label.setBounds(i,0,getWidth(),getHeight());
			Image2Label.setBounds(j,0,getWidth(),getHeight());
			Thread.sleep(20);
			show();
			if(i==-699){  i=700; }
			if(j==-699){ j=700; }
		}
	}
}