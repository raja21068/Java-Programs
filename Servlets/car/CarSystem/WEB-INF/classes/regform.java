import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class regform extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String identify = req.getParameter("identify");
		
		if(identify.equals("search")){
		
		}
		
		if(identify.equals("add")){
		
		
	}
	
	public void showRecords(PrintWriter out) throws IOException
	{
		
			String company = req.getParameter("company");
			String model = req.getParameter("model");
			String color = req.getParameter("color");
			String register = req.getParameter("register");
			String price = req.getParameter("price");
			String ac = req.getParameter("ac");
			String cng = req.getParameter("cng");
			String powerwindow = req.getParameter("powerwindow");
			String transmission = req.getParameter("transmission");
			
				
		ArrayList<VehicleBean> VehicleList = null;
		try{
			VehicleList = DatabaseManager.getAllvehicle();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		out.print("<table border=1>"
					+ "<tr>"
					+ "<td>Remove</td>"
					+ "<td>Name</td>"
					+ "<td>LastName</td>"
					+ "<td>FatherName</td>"
					+ "<td>RollNo</td>"
					+ "<td>Department</td>"
					+"</tr>"
				 );
		
		for(int i = 0; i < VehicleList.size(); i++)
		{
			VehicleBean bean = VehicleList.get(i);
			System.out.println(bean.getLastName());
				out.write("<tr>"
						+"<td><a href='AddressBook?id=" +bean.getId() +"' >remove</a></td>"
						+"<td>" +bean.getName() +"</td>"
						+"<td>" +bean.getLastName() +"</td>"
						+"<td>" +bean.getFName() +"</td>"
						+"<td>" +bean.getRollNo() +"</td>"
						+"<td>" +bean.getDepartment() +"</td>"
						+"</tr>"
						);
		}
		out.print("</table>");
	}
	
	public void AddRecords(PrintWriter out) throws IOException
	{
	String company = req.getParameter("company");
		String model= req.getParameter("model");
		String color = req.getParameter("color");
		String RegistorCity = req.getParameter("registerCity");
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
		String pics = req.getParameter("pics");
		
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

		System.out.println("company: " +company);
		System.out.println("model: " +model);
		System.out.println("color: " +color);
		System.out.println("registerCity: " +registerCity);
		System.out.println("price: " +price);
		System.out.println("ac: " +ac);
		System.out.println("cng: " +cng);
		System.out.println("powerwindow: " +powerwindow);
		System.out.println("transmission: " +transmission);
		System.out.println("ownwer: " +ownwer);
		System.out.println("city: " +city);
		System.out.println("email: " +email);
		System.out.println("address: " +address);
		System.out.println("pics: " +pics);
		
		try
			{
				DatabaseManager.addVehicleDatabaseManager.addVehicle(company, model, color, registerCity, price, acc, cngg, powerWin, trans, ownwer, contact, email, address, "");
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		
		
	}
}