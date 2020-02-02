package lambdas1;

import static lambdas1.Utils.*;

public class Tester {

	public static void main(String[] args) {
		// add 2 numbers n show result
		System.out.println("Add " + testCompute(10, 20, new Adder()));
		// multiply 2 numbers n show result
		System.out.println("Product " + testCompute(10, 20, new Computable() {

			@Override
			public double compute(double d1, double d2) {
				return d1 * d2;
			}
		}));
		//OR lambda expression
		System.out.println("Div "+testCompute(200, 12, (a,b)->a/b));

	}

}
