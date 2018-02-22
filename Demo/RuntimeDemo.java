import java.util.*;
class RuntimeDemo {

	public static void main(String[] args)throws Exception {
		
		Runtime run=Runtime.getRuntime();
		run.exec("calc");
	}

}
