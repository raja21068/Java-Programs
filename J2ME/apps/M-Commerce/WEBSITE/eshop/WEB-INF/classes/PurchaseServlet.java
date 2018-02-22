import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class PurchaseServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		boolean mobile = false;
		String ob = req.getHeader("user-agent");
		System.out.println("user-agent: "+ob);
		if(ob == null){
			mobile = true;
		}
		
		if(!mobile){
			out.println("<html>");
			out.println("<head>");
			out.println("<script lang='javascript'>");
			out.println("function validatePass(p1, p2) {");
			out.println("if (p1.value != p2.value || p1.value == '' || p2.value == '') {");
			out.println("	p2.setCustomValidity('card Number mismatched ');");
			out.println("} else {");
			out.println("	p2.setCustomValidity('');");
			out.println("	}");
			out.println("}");
			out.println("</script>");
			out.println("</head>");
	
			out.println("<form action='Verification'>");
			out.println("<table border=1>");
			
			out.println("<tr>");
			out.println("<td>UserName</td>");
			out.println("<td><input type='text' name='username' required='required'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Password</td>");
			out.println("<td><input type='password' name='pass' required='required'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Credit Card Number</td>");
			out.println("<td><input type='text' name='creditcardno' id='c1' required='required'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Re-Credit Card Number</td>");		
			out.println("<td><input type='text' name='recreditcard' required='required' onfocus=\"validatePass(document.getElementById('c1'), this);\"  ></td>");
			out.println("</tr>");
		
			out.println("<tr>");
			out.println("<td>Card Name</td>");		
			out.println("<td>");
			out.println("<select name='cardid' size=1>");
		}
		try{
			java.util.ArrayList list = DatabaseManager.getAllCreditCards();
			for(int i=0 ; i<list.size();i++){
				CreditCardsBean bean = (CreditCardsBean)list.get(i);
				if(mobile){
					out.println(bean.getCardId()+"~"+bean.getCardName());
				}
				if(!mobile){
					out.println("<option value='"+bean.getCardId()+"' >"+bean.getCardName()+"</option>");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		if(!mobile){
			out.println("</select>");
			out.println("</td>");
			out.println("</tr>");
		
			out.println("<tr>");
			out.println("<td colspan=2><input type='submit' value='Purchase' ></td>");		
			out.println("</tr>");
			
			out.println("</table>");
			out.println("</form>");
			
			out.println("<a href='registrationform.html'>New Registration</a>");
			
			out.println("</html>");
		}		
	}
}