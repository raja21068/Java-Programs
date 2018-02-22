import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteFromDatabase extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println(">> Entered in DeleteFromDatabase");
		
		HttpSession session = req.getSession();
		AdminBean admin =(AdminBean)session.getAttribute("admin");
		PrintWriter out = res.getWriter();
		
		if(admin==null){
			res.sendRedirect("login.html");
			return;
		}
		
		String identify = req.getParameter("identify");
		System.out.println("request from delete the "+identify);
		if(identify.trim().equals("product")){
			String productId = req.getParameter("productid");
			System.out.println("ProductId: "+productId);
			if(productId == null){ 
				res.sendRedirect("ShowProductsForAdmin");
				return;
			}
			try{
				DatabaseManager.deleteProduct(Integer.parseInt(productId));
				
			}catch(Exception ex){ ex.printStackTrace(out);}
			
		}
		
		res.sendRedirect("ShowProductsForAdmin");
		
	}

}
	