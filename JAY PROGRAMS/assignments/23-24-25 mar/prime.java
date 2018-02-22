import java.util.*;

class prime{

public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter no: ");
int n=ob.nextInt();
int i;
int k=1,j=0;
int b=0;
for(int a=2;a<=n;a++){

for(j=2;j<a;j++){
i=a%j;
if(i==0)break;
}

if(j==a){System.out.println(a);}

}


 }
  }