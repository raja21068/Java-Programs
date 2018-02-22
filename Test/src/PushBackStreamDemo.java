
public class PushBackStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		java.io.FileReader file = new java.io.FileReader("");
		java.io.BufferedReader in = new java.io.BufferedReader(file);
		java.io.StreamTokenizer token = new java.io.StreamTokenizer(in);
		String delimeter = ",./<>\"'\\{}";
		char ch[] = delimeter.toCharArray();
		for(int i=0; i<ch.length;i++){
			System.out.print("White Space include: "+ch[i]);
			token.whitespaceChars(ch[i], ch[i]);
		}
		int tokenValue;
		while((tokenValue = token.nextToken())!= java.io.StreamTokenizer.TT_EOF){
			switch(tokenValue){
			case java.io.StreamTokenizer.TT_WORD:
				System.out.println("word token: "+token.sval);break;
			case java.io.StreamTokenizer.TT_NUMBER:
				System.out.print("Number Token: "+token.nval);break;
			default: System.out.println("Character: "+(char)tokenValue);	
			}
		}
	}

}
