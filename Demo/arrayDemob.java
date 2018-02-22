import java.awt.*;
class arrayDemob {

	public static void main(String[] args) {
		/*Button arr[]=new Button[10];
		Frame win=new Frame("button");
		win.setLayout(new FlowLayout());
		win.setBounds(0,0,500,500);
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=new Button();
			arr[i].setSize(20,20);
			win.add(arr[i]);
			
		}
			win.show();*/
		/*int arr[]=new int[10];
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		arr[4]=50;
		arr[5]=60;
		arr[6]=80;
		arr[7]=70;
		arr[8]=90;
		arr[9]=440;
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}*/
	
		int arr[]=new int[6];
		/*for(int i=0;i<arr.length;i++){
			double a=Math.random()*10;
			arr[i]=(int)a;
			System.out.println(arr[i]);	
		}*/
		arr[0]=61;
		arr[1]=7;
		arr[2]=5;
		arr[3]=3;
		arr[4]=101;
		arr[5]=67;
	
		//*****Bubble Sort*****
		/*	for(int outer=0;outer<arr.length;outer++){
			for(int inner=0;inner<arr.length-1;inner++){
				if(arr[inner]>arr[inner+1]){
					int temp=arr[inner];
					arr[inner]=arr[inner+1];
					arr[inner+1]=temp;
				}
			}
			
			
		}
		//For traversing
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}*/
		//*For Linear Search
		/*int item=0;
		int test=1;
		for(int i=0;i<arr.length;i++){
			if(item==arr[i]){ System.out.println("baba item mili wayo: loc athas: "+(i+1));
									test=0;}
		}
		if(test!=0){ System.out.println("yar item ta ladho ee kon...!"); }*/
		
		////*******Binary search?******
		/*int item=10;
		int test=1;
		int lb=0,up=arr.length-1;
		for(int i=0;i<arr.length;i++){
			int mid=(lb+up)/2;
			if(arr[mid]==item){ System.out.println("item found..Loc:"+mid); test=0; break;}
			if(arr[mid]>item){ up=mid; }
			if(arr[mid]<item){ lb=mid+1; }
			}
		if(test!=0) 
			System.out.println("Item Not Found......!");*/
	
	//********selection sort*********
		
	int index=0;
	int kamroparchi=0;
	boolean b=false;
	int box=arr[index];
	for(int i=0;i<5;i++ ){
		box=arr[index];
		for(int j=index+1;j<arr.length;j++){
			if(box>arr[j]){ box=arr[j]; kamroparchi=j; b=true; }
		}
		if(b){int bhando=arr[index];
		arr[index]=box;
		arr[kamroparchi]=bhando;
		
		}
		index++;
		b=false;
	}
	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
	}
		
	}

}
