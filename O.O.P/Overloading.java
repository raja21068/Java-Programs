
public class Overloading {

	
	public static void main(String[] args) {
		Addition.add(70, 60);
		Addition.add(30.98, 60);
		Addition.add(70, 20.322);
		Addition.add(70, 60,76);
	}

}
class Addition{
	
	static void add(int a,int b){
		System.out.println(a+b);
	}
	static void add(int a,int b,int c){
		System.out.println(a+b+c);
	}
	static void add(int a,double b){
		System.out.println(a+b);
	}
	static void add(double a,int b){
		System.out.println(a+b);
	}
}