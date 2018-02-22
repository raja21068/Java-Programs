import java.io.FileInputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
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
class DeSerializeObj{
	public static void main(String arg[])throws Exception{
		FileInputStream file = new FileInputStream("e:\\Abc.obj");
		ObjectInputStream f = new ObjectInputStream(file);
		Box ob1 = (Box) f.readObject();
		Box ob2 = (Box) f.readObject();
		ob1.show();
		ob2.show();
		file.close();
		System.out.println("Object Deserialized.....");
	}
}