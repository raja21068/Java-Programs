import javax.swing.*;

class steric{
public static void main(String arg[]){

int code;

do{
String str1="";

int a=Integer.parseInt(JOptionPane.showInputDialog("Enter row number:"));
int i=1;
while(i<=a){
int j=i;
while(j<=a){
str1+="*";

j++;
}
str1+="\n";
i++;
}

code=JOptionPane.showConfirmDialog(null,str1+"Do you want to repeat:","Confirm",JOptionPane.YES_NO_OPTION);
} while(code==JOptionPane.YES_OPTION);


}

}