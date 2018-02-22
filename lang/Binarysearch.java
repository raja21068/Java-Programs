
class Binarysearch {

	public static void main(String[] args) {

		int arr[]={10,20,30,40,50,60,70,80};
		int item=80;
		int start=0;
		int end=arr.length-1;
		for(int i=0;i<=Math.log(arr.length);i++){
			int mid=(start+end)/2;
			if(arr[mid]==item){
				System.out.println("Item Found at "+(mid+1)+" location");
				item=0;
				break; 
			}
			else if(arr[mid]>item){end=mid;}
			else{start=mid; }
		}
		if(item!=0){System.out.println("Item not found");}
	}

}
