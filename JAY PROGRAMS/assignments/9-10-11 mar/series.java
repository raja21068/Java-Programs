import java.util.*;

class series{

public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter no: ");
int n=ob.nextInt();
int j=3;
for (int i=-2;i<=n;j+=2){
System.out.println(i);
i=i+j;
}
}
}