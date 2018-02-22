import java.util.*;
class Stringemail {

	
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter E-Mail: ");
		String str=ob.nextLine();
		char s1='@';
		String s2=".com";
		char s3=' ';
		char s4=';';
		char s5='\'';
		char s6='\"';
		char s7='\\';
		char s8=']';
		char s9='[';
		char s10='|';
		char s11='/';
		char s12='-';
		char s13='+';
		char s14='*';
		char s15=':';
		char s16='<';
		char s17='>';
		int loc1=str.indexOf(s1);
		int loc2=str.indexOf(s2,loc1+2);
		int loc3=str.indexOf(s3);
		int loc4=str.indexOf(s4);
		int loc5=str.indexOf(s5);
		int loc6=str.indexOf(s6);
		int loc7=str.indexOf(s7);
		int loc8=str.indexOf(s8);
		int loc9=str.indexOf(s9);
		int loc10=str.indexOf(s10);
		int loc11=str.indexOf(s11);
		int loc12=str.indexOf(s12);
		int loc13=str.indexOf(s13);
		int loc14=str.indexOf(s14);
		int loc15=str.indexOf(s5);
		int loc16=str.indexOf(s5);
		int loc17=str.indexOf(s5);
		
		if(loc1>0&&loc2>0&&loc3<0&&loc4<0&&loc5<0&&loc6<0&&loc7<0&&loc8<0&&loc9<0&&loc10<0&&loc11<0&&loc12<0&&loc13<0&&loc14<0&&loc15<0&&loc16<0&&loc17<0){
			System.out.println("**YOU ENTERRED VALID E-MAIL**");
			
		}else{
			System.out.println("**INVALID E-MAIL**");
		}
		
		
	}

}

