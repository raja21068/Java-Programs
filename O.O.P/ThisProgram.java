
class rad{
	int r;
	rad(int r){ this.r=r; }
	
	void circum(pi ob){
		System.out.println(2*ob.piv*this.daimeter2(ob));
	}
	void daimeter(pi ob){
		 System.out.println(this.r*ob.piv);
		 ob.calcu(this);
		}
	int daimeter2(pi ob){
		 return this.r*ob.piv;
		}
	
	}
class pi{
	int piv;
	pi(int p){ this.piv=p; }
		void calcu(rad ob){
			System.out.println("Diameter: "+ob.r*ob.r);
			ob.circum(this);
		}
	
}

class ThisProgram {

	public static void main(String arg[]){
		rad r1=new rad(10);
		pi p1=new pi(3);
		r1.daimeter(p1);
	}
}
