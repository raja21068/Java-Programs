import java.util.*;

public class Fire extends Thread{
	
	Vector arr;
	Vector x;
	boolean isRunning;
	
	public Fire(Vector a, Vector x ,boolean iR){
		arr = a;
		isRunning = iR; 
		this.x = x;
	}
	
	public void run(){
		try{
			while(true){
				if(arr.size() == 0){ isRunning=false; break; }
				else{ isRunning=true; }
				//System.out.println(arr.size());
				for(int i=0;i<arr.size();i++){
					int j = Integer.parseInt((String)arr.elementAt(i)) -2;
					
					arr.removeElementAt(i);
					arr.insertElementAt( ""+j , i);
					
					if(j < 0){
						//System.out.println("Out..");
						arr.removeElementAt(i);
						x.removeElementAt(i);
						i--;
					}
					
				}
				/*for(int i=0;i<arr.size();i++){
					int j = Integer.parseInt((String)arr.elementAt(i)) -2;
					System.out.println(j+" : "+i);
					arr.insertElementAt( ""+j , i);
					/*if(j <= 0){
						arr.removeElementAt(i);
						x.removeElementAt(i);
						continue;
					}else{
						arr.insertElementAt( ""+j , i);
					}
						
				}*/
				sleep(100);
			}
		}catch(Exception ex){ ex.printStackTrace();}
	}
}