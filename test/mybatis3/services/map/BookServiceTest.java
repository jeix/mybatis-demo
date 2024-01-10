package mybatis3.services.map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis3.domain.map.Book;

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

	private String stringify(Map<String,Object> map) {
		return map.get("id") + "::" + map.get("isbn") + "::" + map.get("title");
	}
	
	@Test
	public void test_find_all_book_list() {
		List<Map<String,Object>> book_list = book_svc.find_all_book_list();
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_find_book_list_by_publisher_id() {
		List<Map<String,Object>> book_list = book_svc.find_book_list_by_publisher_id(PUBLISHER_ID_1);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_find_book_list_by_author_id() {
		List<Map<String,Object>> book_list = book_svc.find_book_list_by_author_id(AUTHOR_ID_2);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_find_book_by_id_1() {
		Map<String,Object> book = book_svc.find_book_by_id_1(BOOK_ID_1);
		assertNotNull(book);
		System.out.println(stringify(book));
	}
	
	@Test
	public void test_find_book_by_id_3() {
		Book book = book_svc.find_book_by_id_3(BOOK_ID_3);
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
		List<Map<String,Object>> book_list = book_svc.find_book_list_by_author_id_and_more(AUTHOR_ID_2, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_find_book_list_by_author_id_or_publisher_id() {
		List<Map<String,Object>> book_list = null;
		
		book_list = book_svc.find_book_list_by_author_id_or_publisher_id(AUTHOR_ID_3, PUBLISHER_ID_NIL);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
		
		book_list = book_svc.find_book_list_by_author_id_or_publisher_id(AUTHOR_ID_NIL, PUBLISHER_ID_2);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
		
		book_list = book_svc.find_book_list_by_author_id_or_publisher_id(AUTHOR_ID_NIL, PUBLISHER_ID_NIL);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_find_book_list_by_publisher_id_or_title_1() {
		List<Map<String,Object>> book_list = null;
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_1(PUBLISHER_ID_1, BOOK_TITLE_NIL);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_1(PUBLISHER_ID_NIL, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_1(PUBLISHER_ID_2, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_1(PUBLISHER_ID_NIL, BOOK_TITLE_NIL);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_find_book_list_by_publisher_id_or_title_2() {
		List<Map<String,Object>> book_list = null;
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_2(PUBLISHER_ID_1, BOOK_TITLE_NIL);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_2(PUBLISHER_ID_NIL, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_2(PUBLISHER_ID_2, BOOK_TITLE_SSS);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
		
		book_list = book_svc.find_book_list_by_publisher_id_or_title_2(PUBLISHER_ID_NIL, BOOK_TITLE_NIL);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_find_book_list_by_author_id_list_1() {
		List<Integer> author_id_list = new ArrayList<>();
		author_id_list.add(1);
		author_id_list.add(2);
		author_id_list.add(3);
		
		List<Map<String,Object>> book_list = book_svc.find_book_list_by_author_id_list_1(author_id_list);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_find_book_list_by_author_id_list_2() {
		List<Integer> author_id_list = new ArrayList<>();
		author_id_list.add(1);
		author_id_list.add(2);
		author_id_list.add(3);
		
		List<Map<String,Object>> book_list = book_svc.find_book_list_by_author_id_list_2(author_id_list);
		assertNotNull(book_list);
		for (Map<String,Object> book : book_list) {
			System.out.println(stringify(book));
		}
	}
	
	@Test
	public void test_insert_update_delete_book() {
		Map<String,Object> publisher = null;
		//List<Map<String,Object>> author_list = null;;
		//Map<String,Object> author = null;
		
		Map<String,Object> book = new HashMap<>();
		book.put("isbn", "67890");
		book.put("title", "book_title");
		publisher = new HashMap<>();
		publisher.put("id", 1);
		book.put("publisher", publisher);
		book.put("published_on", "2014-05-21");

		//author = new HashMap<>();
		//author.put("id", 1);
		//author_list = new ArrayList<Map<>>();
		//author_list.add(author);
		//book.put("author_list", author_list);
		int book_id = book_svc.insert_book(book);
		System.out.println("book inserted with id " + book_id);
		book = book_svc.find_book_by_id_1(book_id);
		assertNotNull(book);
		System.out.println(book);
		
		book_id = (Integer) book.get("id");
		book.put("isbn", "78901");
		book.put("title", "book_title_altered");
		publisher = new HashMap<>();
		publisher.put("id", 3);
		book.put("publisher", publisher);
		book.put("published_on", "2014-05-23");
		book_svc.update_book(book);
		System.out.println("book " + book_id + " updated");
		book = book_svc.find_book_by_id_1(book_id);
		assertNotNull(book);
		System.out.println(book);
		
		book_id = (Integer) book.get("id");
		book.put("isbn", "89012");
		book.put("title", "book_title_realtered");
		book.put("publisher", null);
		book.put("published_on", "2014-05-22");
		book_svc.update_book_alt(book);
		System.out.println("book " + book_id + " re-updated");
		book = book_svc.find_book_by_id_1(book_id);
		assertNotNull(book);
		System.out.println(book);
		
		book_id = (Integer) book.get("id");
		book_svc.delete_book(book_id);
		System.out.println("book " + book_id + " deleted");
		book = book_svc.find_book_by_id_1(book_id);
		assertNull(book);
	}
}
