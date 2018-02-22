import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import sun.misc.*;

public class Authentication extends HttpServlet{
	Properties p;
	
	@Override
	public void init(ServletConfig conf){
		try{
		String fileName = getInitParameter("address");
		System.out.println(fileName);
		}catch(Exception ex){ex.printStackTrace();}
		// p = new Properties();
		// try{
			// String file = getServletContext().getRealPath("")+File.separator+"passwords.pass";
			// System.out.println("file at : "+file);
			// FileInputStream f = new FileInputStream(file);
			// p.load(f);
			// System.out.println("Password file successfully loaded....");
		// }catch(Exception ex){ex.printStackTrace();}
	}
	
	@Override
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
		welcome(res);
		// String user = req.getParameter("user");
		// String pass = req.getParameter("pass");
		// String originalPassword = p.getProperty(user);
		// if(originalPassword == null){
			// askForPassword(res);
		// }
		// else if(originalPassword.equals(pass)){
			// welcome(res);
		// }
		// else{
			// askForPassword(res);
		// } 
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
