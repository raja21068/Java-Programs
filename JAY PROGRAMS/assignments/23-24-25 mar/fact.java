import java.util.*;

class fact{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
int i=1,j=1;
char ch='y';
while(ch=='y'||ch=='Y'){

System.out.print("Enter any number:");
int n=ob.nextInt();

  while(i<=n){
        j=i*j;
        System.out.println(i+"!="+j);
        i++;
        }
    i=1;
    j=1;
System.out.print("Do you want to see more y/n..?");
ch=ob.next().charAt(0);
}
System.out.print("Good Bye...");
}
}