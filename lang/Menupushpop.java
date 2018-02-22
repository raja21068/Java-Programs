import java.util.*;


public class Menupushpop {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int[] arr=new int[5];
		int top=-1;
		for(int i=0; ;i++){
		System.out.println("1.Push\n2.POP\n3.Trversing\n4.exit");
		System.out.print("Enter Selection: ");
		int select=ob.nextInt();
		if(select==1){
			if(top==arr.length-1){ System.out.println("Over Flow"); }
			else{top++;
			System.out.print("Enter item:");
			arr[top]=ob.nextInt();}
		}
		if(select==2){
			if(top==-1){ System.out.println("Under flow"); }
			else {System.out.println("Stack["+top+"]="+arr[top]+" is removed ");
			arr[top]=0;
			top--;}
		}
		if(select==3){
			for(int j=0;j<arr.length;j++){
			System.out.println("Stack["+j+"]="+arr[j]);}
		}
		if(select==4){ System.out.println("Good Bye"); break; }
		if(select>4 || select<1){ System.out.println("*...Invalid Choice...*"); }
		}
		}

}
