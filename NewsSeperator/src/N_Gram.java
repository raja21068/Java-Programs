import java.util.*;
public class N_Gram {
	
	static String[] nGram(String str, int n){
		str=str.trim();
		String array[]=str.split(" ");
		String output[]=new String[array.length];
		int index=0;
		int start=0;
		int outIndex=0;
		while(index<=array.length-1){
			int startrepeat=start;
			output[outIndex]="";
			
			for(int i=1;i<=n;i++){
				output[outIndex]+=array[startrepeat++]+" ";
			}
			index= (start+n);
			start++;
			outIndex++;
		}
		int Null=0;
		for(int i=0;i<output.length;i++){ if(output[i]==null){Null++;} }
		array=new String[output.length-Null];
		for(int i=0;i<array.length;i++){ array[i]=output[i]; }

		return array;
	}

	public static void main(String[] args) {
		System.out.print("Enter sentence: ");
		String s=new Scanner(System.in).nextLine();
		String str[]= new N_Gram().nGram(s,2);
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}

}
