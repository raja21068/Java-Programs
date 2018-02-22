interface unisindh{
	void MBA();
	void telecom();
}
interface MUET{
	void computerSystem();
	void telecom();
}
class Coms implements unisindh,MUET{

	@Override
	public void computerSystem() {
		// TODO Auto-generated method stub
		System.out.println("Computer System 4 years");
	}

	@Override
	public void MBA() {
		// TODO Auto-generated method stub
		System.out.println("MBs 2 years");
	}

	@Override
	public void telecom() {
		// TODO Auto-generated method stub
		System.out.println("Telecom /usindh/MUET/4 years");
	}
	
}

class show{
	static void display(unisindh u){
		u.MBA();
		u.telecom();
	}
	static void display(Coms c){
		c.MBA();
	    c.telecom();
	    c.computerSystem();
	}
	static void display(MUET m){
		m.telecom();
		m.computerSystem();
	}
}
class InterfaceDemo3 {

	public static void main(String arg[]){
		Coms c=new Coms();
		show.display((unisindh)c);
		show.display(c);
		show.display((MUET)c);
	}
}
