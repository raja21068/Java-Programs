/**
		}*/
import java.util.Scanner;
public class StackTest2 {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter stack size:");
		int size=ob.nextInt();
		Stack obstack=new Stack(10);
		for (int i=0;i<size;i++){
			if(i==10){
				System.out.println("Over Flow");
				break;
			}
			System.out.print("Enter "+(i+1)+" value");
			obstack.push(ob.nextInt());
		}
		System.out.print("how many numbers u want to remove:");
		int values=ob.nextInt();;
		int i;
		for( i=size-1;i<values;i--){
		if(i<=-1){System.out.print("Under flow"); break; }
		obstack.pop(); }
		 if(i!=-1) {System.out.print("the poped number is:"); } 
	}

}
