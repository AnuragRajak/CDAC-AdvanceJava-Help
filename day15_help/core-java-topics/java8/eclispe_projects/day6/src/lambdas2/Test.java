package lambdas2;

public class Test {

	public static void main(String[] args) {
		// ano inner class
		System.out.println(testCompute(10, 20, new Computable() {

			@Override
			public int compute(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		}));
		System.out.println(testCompute(12, 23, new Computable() {

			@Override
			public int compute(int a, int b) {
				// TODO Auto-generated method stub
				return a - b;
			}
		}));
	}

	// static method
	public static int testCompute(int i1, int i2, Computable ref) {
		return ref.compute(i1, i2);
	}

}
