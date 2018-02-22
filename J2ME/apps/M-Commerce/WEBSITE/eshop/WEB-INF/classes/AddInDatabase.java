import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class AddInDatabase extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in AddInDatabase");
		
		HttpSession session = req.getSession();
		AdminBean admin =(AdminBean)session.getAttribute("admin");
		PrintWriter out = res.getWriter();
		
		if(admin==null){
			res.sendRedirect("login.html");
			return;
		}
		
		String identify = req.getParameter("identify");
		
		if(identify.equals("type")){
			String typeName = req.getParameter("typename");
			String remarks = req.getParameter("remarks");
			
			System.out.println("Type Name: "+typeName);
			try{
				DatabaseManager.addType(typeName , remarks);
				res.sendRedirect("LoginServlet");
			}catch(Exception ex){
				ex.printStackTrace(out);
			}
			return;
		}
		
		if(identify.equals("product")){
			String  productName= req.getParameter("productname");
			String  price= req.getParameter("price");
			String  description= req.getParameter("description");
			
			System.out.println(productName+ " is going to be add..");
			int id = (Integer)session.getAttribute("typeid");
			System.out.println("Got the typeid for adding product "+id);
			
			try{
				DatabaseManager.addProduct(id , productName , Double.parseDouble(price) , description);

			}catch(Exception ex){
				ex.printStackTrace();
			}
			res.sendRedirect("ShowProductsForAdmin");
			return;
		}
		
		res.sendRedirect("LoginServlet");
			
	}
	
}