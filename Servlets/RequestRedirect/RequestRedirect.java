import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RequestRedirect extends HttpServlet{
	@Override
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		res.setStatus(301);
		res.setHeader("Location","http://localhost:8081/servlet/HelloServlet");
	}
}