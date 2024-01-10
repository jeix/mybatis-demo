package mybatis3.mappers;

import java.util.List;

import mybatis3.domain.Publisher;

public interface PublisherMapper {
	
	List<Publisher> find_all_publisher_list();
	Publisher find_publisher_by_id(int id);
	int insert_publisher(Publisher publisher);
	int update_publisher(Publisher publisher);
	int delete_publisher(int id);
}
