package lambdas;

public class Test {

	public static void main(String[] args) {
		System.out.println(testCompute(10, 20, new Adder()));
		System.out.println(testCompute(12, 23, new Multiplier()));
	}

	// static method
	public static int testCompute(int i1, int i2, Computable ref) {
		return ref.compute(i1, i2);
	}

}
