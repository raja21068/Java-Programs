import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import sun.misc.BASE64Decoder;


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


     String authorization=req.getHeader("Authorization");
     if(authorization==null)askForPassword(res);
     else{
            String userInfo=authorization.substring(6).trim();
            BASE64Decoder decoder=new BASE64Decoder();
            String userAndPassword=new String(decoder.decodeBuffer(userInfo));
            StringTokenizer tokens=new StringTokenizer(userAndPassword,":");
            String user=tokens.nextToken();
            String pass=tokens.nextToken(); 
 
   	    String realPassword=p.getProperty(user);
	  
            if(realPassword==null) 
                 askForPassword(res);
            else
                if(realPassword.equals(pass))
		      welcome(out);
		else
                      askForPassword(res);				
      }//end else
   }//end doGet
				  

   private void askForPassword(HttpServletResponse res)throws ServletException{
         res.setStatus(res.SC_UNAUTHORIZED); // Ie 401
         res.setHeader("WWW-Authenticate","BASIC realm=\"privileged-few\"");
          
   }//end askForPassword				  
				  
    private void welcome(PrintWriter out)throws IOException{		   
	   out.println("<center><H1>:::::::::::::::WELCOME:::::::::::::<br> </center>");
	   
    }//end welcome				  
 } //end AuthenticationServlet