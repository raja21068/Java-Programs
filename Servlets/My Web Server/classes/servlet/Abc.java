package classes.servlet;

import java.io.*;

public class Abc implements MyServlet{

   public void service(DataInputStream in, StringBuffer buffer)
   throws Exception{
      
      buffer.append("<h1>Hello</h1>");
   }
}