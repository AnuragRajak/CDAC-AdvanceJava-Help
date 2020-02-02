package utils;

import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static java.time.LocalDate.parse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.app.core.Emp;

public class CollectionUtils {
	public static HashMap<Integer, Emp> populateMap() {
		HashMap<Integer, Emp> hm = new HashMap<>();
		hm.put(10, new Emp(10, "abc1", "rnd", 12000, now(), 5.5));
		hm.put(101, new Emp(101, "abc2", "prod", 15000, parse("2019-01-01"), 8));
		hm.put(45, new Emp(45, "abc3", "rnd", 11000, of(2017, 5, 25), 7.8));
		hm.put(3, new Emp(3, "abc4", "rnd", 22000, parse("2018-09-21"), 7.6));
		return hm;
	}

	public static List<Emp> populateList() {
		LinkedList<Emp> l1 = new LinkedList<>();
		l1.add(new Emp(10, "abc1", "rnd", 12000, now(), 5.5));
		l1.add(new Emp(101, "abc2", "prod", 15000, parse("2019-01-01"), 8));
		l1.add(new Emp(45, "abc3", "rnd", 11000, of(2017, 5, 25), 7.8));
		l1.add(new Emp(3, "abc4", "rnd", 22000, parse("2018-09-21"), 7.6));
		return l1;
	}

	public static Emp[] populateArray() {
		return new Emp[] { new Emp(10, "abc1", "rnd", 12000, now(), 5.5),
				new Emp(101, "abc2", "prod", 15000, parse("2019-01-01"), 8),
				new Emp(45, "abc3", "rnd", 11000, of(2017, 5, 25), 7.8),
				new Emp(3, "abc4", "rnd", 22000, parse("2018-09-21"), 7.6) };
	}
}
