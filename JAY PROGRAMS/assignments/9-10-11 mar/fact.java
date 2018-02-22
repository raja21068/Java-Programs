import java.util.*;

class fact{

public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter No:"); int n=ob.nextInt();
int i,j;
for (i=1,j=1;j<=n;j++)
{
System.out.println(i*j);
i=i*j;
}

}
}