
public class Stringsort {

	public static void main(String[] args) {
		String str="hello java hello";
		String str2="DAM";
		String str3="CAM";
		
        
		char ch[]= " ".toCharArray();
		System.out.println(str.replace("java","hello"));
		System.out.println(str.indexOf('j'));
		System.out.println(str.indexOf('j',4));
		System.out.println(str.indexOf("java"));
		System.out.println(str.indexOf("java",3));

		System.out.println(str.lastIndexOf('j'));
		System.out.println(str.lastIndexOf('j',9));
		System.out.println(str.lastIndexOf("hello"));
		System.out.println(str.lastIndexOf("hello",10));
		
		System.out.println(str.charAt(7));
		System.out.println(str.length());
		
		System.out.println(str.substring(3, 8));
		System.out.println(str.substring(4));

		System.out.println(str.replace('e','L'));
		System.out.println(str2.compareTo(str3));
		
		if(str.equals("hello")){}
		
		String[] s1={"hello","students","java","has","started","new","batch"};
		for(int i=0;i<s1.length;i++){
			for(int k=0;k<s1.length-1;k++){
				if(s1[k].compareTo(s1[k+1])>s1[k+1].compareTo(s1[k])){
					String temp=s1[k];
					s1[k]=s1[k+1];
					s1[k+1]=temp;
				}//if
			}//inner
		}//outer
		for(int i=0;i<s1.length;i++){
			System.out.print(s1[i]+" ");
		}
	}

}
