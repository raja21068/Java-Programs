import javax.servlet.*;
import java.io.*;

public class TestServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException, IOException{
		PrintWriter out = res.getWriter();
		out.println("Hello servlet student..");
	}

}