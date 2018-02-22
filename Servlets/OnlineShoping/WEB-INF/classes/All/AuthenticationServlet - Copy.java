import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class AuthenticationServlet extends HttpServlet {

  private Properties p;
 
  public void init(ServletConfig conf)throws ServletException{
   
        String fileName=conf.getInitParameter("File-Name");	
	try{	
	     FileInputStream file=new FileInputStream(fileName);	  
	     p=new Properties();	  
	     p.load(file);
	     System.out.println("Password File successfully loaded......");	 
	}catch(Exception e){	  
	     ServletContext context=conf.getServletContext();
	     context.log(e,"Password File Not Found");
	     e.printStackTrace();	   	    		  
	}//end catch
  }//end init method


  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
   
     PrintWriter out=res.getWriter();
     res.setContentType("text/html");

     String user=req.getParameter("user");	 
     String pass=req.getParameter("pass");	 

     
     if(p==null)	  
	  out.println("<H1>Server Error 501: Password File not loaded");
     else 
          if(user==null|| user.trim().equals("")||pass==null||pass.trim().equals(""))
	     askForPassword(out,"User or Password Empty");
	  else{
	 	  String realPassword=p.getProperty(user);
		  if(realPassword==null) 
                    askForPassword(out,"Wrong User");
                  else
                      if(realPassword.equals(pass))
		      welcome(out);
		  else
                      askForPassword(out,"Wrong Password");				
	   }
   }//end doGet

				  
     private void askForPassword(PrintWriter out,String msg)throws IOException{
	 
	   out.println("<h1>Restricted Page</h1>");  
	   out.println("<h2>"+msg+"</h2>");  
	   out.println("<form action=/servlet/auth>");  
	   out.println("<center>");
           out.println("<table>");
	   out.println("<tr>");
	   out.println("<td>Enter User</td><td><input type=text name=user><BR></td>");
	   out.println("</tr>");  
           out.println("<tr>"); 
	   out.println("<td>Enter Password</td><td><input type=password name=pass><BR><td>");
	   out.println("</tr>");
	   out.println("<tr></tr>");
	   out.println("<tr></tr>");
	   out.println("<tr></tr>");
	   out.println("<tr>");
	   out.println("<td></td><td><input type=submit></td>");
	   out.println("</tr");
	   out.println("</table>");
	   out.println("</center>");
           out.println("</form>");
    }//end askForPassword				  
				  
    private void welcome(PrintWriter out)throws IOException{
		   
	   out.println("<center><H1>:::::::::::::::WELCOME:::::::::::::<br> </center>");
	   out.println("<center><H2>You are authenticated User</h2></center>");
	   out.println("");
	   out.println("");
	   out.println("");
	   out.println("<center><a href=/servlet/auth><h2>Go to Authentication</h2></a><center>");
	   
    }//end welcome				  
 } //end AuthenticationServlet