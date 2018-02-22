import javax.servlet.http.*;
import java.io.*;

public class MyServlet extends HttpServlet
{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException
	{
		PrintWriter out = res.getWriter();
		out.println("<html><body><marquee>My Name is Ghaffar</marquee></body></html>");
	}
}