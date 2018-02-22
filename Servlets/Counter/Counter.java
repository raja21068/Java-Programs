import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Counter extends HttpServlet{
	int i=1;
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		if(i<=10){
			out.print("<h1 align=\"center\">"+(i++)+"</h1>");
			res.setIntHeader("Refresh",1);
		}
		else{
			out.print("<h1 align=\"center\">Welcome!</h1>");
			i=1;
		}
	}

}