import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class TestRedirect extends HttpServlet{
	@Override
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		res.sendRedirect("Http://localhost:8081/servlet/HelloServlet");
	}
}