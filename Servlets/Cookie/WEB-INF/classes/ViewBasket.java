import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ViewBasket extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request ,  HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		
		Cookie cooks[] = request.getCookies();
		
		PrintWriter out = response.getWriter();
		if(cooks==null || cooks.length==0){
			out.println("Empty Basket");
			out.println("<a href='addbasket.html'>Insert More Items</a>");
			return;
		}
		
		for(int i=0;i<cooks.length;i++){
			String name = cooks[i].getName();
			String value= cooks[i].getValue();
			
			out.println(name+" : "+value+"<br>");
			out.println("<hr>");
		}
		
		out.println("<a href='DestroyBasket'>Destroy Basket</a>");
		out.println("<a href='addbasket.html'>Insert More Items</a>");	
	}	

}