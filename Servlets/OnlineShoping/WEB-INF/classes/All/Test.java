import java.io.*;
import javax.servlet.*;

public class Test extends GenericServlet {

    public void service(ServletRequest request,ServletResponse response)
        throws IOException, ServletException
    {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();






        out.println("<h1>hello it Testing Servlet</h1>");



    }

}


