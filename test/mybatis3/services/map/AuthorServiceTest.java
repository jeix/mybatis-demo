package mybatis3.services.map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private static String stringify(Map<String,Object> map) {
		return map.get("id") + "::" + map.get("name") + "::" + map.get("email");
	}
	
	@Test
	public void test_find_all_author_list() {
		List<Map<String,Object>> author_list = author_svc.find_all_author_list();
		assertNotNull(author_list);
		for (Map<String,Object> author : author_list) {
			System.out.println(stringify(author));
		}
	}
	
	@Test
	public void test_find_author_by_id() {
		Map<String,Object> author = author_svc.find_author_by_id(1);
		assertNotNull(author);
		System.out.println(stringify(author));
	}
	
	@Test
	public void test_insert_update_delete_author() {
		Map<String,Object> author = new HashMap<>();
		author.put("name", "author_name");
		author.put("email", "author_name@somenet.com");
		int author_id = author_svc.insert_author(author);
		System.out.println("author inserted with id " + author_id);
		author = author_svc.find_author_by_id(author_id);
		assertNotNull(author);
		System.out.println(stringify(author));
		
		author_id = (Integer) author.get("id");
		author.put("name", "author_name_altered");
		author.put("email", "author_name_altered@somenet.com");
		author_svc.update_author(author);
		System.out.println("author " + author_id + " updated");
		author = author_svc.find_author_by_id(author_id);
		assertNotNull(author);
		System.out.println(stringify(author));
		
		author_id = (Integer) author.get("id");
		author_svc.delete_author(author_id);
		System.out.println("author " + author_id + " deleted");
		author = author_svc.find_author_by_id(author_id);
		assertNull(author);
	}
}
