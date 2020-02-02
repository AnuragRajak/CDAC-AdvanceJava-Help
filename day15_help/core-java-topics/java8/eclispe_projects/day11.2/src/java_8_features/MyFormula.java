package java_8_features;

public class MyFormula implements Formula{

	@Override
	public double calculate(double a) {
		System.out.println("in calc");
		return a*2;
	}
	@Override
	public double sqrt(double a,double b) 
	{
		return Math.sqrt(a-b);
	}

}
