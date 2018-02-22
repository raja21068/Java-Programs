import java.util.*;
class binary{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
int[] ar={1,2,3,4,5,6};
int loc=ar.length;
System.out.print("Enter roll no");
int num=ob.nextInt();
int i=0,lb=0,ub=ar.lenght-1;

for( i=0;i<ar.length-1; i++){
int mid=(lb+ub)/2;
if(ar[mid]==num){ loc=mid; System.out.print("roll no found  ");
break;   }
}
if(ar[mid]>num){ ub=mid; }
else{ System.out.print("roll no not found.."); }
} 
}