
class Animal{
	void sound(){
		System.out.println("No sound");
	}
	void eye(){
		System.out.println("Two Eyes");
	}
	void legs(){
		System.out.println("Four Legs");
	}
}

class cat2 extends Animal{
	void sound(){
		System.out.println("Miyaoo Miyaoo..");
	}
}

class Dog extends Animal{
	void sound(){
		System.out.println("waho wahoo..");
	}
}

class Human extends Animal{
	void sound(){
		System.out.println("Natural Language..");
	}
	void legs(){
		System.out.println("Two legs..");
	}
}

class Display2{
	static void show(Animal ob){
		ob.sound();
		ob.legs();
		ob.eye();
	} 
}

class DMDispatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat2 c=new cat2();
		Dog d=new Dog();
		Human h=new Human();
		Display2.show(c);
		Display2.show(d);
		Display2.show(h);

	}

}
