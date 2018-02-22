public class TestAssert {
	
	public static void main(String arg[]){
		// validate(90);
		validate(190);
	}
	
	private static boolean validate(int age){
		
		//We are assuming that age should be from 1 to 100 but
		// what if an unexpected age is used, now we should use assert
		
		assert (age>=1 && age<=100): age;
		
		if(age<60){
			return true;
		}else{
			return false;
		}
		
	}

}