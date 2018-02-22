class Test{
	static int add(int a,int b){
		if(a<0||b<0){
			ArithmeticException e=new ArithmeticException("Negetive value not allowed...");
			throw e;
			}
			return a+b;
	}
}
class throwExample{
   public static void main(String arg[]){
      try{
			int a=Test.add(10,5);
			System.out.println("Addition is:" +a);
			a=Test.add(5,-3);
			System.out.println("Addition is:" +a);
	  }
	  catch(ArithmeticException e){
		System.out.println(e.getMessage());
		System.out.println("Msg: "+e);
	  }
	  System.out.println("Good Bye...");
 }
}