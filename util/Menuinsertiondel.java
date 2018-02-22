import java.util.*;
public class Menuinsertiondel {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int[] arr={90,50,60,20,10};
		int select=0,item,loc,top=5;
		for(int i=0 ; ; i++){
		System.out.print("1.Insertion\n2.Delection\n3.traversing\n4.Exit\nEnter Selection: ");
		select=ob.nextInt();
		if(select==1){
		 if(top<=4){ top++; }
		 else{ top=5; }
			System.out.print("Enter item: ");
		item=ob.nextInt();
		System.out.print("Enter Location: ");
		loc=ob.nextInt();
		if(loc>4 || loc<0){ System.out.println("*...Invalid Location...*"); }
		else{ for(int j=arr.length-1;j>loc;j--){ arr[j]=arr[j-1]; } arr[loc]=item; }
		}
		
		if(select==2){
			if(top==0){ System.out.println("all items are deleted"); } else{top--;}
		System.out.print("Enter Location: ");
		loc=ob.nextInt();
		if(loc>4 || loc<0){ System.out.println("*...Invalid Location...*"); }
		else{ for(int j=loc;j<arr.length-1;j++ ){arr[j]=arr[j+1];} arr[top]=0; }
		}
		if(select==3){  for(int j=0;j<arr.length;j++){System.out.println(arr[j]);}  }
		if(select==4){ break; }
		if(select>4 ||select<1){ System.out.println("*...Inavalid Choice...*");  }
		}
		
	}

}
