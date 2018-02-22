import javax.swing.*;

class fact2{

public static void main(String arg[]){

String num=JOptionPane.showInputDialog("Enter No:"); 
int n=Integer.parseInt(num);
int i=1,j=1;
String s="";
String s2="";
for (i=1,j=1;j<=n;j++)
{
i=i*j;
s=(""+i+"\n");
s2=s2+s;
}
 JOptionPane.showMessageDialog(null,s2);
}
}