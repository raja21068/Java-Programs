import java.util.*;
class find {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter array size:");
		int size=ob.nextInt();
		int max=0,loc=0,min,loc1=0;
		int element[]=new int[size];
		System.out.println("Enter"+size+" Elements:");
		element[0]=ob.nextInt();
		max=element[0];
		min=max;
		for (int i=1;i<element.length;i++){
			element[i]=ob.nextInt();
			
			if(element[i]>max){
			max=element[i];
			loc=i+1;}
		if(element[i]<min){
			min=element[i];
		loc1=i+1;
		}	
		}
System.out.println("\n greatr is : "+max+"location is:"+loc+"\nsmall is:"+min+" loc is:"+loc1);
	}

	}
