package java_8_features3;

public class MyFormula implements Formula {

	@Override
	public double calculate(double a) {
		System.out.println("3");
		return 0;
	}

	@Override
	public double sqrt(double a, double b) {
		System.out.println("4");
	/*	// access static method of the i/f
		Formula.test();
*/		return 0;
	}

	//@Override
	static void test() {
		System.out.println("5");
		System.out.println("in i/f static method");
	}

}
