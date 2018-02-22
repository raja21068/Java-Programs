import java.rmi.*;
class RMIClient {
	public static void main(String arg[])throws Exception{
		Calc ob = (Calc) Naming.lookup("ali");
		BoxImp ob1 = new BoxImp();
		Rectangle r = new Rectangle();
		ob.test();
		System.out.println("No argument method is called...");
		ob.test(r);
		System.out.println("rectangle class has passed from method...");
		ob.test(ob1);
		System.out.println("BoxImp is passed...");

	}

}