
class StaticMethodDemo {

	static void obtain(int a, int b, int c, int d, int e){
		int obt=a+b+c+d+e;
		System.out.println("Obtain: "+obt);
		per(obt,500);
	}
	static void per(int obt, int total){
		double p=obt*100/total;
		System.out.println("Per: "+p);
		grade(p);
	}
	static void grade(double per){
		if(per>50){
			System.out.println("Pass");
		}
		else { System.out.println("Fail"); } 
	}
	public static void main(String[] args) {
		obtain(50,90,80,70,90);
		System.out.println("**Good Bye**");
	}

}
