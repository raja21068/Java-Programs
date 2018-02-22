class z{
	void test(){
		System.out.println("Z");
	}
}

class y extends z{
	void test(){
		System.out.println("Y");
	}
}

class x extends z{
	void test(){
		System.out.println("X");
	}
}
class w extends z{
	void test(){
		System.out.println("W");
	}
} 

class DMDispatch3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		y ob1=new y();
		x ob2=new x();
		w ob3=new w();
		z Z=ob1;
		Z.test();
		Z=ob2;
		Z.test();
		Z=ob3;
		Z.test();
		
	}
}