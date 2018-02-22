
class bubble1 {

	public static void main(String[] args) {
		int count=0;
		int count1=0;
		int arr[]={50,40,30,20,10,5,3};
		for(int i=1;i<arr.length;i++){
			count1++;
			for(int j=0;j<arr.length-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					count++;
				}
			}
		}
		for(int i=0;i<arr.length;i++){System.out.println(arr[i]);}
		System.out.println("inner loop repeats "+count+" times");
		System.out.println("outer loop repeats "+count1+" times");
	}

}
