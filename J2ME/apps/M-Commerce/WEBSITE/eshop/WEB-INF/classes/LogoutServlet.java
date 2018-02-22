import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class LogoutServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in LogoutServlet");
		HttpSession session = req.getSession();
		
		java.util.Enumeration<String> en = session.getAttributeNames();
		while(en.hasMoreElements()){
			session.removeAttribute(en.nextElement());
		}
		res.sendRedirect("home.html");
	}

}