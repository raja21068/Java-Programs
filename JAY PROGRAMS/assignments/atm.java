import javax.swing.*;

class atm{
public static void main(String arg[]){

String r=JOptionPane.showInputDialog("Enter Rupees: ");

int rupee=Integer.parseInt(r);

int t1=rupee/5000;
int t2=rupee%5000;

int t3=t2/1000;
int t4=t2%1000;

int t5=t4/500;
int t6=t4%500;

int t7=t6/100;
int t8=t6%100;

int t9=t8/50;
int t10=t8%50;

int t11=t10/20;
int t12=t10%20;

int t13=t12/10;
int t14=t12%10;

int t15=t14/5;
int t16=t14%5;


int t17=t16/2;
int t18=t16%2;

JOptionPane.showMessageDialog(null,"5000="+t1+"\n1000="+t3+"\n500="+t5+"\n100="+t7+"\n50="+t9+"\n20="+t11+"\n10="+t13+"\n5="+t15+"\n2="+t17+"\n1="+t18); 
}
}