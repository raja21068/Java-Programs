import java.io.*;

class InputOutPutFromFile {
	File fi=new File("fileInput.txt");
	File fo=new File("fileOutput.txt");
	InputOutPutFromFile()throws Exception{
		PrintStream prnt=new PrintStream(new FileOutputStream(fo));	
		DataInputStream rite=new DataInputStream(new FileInputStream(fi));
		String s=rite.readLine();
		String st[]=s.split(" ");
		int a,sum=0;
		for(int i=0;i<st.length;i++){
			a=Integer.parseInt(st[i]);
			sum+=a;
		}
		prnt.print("Addition is:"+sum);
		
}
	
	public static void main(String arg[])throws Exception{
		new InputOutPutFromFile();
}
	}
