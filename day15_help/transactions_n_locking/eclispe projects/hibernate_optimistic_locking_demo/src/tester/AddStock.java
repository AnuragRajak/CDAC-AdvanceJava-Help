package tester;

import java.util.Scanner;

import dao.StockDao;

import pojos.Stock2;


import static utils.HibernateUtils.*;

public class AddStock {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			getSf();// hib frmwork loaded --booted.

			StockDao dao = new StockDao();
			System.out.println("Enter stock company qty price");
			System.out.println(dao.addStock(new Stock2(sc.next(), sc.nextInt(), sc.nextDouble())));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getSf().close();// cn pool will be destroyed.
		}

	}

}
