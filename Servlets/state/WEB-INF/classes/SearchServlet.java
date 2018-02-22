import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class SearchServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in Search Form Servlet");
		PrintWriter out = res.getWriter();
		
		String propertyType = req.getParameter("propertytype");
		String forWhat = req.getParameter("forwhat");
		
		System.out.println("Property: "+propertyType);
		System.out.println("For What: "+forWhat);
		
		if(forWhat==null)return;
		
		HttpSession session = req.getSession();
		String areaId = session .getAttribute("area").toString();
		System.out.println("Area Id: "+areaId);
		
		out.println("<body background='images/background.jpg'>");
		out.println("<font face='Imprint MT Shadow' size=8 style='display:block;text-align:center'> "+session.getAttribute("areaname")+"</font>");
		
		try{
			ArrayList list = DatabaseManager.getAllProperty_detail(Integer.parseInt(areaId) ,  propertyType ,  forWhat);
			out.println("<table border=2>");
			out.println("<tr>");
			out.println("<th>Area Size</th>");
			out.println("<th>Number Of Rooms</th>");
			out.println("<th>Location</th>");
			out.println("<th>Single/Double Story</th>");
			out.println("<th>Kitchen</th>");
			out.println("<th>More Info</th>");
			out.println("</tr>");
			for(int i=0;i<list.size();i++){
				PropertyDetailBean bean = (PropertyDetailBean) list.get(i);
				out.println("<tr>");
				out.println("<th>"+ bean.getAreaSquareFeet()+"</th>");
				out.println("<th>"+bean.getNumberRoom()+"</th>");
				out.println("<th>"+bean.getLocation()+"</th>");
				out.println("<th>"+bean.getSingleDoubleStory()+"</th>");
				out.println("<th>"+bean.getKitchen()+"</th>");
				out.println("<th>");
				out.println("<form action='DetailsServlet'>");			
				out.println("<input type='hidden' name='propertyid' value='"+bean.getPropertyDatailId()+"'>");			
				out.println("<input type='submit' value='details'>");			
				out.println("</td>");
				out.println("</tr>");
			
			}
			out.println("</table>");
			out.println("</body>");
		}catch(Exception ex){
			ex.printStackTrace(out);
		}
		
	}
}