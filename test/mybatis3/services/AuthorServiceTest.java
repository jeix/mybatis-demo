package mybatis3.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Map;

import mybatis3.domain.Author;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuthorServiceTest {
	
	private static AuthorService author_svc;
	
	@BeforeClass
	public static void setup() {
		author_svc = new AuthorService();
	}
	
	@AfterClass
	public static void teardown() {
		author_svc = null;
	}
	
	@Test
	public void test_find_all_author_list() {
		List<Author> author_list = author_svc.find_all_author_list();
		assertNotNull(author_list);
		for (Author author : author_list) {
			System.out.println(author);
		}
	}

	@Test
	public void test_find_all_author_list_to_map() {
		Map<Integer,Author> author_list = author_svc.find_all_author_list_to_map();
		assertNotNull(author_list);
		for (Integer id : author_list.keySet()) {
			Author author = author_list.get(id);
			System.out.println(id+"=>"+author);
		}
	}
	
	@Test
	public void test_find_author_by_id() {
		Author author = author_svc.find_author_by_id(1);
		assertNotNull(author);
		System.out.println(author);
	}

	@Test
	public void test_find_author_by_id_using_jit_sql() {
		Map<String,Object> author = author_svc.find_author_by_id_using_jit_sql(1);
		assertNotNull(author);
		System.out.println(stringify(author));
	}

	private static String stringify(Map<String,Object> map) {
		return map.get("id") + "::" + map.get("name") + "::" + map.get("email");
	}
	
	@Test
	public void test_insert_update_delete_author() {
		Author author = new Author();
		author.setName("author_name");
		author.setEmail("author_name@somenet.com");
		int author_id = author_svc.insert_author(author);
		System.out.println("author inserted with id " + author_id);
		author = author_svc.find_author_by_id(author_id);
		assertNotNull(author);
		System.out.println(author);
		
		author_id = author.getId();
		author.setName("author_name_altered");
		author.setEmail("author_name_altered@somenet.com");
		author_svc.update_author(author);
		System.out.println("author " + author_id + " updated");
		author = author_svc.find_author_by_id(author_id);
		assertNotNull(author);
		System.out.println(author);
		
		author_id = author.getId();
		author_svc.delete_author(author_id);
		System.out.println("author " + author_id + " deleted");
		author = author_svc.find_author_by_id(author_id);
		assertNull(author);
	}
}
