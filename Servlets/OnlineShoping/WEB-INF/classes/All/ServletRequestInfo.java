import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;


public class ServletRequestInfo extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{

	PrintWriter out = res.getWriter();
	Enumeration en = req.getHeaderNames();
	while(en.hasMoreElements()){
		String s = (String)en.nextElement();
		out.println("<h1>"+s+"</h1>");
		Enumeration names = req.getHeaders(s);
		while(names.hasMoreElements()){
			out.println(names.nextElement());
		}
       }	
}


}
