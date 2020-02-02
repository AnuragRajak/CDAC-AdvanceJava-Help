package tester;

import java.util.Scanner;

import dao.StockDao;


import static utils.HibernateUtils.*;

public class TestLocking {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			getSf();// hib frmwork loaded --booted.
			
			StockDao dao=new StockDao();
			System.out.println("Available Stocks ");
			dao.getStocks().forEach(System.out::println);
			//purchase stock
			System.out.println("Enter stock id & qty to purchase");
			System.out.println(dao.purchaseStock(sc.nextInt(), sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getSf().close();// cn pool will be destroyed.
		}

	}

}
