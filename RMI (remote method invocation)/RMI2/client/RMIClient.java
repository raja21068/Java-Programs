import java.rmi.*;
class RMIClient {
	public static void main(String arg[])throws Exception{
		Calc ob = (Calc) Naming.lookup("ali");
		Box ob1 = new Box(10,5);
		int a = ob.add(ob1);
		int b = ob.mul(ob1);
		System.out.println(a);
		System.out.println(b);
	}

}