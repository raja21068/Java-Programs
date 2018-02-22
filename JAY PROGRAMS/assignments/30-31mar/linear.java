import java.util.*;
class linear{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
int[] ar={1,2,3,4,5,6};
int loc=ar.length;
System.out.print("Enter roll no");
int num=ob.nextInt();
int i=0;
for( i=0;i<ar.length-1; i++){
if(ar[i]==num){ loc=i; System.out.print("roll no found  ");
break;   }
}
if(loc==i){ System.out.print("at location: "+(loc+1)); }
else{ System.out.print("roll no not found.."); }
} 
}