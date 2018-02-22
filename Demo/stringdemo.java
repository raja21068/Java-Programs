
class stringdemo {

	/**
	 * 
	 */
	public static void main(String[] args) {
				  //0123456789
		String str="Hello java\n";
		System.out.print(str);
	char  ch[]=str.toCharArray();
	for(char c:ch){
		System.out.println(c);
	}
	for(int i=5;i>=0;i--){
		System.out.print(ch[i]);
	}
	}

}
