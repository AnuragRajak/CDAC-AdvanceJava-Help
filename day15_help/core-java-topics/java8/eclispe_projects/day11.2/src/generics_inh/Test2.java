package generics_inh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * Objective --- Display frquency of a parti number in List<Integer>
		 */
		List<Integer> ints=Arrays.asList(10,20,1,23,10,34,-89,10);
		//display freq of 10
		//public static int frequency(Collection<?> c,Object o)
		int freq=Collections.frequency(ints, 10);
		System.out.println(freq);
		//fill up empty list by data
		ArrayList<Integer> l1=new ArrayList<>();
		l1.add(1);l1.add(2);l1.add(3);l1.add(4);
		//public static <T> void fill(List<? super T> list,T obj)
		Collections.fill(l1,10);
		System.out.println(l1);
	}

}
