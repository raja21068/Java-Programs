import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.ObjectOutputStream;
class Box implements Serializable{
	int feet;
	int inch;
	Box(int a, int b){
		feet = a;
		inch = b;
	}
	void show(){
		System.out.println(feet);
		System.out.println(inch);
	}
}
class SerializeObj{
	public static void main(String arg[])throws Exception{
		FileOutputStream file = new FileOutputStream("e:\\Abc.obj");
		ObjectOutputStream f = new ObjectOutputStream(file);
		Box ob1 = new Box(10 , 5);
		Box ob2 = new Box(100, 50);
		f.writeObject(ob1);
		f.writeObject(ob2);
		file.close();
		System.out.println("Object serialized.....");
	}
}