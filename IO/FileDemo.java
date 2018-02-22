import java.io.*;
class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		File f=new File("abc.txt");
		System.out.println(f.exists());
		if(!f.exists()){
			f.createNewFile();

		}

	}

}
