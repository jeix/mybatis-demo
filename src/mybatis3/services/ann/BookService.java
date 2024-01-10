package mybatis3.services.ann;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis3.domain.Book;
import mybatis3.mappers.ann.BookMapper;
import mybatis3.util.MyBatisSqlSessionFactoryUsingXML;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Book> find_all_book_list() {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_all_book_list();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Book> find_book_list_by_publisher_id(int publisher_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_list_by_publisher_id(publisher_id);
		} finally {
			sqlSession.close();
		}
	}
	
	public Book find_book_by_id_1(int book_id) {
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
	
	public Book find_book_by_id_4(int book_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_by_id_4(book_id);
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
	
	public Book find_book_by_id(int book_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			return bookMapper.find_book_by_id(book_id);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Book> find_book_list_by_author_id_or_publisher_id(int author_id, int publisher_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		String search_by = null;
		if (author_id > 0) {
			map.put("search_by", "author");
			map.put("author_id", author_id);
			search_by = "author";
		} else if (publisher_id > 0) {
			map.put("search_by", "publisher");
			map.put("publisher_id", publisher_id);
			search_by = "publisher";
		}
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			//return bookMapper.find_book_list_by_author_id_or_publisher_id(map);
			if (author_id > 0) {
				return bookMapper.find_book_list_by_author_id_or_publisher_id(search_by, author_id);
			} else if (publisher_id > 0) {
				return bookMapper.find_book_list_by_author_id_or_publisher_id(search_by, publisher_id);
			} else {
				return null;
			}
		} finally {
			sqlSession.close();
		}
	}
	
	public int insert_book(Book book) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			int count = bookMapper.insert_book(book);
			count = book.getId();
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	public int update_book(Book book) {
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
