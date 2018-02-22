import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CodeExecuteServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String code = req.getParameter("codingArea");
			int port = req.getServerPort();
			String server = req.getServerName();
			out.println("<form name=form action=\"http://"+server+":"+port+"/servlet/CodeExecuteServlet\"><center>code<br><textarea name=\"codingArea\" cols=50% rows=10%></textarea><br><input type=submit value=\"try it!\"></center><hr></hr>"+code+"</form>");
	}
}