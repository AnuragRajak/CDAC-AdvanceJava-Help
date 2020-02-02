package java_8_features2;

public class MyFormula implements Formula, Formula2 {

	@Override
	public double calculate(double a) {
		System.out.println("in calc");
		return a * 2;
	}

	@Override
	public double sqrt(double a, double b) {
		double res1 = Formula.super.sqrt(a, b);
		double res2 = Formula2.super.sqrt(a, b);
		return res1 + res2;

	}

}
