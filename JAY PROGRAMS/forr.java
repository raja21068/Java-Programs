import java.util.*;

class forr{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter table no: "); int table=ob.nextInt();
System.out.print("Enter counter no: "); int count=ob.nextInt();

for(int a=1; a<=count; a++)
{
System.out.println(table+"x"+a+"="+table*a);
} 


}
}