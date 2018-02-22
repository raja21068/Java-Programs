
class Quicksort {

	public static void main(String[] args) {
		int arr[]= {90,23,45,10,24,12,5};
		int a=-1,count=0;
		for(int i=1;i<arr.length/2+1;i++){
			a++; 
			for(int j=a,k=arr.length-i;j<arr.length-i;j++,k--){
				count++;
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;	}
				if(arr[k]<arr[k-1]){
					int temp=arr[k];
					arr[k]=arr[k-1];
					arr[k-1]=temp;
				}
			}
		}
		
for(int t=0;t<arr.length;t++){
	System.out.println(arr[t]);
}	System.out.println("count is "+count+"outr"+(a+2));
	}

}
