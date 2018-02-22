import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddBasket extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		
		String item = request.getParameter("item");
		String quantity = request.getParameter("quantity");
	
		Cookie cook = new Cookie(item , quantity);
		
		response.addCookie(cook);
		
		PrintWriter out = response.getWriter();
		out.println("Succesffuly  inserted ");
		out.println("<a href='ViewBasket'>View Basket</a>");
		out.println("<a href='addbasket.html'>Insert More Items</a>");
	}

}