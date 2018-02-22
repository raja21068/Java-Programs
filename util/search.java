import java.util.*;
class search {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter array size: ");
		int size=ob.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++){
			System.out.print("Num["+i+"]=");
			arr[i]=ob.nextInt();
		}
		System.out.print("Which item you want to search?\nEnter item: ");
		int item=ob.nextInt();
		int i;
		for( i=0;i<size;i++){
			if(arr[i]==item)break;
		}
	if(i!=size)System.out.println("Item is: "+item+"\nlocation is: "+i);
	else System.out.print("Item not found....!");
	}

}
