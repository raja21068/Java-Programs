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
		
		boolean mobile = false;
		String ob = req.getHeader("user-agent");
		System.out.println("user-agent: "+ob);
		if(ob == null){
			mobile = true;
		}
		
		try{
			CustomerBean customerBean = DatabaseManager.getCustomer(username , password);
		
			//if customer is not found in database
			if(customerBean==null){
				if(mobile){
					res.getWriter().println("UserName or Password is not valid..");
				}else{
					res.getWriter().println("<h2 style='color:red;'>UserName or Password is not valid..<h2>");
					res.getWriter().println("<a href='PurchaseServlet'>Retry Again</a><br>");
					res.getWriter().println("<a href='registrationform.html'>New Registration</a>");
				}
				return;
				
			}
			
			CreditCardNumberBean cardBean = DatabaseManager.getCreditCardNumberBean(Integer.parseInt(cardId),creditCardNo.trim());
			if(cardBean==null){
				if(mobile){
					res.getWriter().println("Your Card Number is Invalid..");
				}else{
					res.getWriter().println("<h2 style='color:red;'>Your Card Number is Invalid..</h2>");
					res.getWriter().println("<a href='PurchaseServlet'>Retry Again</a><br>");
					res.getWriter().println("<a href='registrationform.html'>New Registration</a>");
				}
				return;
			}
			
			double billAmount = 0;
			
			if(mobile){
				billAmount = Double.parseDouble(req.getParameter("total"));
				if(cardBean.getAmount()<billAmount){
					res.getWriter().println("You have "+cardBean.getAmount()+ "in your account and your bill is "+billAmount);
					return;
				}
				String info = req.getParameter("beans");
				info = info.substring(0,info.length()-1);
				String[] beans = info.split("`");
				for(int i=0;i<beans.length;i++){
					String id = beans[i].split("~")[0];
					String price = beans[i].split("~")[1];
					String quantity = beans[i].split("~")[2];
					
					System.out.println("Id: "+id);
					System.out.println("Price: "+price);
					System.out.println("Quantity: "+quantity);
				
					DatabaseManager.addTansaction(customerBean.getCustomerId() , Integer.parseInt(id.trim()) , cardBean.getCardNoId() , Double.parseDouble(price) , Integer.parseInt(quantity), DateFormatter.dateToString(new java.util.Date() , "yyyy-MM-dd") , "" , 0 , "" );
				}
				DatabaseManager.updateCreditCardNumber(cardBean.getCardNoId() ,cardBean.getAmount()-billAmount, "");
				res.getWriter().println("Transaction Successfully..! Your Items will be Delivered Soon..!");
				return;
			}
			
			if(!mobile){
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
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}