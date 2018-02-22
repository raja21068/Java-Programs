import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GuiDataBase{
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		DataBaseFrame data=new DataBaseFrame();
		data.frame.setVisible(true);
	}
}

class DataBaseFrame implements ActionListener {
	JFrame frame;
	JLabel Id, Name, Fname,Nic ,RollNo, cast, Add, D_of_B, mob, email;
	JTextField IdTxt, NameTxt,NicTxt , FnameTxt, RollNoTxt, castTxt, AddTxt, D_of_BTxt, mobTxt, emailTxt;
	JButton Next, Previous;
	Connection con = DriverManager.getConnection("jdbc:odbc:Students");
	Statement st = con.createStatement();
	ResultSet res;
	int id=-1;
	DataBaseFrame()throws Exception{
		//*******************************//
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDrive");
		
		//////////initializing components\\\\\\\\
		frame = new JFrame("Student Data Base");
		Id = new JLabel("ID");
		Name = new JLabel("Name");
		Fname = new JLabel("F/Name");
		Nic = new JLabel("Nic");
		RollNo = new JLabel("Roll No");
		cast = new JLabel("Cast");
		Add = new JLabel("Address");
		D_of_B = new JLabel("Date of Birth");
		mob = new JLabel("Mob No");
		email = new JLabel("e-mail");
		IdTxt = new JTextField(); 
		NameTxt = new JTextField(); 
		FnameTxt = new JTextField();
		RollNoTxt = new JTextField();
		NicTxt = new JTextField();
		castTxt = new JTextField();
		AddTxt = new JTextField();
		D_of_BTxt = new JTextField();
		mobTxt = new JTextField();
		emailTxt = new JTextField();
		Next = new JButton("Next");
		Previous = new JButton("Previous");
		////////////////adding into frame\\\\\\\\\\\\
		frame.getContentPane().add(Id);
		frame.getContentPane().add(Name);
		frame.getContentPane().add(Fname);
		frame.getContentPane().add(RollNo);
		frame.getContentPane().add(Nic);
		frame.getContentPane().add(cast);
		frame.getContentPane().add(Add);
		frame.getContentPane().add(D_of_B);
		frame.getContentPane().add(mob);
		frame.getContentPane().add(email);
		frame.getContentPane().add(IdTxt);
		frame.getContentPane().add(NameTxt);
		frame.getContentPane().add(FnameTxt);
		frame.getContentPane().add(RollNoTxt);
		frame.getContentPane().add(castTxt);
		frame.getContentPane().add(NicTxt);
		frame.getContentPane().add(AddTxt);
		frame.getContentPane().add(D_of_BTxt);
		frame.getContentPane().add(mobTxt);
		frame.getContentPane().add(emailTxt);
		frame.getContentPane().add(Next);
		frame.getContentPane().add(Previous);
		////////////////setting bounds\\\\\\\\\\\\\\
		frame.setBounds(0,0,600,400);
		Id.setBounds(10,10,40,20);
		IdTxt.setBounds(80,10,150,20);
		Name.setBounds(10,50,50,20);
		NameTxt.setBounds(80,50,150,20);
		Fname.setBounds(10,90,50,20);
		FnameTxt.setBounds(80,90,150,20);
		cast.setBounds(10,130,50,20);
		castTxt.setBounds(80,130,150,20);
		Nic.setBounds(10,170,50,20);
		NicTxt.setBounds(80,170,150,20);
		D_of_B.setBounds(10,210,50,20);
		D_of_BTxt.setBounds(80,210,150,20);
		RollNo.setBounds(10,250,50,20);
		RollNoTxt.setBounds(80,250,150,20);
		Add.setBounds(10,290,50,20);
		AddTxt.setBounds(80,290,150,20);
		mob.setBounds(280,10,70,20);
		mobTxt.setBounds(350,10,150,20);
		email.setBounds(280,50,70,20);
		emailTxt.setBounds(350,50,150,20);
		Next.setBounds(350,90,150,40);
		Previous.setBounds(350,140,150,40);
		Next.addActionListener(this);
		Previous.addActionListener(this);
		frame.setLayout(null);
	}

	public void actionPerformed(ActionEvent e){
		Object click= e.getSource();
		int total=0;
		try{
			res = st.executeQuery("SELECT * from Data");            
			while(res.next()){total++;}
			int recordID[]= new int[total];
			res = st.executeQuery("SELECT * from Data");
			int i=0;
			while(res.next()){ recordID[i++]=Integer.parseInt(res.getString("ID"));}
			
		
		if(click == Next){if(id>=recordID.length-1){ id=-1;} id++; try{show(recordID[id]);}catch(Exception e1){}}
		if(click == Previous){if(id<=0){id=recordID.length;} id--; try{show(recordID[id]);}catch(Exception e1){}}
		
		}catch(Exception e1){}
	}
	
	void show(int ID)throws Exception{
		
		String arr[]={"ID","name","f_Name","Cast","Nic","roll_No","address","mob_No","e_mail"};
		JTextField tf[]= {IdTxt, NameTxt,FnameTxt,castTxt,NicTxt,RollNoTxt,AddTxt,mobTxt,emailTxt};
		for(int i=0;i<tf.length;i++)tf[i].setText("");
		for(int i=0;i<arr.length;i++){
		res = st.executeQuery("SELECT " +arr[i] +" from Data where ID= "+ID);
		while(res.next())tf[i].setText(res.getString(arr[i]));}
	}
}

