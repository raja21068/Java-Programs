import java.util.*;

class prime2{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
char ch='y';
while(ch=='y'||ch=='Y'){
System.out.print("Enter any no:");
int i=ob.nextInt();
int j=2;
int k=1;
while(j<i){
 k=i%j;
 j++;
if(k==0){
System.out.println("it is not a primt no...!");
break;}
}
if(k!=0){ System.out.println("It is a prime no..!");   }
System.out.print("Do you want to see more Y/N...?");
ch=ob.next().charAt(0);
}
}
}