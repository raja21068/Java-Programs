// * Example of DYNAMIC METHOD DISPATCH
class usindh{
	void MBA(){
		System.out.println("MBA USINDH");
	}
	void IT(){
		System.out.println("IT USINDH");
	}
}

class mit extends usindh{
	void MBA(){
		System.out.println("MBA MIT");
	}
	void IT(){
		System.out.println("IT MIT");
	}
}

class imsa extends usindh{
	void MBA(){
		System.out.println("MBA IMSA");
	}
}

class cms extends usindh{
	void MBA(){
		System.out.println("MBA CMS");
	}
	void IT(){
		System.out.println("IT CMS");
	}
}

class Display1{
	static void show(usindh u){
		u.MBA();
		u.IT();
	}
}
class DMDipatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cms cm=new cms();
		imsa im=new imsa();
		mit m=new mit();
		Display1.show(cm);
		Display1.show(im);
		Display1.show(m);

	}

}
