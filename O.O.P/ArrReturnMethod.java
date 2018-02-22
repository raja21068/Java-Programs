import java.util.*;
class ArrReturnMethod {
	static Scanner ob=new Scanner(System.in);
	int arr[];
	
	static int[] inputArr(int size){
		int[] a=new int[size];
		System.out.println("Enter"+size+"Elements");
		for(int i=0;i<a.length;i++){			
			a[i]=ob.nextInt();
		}
		return a;
	}
	
	static void show(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

	
	public static void main(String[] args) {
		ArrReturnMethod ob1=new ArrReturnMethod();
		ob1.arr=ArrReturnMethod.inputArr(5);
		System.out.println("You entered these Elents:");
		ArrReturnMethod.show(ob1.arr);

	}

}
