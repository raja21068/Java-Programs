import java.util.*;

public class PasswordBuilder{
	
	public static void main(String arg[])throws Exception{
		Properties p = new Properties();
		p.setProperty("ali","netlyc");
		p.setProperty("abc","mit");
		p.setProperty("xyz","bell");
		p.setProperty("jay","kumar");
		
		java.io.FileOutputStream file =  new java.io.FileOutputStream("E://passwords.pass");
		
		p.save(System.out,"System.out");
		p.save(file,"Fie");
		
		file.close();
		System.out.println("Password fie build successfully...");
	}

}