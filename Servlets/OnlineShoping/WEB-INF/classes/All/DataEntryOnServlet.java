import javax.servlet.*;
import java.io.*;
import java.util.*;

public class DataEntryOnServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)throws ServletException,IOException{
		PrintWriter out = res.getWriter();
		String dbPath = req.getRealPath("data.mdb");
		out.println(dbPath);
		DatabaseManagerServlet.setDBPath(dbPath , out);
		res.setContentType("text/html");
		out.println("<h1>Data Entry</h1>");
		Enumeration parameterNames = req.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String name =(String) parameterNames.nextElement();
			if(name.equals("cell")){
				entry(out , req , parameterNames);
				break;
			}
			else if(name.equals("data")){
				showData(out);
				break;
			}
			else if(name.equals("id")){
				delete(out , req.getParameter(name));
				break;
			}
		}
		
	}
	public void entry(PrintWriter print , ServletRequest req , Enumeration parameterNames){
		print.println("Entered in entry()");
		String name = req.getParameter("name");
		String father = req.getParameter("father");
		String surname = req.getParameter("surname");
		String roll = req.getParameter("roll");
		String cell = req.getParameter("cell");
		print.println(name+"<br>"+father+"<br>"+surname+"<br>"+roll+"<br>"+cell);
		try{
			DatabaseManagerServlet.addRecord(print , name , father , surname , roll , cell);
		}catch(Exception ex){
			print.println(ex);
		}
	}
	
	public void showData(PrintWriter out){
		try{
			java.util.ArrayList list = DatabaseManagerServlet.getRecords();
			out.println("<table border=2>");
			
			out.println("<tr>");
			out.println("<th>Delete</th>");
			out.println("<th>Name</th>");
			out.println("<th>Father Name</th>");
			out.println("<th>Surname</th>");
			out.println("<th>getRoll No</th>");
			out.println("<th>Cell No</th>");
			out.println("</tr>");
			
			for(int i=0;i<list.size();i++){
				RecordBean rec = (RecordBean)list.get(i);
				out.println("<tr>");
				out.println("<td><a href=\"DataEntryOnServlet?id="+rec.getId()+"\" >remove</a></td>");
				out.println("<td>"+rec.getName()+"</td>");
				out.println("<td>"+rec.getFatherName()+"</td>");
				out.println("<td>"+rec.getSurname()+"</td>");
				out.println("<td>"+rec.getRollNo()+"</td>");
				out.println("<td>"+rec.getCellNo()+"</td>");
				
				out.println("</tr>");
			}
			out.println("</table>");
		}catch(Exception ex){
			out.println(ex);
		}
	
	}
	
	public void delete(PrintWriter out , String id){
		int ID = Integer.parseInt(id);
		try{
			DatabaseManagerServlet.deleteRecord(out ,ID);
		}catch(Exception ex){
		
		}
		showData(out);
	}

}