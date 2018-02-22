/*this program gives us pay slip..*/
import javax.swing.*;

class payslip{
public static void main(String arg[]){
String s=JOptionPane.showInputDialog("Enter Employee basic salary?");
int sal=Integer.parseInt(s);
int per=sal/100; /*this is 1% of salary*/
int halfp=per/2;
int ma=per*15;
int hr=per*45;
int bo=per*5;
int grospay=sal+ma+hr+bo;
int tax=per*8;
int ca=per*15;
int zak=halfp+(per*2);
int net=grospay-tax-ca-zak;
JOptionPane.showMessageDialog(null,"Basic pay= "+sal+"\nMedical allounce 15%= "+ma+"\nHouse rent 45%= "+hr+"\nBonus 5%= "+bo+"\nGross pay= "+grospay+"\nIncome tax 8%="+tax+"\nConvence Allounce 15%="+ca+"\nZakwat 2.5%="+zak+"\nNet Income:"+net);
 }
}
