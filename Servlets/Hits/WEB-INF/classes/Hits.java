import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Hits extends HttpServlet{
	
	int counter;
	String file = "counter.txt";
	
	@Override
	public void init(){
		
		try{
			File fil = new File(file);
			System.out.println(fil.getAbsolutePath());
			DataInputStream f = new DataInputStream(new FileInputStream(file));
			counter = Integer.parseInt(f.readLine());
		}catch(IOException ex){
			counter = 0;
		}
		
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		PrintWriter out = res.getWriter();
		out.println(++counter+" Time website accessed..");
	}
	
	@Override
	public void destroy(){
		try{
			PrintStream f = new PrintStream(new FileOutputStream(file));
			f.println(counter);
			f.close();
			
		}catch(IOException ex){ex.printStackTrace();}
	}
}
