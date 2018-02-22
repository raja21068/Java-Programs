import java.util.*;

class del{

public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
int[] rollno={2,4,6,8,10};
System.out.print("Enter roll no: ");
int num=ob.nextInt();
int i=0;
int k=rollno.length;
for( i=0;i<=k-1;i++){
    if (num==rollno[i]){
      for (int j=i;j>k;j++){
       rollno[j]=rollno[j+1];}
             break;
                      }

                                }
if(i==k){ System.out.print("Roll no not found");  }
}
}