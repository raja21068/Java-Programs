import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args)throws Exception{
		FileInputStream file = new FileInputStream("E:/Hello.txt");
		InputStreamReader reader = new InputStreamReader(file);
		int ch;
		while((ch=reader.read())!=-1){
			System.out.print((char)ch);
		}
		
	}

}
