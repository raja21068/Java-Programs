import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class CityServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in CityServlet");
		PrintWriter out = res.getWriter();
		
		try{
			out.println("<body background='images/background.jpg'>");
			out.println("<font face='Imprint MT Shadow' size=4> Cities (Sindh) </font>");
			out.println("<ul>");
			ArrayList cities = DatabaseManager.getAllCity();
			for(int i=0;i<cities.size();i++){
				CityBean bean = (CityBean) cities.get(i);
				
				out.println("<li><a href='AreaServlet?cityname="+bean. getCityName().trim().replaceAll(" " ,"+")+"&cityid="+bean.getCityId()+"' target='area'>"+bean. getCityName()+"</a></li>");
				
			}
			out.println("</ul>");
			out.println("</body>");
		}catch(Exception ex){
			ex.printStackTrace(out);
		}
			
	}
	
}