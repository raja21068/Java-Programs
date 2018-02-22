import java.util.*;
class array {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter array size:");
		int size=ob.nextInt();
		int sum=0;
		String str="";
		int element[]=new int[size];
		System.out.println("Enter"+size+" Elements:");
		for (int i=0;i<element.length;i++){
			element[i]=ob.nextInt();
		sum+=element[i];
		str+="\n"+element[i];
		}
		System.out.print("Addition is:"+sum);
		System.out.print(str);
	
	}

}
