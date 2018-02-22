import java.io.*;
import javax.servlet.*;

public class OnlineShopping extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException{
		
		String identify = req.getParameter("identify");
		
                PrintWriter out = res.getWriter();
		
                if(identify.equals("search")){
			String company = req.getParameter("company");
			String model = req.getParameter("model");
			String color = req.getParameter("color");
			String register = req.getParameter("register");
			String price = req.getParameter("price");
			String ac = req.getParameter("ac");
			String cng = req.getParameter("cng");
			String powerwindow = req.getParameter("powerwindow");
			String transmission = req.getParameter("transmission");
		}
		else if(identify.equals("add")){
			String company = req.getParameter("company");
			String model = req.getParameter("model");
			String color = req.getParameter("color");
			String register = req.getParameter("register");
			String price = req.getParameter("price");
			String ac = req.getParameter("ac");
			String cng = req.getParameter("cng");
			String powerwindow = req.getParameter("powerwindow");
			String transmission = req.getParameter("transmission");
			String ownwer = req.getParameter("ownwer");
			String city = req.getParameter("city");
			String contact = req.getParameter("contact");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
                        
                        boolean acc = false;
                        if(ac.equals("yes")){ acc = true;  }
                        
                        boolean cngg = false;
                        if(cng.equals("yes")){ cngg = true; }
                        
                        boolean powerWin = false;
                        if(powerwindow.equals("yes")){ powerWin = true; }
                        
                        int trans = 0;
                        if(transmission.equals("auto")){
                            trans = Constant.AUTO;
                        }
                        else if(transmission.equals("normal")){
                            trans = Constant.NORMAL;
                        }
                        try{
                            DatabaseManager.addVehicle(company, model, color, register, price, acc, cngg, powerWin, trans, ownwer, contact, email, address, "");
                            out.println("<h1>Record succesfully added..</h1>");
                        }catch(Exception ex){
							System.out.println("");
							System.out.println("");
							System.out.println("");
							ex.printStackTrace();
							out.println(ex);
                        }
                        
		}
	}
}