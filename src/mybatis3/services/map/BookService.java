package mybatis3.services.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis3.domain.map.Book;
import mybatis3.mappers.map.BookMapper;
import mybatis3.util.MyBatisSqlSessionFactoryUsingXML;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Map<String,Object>> find_all_book_list() {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_all_book_list();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String,Object>> find_book_list_by_publisher_id(int publisher_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_publisher_id(publisher_id);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String,Object>> find_book_list_by_author_id(int author_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_author_id(author_id);
		} finally {
			sqlSession.close();
		}
	}
	
	public Map<String,Object> find_book_by_id_1(int book_id) {
		logger.debug("find book by id {}", book_id);
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_by_id_1(book_id);
		} finally {
			sqlSession.close();
		}
	}
	
	public Book find_book_by_id_3(int book_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_by_id_3(book_id);
		} finally {
			sqlSession.close();
		}
	}
	
	public Book find_book_by_id_5(int book_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_by_id_5(book_id);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String,Object>> find_book_list_by_author_id_and_more(int author_id, String title) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("author_id", author_id);
		map.put("title", "%"+title+"%");
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_author_id_and_more(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String,Object>> find_book_list_by_author_id_or_publisher_id(int author_id, int publisher_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		if (author_id > 0) {
			map.put("search_by", "author");
			map.put("author_id", author_id);
		} else if (publisher_id > 0) {
			map.put("search_by", "publisher");
			map.put("publisher_id", publisher_id);
		}
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_author_id_or_publisher_id(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String,Object>> find_book_list_by_publisher_id_or_title_1(int publisher_id, String title) {
		Map<String,Object> map = new HashMap<String,Object>();
		if (publisher_id > 0) {
			map.put("publisher_id", publisher_id);
		}
		if (title != null) {
			map.put("title", title);
		}
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_publisher_id_or_title_1(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String,Object>> find_book_list_by_publisher_id_or_title_2(int publisher_id, String title) {
		Map<String,Object> map = new HashMap<String,Object>();
		if (publisher_id > 0) {
			map.put("publisher_id", publisher_id);
		}
		if (title != null) {
			map.put("title", title);
		}
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_publisher_id_or_title_2(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String,Object>> find_book_list_by_author_id_list_1(List<Integer> author_id_list) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("author_id_list", author_id_list);
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_author_id_list_1(map);
		} finally {
			sqlSession.close();
		}
	}
	
	List<Map<String,Object>> find_book_list_by_author_id_list_2(List<Integer> author_id_list) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("author_id_list", author_id_list);
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_author_id_list_2(map);
		} finally {
			sqlSession.close();
		}
	}
	
	public int insert_book(Map<String,Object> book) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			int count = bookMapper.insert_book(book);
			int id = (Integer) book.get("id");
			sqlSession.commit();
			return id;
		} finally {
			sqlSession.close();
		}
	}
	
	public int update_book(Map<String,Object> book) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			int count = bookMapper.update_book(book);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	public int update_book_alt(Map<String,Object> book) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			int count = bookMapper.update_book_alt(book);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	public int delete_book(int book_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			int count = bookMapper.delete_book(book_id);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
}
