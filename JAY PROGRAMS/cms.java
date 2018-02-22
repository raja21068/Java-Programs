import java.util.*;
class cms{

static int arr[]=new int[5];
static int index=0;
public static void insert(int rollno)
{
arr[index]=rollno;
index++;
}
public static int linearsearch(int rollno){
for (int loc=0; loc<arr.lenght; loc++){
if (rollno==arr[loc]){ return loc; }
return -1;
}
}
public static int delete(int rollno){
for (int loc=0; loc<arr.lenght; loc++){
if (rollno==arr[loc])
{loc=index;
index=0;}
}
}
public static void main(String arg []){
Scanner ob=new Scanner(System.in);

System.out.print("1.Insert/n2.Search/n3.Delete"); int s=ob.nextInt();  
if(s==1){ for(int i=0; i<5; i++){ insert(i); }
if(s==2){ System.out.print("enter roll no:");  int rollno=ob.nextInt(); linearsearch(rollno);}
if(s==3){ System.out.print("Enter rollno:"); int rollno=ob.nextInt(); delete(rollno);}

}
}
