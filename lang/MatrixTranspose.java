import java.util.*;
class MatrixTranspose {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int arr[][]=new int[2][2];
		int temp[][]=new int[2][2];
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][j]=ob.nextInt();
				}//end of inner loop
			}//end of outer loop
			
		
		for(int i=0;i<arr.length;i++){
			System.out.println();
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
				}//end of inner loop
			}//end of outer loop
		
		
		System.out.println("transpose");
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				temp[j][i]=arr[i][j];
				}//end of inner loop
			}//end of outer loop
		
		
		for(int i=0;i<arr.length;i++){
			System.out.println();
			for(int j=0;j<arr[i].length;j++){
				arr[i][j]=temp[i][j];
				System.out.print(arr[i][j]+" ");
				}//end of inner loop
			}//end of outer loop
		
	}

}
