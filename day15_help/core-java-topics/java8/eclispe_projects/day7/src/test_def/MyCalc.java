package test_def;

public class MyCalc implements Calculator {

	@Override
	public double add(double d1, double d2) {
		System.out.println("imple method");
		return d1 + d2;
	}
	@Override
	public  void test() {
		System.out.println("overrding def method imple.");
	}

}
