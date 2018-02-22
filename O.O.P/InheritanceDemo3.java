// * HOW A CONTRUCTOR CALL IN INHERITANCE

class a1{
	a1(){ System.out.println("I am no argument constructor of A1.."); }
	a1(int a){ System.out.println("I am one argument constructor of A1.."); }
}
class b1 extends a1{	
	b1(){ System.out.println("I am no argument constructor of B1.."); }
	b1(int a){ System.out.println("I am one argument constructor of B1.."); }}
class c1 extends b1{
	c1(){ System.out.println("I am no argument constructor of C1.."); }
	c1(int a){ System.out.println("I am one argument constructor of C1.."); }
}
class InheritanceDemo3 {
	public static void main(String arg[]){
		c1 ob1=new c1();
		c1 ob2=new c1(10);
	}

}
