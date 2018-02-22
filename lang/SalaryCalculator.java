
class SalaryCalculator {

int salary=0;
public SalaryCalculator(){
	
}
public void payhour(int bp,int h){
	if(bp<8||h>60){ System.out.println("It is an error...!"); }
	else{if(h<=40){salary=h*bp; System.out.print("salary is:"+salary); }
		 if(h>40){int r=h-40; System.out.print("salary is:"+((40*bp)+(r*(bp*1.5))));  }
		 }
    }
}
