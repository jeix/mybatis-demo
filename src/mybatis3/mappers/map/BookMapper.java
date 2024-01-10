package mybatis3.mappers.map;

import java.util.List;
import java.util.Map;

import mybatis3.domain.map.Book;

public interface BookMapper {
	
	List<Map<String,Object>> find_all_book_list();
	List<Map<String,Object>> find_book_list_by_publisher_id(int publisher_id);
	List<Map<String,Object>> find_book_list_by_author_id(int author_id);
	
	Map<String,Object> find_book_by_id_1(int id);
	Book find_book_by_id_3(int id);
	Book find_book_by_id_5(int id);
	
	List<Map<String,Object>> find_book_list_by_author_id_and_more(Map<String,Object> map);
	List<Map<String,Object>> find_book_list_by_author_id_or_publisher_id(Map<String,Object> map);
	List<Map<String,Object>> find_book_list_by_publisher_id_or_title_1(Map<String,Object> map);
	List<Map<String,Object>> find_book_list_by_publisher_id_or_title_2(Map<String,Object> map);
	List<Map<String,Object>> find_book_list_by_author_id_list_1(Map<String,Object> map);
	List<Map<String,Object>> find_book_list_by_author_id_list_2(Map<String,Object> map);
	
	int insert_book(Map<String,Object> book);
//	int insert_book_author(Map<String,Integer> id_map);
	int update_book(Map<String,Object> book);
	int update_book_alt(Map<String,Object> book);
//	int delete_book_author(Map<String,Integer> id_map);
	int delete_book(int id);
}
