import java.net.*;
import java.io.*;

public class Webserver{
	public static void main(String arg[])throws Exception{
	
		DataInputStream info = new DataInputStream(new FileInputStream("web.xml"));
		String information="";
		String temp;
		while((temp=info.readLine())!=null){
			information+=temp;
		}
		
		System.out.println(information);
		int index = information.indexOf("port");
		int port = Integer.parseInt((information.substring(index+5,information.indexOf(";",index))).trim());
		System.out.println("Starting on port no: "+port);
		
		ServerSocket server = new ServerSocket(port);
		do{
			Socket socket = server.accept();
			System.out.println("Connected with client...");
			
			DataInputStream in = new DataInputStream(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			String statusLine = in.readLine();
			System.out.println(statusLine);
			
			String tokens[] = statusLine.split(" ");
			String method = tokens[0];			
			String url = tokens[1];
			String protocol = tokens[2];
			
			// try{
				// System.out.println(url.substring(1)+"/WEB-INF/web.xml");
				// FileInputStream webin = new FileInputStream(url.substring(1)+"/WEB-INF/web.xml");
				// System.out.println("got the web.xml");
			// }catch(FileNotFoundException ex){
				// ex.printStackTrace();
			// }
			
			// url = "classes"+url.replace('/','.');
			url = url.replace('/','.');
			
			System.out.println(method);		
			System.out.println(url);
			System.out.println(protocol);
			System.out.println(url.substring(1));
			try{
				Class c= Class.forName(url.substring(1));
				System.out.println("loaded the class");
				Object ob = c.newInstance();
				System.out.println("Got the object..");
				MyServlet request = (MyServlet)ob;
			
				out.println("HTTP/1.1 200 OK");	
				out.println("Content-type: text/html");
				out.println();
				
				request.service(in , out);
			}catch(Exception ex){
				out.println(url+ " not found");
			}
			
			out.close();
			in.close();
			socket.close();
		}while(true);
	}
}