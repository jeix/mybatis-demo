package mybatis3.domain.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {
	
	private int id;
	private String isbn;
	private String title;
	private Map<String,Object> publisher;
	private String published_on;
	private List<Map<String,Object>> author_list;

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

	public Map<String,Object> getPublisher() {
		return publisher;
	}
	public void setPublisher(Map<String,Object> publisher) {
		this.publisher = publisher;
	}

	public String getPublished_on() {
		return published_on;
	}
	public void setPublished_on(String published_on) {
		this.published_on = published_on;
	}
	
	public List<Map<String,Object>> getAuthor_list() {
		return author_list;
	}
	public void setAuthor_list(List<Map<String,Object>> author_list) {
		this.author_list = author_list;
	}
	public void addAuthor(Map<String,Object> author) {
		if (author_list == null) {
			author_list = new ArrayList<Map<String,Object>>();
		}
		author_list.add(author);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer().append(id).append("::").append(isbn).append("::").append(title);
		if (publisher != null) sb.append("::from [").append(stringify_publisher(publisher)).append("]");
		if (author_list != null) {
			for (Map<String,Object> author : author_list) {
				sb.append(":by [").append(stringify_author(author)).append("]");
			}
		}
		return sb.toString();
	}

	private String stringify_publisher(Map<String,Object> map) {
		return map.get("id") + "::" + map.get("name") + "::" + map.get("phone_number");
	}

	private String stringify_author(Map<String,Object> map) {
		return map.get("id") + "::" + map.get("name") + "::" + map.get("email");
	}
}
