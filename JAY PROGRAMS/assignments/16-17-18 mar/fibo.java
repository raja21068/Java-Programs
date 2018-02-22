import java.util.*;

class fibo{
public static void main(String arg[]){
   Scanner ob=new Scanner(System.in);
    System.out.print("Enter no:");

   int n=ob.nextInt();
   n=n-2;
  int a=0,b=1,c=0;

   System.out.println("\n"+b);

    for (int i=0;c<=n; i++){
     c=a+b;
     System.out.println(c);
     a=b;
     b=c;       
}
}
}
