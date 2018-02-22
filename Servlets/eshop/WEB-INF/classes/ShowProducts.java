import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ShowProducts extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		res.setContentType("text/html");
		
		
		HttpSession session = req.getSession();
		
		String typeId = req.getParameter("typeid");
		System.out.println(typeId);
		
		//This condition means adding products in session and show again
		if(typeId==null){
			typeId =(String) session.getAttribute("typeid");
			String productId = req.getParameter("productid");
			String  productName = req.getParameter("productname");
			String  price= req.getParameter("price");
			String  quantity = req.getParameter("quantity");
			
			System.out.println(typeId);
			System.out.println(productId);
			System.out.println(productName);
			System.out.println(price);
			System.out.println(quantity);
			
			ItemBean item = new ItemBean();
			item.setProductId(Integer.parseInt(productId));
			item.setProductName(productName);
			item.setPrice(Double.parseDouble(price));
			item.setQuantity(Integer.parseInt(quantity));
			
			session.setAttribute(productId,item);
		}
		session.setAttribute("typeid",typeId);
		PrintWriter out = res.getWriter();
		out.println("got type Id "+typeId);
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>S.No</th>");
		out.println("<th>Name</th>");
		out.println("<th>Rate</th>");
		out.println("<th>Quantity</th>");
		out.println("<th>Basket</th>");
		out.println("</tr>");
		try{
			java.util.ArrayList list = DatabaseManager. getAllProduct(Integer.parseInt(typeId));
			for(int i=0;i<list.size();i++){
				ProductBean bean = (ProductBean)list.get(i);
				out.println("<tr>");
				out.println("<td>"+(i+1)+"</td>");
				out.println("<td>"+bean.getProductName()+"</td>");
				out.println("<td>"+bean.getPrice()+"</td>");
				out.println("<td colspan=2><form action='ShowProducts'>");
				out.println("<input type='hidden' name='productid' value='"+bean.getProductId()+"'>");
				out.println("<input type='hidden' name='productname' value='"+bean.getProductName()+"'>");
				out.println("<input type='hidden' name='price' value='"+bean.getPrice()+"'>");
				out.println("<input type='number' name='quantity' required='required'>");
				out.println("<input type='submit' value='Add'>");
				out.println("</form></td>");
				out.println("</tr>");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		out.println("</table>");
		
		out.println("<form action='ViewBasket'>");
		out.println("<input type='submit' value='ViewBasket'>");
		out.println("</form>");
	}
}	