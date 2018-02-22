
class InsertinSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={8,5,1,4,3};
		int in,out;
		for(out=1;out<arr.length;out++){
			int temp=arr[out];
			in=out;
			while(in>0 && arr[in-1]<=temp){
				arr[in]=arr[in-1];
				in--;
			}
			arr[in]=temp;
		}
		for (int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
