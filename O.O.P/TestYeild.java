class Item{
	int val;
	synchronized void put(int val){
		this.val = val;
		System.out.println("put :"+val);
	}
	synchronized void get(){
		System.out.println("get :"+val);
	}
}//end of item

class Producer extends Thread{
	Item item;
	Producer(Item item){
		this.item = item;
	}
	public void run(){
		int num =0;
		while(true){
			item.put(++num);
			yield();
			//try{Thread.sleep(20);}catch(Exception e){}
		}
	}
}//end of class producer

class Consumer extends Thread{
	Item item;
	Consumer(Item item){
	this.item = item;
	}
	public void run(){
		while(true){
			item.get();
			yield();
			//try{Thread.sleep(20);}catch(Exception e){}
		}
	}
}//end of class Consumer

class TestYeild{
	public static void main(String arg[]){
		Item item = new Item();
		Producer p = new Producer(item);
		Consumer c = new Consumer(item);
		p.start();
		c.start();
		try{Thread.sleep(2000);}catch(Exception e){}
		p.stop();
		c.stop();
		
	}
}