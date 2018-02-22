import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class LoginServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in Login Servlet");
		res.setContentType("text/html");
		
		HttpSession session = req.getSession();
		
		AdminBean adminBean =(AdminBean)session.getAttribute("admin");
		
		System.out.println("AdminBean: "+adminBean);
		if(adminBean!=null){
			try{printProducts(res.getWriter());}catch(Exception ex){ex.printStackTrace(res.getWriter());}
			return;
		}
		
		String name = req.getParameter("username");
		String pass = req.getParameter("pass");
		
		System.out.println("Name: "+name);
		if(name!=null && pass!=null){
			
			try{
				AdminBean admin = DatabaseManager. getAdmin(name , pass);
		
				if(admin == null){
					ServletContext context = getServletContext();
					RequestDispatcher dis = context. getRequestDispatcher("/login.html");
					res.getWriter().println("<h2>Invalid user or password..!</h2>");
					dis.include(req, res);
					return;
				}
			
				session.setAttribute("admin", admin);
				System.out.println("A session is added named 'admin'");
			
				PrintWriter out = res.getWriter();
				printProducts(out);
				
			}catch(Exception ex){
				ex.printStackTrace(res.getWriter());
			}
		}
		
		if(name==null && adminBean==null){
			res.sendRedirect("login.html");
		}
	}
	
	private void printProducts(PrintWriter out)throws Exception{
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>Categories</th>");
		out.println("<th>No. Of Products</th>");
		out.println("<th>View Products</th>");
		out.println("</tr>");
			
		java.util.ArrayList list = DatabaseManager.getAllType();
		for(int i=0;i<list.size();i++){
			TypeBean bean = (TypeBean) list.get(i);
			out.println("<tr>");
			out.println("<td>"+bean.getTypeName()+"</td>");
			out.println("<td>"+(DatabaseManager.getAllProduct(bean.getTypeId())).size()+"</td>");
			out.println("<td><a href='ShowProductsForAdmin?typeid="+bean.getTypeId()+"'>View</a></td>");
			out.println("</tr>");
			
		}
			
		out.println("</table>");
		out.println("<a href='addtpye.html'>Add Type</a><br>");
		out.println("<a href='LogoutServlet'>Logout</a>");
	}
}