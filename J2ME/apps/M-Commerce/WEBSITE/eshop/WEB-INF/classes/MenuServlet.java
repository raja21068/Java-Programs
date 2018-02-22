import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MenuServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		boolean mobile = false;
		String ob = req.getHeader("user-agent");
		System.out.println("user-agent: "+ob);
		if(ob == null){
			mobile = true;
		}
		
		if(!mobile){
			out.println("<link rel='stylesheet' href='css/style.css' />");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td> <a href='home.html' target='display' id=heading> Home</a> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td> <a href='LoginServlet' target='display' id=heading>Admin</a> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td id=heading>Categories </td>");
			out.println("</tr>");
		}
		try{
			java.util.ArrayList list = DatabaseManager. getAllType();
			for(int i=0;i<list.size();i++){
				TypeBean bean = (TypeBean)list.get(i);
				if(mobile){
					out.println(bean.getTypeName()+"~ShowProducts?typeid="+bean.getTypeId());
				}else{
					out.println("<tr>");
					out.println("<td> <a href='ShowProducts?typeid="+bean.getTypeId()+"' target='display'>"+bean.getTypeName()+" </a> </td>");
					out.println("</tr>");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if(!mobile){ 
			out.println("</table>");
		}
	}
}	