class Test{

	public static void main (String arg[]){
		double r1=6;
		double r2=6;
		double r3=9;
		if(r1>r2 && r1>r3){
			System.out.println("r1>r2 is greater..");
		}						
		else if(r2>r1 && r2>r3){
			System.out.println("r2>r1 is greater..");
		}						
		else if(r3>r1 && r3>r2){
			System.out.println("r3>r1 is greater..");
		}else if(r3==r1){
			System.out.println(r3+" is greater..");
		}else if(r2==r1){
			System.out.println(r2+" is greater..");
		}else if(r3==r2){
			System.out.println(r2+" is greater..");
		}
	}
}