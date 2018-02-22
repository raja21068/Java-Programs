import java.util.Scanner;
public class StackTest {

	

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter stack size:");
		int size=ob.nextInt();
		Stack obstack=new Stack(size);
		for (int i=0;i<size;i++){
		System.out.print("Enter "+(i+1)+" value");
		obstack.push(ob.nextInt());
		}
		int value=obstack.pop();
		System.out.print("the poped number is:"+value);
	}

}
class Stack{
	int stackarray[];
	int maxsize;
	int top;
	public Stack(int s){
		stackarray=new int[s];
		maxsize=s;
		top=-1;
	}
	public void push(int element){
		if(top==maxsize-1){System.out.print("Stack is over flow");}
		else { stackarray[++top]=element; }
	}
public int pop(){
	return stackarray[top--]; 
}
}
