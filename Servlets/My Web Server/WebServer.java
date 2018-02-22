import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import classes.servlet.MyServlet;

public class WebServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(7777);
        do{
			Socket socket = server.accept();
			System.out.println("Client Connected....");

			DataInputStream in = new DataInputStream(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream(),false);

			String statusLine = in.readLine();
			System.out.println(statusLine);

			String[] tokens = statusLine.split(" ");

			String method=tokens[0];
			String url=tokens[1];
			String protocol=tokens[2];

			url="classes"+url.replace('/','.');

			System.out.println(method);
			System.out.println(url);
			System.out.println(protocol);

			Class c=Class.forName(url);
			Object obj=c.newInstance();
	
			MyServlet servlet=(MyServlet)obj;

			StringBuffer buffer=new StringBuffer();

			servlet.service(in,buffer);

			System.out.println("HTTP/1.1 200 OK");
			System.out.println("Content-type: text/plain");
			System.out.println("Content-length: "+buffer.toString().length());
			System.out.println();
			System.out.println(buffer.toString());  

			out.println("HTTP/1.1 200 OK");
			out.println("Content-type: text/html");
			out.println("Content-length: "+buffer.toString().length());
			out.println();
			out.println(buffer.toString());  

			out.flush();

			in.close();
			out.close();
			socket.close();

		}while(true);
    }
}














/*
            if(reqArray[1].equals("/")){
                File f = new File("index.html");
                DataInputStream file = new DataInputStream(new FileInputStream(f));
                String str;
                while((str=file.readLine())!=null){
                    out.println(str);
                }
            }
            else{
                String[] s = reqArray[1].split("");
                String path="";
                for(int i=2; i<s.length; i++){
                    path+=s[i];
                }
                File f = new File(path);
                System.out.println(path);
                if(f.exists()){
                    DataInputStream file = new DataInputStream(new FileInputStream(f));
                    String str;
                    while((str=file.readLine())!=null){
                        out.println(str);
                    }
                }
                else{
                    out.println("<h1>File not Found</h1>");
                }
            }

*/
  