import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ShowProductsForAdmin extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in ShowProductsForAdmin");
		
		HttpSession session = req.getSession();
		AdminBean admin =(AdminBean)session.getAttribute("admin");
		PrintWriter out = res.getWriter();
		
		if(admin==null){
			res.sendRedirect("login.html");
			return;
		}
		int typeId;
		try{
			typeId = Integer.parseInt(req.getParameter("typeid"));
		}catch(Exception ex){
			try{
				// ex.printStackTrace();
				//if type id is not found through parameter then find in session
				typeId = (Integer) session.getAttribute("typeid");
			}catch(Exception exx){
				// ex.printStackTrace();
				// if type id is not found in session then resend request to login
				res.sendRedirect("LoginServlet");
				System.out.println("resended to Login servelet");
				return;
			}
		}
		
		System.out.println("Got the type id "+typeId);
		session.setAttribute("typeid",typeId);
		
		try{
			java.util.ArrayList list = DatabaseManager.getAllProduct(typeId);
			
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Products</th>");
			out.println("<th>Price</th>");
			out.println("<th>Description</th>");
			out.println("<th>Delete</th>");
			// out.println("<th></th>");
			out.println("</tr>");
		
			for(int i=0;i<list.size();i++){
				ProductBean bean = (ProductBean) list.get(i);
				out.println("<tr>");
				out.println("<td>"+bean .getProductName()+"</td>");
				out.println("<td>"+bean .getPrice()+"</td>");
				out.println("<td>"+bean .getDescription()+"</td>");
				out.println("<td><a href='DeleteFromDatabase?identify=product&productid="+bean.getProductId()+"'><img src='images/remove.png'></a></td>");
				out.println("</tr>");
		
			}
		
			out.println("</table>");
			out.println("<a href='addproduct.html'>Add Product</a><br>");
			out.println("<a href='LogoutServlet'>Logout</a>");
		}catch(Exception ex){
			ex.printStackTrace(out);
		}
	}
}