import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Verification extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("pass");
		String creditCardNo = req.getParameter("creditcardno");
		String cardId = req.getParameter("cardid");
		
		System.out.println(">> Entered in Verfication servlet..");
		System.out.println(username);
		System.out.println(password);
		System.out.println(creditCardNo);
		System.out.println(cardId);
		
		try{
			CustomerBean customerBean = DatabaseManager.getCustomer(username , password);
		
			//if customer is not found in database
			if(customerBean==null){
				res.getWriter().println("<h2 style='color:red;'>UserName or Password is not valid..<h2>");
				res.getWriter().println("<a href='PurchaseServlet'>Retry Again</a><br>");
				res.getWriter().println("<a href='registrationform.html'>New Registration</a>");
				return;
			}
			
			CreditCardNumberBean cardBean = DatabaseManager.getCreditCardNumberBean(Integer.parseInt(cardId),creditCardNo.trim());
			if(cardBean==null){
				res.getWriter().println("<h2 style='color:red;'>Your Card Number is Invalid..</h2>");
				res.getWriter().println("<a href='PurchaseServlet'>Retry Again</a><br>");
				res.getWriter().println("<a href='registrationform.html'>New Registration</a>");
				return;
			}
			
			double billAmount = 0;
			HttpSession session = req.getSession();
			java.util.Enumeration<String> names = session.getAttributeNames();
			
			while(names.hasMoreElements()){
				String s = (String)names.nextElement();
				if(s.equals("typeid")){continue;}
				ItemBean bean =(ItemBean) session.getAttribute(s);
				billAmount += (bean.getQuantity()* bean.getPrice());
			}
			
			if(cardBean.getAmount()<billAmount){
				res.getWriter().println("<h2 style='color:red;'>You have "+cardBean.getAmount()+ "in your account and your bill is "+billAmount+" </h2>");
				res.getWriter().println("<a href='PurchaseServlet'>Try another Credit Card..</a><br>");
				return;
			}
			
			//performaing transaction
			names = session.getAttributeNames();
			
			while(names.hasMoreElements()){
				String s = (String)names.nextElement();
				if(s.equals("typeid")){session.removeAttribute(s); continue;}
				ItemBean bean =(ItemBean) session.getAttribute(s);
				DatabaseManager.addTansaction(customerBean.getCustomerId() , bean.getProductId() , cardBean.getCardNoId() , bean.getPrice() , bean.getQuantity(), DateFormatter.dateToString(new java.util.Date() , "yyyy-MM-dd") , "" , 0 , "" );
				session.removeAttribute(s);
			}
			
			DatabaseManager.updateCreditCardNumber(cardBean.getCardNoId() ,cardBean.getAmount()-billAmount, "");
			res.getWriter().println("<h2>Your purchased items will be delivered soon..!</h2><br>");
			res.getWriter().println("<a href='home.html'>Home</a>");
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}