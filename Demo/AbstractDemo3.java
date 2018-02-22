abstract class first{
	abstract void show();
	abstract void hello();
} 

abstract class second extends first{
	abstract void test();
}
class ttest extends second{

	@Override
	void test() {
		// TODO Auto-generated method stub
		System.out.println("this is test method of father class..");
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.println("this is show method of Grand father class..");
	}

	@Override
	void hello() {
		// TODO Auto-generated method stub
		System.out.println("this is hello method of Grand father class..");
	}
	
}
public class AbstractDemo3 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		second ob=new ttest();
		ob.hello();
		ob.test();
		ob.show();
	}

}
