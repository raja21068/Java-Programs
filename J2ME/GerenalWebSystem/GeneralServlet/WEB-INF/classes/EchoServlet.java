import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class EchoServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		/*
		Enumeration en = req.getHeaderNames();
		while(en.hasMoreElements()){
			String s = (String)en.nextElement();
			System.out.println(s+" : "+req.getHeader(s));
			Enumeration values = req.getHeaders(s);
		}
		*/
		String userAgent = req.getHeader("user-agent");
		String name = req.getParameter("user");
		String pass = req.getParameter("pass");
		
		System.out.println("user-agent: "+userAgent);
		System.out.println("Name: "+name);
		System.out.println("Pass: "+pass);
		
		String message = "";
		if(name.equals("jay") && pass.equals("kumar")){
			message= "Welcome Jay";
		}else{
			message = "You are unauthorized";
		}
		
		PrintWriter out = res.getWriter();
		
		
		if( userAgent == null){
			res.setContentType("text/plain");
			out.println("This is a mobile "+message);
		}else if( userAgent.contains("Java") ){
			res.setContentType("text/plain");
			out.println("This is a Desktop App.. "+message);
		}else{
			res.setContentType("text/html");
			out.println("This is a Browser.. <h1>"+message+"</h1>");
		}
		
		
	}
}