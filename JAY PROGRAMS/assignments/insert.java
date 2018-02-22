import java.util.*;

class insert{

public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
int[] rollno=new int[5];
rollno[0]=2;
rollno[1]=4;
rollno[2]=6;
rollno[3]=8;
System.out.print("Enter roll no: ");
int num=ob.nextInt();
int i=0;
int k=rollno.length-1;
for( i=0;i<=k;i++){
    if (num<rollno[i]){
      for (int j=k;j>i;j--){
       rollno[j]=rollno[j-1];}
       rollno[i]=num;
       break;
                      }

                                }
if(i==k){ rollno[i]=num;  }
}
}