import java.util.*;

class marksheet2{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter jam Marks: ");
Double jm=ob.nextDouble();

System.out.print("Enter Visual Basic Marks: ");
Double vm=ob.nextDouble();

System.out.print("Enter Oracle Marks: ");
Double om=ob.nextDouble();

System.out.print("Enter c++ Marks: ");
Double cm=ob.nextDouble();

System.out.print("Enter Assembly Marks: ");
Double am=ob.nextDouble();

Double obtain=jm+vm+om+cm+am;
Double per=(obtain*100)/500;

System.out.print("==========================");
System.out.print("\nYour obatined marks: "+obtain+"\nyour total marks: 500\nYour percentage : "+per+"\nGrade:");

if (per>=90){ System.out.print("'A1'\n ***PASS***"); }
if (per>=80 && per<=89){ System.out.print("'A'\n***PASS***"); }
if (per>=70 && per<=79){ System.out.print("'B'\n***PASS***"); }
if (per>=60 && per<=69){ System.out.print("'C'\n***PASS***"); }
if (per>=50 && per<=59){ System.out.print("'D'\n***PASS***"); }
if (per>=40 && per<=49){ System.out.print("'E'\n***PASS***"); }
if (per<40) { System.out.print("'F'\n***FAIL***"); }
}
}