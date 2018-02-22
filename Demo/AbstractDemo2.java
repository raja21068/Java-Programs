abstract class Calc{
	abstract void add(int a,int b);
	abstract void sub(int a,int b);
	void mul(int a, int b){
		System.out.println(a*b);
	}
} 
class CalcImp extends Calc{

	@Override
	void add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println(a+b);
	}

	@Override
	void sub(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println(a-b);
	}
	
} 
public class AbstractDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc ob=new CalcImp();
		ob.add(10,20);
		ob.mul(10, 20);
		ob.sub(10, 20);
	}

}
