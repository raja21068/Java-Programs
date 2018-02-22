import javax.swing.*;

class seconds{
public static void main(String arg[]){

String s=JOptionPane.showInputDialog("Enter Seconds: ");

int second=Integer.parseInt(s);

int s1=second/(3600*24);
int s2=second%(3600*24);

int s3=s2/3600;
int s4=s2%3600;

int s5=s4/60;
int s6=s4%60;

JOptionPane.showMessageDialog(null,"days="+s1+"\nHours="+s3+"\nMinutes="+s5+"\nsecond="+s6); 
 }
}