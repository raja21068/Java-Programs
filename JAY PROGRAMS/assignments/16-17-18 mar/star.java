import java.util.*;
class star{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter Rows: ");
int row=ob.nextInt();
System.out.print("Enter colmn: ");
int col=ob.nextInt();
for(int i=1;i<=row;i++){
System.out.print("\n");
for (int j=1;j<=col;j++){
System.out.print("*");
}
}

}
}