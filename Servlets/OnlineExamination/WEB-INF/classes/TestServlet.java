import javax.servlet.*;
import java.io.*;

class TestServlet extends GenericServlet{
	
	public void service(ServletRequest req, ServletResponse res)throws 	IOException,ServletException{
		PrintWriter out= res.getWriter();
		out.println("Hello servlet student..");

	}

}