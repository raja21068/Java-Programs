
class bubble2 {

	public static void main(String[] args) {

		int arr[]={50,40,30,20,10};
		for(int i=1;i<arr.length;i++){
			for(int j=arr.length-1;j>=i;j--){
				if(arr[j]<arr[j-1]){
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++){System.out.println(arr[i]);}
	}

}
