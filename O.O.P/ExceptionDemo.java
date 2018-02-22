
class ExceptionDemo{
public static void main(String arg[]){
        try{
                String s1=arg[0];
                String s2=arg[1];
                int a=Integer.parseInt(s1);
                int b=Integer.parseInt(s2);
                int c=a/b;
                System.out.println("Division is: "+c);
        }
        catch(ArrayIndexOutOfBoundsException e){ System.out.println("plz pass two command line argument: "+e);  }
        catch(NumberFormatException e){ System.out.println("Both argument must be integer: "+e);  }
        catch(ArithmeticException e){ System.out.println("2nd argument must not be zero: "+e);  }
        catch(Exception e){ System.out.println("Gerenal Error: "+e);  }
        System.out.println("GOOD BYE");
}
}
