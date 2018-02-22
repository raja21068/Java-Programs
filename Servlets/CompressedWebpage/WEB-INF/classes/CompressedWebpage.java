import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.zip.*;

public class CompressedWebpage extends HttpServlet{
	
	
	@Override
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
		PrintWriter out;
		String title;
		
		String header = req.getHeader("Accept-Encoding");
		res.setContentType("text/html");
		
		if(header!=null && header.indexOf("gzip")!= -1){
			title = "<h1>Compressed Webpage</h1>";
			OutputStream os = res.getOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(os);
			out = new PrintWriter(gzip, false);
			res.setHeader("Content-Encoding","gzip");
		}
		else{
			out = res.getWriter();
			title = "<h1>Uncompressed</h1>";
		}
		out.println(title);
		for(int i=1;i<=1000;i++){
			out.println("Hello netlync");
		}
		out.close();
	}
	
	private void askForPassword(HttpServletResponse res)throws ServletException , IOException{
		PrintWriter out = res.getWriter();
		out.println("<form action='Authentication'>");
		out.println("Enter User");
		out.println("<input type='text' name='user'><br>");
		out.println("Enter Password");
		out.println("<input type='password' name='pass'><br>");
		out.println("<input type='submit' value='Login'>");
		out.println("</form>");
	}
	
	private void welcome(HttpServletResponse res)throws ServletException , IOException{
		PrintWriter out = res.getWriter();
		out.println("<h1>Welcome</h1>");
	}

}
