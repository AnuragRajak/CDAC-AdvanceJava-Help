package pojos;


import javax.persistence.*;

@Entity
@Table(name = "dac_books")
public class Book {
	private Integer id;
	private String title, author, category;
	private double price;

	public Book() {
		System.out.println("in book def constr");
	}

	public Book(String title, String author, String category, double price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30, unique = true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		System.out.println("in set title");
		this.title = title;
	}

	@Column(length = 30)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(length = 30)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(columnDefinition = "double(6,1)")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return title + " " + author + " " + price;
	}

}
