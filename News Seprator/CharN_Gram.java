import java.util.Scanner;

public class CharN_Gram {
	
	String[] nGram(String str, int n){
		str=str.trim();
		char array[]=str.toCharArray();
		String output[]=new String[array.length];
		int index=0;
		int start=0;
		int outIndex=0;
		while(index<=array.length-1){
			int startrepeat=start;
			output[outIndex]="";
			
			for(int i=1;i<n;i++){
				output[outIndex]+=array[startrepeat++]+" ";
			}
			index= (start+n);
			start++;
			outIndex++;
		}
		int Null=0;
		for(int i=0;i<output.length;i++){ if(output[i]==null){Null++;} }
		String out[]=new String[output.length-Null];
		for(int i=0;i<out.length;i++){ out[i]=output[i]; }
		return out;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter any word: ");
		String s=scan.nextLine();
		System.out.print("Enter gram: ");
		int gram=scan.nextInt();
		String str[]= new N_Gram().nGram(s,gram);
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}

}
