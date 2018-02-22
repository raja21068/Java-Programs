import java.util.*;

class cont{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("How much item you have purchased: ");
int item=ob.nextInt();
int c=0;
for (int i=1,j=1; j<=item;i++ )
{
int a=ob.nextInt();
if(a<1)continue;
j++;
c+=a;



}
System.out.print("Total is: "+c);
}
}