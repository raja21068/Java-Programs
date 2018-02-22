import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class AreaServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in Area");
		PrintWriter out = res.getWriter();
		
		String id = req.getParameter("cityid");
		if(id==null)return;
		
		HttpSession session = req.getSession();
		session. setAttribute("city",id);
		
		out.println("<body background='images/background.jpg'>");
		out.println("<font face='Imprint MT Shadow' size=4>"+req.getParameter("cityname")+"</font>");
		out.println("<ul>");
		try{
			ArrayList areas = DatabaseManager.getAllArea(Integer.parseInt(id));
			for(int i=0;i<areas.size();i++){
				AreaBean bean = (AreaBean) areas.get(i);
				out.println("<li><a href='SearchFormServlet?areaname="+bean.getAreaName().trim().replaceAll(" ","+")+"&areaid="+bean.getAreaId()+"' target='display'>"+bean. getAreaName()+"</a></li>");
				
			}
		out.println("</ul>");
		out.println("</body>");
		}catch(Exception ex){
			ex.printStackTrace(out);
		}
	}
}