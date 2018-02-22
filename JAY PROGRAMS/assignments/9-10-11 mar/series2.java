import java.util.*;

class series2{

public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter no: ");
int n=ob.nextInt();
int j=4;
for (int i=3;i<=n;j+=2){
System.out.println(i);
i=i+j;
}
}
}