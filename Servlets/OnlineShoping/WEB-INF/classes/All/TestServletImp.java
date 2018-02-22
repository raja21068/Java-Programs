import javax.servlet.*;
import java.io.*;

public class TestServletImp implements Servlet{
	ServletConfig conf;
	public void init(ServletConfig conf)
	{
		this.conf = conf;
		System.out.println("I am init()");
	}
	
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException, IOException{
		PrintWriter out = res.getWriter();
		out.println("Hello servlet");
		System.out.println("I am service()");
	}

	public void destroy(){
		System.out.println("I am destroy()");
	}

	public String getServletInfo(){
		System.out.println("I am get ServletInfo()");
		return "This is just a testing example";
	}

	public ServletConfig getServletConfig(){
		return conf;
	}
}