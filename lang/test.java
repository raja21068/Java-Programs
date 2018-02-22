

class test {

	
	public static void main(String[] args) {
	int space=2,h=-1;
		for(int i=1;i<=3;i++){
			System.out.print("\n");
			space++;
			for(int j=5;j>=i;j--){
			System.out.print(" ");
			if(j==space){h++; j-=h;
				for(int k=0;k<=h;k++){System.out.print(" *"); }
			}
			}
 				}
		space=0; h=5; int j;
		
		for(int i=1;i<5;i++){
			System.out.print("\n");
			h-=1;
			 space++; 
			for(j=1;j<5;j++){
			System.out.print(" ");
		if(j==space){ for(int k=1;k<=h;k++){ System.out.print("* ");} }			
		}
			
	
	
}
		
	}

}
