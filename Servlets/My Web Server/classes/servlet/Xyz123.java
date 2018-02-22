package classes.servlet;

import java.io.*;

public class Xyz123 implements MyServlet{

   public void service(DataInputStream in,StringBuffer buffer)
   throws Exception{
      
   for(int i=1; i<=6; i++)
      buffer.append("<h"+i+">Hello</h"+i+">");
   for(int i=6; i>=1; i--)
      buffer.append("<h"+i+">Hello</h"+i+">");

   }
}