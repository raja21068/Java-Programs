interface Calcu{
	void add(int a,int b);
	void sub(int a,int b);
}

class calcImp2 implements Calcu{

	@Override
	public void add(int a,int b) {
		// TODO Auto-generated method stub
		System.out.println(a+b);
	}

	@Override
	public void sub(int a,int b) {
		// TODO Auto-generated method stub
		System.out.println(a-b);
	}
	
}
class  InterfaceDemo {
	public static void main(String arg[]){
		calcImp2 ob=new calcImp2();
		ob.add(210, 10);
	}
}
