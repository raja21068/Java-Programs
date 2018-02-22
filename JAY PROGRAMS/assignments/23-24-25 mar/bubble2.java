import java.util.*;


class bubble2{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
int[] ar=new int[10];
System.out.println("Enter numbers randomly..");
for(int i=0;i<ar.length;i++){
ar[i]=ob.nextInt();
}


for (int j=ar.length-1;j>=1;j--){
for (int i=0;i<j;i++){
if (ar[i]<ar[i+1]){
int temp=ar[i];
ar[i]=ar[i+1];
ar[i+1]=temp;
}
}
}
System.out.println("elements in sorted form in descending order...");
for(int i=0;i<ar.length;i++){
System.out.println(""+ar[i]);
}
}
}