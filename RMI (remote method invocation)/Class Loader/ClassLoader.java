import java.util.*;

class ClassLoader{
	public static void main(String args[])throws Exception{
		Scanner ob = new Scanner(System.in);
		System.out.print("Enter Class Name:");
		String className = ob.next();
		Class c = Class.forName(className);
		Object obj = c.newInstance();
		Usindh u = (Usindh)obj;
		u.IT();
		u.MBA();
	} 

}