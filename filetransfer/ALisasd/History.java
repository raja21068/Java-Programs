import java.io.*;
import java.util.*;
import javax.swing.table.*;


class History
{

	static String historyText="";
	
	static void addToHistory(String source, String destination,String fileName)throws Exception
	{
		File recordFile = new File("Record.txt");
		
		if(!recordFile.exists())
		{
			recordFile.createNewFile();
			PrintStream out = new PrintStream(new FileOutputStream(recordFile));
			out.println(fileName + "|||" + source + "|||" + destination  + "|||" + new Date().getDate()+ "-" + new Date().getMonth() + "-2012");
			out.close();
		}
		
		else if(recordFile.exists())
		{
			RandomAccessFile file = new RandomAccessFile(recordFile,"rw");
			file.seek(recordFile.length());
			file.writeBytes(fileName + "|||" + source + "|||" + destination  + "|||" + new Date().getDate()+ "-" + new Date().getMonth() + "-2012" + "\n");
			file.close();
		}
	}
	
	static void addRecordToTable()throws Exception
	{
		File recordFile = new File("Record.txt");
		
		if(recordFile.exists())
		{
			DataInputStream in = new DataInputStream(new FileInputStream(recordFile));
			String str="";
			
			while( (str=in.readLine()) != null)
			{
				StringTokenizer token = new StringTokenizer(str,"|||");
				String s[] = new String[4];
				
					int k=0;
						while(k<=3)
						{
							s[k] = token.nextToken();
							k++;
						}
					double per;
						
						if(new File(s[2]).length() == 0)
							per = 0;
						else
							per = (double)(new File(s[2]).length())/(new File(s[1]).length()) * 100;
								
					
				
				DynamicFileDownloadProtocol.tableModel.addRow(new Object[]{s[0],(int)per+"%",s[3],s[1],s[2]});
			}
			in.close();
		}
	}
	
	static boolean checkIfAllreadyExists(String source,String destination, String fileName)throws Exception
	{
		File recordFile = new File("Record.txt");
		
		if(recordFile.exists())
		{
			DataInputStream in = new DataInputStream(new FileInputStream(recordFile));
			String str="";
			while((str=in.readLine()) != null)
			{
				StringTokenizer token = new StringTokenizer(str,"|||");
				String s[] = new String[4];
				int k=0;
				while(k<=3)
				{
					s[k] = token.nextToken();
					k++;
				}
				
				if(s[0].equals(fileName) && s[1].equals(source) && s[2].equals(destination))
					return true;
			}
		}
		
		return false;
	}
	
	
	static void deleteRecord(String source, String destination, String fileName)throws Exception
	{
		File recordFile = new File("Record.txt");
		
		if(recordFile.exists())
		{
			DataInputStream in = new DataInputStream(new FileInputStream(recordFile));
			
			File tempFile = new File("tempFile.txt");
			PrintStream out = new PrintStream(new FileOutputStream(tempFile));
			
			String str="";
			while( (str=in.readLine()) != null)
			{
				StringTokenizer token = new StringTokenizer(str,"|||");
				String s[] = new String[4];
				
				int k=0;
				while(k<=3)
				{
					s[k] = token.nextToken();
					k++;
				}
		
				if(!(s[0].equals(fileName) && s[1].equals(source) && s[2].equals(destination)))	
					out.println(str);

			}
			
			in.close();
			out.close();
			System.out.println(recordFile.delete());
			System.out.println(tempFile.renameTo(recordFile));
			
		}
		
	}
}
