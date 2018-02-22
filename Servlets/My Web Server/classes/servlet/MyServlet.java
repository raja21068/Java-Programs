package classes.servlet;

import java.io.*;

public interface MyServlet{
void service(DataInputStream in,StringBuffer buffer)
throws Exception;
}
