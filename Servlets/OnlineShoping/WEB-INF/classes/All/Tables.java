import javax.servlet.*;
import java.io.*;

public class Tables extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException, IOException{
		PrintWriter out = res.getWriter();
		
		int tab = Integer.parseInt(req.getParameter("tab"));
		int count = Integer.parseInt(req.getParameter("count"));
		
		res.setContentType("text/html");;
		out.println("<html>");
		out.println("<form action=\"Tables\">");
		out.println("Enter Table No");
		out.println("<input type=\"text\" name=\"tab\" required=\"required\"/><br />");
		out.println("Enter counter number");
		out.println("<input type=\"text\" name=\"count\" required=\"required\" /><br />");
		out.println("<input type=\"submit\" value=\"submit\" />");
		out.println("</form>");
		out.println("<hr />");
		out.println("<table border=2>");
		for(int i=1;i<=count;i++){
			out.println("<tr>");
			out.println("<td>"+tab+"</td>");
			out.println("<td>X</td>");
			out.println("<td>"+i+"</td>");
			out.println("<td>=</td>");
			out.println("<td>"+(tab*i)+"</td>");
			
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</html>");
	}

}