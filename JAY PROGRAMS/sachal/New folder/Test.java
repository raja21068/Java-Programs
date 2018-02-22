 import javax.swing.*;
class test{
public static void main(String args[]){
String name = JOptionPane.showInputDialog("what is your name ?");
String subject = JOptionPane.showInputDialog("which is your subject ?");
String rollnumber = JOptionPane.showInputDialog("which is your roll number ?");
JOptionPane.showMessageDialog(null,"My name is "+ name+ "\n My subject is "+subject +"\n My roll number is "+rollnumber);
}
}
