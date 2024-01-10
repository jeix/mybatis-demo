package mybatis3.mappers.map;

import java.util.List;
import java.util.Map;

public interface AuthorMapper {
	
	List<Map<String,Object>> find_all_author_list();
	Map<String,Object> find_author_by_id(int id);
	int insert_author(Map<String,Object> author);
	int update_author(Map<String,Object> author);
	int delete_author(int id);
}
