import java.util.*;
class tridigit{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter last digit: ");
int n=ob.nextInt();
for(int a=1;a<=n;a++){
System.out.print("\n");
for(int b=1;b<=a;b++){
System.out.print(a);
}
}
}
}