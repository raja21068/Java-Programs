
public class StringBufferDemo {

	public static void main(String[] args) {
		String s = "Hello";
		System.out.println(s.hashCode());
		System.out.println("Hello".hashCode());
		s+="student";
		System.out.println(s.hashCode());
		
		StringBuffer buf = new StringBuffer("Hello");
		buf.append("How");
		System.out.println(buf.hashCode());
		buf.append("are");
		System.out.println(buf.hashCode());
		buf.append("you");
		System.out.println(buf.hashCode());
		buf.append("student");
		System.out.println(buf.hashCode());
	}

}
