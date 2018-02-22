import java.util.*;
class array3 {

	
	public static void main(String[] args) {
  		Scanner ob=new Scanner(System.in);
		int[] arr={10,43,5,24,76,58,98,33};
		int j=0;
	/*1st for*/	for(int i=1;j<4;i++){
		int smal=arr[0],large=arr[0],loc=0;
		System.out.println("\n1. Search Smallest\n2.Search Largest\n3.Traversing\n4.Exit");	
		System.out.print("Enter selection: ");
		j=ob.nextInt();
		if(j>4){System.out.println("Invalid Selection");
		j=0;
		}
		/*1st if*/if(j==1){ 
			/*2nd for*/for(int k=1;k<arr.length;k++){
				
				/*2nd if*/if(arr[k]<smal){
					smal=arr[k];
					loc=k+1;
				    }//end of 2nd if
			                    }//end of 2nd for
			System.out.print("Smallest is: "+smal+"\nlocation is: "+(loc));
		}//end of 1st if
		if(j==2){
/*2nd for*/for(int k=1;k<arr.length;k++){
				
				/*2nd if*/if(arr[k]>large){
					large=arr[k];
					loc=k+1;
				    }//end of 2nd if
			                    }//end of 2nd for
			System.out.print("Largest is: "+large+"\nlocation is: "+(loc));
		}
	
		if(j==3){
			for(int a=0;a<arr.length;a++){
				System.out.println(arr[a]);
			}
		}
	}//end of 1st  for
	System.out.println("Good Bye");	
	} 

}
