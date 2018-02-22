import java.io.File;
import java.io.FilenameFilter;
class Filtering implements FilenameFilter{
	
	String extension;
	Filtering(String ext){
		extension = ext; 
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		System.out.println(name);//checking method repetition
		if(name.endsWith(extension)){ return true;}
		return false;
	}
} 

public class FilenameFilterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("E:/javaProgramms");
		Filtering filter = new Filtering(".java");
		String files[] = f.list(filter);
		for(int i=0; i<files.length; i++){
			System.out.println(files[i]);
		}
	}

}
