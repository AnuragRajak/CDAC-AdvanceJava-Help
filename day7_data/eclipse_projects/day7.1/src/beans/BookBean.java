package beans;

import java.util.ArrayList;
import java.util.List;

import dao.BookDaoImpl;
import pojos.Book;

public class BookBean {
	// props
	private BookDaoImpl dao;
	// clnt's req param
	private String cat;
	//selected book ids
	private int[] bkId;
	//shopping cart
	private List<Integer> cart;
	//total cart value
	private double totalBill;

	// constr
	public BookBean() throws Exception {
		System.out.println("in bk bean constr creating empty cart");
		//create an empty cart
		cart=new ArrayList<>();
		dao = new BookDaoImpl();
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
	

	public void setBkId(int[] bkId) {
		this.bkId = bkId;
	}
	

	public double getTotalBill() {
		return totalBill;
	}

	// B.L method to get all distinct categories from DAO
	public List<String> getCategories() throws Exception {
		return dao.getAllCategories();
	}

	// B.L method to ret books by a specific category
	public List<Book> getBooksByCategory() throws Exception {
		return dao.getBooksByCategory(cat);
	}
	//B.L method to populate the cart with selected book ids
	public String populateCart()
	{
		for(int i : bkId)
			cart.add(i);
		System.out.println("cart "+cart);
		return "category";
	}
	//B.L method to get actual book details in a cart
	public List<Book> getBooks() throws Exception
	{
		List<Book> bks=new ArrayList<>();
		totalBill=0;
		for(int id : cart)
		{
			Book b=dao.getBookDetails(id);
			bks.add(b);
			totalBill += b.getPrice();
		}
		return bks;
		
	}

}
