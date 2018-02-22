import java.util.*;

class abc{
public static void main(String[] args){
Scanner ob=new Scanner(System.in);
char ch;
System.out.print("Enter rows: ");
int n=ob.nextInt();
n=n+65; 
for(char i=65;i<=n;i++){
System.out.print("\n");
for(char j=65; j<i; j++){
ch= j;
System.out.print(""+ch); }
}
}
}
