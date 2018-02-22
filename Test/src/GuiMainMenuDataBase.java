import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class GuiMainMenuDataBase {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDrive");
		new GuiMainMenuDataBase().new DBFrame().setVisible(true);
	}
	
	
	class DBFrame extends JFrame implements ActionListener{
		JButton  InsertNew,Delete,Update,Select,Exit,Search;
		Connection con;
		Statement st;
		ResultSet rs;
		InsertStudent addNew;
		DeleteStudent delete;
		UpdateStudent update;
		 DBFrame(){
			try{
				con = DriverManager.getConnection("jdbc:odbc:Students");
				st = con.createStatement();
				addNew = new InsertStudent(this);
				delete = new DeleteStudent(this);
				update = new UpdateStudent(this);
			}catch(Exception e){}
			
			
			initComponents();
			setTitle("Data Base Menu");
			setSize(400,400);
			setLayout(new FlowLayout());
			
		}
		private void initComponents(){
			InsertNew = new JButton("Insert New Student");
			Delete = new JButton("Delete Student record");
			Update = new JButton("Update Student Record");
			Select = new JButton("Select View Student");
			Search = new JButton("Search Record");
			Exit = new JButton("Exit");
			InsertNew.setFont(new Font("arial",Font.BOLD,30));
			Delete.setFont(new Font("arial",Font.BOLD,30));
			Update.setFont(new Font("arial",Font.BOLD,30));
			Select.setFont(new Font("arial",Font.BOLD,30));
			Search.setFont(new Font("arial",Font.BOLD,30));
			Exit.setFont(new Font("arial",Font.BOLD,30));
			getContentPane().add(InsertNew);
			getContentPane().add(Delete);
			getContentPane().add(Update);
			getContentPane().add(Select);
			getContentPane().add(Search);
			getContentPane().add(Exit);
			InsertNew.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					InsertNewActionPerformed(e);
				}
			});
			Delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					DeleteActionPerformed(e);
				}
			});
			Update.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					UpdateActionPerformed(e);
				}
			});
			Select.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					SelectActionPerformed(e);
				}
			});	
			Search.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					SearchActionPerformed(e);
				}
			});
			Exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
		}
		private void InsertNewActionPerformed(ActionEvent e){addNew.setVisible(true);}
		private void DeleteActionPerformed(ActionEvent e){ delete.setVisible(true); }
		private void UpdateActionPerformed(ActionEvent e){ update.setVisible(true); }
		private void SearchActionPerformed(ActionEvent e){}
		private void SelectActionPerformed(ActionEvent e){}
		@Override
		public void actionPerformed(ActionEvent e) {}
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////
	class InsertStudent extends InsertFrame{

		DBFrame main;
		InsertStudent(DBFrame frame)throws Exception{
			main = frame;
			initComp();
		}
		public void setAllValue(String value){
			name = fname = nic = rollno = castt = addr = d_of_b =mobno = emailadd =value;
		}
		@Override
		void okActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			name = fname = nic = rollno = castt = addr = d_of_b =mobno = emailadd =null;
			System.out.println("Done");
			name= NameTxt.getText();
		    fname= FnameTxt.getText();
			nic = NicTxt.getText();
			rollno = RollNoTxt.getText();
			castt = castTxt.getText();
			addr = AddTxt.getText();
			d_of_b = D_of_B.getText();
			mobno = mobTxt.getText();
			emailadd = emailTxt.getText();
			try{
			int r = main.st.executeUpdate("INSERT into Data(name, f_Name, Cast,roll_No, Nic, address, mob_No, e_mail)values('"+name+"', '"+fname+"', '"+castt+"','"+rollno+"','"+nic+"','"+addr+"','"+mobno+"','"+emailadd+"')");
			System.out.println(r);}catch(Exception e1){}
			dispose();
		}
		@Override
		void CancelActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			name = fname = nic = rollno = castt = addr = d_of_b =mobno = emailadd =null;
			dispose();
		}
	}
	
	
	
	class DeleteStudent extends DeleteFrame{
		DBFrame main;
		
		DeleteStudent(DBFrame frame){
			main = frame;
			setTitle("Delete Students");	
		}
		@Override
		void deleteActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
			int r=main.st.executeUpdate("DELETE from Data where ID ="+Integer.parseInt(txt.getText()));
			System.out.println(r);
			if(r!=1){
				javax.swing.JOptionPane.showMessageDialog(this,"ID Does not exist");txt.setText("");
				}
			else{ javax.swing.JOptionPane.showMessageDialog(this,"Record Deleted...."); dispose();}
			}catch(Exception e1){e1.printStackTrace();}
		}
		@Override
		void cancelActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();	
		}
		
	}
	
	class UpdateStudent extends DeleteFrame{
		DBFrame main;
		ChildInsertFrame insert;
		UpdateStudent(DBFrame main){
			this.main = main;
			insert = new ChildInsertFrame(main); 
			insert.initComp();
			insert.setTitle("Update");
			try{
				delete.setText("Update");
				setTitle("Update Id");
			}
			catch(Exception e){e.printStackTrace();}
		}
		@Override
		void deleteActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			try{
				int Id = Integer.parseInt(txt.getText());
				String checkNull=null;
				main.rs = main.st.executeQuery("SELECT name from Data where ID =" +Id);
				while(main.rs.next())checkNull = (main.rs.getString("name"));
				if(checkNull!=null){ insert.setVisible(true); dispose(); 
									 insert.setTitle(""+Id);
									 insert.NameTxt.setText(checkNull);
									 main.rs = main.st.executeQuery("SELECT f_Name from Data where ID =" +Id);
									 while(main.rs.next())insert.FnameTxt.setText(main.rs.getString("f_Name"));
									 main.rs = main.st.executeQuery("SELECT Cast from Data where ID =" +Id);
									 while(main.rs.next())insert.castTxt.setText(main.rs.getString("Cast"));
									 main.rs = main.st.executeQuery("SELECT D_of_B from Data where ID =" +Id);
									 while(main.rs.next())insert.D_of_BTxt.setText(main.rs.getString("D_of_B"));
									 main.rs = main.st.executeQuery("SELECT Nic from Data where ID =" +Id);
									 while(main.rs.next())insert.NicTxt.setText(main.rs.getString("Nic"));
									 main.rs = main.st.executeQuery("SELECT roll_No from Data where ID =" +Id);
									 while(main.rs.next())insert.RollNoTxt.setText(main.rs.getString("roll_No"));
									 main.rs = main.st.executeQuery("SELECT address from Data where ID =" +Id);
									 while(main.rs.next())insert.AddTxt.setText(main.rs.getString("address"));
									 main.rs = main.st.executeQuery("SELECT mob_No from Data where ID =" +Id);
									 while(main.rs.next())insert.mobTxt.setText(main.rs.getString("mob_No"));
									 main.rs = main.st.executeQuery("SELECT e_mail from Data where ID =" +Id);
									 while(main.rs.next())insert.emailTxt.setText(main.rs.getString("e_mail"));
									 
									 								 
				}
			}
			catch(NumberFormatException e1){JOptionPane.showMessageDialog(this,"Invalid Id.."); txt.setText("");}
			catch(SQLException e1){ e1.printStackTrace(); }
		
		}
		@Override
		void cancelActionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	
}// end of main class


abstract class InsertFrame extends JFrame{
	JLabel Name, Fname,Nic ,RollNo, cast, Add, D_of_B, mob, email;
	JTextField NameTxt,NicTxt , FnameTxt, RollNoTxt, castTxt, AddTxt, D_of_BTxt, mobTxt, emailTxt;
	JButton OK, Cancel;
	String name,fname,nic,rollno,castt,addr,d_of_b,mobno,emailadd;
	InsertFrame(){}
			void initComp(){
		//*******************************//
			setTitle("Insert new Student Record");
			//////////initializing components\\\\\\\\

			Name = new JLabel("Name");
			Fname = new JLabel("F/Name");
			Nic = new JLabel("Nic");
			RollNo = new JLabel("Roll No");
			cast = new JLabel("Cast");
			Add = new JLabel("Address");
			D_of_B = new JLabel("Date of Birth");
			mob = new JLabel("Mob No");
			email = new JLabel("e-mail");
			NameTxt = new JTextField(); 
			FnameTxt = new JTextField();
			RollNoTxt = new JTextField();
			NicTxt = new JTextField();
			castTxt = new JTextField();
			AddTxt = new JTextField();
			D_of_BTxt = new JTextField();
			mobTxt = new JTextField();
			emailTxt = new JTextField();
			OK = new JButton("Save");
			Cancel = new JButton("Cancel");
			////////////////adding into frame\\\\\\\\\\\\
			
			getContentPane().add(Name);
			getContentPane().add(Fname);
			getContentPane().add(RollNo);
			getContentPane().add(Nic);
			getContentPane().add(cast);
			getContentPane().add(Add);
			getContentPane().add(D_of_B);
			getContentPane().add(mob);
			getContentPane().add(email);
			
			getContentPane().add(NameTxt);
			getContentPane().add(FnameTxt);
			getContentPane().add(RollNoTxt);
			getContentPane().add(castTxt);
			getContentPane().add(NicTxt);
			getContentPane().add(AddTxt);
			getContentPane().add(D_of_BTxt);
			getContentPane().add(mobTxt);
			getContentPane().add(emailTxt);
			getContentPane().add(OK);
			getContentPane().add(Cancel);
			////////////////setting bounds\\\\\\\\\\\\\\
			setBounds(0,0,600,400);
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
			OK.setBounds(350,90,150,40);
			Cancel.setBounds(350,140,150,40);
			setLayout(null);	
			OK.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					okActionPerformed(e);
				}
			});
			Cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					CancelActionPerformed(e);
				}
			});
			
	}
			abstract void okActionPerformed(ActionEvent e);
			abstract void CancelActionPerformed(ActionEvent e);
}


abstract class DeleteFrame extends JFrame{
	JTextField txt;
	JLabel label;
	JButton delete,cancel;
	DeleteFrame(){
		initComp();
	}
	void initComp(){label = new JLabel("Enter Student ID:");
	txt = new JTextField();
	delete = new JButton("Delete");
	cancel = new JButton("Cancel");
	setLayout(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setBounds(400,400,400,200);
	label.setBounds(20,40,100,20);
	txt.setBounds(label.getX()+100,label.getY(),60,20);
	delete.setBounds(60,100,100,30);
	cancel.setBounds(170,100,100,30);
	getContentPane().add(delete);
	getContentPane().add(cancel);
	getContentPane().add(label);
	getContentPane().add(txt);
	delete.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try{deleteActionPerformed(e);}catch(Exception e1){}
		}
	});
	cancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			cancelActionPerformed(e);
		}
	});}
	abstract void deleteActionPerformed(ActionEvent e);
	abstract void cancelActionPerformed(ActionEvent e);
}
class ChildInsertFrame extends InsertFrame{
	GuiMainMenuDataBase.DBFrame main;
	ChildInsertFrame(GuiMainMenuDataBase.DBFrame f){ main = f; }
	@Override
	void okActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
		main.st.executeUpdate("UPDATE Data SET name ='"+NameTxt.getText()+
				"' ,f_Name='"+FnameTxt.getText()+
				"', Cast= '"+castTxt.getText()+
				"',D_of_B='"+D_of_BTxt.getText()+
				"',roll_No='"+RollNoTxt.getText()+
				"', Nic ='"+NicTxt.getText()+
				"', address='"+AddTxt.getText()+
				"',mob_No='"+mobTxt.getText()+
				"',e_mail='"+emailTxt.getText()+"' where ID="+Integer.parseInt(getTitle()));
		
		}catch(Exception e1){e1.printStackTrace();}
		finally{dispose(); }
	}

	@Override
	void CancelActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}
	
}