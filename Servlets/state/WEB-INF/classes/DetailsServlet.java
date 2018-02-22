import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class DetailsServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in Search Form Servlet");
		PrintWriter out = res.getWriter();
	
		String propertyId = req.getParameter("propertyid");
		
		System.out.println("Property Id: "+propertyId);
		
		if(propertyId==null)return;
		HttpSession session = req.getSession();
		
		out.println("<font face='Imprint MT Shadow' size=8 style='display:block;text-align:center'> "+session.getAttribute("areaname")+"</font>");
		try{
			PropertyDetailBean propsBean=DatabaseManager.getAllPropertyDetail(Integer.parseInt(propertyId) );
			ArrayList list = DatabaseManager.getAllMediaDetail( Integer.parseInt(propertyId));
			
			for(int i=0;i<list.size();i++){
				MediaDetailBean bean = (MediaDetailBean) list.get(i);
				System.out.println(bean.getMediaName());
				out.println("<a href='upload/"+bean.getMediaName()+"'><img src='upload/"+bean.getMediaName()+"' witdth=100 height=100></a>");
				
			}
			out.println("<center>");
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Area Size</th>");
			out.println("<th>"+propsBean.getAreaSquareFeet()+"</th>");
			out.println("</tr>");			
			
			out.println("<tr>");
			out.println("<th>Number Of Rooms</th>");
			out.println("<th>"+propsBean.getNumberRoom()+"</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Location</th>");
			out.println("<th>"+propsBean.getLocation()+"</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Single/Double Story</th>");
			out.println("<th>"+propsBean.getSingleDoubleStory()+"</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Kitchen</th>");
			out.println("<th>"+propsBean.getKitchen()+"</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Property type</th>");
			out.println("<th>"+propsBean.getPropertyType()+"</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Price</th>");
			out.println("<th>"+propsBean.getPrice()+"</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Date Of Upload</th>");
			out.println("<th>"+propsBean.getDateUpload()+"</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Description</th>");
			out.println("<th>"+propsBean.getDescription()+"</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>For </th>");
			out.println("<th>"+propsBean.getForWhat()+"</th>");
			out.println("</tr>");
			
			out.println("</table>");
			
			out.println("if you are interested to take this property please contact us on following link.<br>");
			out.println("<a  href='bottom.html'>Click here for Contact</center>");
		}catch(Exception ex){
		
		}
		
	}
}