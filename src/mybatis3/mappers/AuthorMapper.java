package mybatis3.mappers;

import java.util.List;
import java.util.Map;

import mybatis3.domain.Author;

public interface AuthorMapper {
	
	List<Author> find_all_author_list();
	List<Author> find_all_author_list_to_map();
	Author find_author_by_id(int id);
	Map<String,Object> find_author_by_id_using_jit_sql(Map<String,Object> map);
	int insert_author(Author author);
	int update_author(Author author);
	int delete_author(int id);
}
