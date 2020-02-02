package java_8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test2 {

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(10, 34, 2, 56, 45, 100, 5, 67);
		// convert coll ---> Stream<Integer> ---foreach
		l1.stream().forEach(i -> System.out.print(i + " "));
		System.out.println();
		l1.parallelStream().forEach(i -> System.out.print(i + " "));
		System.out.println();
		// filter n display
		l1.stream().filter(i -> i > 40).forEach(i -> System.out.print(i + " "));
		// array ---> Stream & display
		// java.util.stream.IntStream
		int[] data = { 4, 78, 10, 34, 2, 56, 45, 100, 5, 67 };
		Arrays.stream(data).forEach(i -> System.out.print(i + " "));
		// sum of ints between 10 --50
		System.out.println("\nsum " + IntStream.rangeClosed(10, 50).sum());
		// Print avg of odd numbers between 10 & 50
		System.out.println(IntStream.range(100, 100).filter(i -> i % 2 == 0).average().orElse(-1234));
		// Print avg of square of odd nums between 10 & 50
		double avg = IntStream.range(1, 101).filter(i -> i % 2 != 0).map(i -> i * i).average().getAsDouble();
		System.out.println("\n avg "+avg);
	}

}
