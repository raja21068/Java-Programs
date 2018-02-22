import java.util.*;

class ArrayIncreament {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter array size:");
		int top=ob.nextInt();
		int sum=0;
		int temp[]=new int[top];
		int arr[]=new int[top];
	
		for(int i=0;i<arr.length;i++){
			arr[i]=ob.nextInt();
			sum+=arr[i];
			if(arr[i]==0){ break; }
			if(i==arr.length-1){
				for(int k=0;k<temp.length;k++){
					temp[k]=arr[k];
				}
			arr=new int[top+=top];
			for(int j=0;j<temp.length;j++){
				arr[j]=temp[j];
				
			}
			temp=new int[top];
			}
		}
		System.out.println("sum="+sum);
		System.out.println("do you want to continue:");
		String c=ob.nextLine();
		if(c.endsWith("y")){ for(int i=0;i<arr.length;i++){}
	}
	}

}
