import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ViewBasket extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession();
		
		String deleteId = req.getParameter("deleteid");
		if(deleteId!=null){
			System.out.println("removed : "+deleteId);
			session.removeAttribute(deleteId);
		}
		
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>S.No</th>");
		out.println("<th>Name</th>");
		out.println("<th>Rate</th>");
		out.println("<th>Quantity</th>");
		out.println("<th>Total</th>");
		out.println("<th>Basket</th>");
		out.println("</tr>");
		
		java.util.Enumeration<String> names = session.getAttributeNames();
		int count=1;
		int total=0;
		while(names.hasMoreElements()){
			String s = (String)names.nextElement();
			if(s.equals("typeid")){continue;}
			ItemBean bean =(ItemBean) session.getAttribute(s);
			out.println("<tr>");
			out.println("<td>"+(count++)+"</td>");
			out.println("<td>"+bean.getProductName()+"</td>");
			out.println("<td>"+bean.getPrice()+"</td>");
			out.println("<td>"+bean.getQuantity()+"</td>");
			total +=  (bean.getQuantity()* bean.getPrice());
			out.println("<td>"+(bean.getQuantity()* bean.getPrice())+"</td>");
			out.println("<td><a href='ViewBasket?deleteid="+s+"'>Delete</a>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("<tr> <th></th> <th></th> <th></th>  <th></th> <th> Total : "+total+"  </th>   </tr>");
		out.println("</table>");
		
		out.println("<a href='PurchaseServlet'>Purchase</a>");
	}
}