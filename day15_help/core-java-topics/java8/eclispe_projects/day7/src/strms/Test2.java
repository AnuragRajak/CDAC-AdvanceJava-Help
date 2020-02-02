package strms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * create stream fro int[]
		 */
		int[] ints= {1,34,56,21,50,678,2,6,45};
		Arrays.stream(ints).forEach(i->System.out.print(i+" "));
	//is.forEach(i -> System.out.print(i+" "));
//		System.out.println("Sum "+is.sum());

	}

}
