import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Trolyload extends Frame implements ActionListener {



	
	Label title=new Label("TROLY LOAD");
	Label load=new Label("Enter load");
	Label perload1=new Label("Perload");
	Label perload2=new Label("Perload");
	Label perload3=new Label("Perload");
	Label perload4=new Label("Perload");
	Label rupee=new Label("Enter Rupees");
Label driver=new Label("Enter Driver");
Label tax=new Label("Enter Tax");
Label diesel=new Label("Enter Diesel");
Label total=new Label("Total Charges ");
Label driverpay=new Label("Driver charges");
Label taxpay=new Label("Tax Pay");
Label profit=new Label("Profit");
Button about=new Button("About");
Button cal=new Button("Calculate");
Button clear=new Button("Clear");
Font font=new Font("italic",Font.BOLD,30);
TextField loa=new TextField();
TextField rupe=new TextField();
TextField drive=new TextField();
TextField ta=new TextField();
TextField diese=new TextField();
TextField tota=new TextField();
TextField driverpa=new TextField();
TextField profi=new TextField();
TextField taxpa=new TextField();

Trolyload(){
	title.setFont(font);
	title.setBounds(60, 40, 200, 25);
	title.setBackground(Color.GREEN);
	add(title);
	setBackground(Color.cyan);
	setBounds(0,0,400,400);	
	setLayout(null);
	perload1.setBounds(242, 80, 80, 25);
	perload2.setBounds(242, 110, 80, 25);
	perload3.setBounds(242, 140, 80, 25);
	perload4.setBounds(242, 170, 80, 25);

	load.setBounds(60,80,80,25);
	add(load);
	loa.setBounds(140, 80, 100, 25);
	add(loa);
	rupe.setBounds(140, 110, 100, 25);
	add(rupe);
	rupee.setBounds(60,110,100,25);
	add(rupee);
	drive.setBounds(140, 140, 100, 25);
	add(drive);
	driver.setBounds(60,140,100,25);
	add(driver);
	ta.setBounds(140, 170, 100, 25);
	add(ta);
	tax.setBounds(60,170,100,25);
	add(tax);
	diese.setBounds(140, 200, 100, 25);
	add(diese);
	diesel.setBounds(60,200,100,25);
	add(diesel);
	cal.setBounds(140,230,100,25);
	add(cal);
	clear.setBounds(250, 230, 80, 25);
	tota.setBounds(140, 260, 100, 25);
	add(tota);
	total.setBounds(60,260,100,25);	
	add(total);
	driverpa.setBounds(140, 290, 100, 25);
	add(driverpa);
	driverpay.setBounds(60,290,100,25);
	add(driverpay);
	taxpa.setBounds(140, 320, 100, 25);
	add(taxpa);
	taxpay.setBounds(60,320,100,25);
	add(taxpay);
	profi.setBounds(140, 350, 100, 25);
	add(profi);
	profit.setBounds(60,350,100,25);
	about.setBounds(40, 230,100, 25);
	add(profit);
	add(clear);
	add(perload1);
	add(perload2);
	add(perload3);
	add(perload4);
	add(about);
	show();
	cal.addActionListener(this);
	clear.addActionListener(this);
	about.addActionListener(this);
}//end of function
	
		public void actionPerformed(ActionEvent e) {
	Object ob=e.getSource();
if(ob==clear){
	loa.setText(null);
	rupe.setText(null);
	drive.setText(null);
	ta.setText(null);
	diese.setText(null);
	tota.setText(null);
	driverpa.setText(null);
	taxpa.setText(null);
	profi.setText(null);
	
}
	if(ob==cal){
	int lo=Integer.parseInt(loa.getText());	
	int rup=Integer.parseInt(rupe.getText());	
	int driv=Integer.parseInt(drive.getText());	
	int t=Integer.parseInt(ta.getText());	
	int dies=Integer.parseInt(diese.getText());
	int totalrupees=lo*rup;
	int drivercharge=driv*lo;
	int taxperload=lo*t;
	int totalprofit=totalrupees-drivercharge-taxperload-(dies*2);
	tota.setText(""+totalrupees);
	driverpa.setText(""+drivercharge);
	taxpa.setText(""+taxperload);
	profi.setText(""+totalprofit);
	}
	if(ob==about){
		JOptionPane.showMessageDialog(null,"This program is for the transport company\nthere is calculation of 2 litr per load.\nmade by Jay kumar");
	}
				}//end of action performed

		
		public static void main(String[] args) {
		new Trolyload();
	}//end of main method
}//end of class
