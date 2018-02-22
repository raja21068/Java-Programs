abstract class Animals{
	abstract void sound();
	void eyes(){ System.out.println("Two eyes"); }
	void legs(){ System.out.println("Four Legs"); }
}

class cats extends Animals{

	@Override
	void sound() {
		// TODO Auto-generated method stub
		System.out.println("Meayoo Meayoo.....");
	}
	
}

class Dogs extends Animals{
	
	void sound(){
		System.out.println("wawoo wawoo.....");
	}
}
class Humans extends Animals{

	@Override
	void sound() {
		// TODO Auto-generated method stub
		System.out.println("Natural Language");
	}
	void legs(){
		System.out.println("Two legs");
	}
}

class Displays{
	static void show(Animals ob){
		ob.sound();
		ob.eyes();
		ob.legs();
	}
}
public class AbstracrtDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cats c=new cats();
		Dogs d=new Dogs();
		Humans h=new Humans();
		
		Displays.show(c);
		Displays.show(d);
		Displays.show(h);
	}

}
