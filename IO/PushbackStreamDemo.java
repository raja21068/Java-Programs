import java.io.*;
public class PushbackStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String s = "if(a==4)a==0;\n";
		byte buf[] = s.getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		PushbackInputStream f = new PushbackInputStream(in);
		int c;
		while((c = f.read())!= -1){
			switch(c){ 
			case '=': if((c=f.read())=='='){System.out.print(".eq.");}
				  else{ System.out.print("<-"); f.unread();} break;
			default : System.out.print((char)c); 
					}
				} 
			}

}
