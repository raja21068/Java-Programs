class Box implements java.io.Serializable{
	int feet, inch;
	Box(int a , int b){
		feet  = a;
		inch = b;
	}

	public int add(){
		return feet + inch;
	}

	public int mul(){
		return feet * inch;
	}

}