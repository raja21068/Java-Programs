
class Cc{}
class InheritanceDemo2 {


	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Cc ob=new Cc();
		Aa ob2=new Aa();
		int code=ob.hashCode();
		boolean b=ob.equals(ob2);
		System.out.println(code);
		System.out.println(b);
		ob.wait(1000);
		System.out.println("GOOOD Bye");
	}

}
