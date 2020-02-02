package strms;

import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> l1=Arrays.asList(12,34,21,67,4,5,6,45);
		System.out.println("via seq strm");
		l1.stream().forEach(i->System.out.print(i+" "));
		System.out.println("via paraller strm");
		l1.parallelStream().forEach(i->System.out.print(i+" "));
	}

}
