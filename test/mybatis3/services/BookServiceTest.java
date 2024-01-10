package mybatis3.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mybatis3.domain.Author;
import mybatis3.domain.Book;
import mybatis3.domain.Publisher;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookServiceTest {
	
	private static BookService book_svc;
	
	@BeforeClass
	public static void setup() {
		book_svc = new BookService();
	}
	
	@AfterClass
	public static void teardown() {
		book_svc = null;
	}
	
	private static final int AUTHOR_ID_NIL = 0;
	private static final int AUTHOR_ID_2 = 2;
	private static final int AUTHOR_ID_3 = 3;
	
	private static final int PUBLISHER_ID_NIL = 0;
	private static final int PUBLISHER_ID_1 = 1;
	private static final int PUBLISHER_ID_2 = 2;
	
	private static final int BOOK_ID_1 = 1;
	private static final int BOOK_ID_2 = 2;
	private static final int BOOK_ID_3 = 3;
	
	private static final String BOOK_TITLE_NIL = null;
	private static final String BOOK_TITLE_SSS = "sss";
	
	@Test
	public void test_find_all_book_list() {
		List<Book> book_list = book_svc.find_all_book_list();
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test_find_book_list_by_publisher_id() {
		List<Book> book_list = book_svc.find_book_list_by_publisher_id(PUBLISHER_ID_1);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test_find_book_list_by_author_id() {
		List<Map<String,Object>> book_map_list = book_svc.find_book_list_by_author_id(AUTHOR_ID_2);
		assertNotNull(book_map_list);
		for (Map<String,Object> book_map : book_map_list) {
			System.out.println(book_map);
		}
	}
	
	@Test
	public void test_find_book_by_id_1() {
		Book book = book_svc.find_book_by_id_1(BOOK_ID_1);
		assertNotNull(book);
		System.out.println(book);
	}
	
	@Test
	public void test_find_book_by_id_2() {
		Book book = book_svc.find_book_by_id_2(BOOK_ID_2);
		assertNotNull(book);
		System.out.println(book);
	}
	
	@Test
	public void test_find_book_by_id_3() {
		Book book = book_svc.find_book_by_id_3(BOOK_ID_3);
		assertNotNull(book);
		System.out.println(book);
	}
	
	@Test
	public void test_find_book_by_id_4() {
		Book book = book_svc.find_book_by_id_4(BOOK_ID_1);
		assertNotNull(book);
		System.out.println(book);
	}
	
	@Test
	public void test_find_book_by_id_5() {
		Book book = book_svc.find_book_by_id_5(BOOK_ID_1);
		assertNotNull(book);
		System.out.println(book);
	}
	
	@Test
	public void test_find_book_list_by_author_id_and_more() {
		List<Book> book_list = book_svc.find_book_list_by_author_id_and_more(AUTHOR_ID_2, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test_find_book_list_by_author_id_or_publisher_id() {
		List<Book> book_list = null;
		
		book_list = book_svc.find_book_list_by_author_id_or_publisher_id(AUTHOR_ID_3, PUBLISHER_ID_NIL);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
		
		book_list = book_svc.find_book_list_by_author_id_or_publisher_id(AUTHOR_ID_NIL, PUBLISHER_ID_2);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
		
		book_list = book_svc.find_book_list_by_author_id_or_publisher_id(AUTHOR_ID_NIL, PUBLISHER_ID_NIL);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test_find_book_list_by_publisher_id_or_title_1() {
		List<Book> book_list = null;
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_1(PUBLISHER_ID_1, BOOK_TITLE_NIL);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_1(PUBLISHER_ID_NIL, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_1(PUBLISHER_ID_2, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_1(PUBLISHER_ID_NIL, BOOK_TITLE_NIL);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test_find_book_list_by_publisher_id_or_title_2() {
		List<Book> book_list = null;
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_2(PUBLISHER_ID_1, BOOK_TITLE_NIL);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_2(PUBLISHER_ID_NIL, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_2(PUBLISHER_ID_2, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_2(PUBLISHER_ID_NIL, BOOK_TITLE_NIL);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test_find_book_list_by_author_id_list_1() {
		List<Integer> author_id_list = new ArrayList<>();
		author_id_list.add(1);
		author_id_list.add(2);
		author_id_list.add(3);
		
		List<Book> book_list = book_svc.find_book_list_by_author_id_list_1(author_id_list);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test_find_book_list_by_author_id_list_2() {
		List<Integer> author_id_list = new ArrayList<>();
		author_id_list.add(1);
		author_id_list.add(2);
		author_id_list.add(3);
		
		List<Book> book_list = book_svc.find_book_list_by_author_id_list_2(author_id_list);
		assertNotNull(book_list);
		for (Book book : book_list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void test_insert_update_delete_book() {
		Publisher publisher = null;
		Author author = null;
		
		Book book = new Book();
		book.setIsbn("67890");
		book.setTitle("book_title");
		publisher = new Publisher();
		publisher.setId(1);
		book.setPublisher(publisher);
		book.setPublished_on("2014-05-21");
		author = new Author();
		author.setId(1);
		book.addAuthor(author);
		int book_id = book_svc.insert_book(book);
		System.out.println("book inserted with id " + book_id);
		book = book_svc.find_book_by_id_1(book_id);
		assertNotNull(book);
		System.out.println(book);
		
		book_id = book.getId();
		book.setIsbn("78901");
		book.setTitle("book_title_altered");
		publisher = new Publisher();
		publisher.setId(3);
		book.setPublisher(publisher);
		book.setPublished_on("2014-05-23");
		book_svc.update_book(book);
		System.out.println("book " + book_id + " updated");
		book = book_svc.find_book_by_id_1(book_id);
		assertNotNull(book);
		System.out.println(book);
		
		book_id = book.getId();
		book.setIsbn("89012");
		book.setTitle("book_title_realtered");
		book.setPublisher(null);
		book.setPublished_on("2014-05-22");
		book_svc.update_book_alt(book);
		System.out.println("book " + book_id + " re-updated");
		book = book_svc.find_book_by_id_1(book_id);
		assertNotNull(book);
		System.out.println(book);
		
		book_id = book.getId();
		book_svc.delete_book(book_id);
		System.out.println("book " + book_id + " deleted");
		book = book_svc.find_book_by_id_1(book_id);
		assertNull(book);
	}
}
