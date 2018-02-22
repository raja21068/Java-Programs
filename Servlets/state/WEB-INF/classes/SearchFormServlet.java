import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class SearchFormServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in Search Form Servlet");
		PrintWriter out = res.getWriter();
		
		String areaId = req.getParameter("areaid");
		String areaName = req.getParameter("areaname");
		
		
		if(areaId!=null){
			HttpSession session = req.getSession();
			session.setAttribute("area",areaId);
			session.setAttribute("areaname",areaName);
			
			out.println("<body background='images/background.jpg'>");
			out.println("<font face='Imprint MT Shadow' size=8 style='display:block;text-align:center'> "+areaName+"</font>");
			out.println("<form action='SearchServlet'>");
			try{
				out.println("Property Type:");
				out.println("<select name='propertytype'>");
				ArrayList list = DatabaseManager.getDistinctPropertyType( Integer.parseInt(areaId) );
				for(int i=0;i<list.size();i++){
					out.println("<option value='"+list.get(i)+"'>"+list.get(i)+"</option>");
				}
				out.println("</select>");
				out.println("<br>");
				out.println("for:");
				out.println("<select name='forwhat' size=1>");
				out.println("<option value='Sale'>Sale</option>");
				out.println("<option value='Rent'>Rent</option>");
				out.println("</select>");
				out.println("<br>");
				out.println("<input type='image' src='images/search.gif'>");
			}catch(Exception ex){ ex.printStackTrace(out);}
			out.println("</form>");
			out.println("</body>");
		}
	}
}