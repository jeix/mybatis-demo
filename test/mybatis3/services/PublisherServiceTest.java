package mybatis3.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import mybatis3.domain.Publisher;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PublisherServiceTest {
	
	private static PublisherService publisher_svc;
	
	@BeforeClass
	public static void setup() {
		publisher_svc = new PublisherService();
	}
	
	@AfterClass
	public static void teardown() {
		publisher_svc = null;
	}
	
	@Test
	public void test_find_all_publisher_list() {
		List<Publisher> publisher_list = publisher_svc.find_all_publisher_list();
		assertNotNull(publisher_list);
		for (Publisher publisher : publisher_list) {
			System.out.println(publisher);
		}
	}
	
	@Test
	public void test_find_publisher_by_id() {
		Publisher publisher = publisher_svc.find_publisher_by_id(1);
		assertNotNull(publisher);
		System.out.println(publisher);
	}
	
	@Test
	public void test_insert_update_delete_publisher() {
		Publisher publisher = new Publisher();
		publisher.setName("publisher_name");
		publisher.setPhone_number("456-7890");
		int publisher_id = publisher_svc.insert_publisher(publisher);
		publisher = publisher_svc.find_publisher_by_id(publisher_id);
		System.out.println("publisher inserted with id " + publisher_id);
		assertNotNull(publisher);
		System.out.println(publisher);
		
		publisher_id = publisher.getId();
		publisher.setName("publisher_name_altered");
		publisher.setPhone_number("567-8901");
		publisher_svc.update_publisher(publisher);
		System.out.println("publisher " + publisher_id + " updated");
		publisher = publisher_svc.find_publisher_by_id(publisher_id);
		assertNotNull(publisher);
		System.out.println(publisher);
		
		publisher_id = publisher.getId();
		publisher_svc.delete_publisher(publisher_id);
		System.out.println("publisher " + publisher_id + " deleted");
		publisher = publisher_svc.find_publisher_by_id(publisher_id);
		assertNull(publisher);
	}
}
