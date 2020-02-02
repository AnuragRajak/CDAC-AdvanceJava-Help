package beans;

import java.util.List;

import dao.BookDaoImpl;
import pojos.Book;

public class BookBean {
	// props
	private BookDaoImpl dao;
	// clnt's req param
	private String cat;

	// constr
	public BookBean() throws Exception {
		System.out.println("in bk bean constr");
		dao = new BookDaoImpl();
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	// B.L method to get all distinct categories from DAO
	public List<String> getCategories() throws Exception {
		return dao.getAllCategories();
	}

	// B.L method to ret books by a specific category
	public List<Book> getBooksByCategory() throws Exception {
		return dao.getBooksByCategory(cat);
	}

}
