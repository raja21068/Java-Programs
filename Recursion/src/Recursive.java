
public class Recursive {
    
//*****************************************\\    
    static void even(int num){
        if(num<1){System.out.println(num);return;}
        even(num-1);
        if((num%2)==0)System.out.println(num);
    }   
//*****************************************\\    
    static void evenReverse(int num){
        if(num<1){System.out.println(num);return;}
        if((num%2)==0)System.out.println(num);
        evenReverse(num-1);
    }    
//*****************************************\\
    static void odd(int num){
        if(num<1)return;
        odd(num-1);
        if((num%2)==1)System.out.println(num);
    }
//*****************************************\\
    static void oddReverse(int num){
        if(num<1)return;
        if((num%2)==1)System.out.println(num);
        oddReverse(num-1);
    }
//*****************************************\\
    static void primeReverse(int num){
        if(num==1){System.out.println(num);return;}
        boolean b = true;
        for(int i=2;i<num;i++){
            if((num%i)==0){b=!b;break;}
        }
        if(b)System.out.println(num);
        primeReverse(num-1);
    }
    //*****************************************\\
    static void prime(int num){
        if(num==1){System.out.println(num);return;}
        prime(num-1);
        for(int i=2;i<num;i++){
            if((num%i)==0)return;
        }
        System.out.println(num);
        
    }
//*****************************************\\
    static void star(int num){
        if(num==0)return;
        star(num-1);
        for(int i=1 ; i<=num;i++){
            System.out.print("*");
        }
        System.out.println();
    }
//*****************************************\\    
    static void fibo(int num){
      int temp = 1 , j = 1;
      for(int i=1 ; i<num ; ){
            temp =i;
            System.out.println(i);
            i = j+temp;
            j = temp;
        }        
    }
//*****************************************\\
    static void fibonacea(int num , int no2){
        
        int sum=num+no2;
        if(no2>num || sum <0)return;
        System.out.println(sum); 
        fibonacea(sum , num);
       
    }
    //*****************************************\\
    static void fibonaceaLimit(int num , int num2, int limit){
        int sum=num+num2;
        if(sum>limit)return;
        System.out.println(sum); 
        fibonaceaLimit(sum , num , limit);
       
    }
//*****************************************\\       
    public static void main(String args[]){
        fibonacea(1,0 );
    }
}
