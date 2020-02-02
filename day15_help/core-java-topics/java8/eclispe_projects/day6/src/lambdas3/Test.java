package lambdas3;

public class Test {

	public static void main(String[] args) {
		// ano inner class
		System.out.println(testCompute(10, 20,(a,b) ->   a + b));
			
		System.out.println(testCompute(12, 23, (i1,i2)->i1*i2));
	}

	// static method
	public static int testCompute(int i1, int i2, Computable ref) {
		return ref.compute(i1, i2);
	}

}
