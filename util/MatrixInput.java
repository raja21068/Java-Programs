import java.util.*;
class MatrixInput {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int arr[][]=new int[3][3];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][j]=ob.nextInt();
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.println();
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
		}
	}

}
