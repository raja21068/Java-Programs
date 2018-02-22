
class Matrixes2 {


	public static void main(String[] args) {

		int arr[][]={{2,3},{3,5}};
		int arr2[][]={{4},{6}};
		System.out.println("The values in 1st matrixes");
		for(int i=0;i<arr.length;i++){
			System.out.println("");
			for(int j=0;j<arr[i].length;j++)
			System.out.print(" "+arr[i][j]);
		}
		System.out.println("\nThe values in 2nd matrixes");
		for(int i=0;i<arr2.length;i++){
			System.out.println("");
			for(int j=0;j<arr2[i].length;j++)
			System.out.print(" "+arr2[i][j]);
		}
		System.out.println("\nThe Multiplication of matrixes:");
		
		for(int i=0;i<arr.length;i++){
			System.out.println("");
			for(int j=0;j<2;j++){
				System.out.print(" "+(arr[i][j]*arr2[j][0]));
			}
		}
	}

}
