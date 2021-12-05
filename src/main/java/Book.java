
public class Book {
private String book_name;
private String book_title;
private String author;
private String category;
private String imagePath;
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(String book_name, String book_title, String author, String category, String imagePath) {
	super();
	this.book_name = book_name;
	this.book_title = book_title;
	this.author = author;
	this.category = category;
	this.imagePath = imagePath;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
}
public String getBook_title() {
	return book_title;
}
public void setBook_title(String book_title) {
	this.book_title = book_title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getImagePath() {
	return imagePath;
}
public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}

}
