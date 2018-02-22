import java.io.*;

class ByteArrayInputStreamDemo{
	public static void main(String arg[]){
		String tmp = "abcdefghijklmnopqrstuvwxyz";
		byte b[] = tmp.getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		ByteArrayInputStream in2 = new ByteArrayInputStream(b,0,3);
		int c;
		while((c=in.read())!=-1)
		System.out.println((char)c);
		while((c=in2.read())!=-1)
		System.out.println((char)c);

  }
}