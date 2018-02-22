import java.util.*;
class array2 {

	
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter array size:");
		int size=ob.nextInt();
		int temp=0,loc=0;
		int element[]=new int[size];
		System.out.println("Enter"+size+" Elements:");
		element[0]=ob.nextInt();
		for (int i=1;i<element.length;i++){
			element[i]=ob.nextInt();
			temp=element[0];
			if(element[i]>element[i-1]&&element[i]>temp){
			temp=element[i];
			loc=i+1;}		                           }
System.out.println("location is:"+loc+"\n greatr is : "+element[loc-1]);
	}

}
