package mybatis3.domain;

import java.util.ArrayList;
import java.util.List;

public class Book {
	
	private int id;
	private String isbn;
	private String title;
	private Publisher publisher;
	private String published_on;
	private List<Author> author_list;

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getPublished_on() {
		return published_on;
	}
	public void setPublished_on(String published_on) {
		this.published_on = published_on;
	}
	
	public List<Author> getAuthor_list() {
		return author_list;
	}
	public void setAuthor_list(List<Author> author_list) {
		this.author_list = author_list;
	}
	public void addAuthor(Author author) {
		if (author_list == null) {
			author_list = new ArrayList<Author>();
		}
		author_list.add(author);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer().append(id).append("::").append(isbn).append("::").append(title);
		if (publisher != null) sb.append("::from [").append(publisher.toString()).append("]");
		if (author_list != null) {
			for (Author author : author_list) {
				sb.append(":by [").append(author.toString()).append("]");
			}
		}
		return sb.toString();
	}
}
