package lambdas1;

public class Utils {
	// 1.Write a method to perform ANY operation
	// on 2 double values & return the result to the caller.
	public static double testCompute(double a,
			double b,Computable ref) {
		return ref.compute(a, b);
	}
}
