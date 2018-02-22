import java.io.*;
import javax.servlet.*;

public class Addition extends GenericServlet{

	@Override
	public void service(ServletRequest req , ServletResponse res)throws ServletException,IOException{
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");
		int amount = Integer.parseInt(req.getParameter("amount"));
		int total =0;
		try{
			total = Integer.parseInt(req.getParameter("total"));
		}catch(NumberFormatException ex){}
		out.println("<form action=\"Addition\">");
		out.println("Enter Amount");
		out.println("<input type='text' name='amount' />");
		out.println("<input type='hidden' name='total' value='"+(amount+total)+"' /><br />");
		out.println("Total Rs: "+(amount+total));
		out.println("<input type='submit' value='sum'>");
		out.println("</form>");
	}

}