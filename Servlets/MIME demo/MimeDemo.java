import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MimeDemo extends HttpServlet{
	String user;
	String pass;
	
	public void init(ServletConfig conf) throws ServletException{
		super.init(conf);
		System.out.println("aa");
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("application/vnd.ms-excel");
		user = req.getParameter("user");
		
		out.println(user+"\tQ1\tQ2\tQ3\tQ4\tTotal");
		out.println("Apples\t78\t87\t92\t22\t=SUM(B2:E2)");
		out.println("Orannges\t77\t86\t93\t30\t=SUM(B3:E3)");
		
	}
}