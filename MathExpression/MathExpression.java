import java.util.*;
public class MathExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob =new Scanner(System.in);
		int total=0;
		System.out.print("Enter Math Expression: ");
		String s= ob.nextLine();
		String str[]= new String[s.length()];
		int last=0;
		int index=-1;
		
		try{
		for(int i=0 ; i<s.length() ; i++){
			char ch= s.charAt(i);
			if(ch=='/' || ch=='*' || ch=='+' || ch=='-'){
				str[++index]=s.substring(last, i);
				str[++index]=""+s.charAt(i);
				last=i+1;
			}
		}
		
		str[++index]=s.substring(last,s.length());
		
		for(int i=0 ; i<str.length+5;i++){
			if(s.contains("/")|| s.contains("*")||s.contains("%")){
				for(int j=0;j<str.length; j++){
					if(str[j].equals("/")){
						str[j]=""+Double.parseDouble(str[j-1])/Double.parseDouble(str[j+1]);
						str[j-1]=null;
						str[j+1]=null;
						s="";
						for(int k=0;k<str.length;k++){
							if(str[k]!=null)s+=str[k];
						}
						System.out.println(s);
						str=new String[s.length()];
						last=0;
						index=-1;
						for(int l=0 ; l<s.length() ; l++){
							char ch= s.charAt(l);
							if(ch=='/' || ch=='*' || ch=='+' || ch=='-'){
								str[++index]=s.substring(last, l);
								str[++index]=""+s.charAt(l);
								last=l+1;
							}
						}str[++index]=s.substring(last,s.length());
						break;
					}
					if(str[j].equals("*")){
						str[j]=""+Double.parseDouble(str[j-1])*Double.parseDouble(str[j+1]);
						str[j-1]=null;
						str[j+1]=null;
						s="";
						for(int k=0;k<str.length;k++){
							if(str[k]!=null)s+=str[k];
						}
						System.out.println(s);
						str=new String[s.length()];
						last=0;
						index=-1;
						for(int l=0 ; l<s.length() ; l++){
							char ch= s.charAt(l);
							if(ch=='/' || ch=='*' || ch=='+' || ch=='-'){
								str[++index]=s.substring(last, l);
								str[++index]=""+s.charAt(l);
								last=l+1;
							}
						}str[++index]=s.substring(last,s.length());
						break;
					}
					if(str[j].equals("%")){
							str[j]=""+Double.parseDouble(str[j-1])%Double.parseDouble(str[j+1]);
						str[j-1]=null;
						str[j+1]=null;
						s="";
						for(int k=0;k<str.length;k++){
							if(str[k]!=null)s+=str[k];
						}
						System.out.println(s);
						str=new String[s.length()];
						last=0;
						index=-1;
						for(int l=0 ; l<s.length() ; l++){
							char ch= s.charAt(l);
							if(ch=='/' || ch=='*' || ch=='+' || ch=='-'){
								str[++index]=s.substring(last, l);
								str[++index]=""+s.charAt(l);
								last=l+1;
							}
						}str[++index]=s.substring(last,s.length());
						break;
					}
				}
			}
		}
		
		//////////////////////////////////////////////////////////////////
		for(int i=0 ; i<str.length+5;i++){
			if(s.contains("-")|| s.contains("+")){
				for(int j=0;j<str.length; j++){
					if(str[j].equals("+")){
						str[j]=""+(Double.parseDouble(str[j-1])+Double.parseDouble(str[j+1]));
						str[j-1]=null;
						str[j+1]=null;
						s="";
						for(int k=0;k<str.length;k++){
							if(str[k]!=null)s+=str[k];
						}
						System.out.println(s);
						str=new String[s.length()];
						last=0;
						index=-1;
						for(int l=0 ; l<s.length() ; l++){
							char ch= s.charAt(l);
							if(ch=='/' || ch=='*' || ch=='+' || ch=='-'){
								str[++index]=s.substring(last, l);
								str[++index]=""+s.charAt(l);
								last=l+1;
							}
						}str[++index]=s.substring(last,s.length());
						break;
					}
					if(str[j].equals("-")){
						str[j]=""+(Double.parseDouble(str[j-1])-Double.parseDouble(str[j+1]));
						str[j-1]=null;
						str[j+1]=null;
						s="";
						for(int k=0;k<str.length;k++){
							if(str[k]!=null)s+=str[k];
						}
						System.out.println(s);
						str=new String[s.length()];
						last=0;
						index=-1;
						for(int l=0 ; l<s.length() ; l++){
							char ch= s.charAt(l);
							if(ch=='/' || ch=='*' || ch=='+' || ch=='-'){
								str[++index]=s.substring(last, l);
								str[++index]=""+s.charAt(l);
								last=l+1;
							}
						}str[++index]=s.substring(last,s.length());
						break;
					}
				}
			}
		}
		
		}catch(Exception e){ System.out.println("Oops..! calculation problem"); }
		//**********visiting*******************
		//for(int i=0;i<str.length ; i++){
			//System.out.println(str[i]);
		//}
		
	}

}
