package generics_inh;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Emp e = new SalesMgr();
		ArrayList<Emp> emps = new ArrayList<>();
		ArrayList<SalesMgr> sMgrs = new ArrayList<>();
		// emps=sMgrs;
		ArrayList<Object> objs = new ArrayList<>();
		// objs=emps;
		ArrayList<?> any = new ArrayList<>();
		any = emps;
		any = sMgrs;

	}

}

class Emp {
}

class Mgr extends Emp {
}

class SalesMgr extends Mgr {
}
