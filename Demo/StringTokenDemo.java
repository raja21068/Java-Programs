import java.util.*;

class StringTokenDemo {

	public static void main(String[] args) {
 
		String str="My name is Ali";
		StringTokenizer token=new StringTokenizer(str," ");
		while(token.hasMoreTokens()){
			System.out.println(token.nextToken());
		}
		
	}

}
