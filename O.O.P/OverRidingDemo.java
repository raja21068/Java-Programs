class PhysicsAndTechnolgy{
	void computerTech(){ System.out.println("Computer Technology 3 yrs"); }
	void electronics(){ System.out.println("Electronics 3 yrs"); }
	void telecom(){ System.out.println("Telecom 3 yrs"); }
	void lab(){ System.out.println("Lab for Practicles"); }
}
class IIT extends PhysicsAndTechnolgy{
	void softeng(){ System.out.println("Software Engineering 4 yrs"); }
	void it(){ System.out.println("Information Technology 4 yrs"); }
	void electronics(){ super.electronics(); System.out.println("Electronics 4 yrs only");  }
	void telecom(){ super.telecom(); System.out.println("Telecom 4 yrs only"); }
	
}
class OverRidingDemo {
	public static void main(String arg[]){
		IIT ob=new IIT();
		ob.computerTech();
		ob.lab();
		ob.telecom();
		ob.it();
		ob.electronics();
		ob.softeng();
	}
}
