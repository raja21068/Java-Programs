import java.util.*;

class prime{

public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter no: ");
int n=ob.nextInt();
int i;
int k=1;

for(int j=2;j<n;j++){
i=n%j;
if(i==0){ k=i; }
}

if(k==0){ System.out.println("It is not a prime no..!");}
else{ System.out.println("It is a prime no..!"); }



 }
  }