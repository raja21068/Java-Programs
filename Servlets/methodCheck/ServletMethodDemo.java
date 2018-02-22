import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ServletMethodDemo extends HttpServlet{
	String user;
	String pass;
	
	public void init(ServletConfig conf) throws ServletException{
		super.init(conf);
		System.out.println("aa");
		user = conf.getInitParameter("user");
		pass = conf.getInitParameter("pass");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		user = req.getParameter("user");
		pass = req.getParameter("pass");

		if(user.equals("al") && pass.equals("bell")){
			out.println("<h1>User Authenticated</h1>");
		}else{
			out.println("<h1>User Un-Authenticated</h1>");
		}
		out.println("getRemoteHost() : "+req.getRemoteHost()+"<br>");
		out.println("getRemotePort() : "+req.getRemotePort()+"<br>");
		out.println("getLocalAddr(): "+req.getLocalAddr()+"<br>");
		out.println("getLocale(): "+req.getLocale()+"<br>");
		out.println("getLocalPort(): "+req.getLocalPort()+"<br>");
		out.println("getServerPort() : "+req.getServerPort()+"<br>");
		out.println("getServerName() : "+req.getServerName()+"<br>");
	}
}