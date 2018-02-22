import java.util.*;
class table{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter last table no:");
int t=ob.nextInt();
System.out.print("Enter counter no:");
int c=ob.nextInt();
for (int i=1;i<=t;i++){
System.out.print("\nTable No:"+i+"\n");
for (int j=1;j<=c;j++){
System.out.print(i+"x"+j+"="+i*j+"\n");
}
}
}
}