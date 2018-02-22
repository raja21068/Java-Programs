import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DestroyBasket extends HttpServlet{

	@Override
	public void service(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		Cookie cooks[] = request.getCookies();
		
		if(cooks==null || cooks.length==0){
			out.println("Empty basket");
			return;
		}
		
		for(int i=0;i<cooks.length;i++){
			cooks[i].setMaxAge(0);
			response.addCookie(cooks[i]);
		}
		
		out.println("<a href='addbasket.html'>Add more Items</a>");
	}

}