class ExceptionDemo2{
   public static void main(String arg[]){
      try{
			String s1=arg[0];
			String s2=arg[1];
			System.out.println("Command line argument recieved....");
			try{
				  int a=Integer.parseInt(s1);
				  int b=Integer.parseInt(s2);
				  System.out.println("converted from string to int");
				  try{
						int c=a/b;
						System.out.println("Division is: "+c);
						System.out.println("Divion has been performed...");
						}catch(ArithmeticException e){
							System.out.println("2nd arg must not be zero: "+e.getMessage());
							}
							System.out.println("After Arthmetin Exception.....");
						}
						catch(NumberFormatException e){
							System.out.println("integer Required...");
						}
						System.out.println("After Number Format Exception...");
	  }
	  catch(ArrayIndexOutOfBoundsException e){
		e.printStackTrace();
	  }
	  System.out.println("Good Bye...");
 }
}