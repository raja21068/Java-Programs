import java.io.FileReader;
import java.io.BufferedReader;
public class FileReaderDemo {

	public static void main(String[] args)throws Exception {
		FileReader reader = new FileReader("E:/Hello.txt");
		BufferedReader in = new BufferedReader(reader);
		String line;
		while((line= in.readLine())!=null){
			System.out.println(line);
		}
	}

}
