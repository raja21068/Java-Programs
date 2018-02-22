import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

 
class LoginServletDemo extends HttpServlet{
	String user;
	String pass;
	
	public void init(ServletConfig conf) throws ServletException{
		super.init(conf);
		System.out.println("aa");
		user = conf.getInitParameter("user");
		pass = conf.getInitParameter("pass");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		user = req.getParameter("user");
		pass = req.getParameter("pass");

		if(user.equals("al") && pass.equals("bell")){
			out.println("<h1>User Authenticated</h1>");
		}else{
			out.println("<h1>User Un-Authenticated</h1>");
		}

//		out.println("getAsyncContext() : "+req.getAsyncContext().name() );
//		out.println("getAuthType() : "+req.getAuthType() );
//		out.println("isRequestedSessionIdValid() : "+req.isRequestedSessionIdValid() );
//		out.println("getQueryString(): "+req.getQueryString());
//		out.println("getAttribute(\"form\"): "+req.getAttribute("form")+"<br>");
//		out.println("getAttributeNames() : ");
//		java.util.Enumeration<String> en = req.getAttributeNames();
//		out.println("<UL>");
//		while(en.hasMoreElements()){
//			String at = en.nextElement();
//			out.println("<IL><b>"+at+"</b></IL><br>");
//			out.println("getAttribute("+at+"): "+req.getAttribute(at)+"<br>");
//		}
//		out.println("</UL>");
//		out.println("getCharacterEncoding(): "+req.getCharacterEncoding()+"<br>");
//		out.println("getContentLength(): "+req.getContentLength()+"<br>");
//		out.println("getContentType(): "+req.getContentType()+"<br>");
		//out.println("getDispatcherType(): "+req.getDispatcherType()+"<br>");
//		out.println("getLocalAddr(): "+req.getLocalAddr()+"<br>");
//		out.println("getLocale(): "+req.getLocale()+"<br>");
 //               
//                out.println("getLocales(): "+req.getLocales()+"<br>");
//                java.util.Enumeration loc = req.getLocales();
//                while(loc.hasMoreElements()){
//			out.println("<b>"+loc.nextElement()+"</b><br>");
//		}
//                
//                out.println("getLocalName(): "+req.getLocalName()+"<br>");
//		out.println("getLocalPort(): "+req.getLocalPort()+"<br>");
//		//out.println("getParameter(): "+req.getParameter("pass")+"<br>");
//		//out.println("getParameterMap(): "+req.getParameterMap()+"<br>");
//		out.println("getParameterNames(): <UL>");
//		java.util.Enumeration<String> names = req.getParameterNames();
//		while(names.hasMoreElements()){
//			out.println("<IL><b>"+names.nextElement()+"</b></IL><br>");
//		}
//		out.println("</UL>");
//		//out.println("String[]  getParameterValues(" ") : ");
//		out.println("getProtocol() : "+req.getProtocol()+"<br>");
//		//out.println("getReader() : "+req.getReader()+"<br>");
//		//out.println("getRealPath("") : "+req.getRealPath("")+"<br>");
//		out.println("getRemoteAddr() : "+req.getRemoteAddr()+"<br>");
//		out.println("getRemoteHost() : "+req.getRemoteHost()+"<br>");
//		out.println("getRemotePort() : "+req.getRemotePort()+"<br>");
//		out.println("getScheme() : "+req.getScheme()+"<br>");
//		out.println("getServerName() : "+req.getServerName()+"<br>");
//		out.println("getServerPort() : "+req.getServerPort()+"<br>");
//		//out.println("getServerContext() : "+req.getServerContext()+"<br>");
//		//out.println("isAsyncStarted() : "+req.isAsyncStarted()+"<br>");
//		//out.println("isAsyncSupported() : "+req.isAsyncSupported()+"<br>");
//		out.println("isAsyncSecure() : "+req.isSecure()+"<br>");

	}
}