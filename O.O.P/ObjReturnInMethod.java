class Box3{
	int feet;
	int inch;
	Box3(){}
	Box3(int a,int b){
		feet=a;
		inch=b;
	}
	
	Box3 add(Box3 ob1,Box3 ob2){
		Box3 newBox=new Box3();
		newBox.feet=ob1.inch+ob2.inch;
		newBox.inch=ob1.inch+ob2.inch;
		return newBox;
	}
	Box3 sub(Box3 ob1,Box3 ob2){
		Box3 newBox=new Box3();
		newBox.feet=ob1.inch-ob2.inch;
		newBox.inch=ob1.inch-ob2.inch;
		return newBox;
	}
	Box3 mul(Box3 ob1,Box3 ob2){
		Box3 newBox=new Box3();
		newBox.feet=ob1.inch*ob2.inch;
		newBox.inch=ob1.inch*ob2.inch;
		return newBox;
	}
	
	
}
class ObjReturnInMethod {
	public static void main(String arg[]){
		Box3 ob=new Box3(20,30);
		Box3 he=ob.add(ob, ob);
		System.out.println(he.feet);
		
	}

}
