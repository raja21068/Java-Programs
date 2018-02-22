
class Queue2 {
	int[] arr=new int[5];
	int rear=0;
	int front=0;
	private void rear(int item){
		
		if(rear==arr.length){ rear=0; }
		else {arr[rear]=item;
		rear++;}
		
	}
	private void front(){
		if(front==arr.length){ front=0; }
	arr[front]=0;
		front++;

		
	} 
	private void dis(){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		Queue2 ob=new Queue2();
		ob.rear(44);
		ob.rear(43);
		ob.rear(42);
		ob.rear(41);
		ob.rear(40);
		ob.dis();
		ob.rear(11);
		ob.front();
		ob.rear(11);
		ob.dis();
	}

}
