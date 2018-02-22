import javax.swing.*;

class cube{

public static void main(String arg[]){

String num=JOptionPane.showInputDialog("Enter no:");
int n=Integer.parseInt(num);
String a="";
String b="";
for (int i=1;i<=n;i++){ 
int j=i*i; 
int k=i*i*i; 
a=i+"            "+j+"             "+k+"\n";
b=b+a;

 } 
JOptionPane.showMessageDialog(null,"no     square     cube\n"+b);

 }
  }