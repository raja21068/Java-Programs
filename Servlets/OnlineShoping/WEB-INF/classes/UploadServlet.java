import java.io.*;
import javax.servlet.*;

public class UploadServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException{
		ServletInputStream in = req.getInputStream();
 		int len = req.getContentLength();
		byte[] data = new  byte[len];
		in.read(data , 0 , len);
		FileOutputStream file = new FileOutputStream("d:/abc.txt");
		file.write(data, 0, len);
		file.close();
		PrintWriter out = res.getWriter();
		out.println("uploaded succesfully...");
	}

}