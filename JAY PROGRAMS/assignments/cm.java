import javax.swing.*;

class cm{
public static void main(String arg[]){

String c=JOptionPane.showInputDialog("Enter Centimeter: ");

int cm=Integer.parseInt(c);

int c1=cm/100/1000;
int c2=cm%100000;

int c3=c2/100;
int c4=c2%100;

JOptionPane.showMessageDialog(null,"Kilometer ="+c1+"\nMeter="+c3+"\ncentimeter="+c4); 
 }
}