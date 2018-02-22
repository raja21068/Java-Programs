
class Queue {
	int[] arr=new int[5];
	int rear=-1;
	int front=-1;
	void rear(int item){
		
		if(rear==arr.length-1 ){rear=-1; }
		
		if(arr[rear+1]==0){ arr[++rear]=item;}
		else { System.out.println("Over flow"); }
		
	}
	private void front(){
	if(front==arr.length-1){front=-1;}
		if(arr[front+1]!=0){
			arr[++front]=0;}
	else{System.out.println("under flow");}
		
	} 
	private void display(){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		Queue ob=new Queue();
		ob.rear(44);
		ob.rear(43);
		ob.rear(42);
		ob.rear(41);
		ob.rear(40);
		ob.display();
		ob.rear(11);
		ob.front();
		ob.front();
		ob.front();
		ob.rear(11);
		ob.rear(22);
		ob.display();
		
	}

}
