import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class RegistrationServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in LoginServlet");
		
		String  firstName=req.getParameter("first_name");
		String  lastName=req.getParameter("last_name");
		String  city=req.getParameter("city");
		String  address=req.getParameter("address");
		String  contactNo=req.getParameter("contact_no");
		String  email=req.getParameter("email");
		String  user=req.getParameter("user");
		String  password=req.getParameter("password");
		
		try{
				DatabaseManager.addCustomer(firstName, lastName, city, address, contactNo, email,user, password);
				System.out.println("Added the user..");
				res.getWriter().println("<h1>You have registered Succesfuuly</h1>");
				RequestDispatcher dis = getServletContext().getRequestDispatcher("login.html");
				dis.forward(req,res);
		}catch(Exception ex){
		
		}
	}
}