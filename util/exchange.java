import java.util.*;


public class exchange {
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int item,loc;
		int[] arr={3,44,87,66,98};
		System.out.println("Enter item:");
		item=ob.nextInt();
		System.out.println("Enter Location:");
		loc=ob.nextInt();
		for(int i=arr.length-1;i<loc;i--){
			arr[i]=arr[i-1];
		}
		arr[loc]=item;
		for(int j=0;j<arr.length;j++){
			System.out.println(arr[j]);
		}
	}

}
