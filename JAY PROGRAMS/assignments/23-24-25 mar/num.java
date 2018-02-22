import javax.swing.*;

class num{
public static void main(String arg[]){

int code;

do{
String str1="";

int a=Integer.parseInt(JOptionPane.showInputDialog("Enter row:"));
int b=Integer.parseInt(JOptionPane.showInputDialog("Enter colmn:"));

int i=1;
while(i<=a){
int j=1;
int l=0;
while(j<=b){
l+=i;
str1+=" "+l;

j++;
}
str1+="\n";
i++;
}

code=JOptionPane.showConfirmDialog(null,str1+"Do you want to repeat:","Confirm",JOptionPane.YES_NO_OPTION);
} while(code==JOptionPane.YES_OPTION);


}

}