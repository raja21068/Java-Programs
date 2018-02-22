
class Aa{
	void a(){ System.out.println("I am a()"); }
}//end of A
class Bb extends Aa{
	void b(){ System.out.println("I am a()"); }
	void test(){ System.out.println("I am test()"); }
}//end of B

class InheritanceDemo {

	public static void main(String[] args) {
		Bb ob=new Bb();
		ob.a();
		ob.b();
		ob.test();
	}

}
