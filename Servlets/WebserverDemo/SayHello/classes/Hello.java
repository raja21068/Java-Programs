import java.io.*;

public class Hello implements MyServlet{

	public void service(DataInputStream in , PrintWriter out)throws Exception{
		
		out.println("<h1>Hello</h1>");
	}
}