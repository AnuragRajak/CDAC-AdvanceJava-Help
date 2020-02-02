package lambdas1;

import static lambdas1.Utils.*;

public class Tester2 {

	public static void main(String[] args) {
		//OR lambda expression
		System.out.println("Div "+testCompute(200, 12, (a,b)->a/b));
		int data=100;
		String s="adgadf";
		//func literal -- sub 
		Computable sub=(a,b)->a-b;
		System.out.println("Sub "+testCompute(200, 12, sub));
		
	}

}
