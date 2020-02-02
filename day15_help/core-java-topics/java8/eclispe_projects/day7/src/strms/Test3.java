package strms;

import java.util.stream.IntStream;

public class Test3 {

	public static void main(String[] args) {
		// print sum of 10-50 numbers
		System.out.println("Sum=" + IntStream.range(10, 51).sum());
		// print avg of 10-50 numbers
		System.out.println("Avg " + IntStream.range(10, 100).average().orElse(-1));
		// print avg of odd numbers between 10 & 50
		double val = IntStream.rangeClosed(10, 50).filter(i -> i % 2 != 0).average().getAsDouble();
		System.out.println("Avg of odd nums " + val);
		// print avg of square of odd nums between 10 & 50
		val = IntStream.rangeClosed(1, 100).
				filter(i -> i % 2 != 0).map(i -> i * i).
				average().getAsDouble();
		System.out.println("Avg of sq of  odd nums " + val);

	}

}
