
public class Main {
    public static void main(String arg[]){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        
        double r1 = 1;
        double r2 = 1;
        double r3 = 1;
        
        double a1=0.0;
        double a2=0.0;
        double a3=0.0;
        double a4=0.0;
        double a5=0.0;
        double a6=0.0;
        double a7=0.0;
        double a8=0.0;
        double a9=0.0;
        
        System.out.print("Enter r1c1= ");
        a1 = scan.nextDouble();
        System.out.print("Enter r1c2= ");
        a2 = scan.nextDouble();
        System.out.print("Enter r1c3= ");
        a3 = scan.nextDouble();
        System.out.print("Enter r2c1= ");
        a4 = scan.nextDouble();
        System.out.print("Enter r2c2= ");
        a5 = scan.nextDouble();
        System.out.print("Enter r2c3= ");
        a6 = scan.nextDouble();
        System.out.print("Enter r3c1= ");
        a7 = scan.nextDouble();
        System.out.print("Enter r3c2= ");
        a8 = scan.nextDouble();
        System.out.print("Enter r3c3= ");
        a9 = scan.nextDouble();
        
        System.out.print("How may iteration you have to perform: ");
        int iter = scan.nextInt();
        
        double temp1 = r1;
        double temp2 = r2;
        double temp3 = r3;
        
        double max=0;
        for(int i=0;i<iter;i++){
        
			r1 = ((a1*temp1)+(a2*temp2)+(a3*temp3));
			r2 = ((a4*temp1)+(a5*temp2)+(a6*temp3));
			r3 = ((a7*temp1)+(a8*temp2)+(a9*temp3));
			
			if(r1>r2 && r1>r3){
				max = r1;
			}						
			else if(r2>r1 && r2>r3){
				max = r2;
			}						
			else if(r3>r1 && r3>r2){
				max = r3;
			}else if(r3==r1){
				max = r1;
			}else if(r2==r1){
				max = r2;
			}else if(r3==r2){
				max = r3;
			}			
			
			System.out.println(a1+"  "+a2+"  "+a3+"          "+temp1+"    =      "+r1);
			System.out.println(a4+"  "+a5+"  "+a6+"          "+temp2+"    =      "+r2);
			System.out.println(a7+"  "+a8+"  "+a9+"          "+temp3+"    =      "+r3);
        
		
		
			temp1 = r1 / max;
			temp2 = r2 / max;
			temp3 = r3/max;
			System.out.println("U"+(i+1)+" = "+max);
			System.out.println("      -              ");
			System.out.println("     |   "+temp1);
			System.out.println("V"+(i+1)+"=  |   "+temp2);
			System.out.println("     |   "+temp3);
			System.out.println("      -              ");
			System.out.println("=========================================================");
        }
    }
}
