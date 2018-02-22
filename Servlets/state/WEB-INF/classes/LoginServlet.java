import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class LoginServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in LoginServlet");
		
		String name = req.getParameter("user");
		String pass = req.getParameter("password");
		
		System.out.println("Username: "+name);
		System.out.println("Password: "+pass);
		
		try{
			CustomerBean bean = DatabaseManager.getCustomer(name , pass);
			if(bean==null){
				res.sendRedirect("invalidlogin.html");
			}else{
				HttpSession session = req.getSession();
				
				session.setAttribute("user" , bean);
				printRegistrationPropertyForm(req, res , bean );
			}
			
		}catch(Exception ex){
		}
	}
	
	private void printRegistrationPropertyForm(HttpServletRequest req, HttpServletResponse res , CustomerBean bean)throws Exception{
		System.out.println(">> Entered in Print Registration Form");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body background=background.gif>");
		out.println("<center>");
		out.println("<font face=\"Imprint MT Shadow\" size=5> Registration Form for Uploading the Property </font>	");


		out.println("<form enctype='multipart/form-data' action='UploadServlet' method='post'>");
		out.println("<TABLE>");


		out.println("<input type=hidden name=customer_id value="+bean.getCustomerId()+">");
		out.println("<TR>");
		out.println("<TD>City/ Area</TD>");
		out.println("<TD><select name=area_id>");
		try{
			ArrayList list = DatabaseManager.getAllArea();
			for(int i=0;i<list.size();i++){
				AreaBean area =(AreaBean) list.get(i);
				out.println("<option value="+area.getAreaId()+">"+area.getAreaName()+"</option>");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
		out.println("<TR>");
		out.println("<TD>Property Type</TD>");
		out.println("<TD>");
		out.println("<select name=property_type>");
		out.println("<option value=\"Banglow\">	Banglow</option>");
		out.println("<option value=\"Flate\">		Flate</option>");
		out.println("<option value=\"House\">		House</option>");
		out.println("<option value=\"CNG_pump\">	CNG Pump</option>");
		out.println("<option value=\"Petrol_pump\">	Petrol Pump</option>");
		out.println("<option value=\"Shop\">		Shop</option>");
		out.println("</select>");
		out.println("</TD>");
		out.println("</TR>");
	
	
		out.println("<TR>");
		out.println("<TD>For </TD>");
		out.println("<TD>	");
		out.println("<select name=for_what>");
		out.println("<option value='Sale'>Sale</option>");
		out.println("<option value='Rent'>Rent</option>");
		out.println("</select>");
		out.println("</TD>");
		out.println("</TR>");
	
		out.println("<TR>");
		out.println("<TD>Area in Sqr Feet</TD>");
		out.println("<TD><input type=text name=area_square_feet></TD>");
		out.println("</TR>");
	
		out.println("<TR>");
		out.println("<TD>Single/ Double Story</TD>");
		out.println("<TD><input type=text name=single_double_story></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>Number of Rooms</TD>");
		out.println("<TD><input type=text size=6 name=number_room></TD>");
		out.println("</TR>	");
		out.println("<TR>");
		out.println("<TD>Number of Kitchens</TD>");
		out.println("<TD><input type=text size=6 name=kitchen></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>Location of Property</TD>");
		out.println("<TD><input type=text size=40 name=location></TD>");
		out.println("</TR>");
	
		out.println("<TR>");
		out.println("<TD>Address of Property</TD>");
		out.println("<TD><input type=text size=60 name=property_address></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("	<TD>Prise Demand</TD>");
		out.println("<TD><input type=text size=6 name=prise></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>Full Descriptions & Features</TD>");
		out.println("<TD><textarea rows=5 cols=50 name=description></textarea></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>Photos</TD>");
		out.println("<TD><input type='file' name='dataFile' id='fileChooser'  multiple='multiple'/></TD>");
		out.println("</TR>");



		out.println("<TR>");
		out.println("<TD COLSPAN=2><input type=submit value='Next'></TD>");
		out.println("</TR>");
		out.println("</TABLE>");
		out.println("</FORM>");

		out.println("</center>");
		out.println("</html>");
	}
}