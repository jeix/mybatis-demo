package mybatis3.services.ann;

import java.util.List;

import mybatis3.domain.Author;
import mybatis3.mappers.ann.AuthorMapper;
import mybatis3.util.MyBatisSqlSessionFactoryUsingXML;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Author> find_all_author_list() {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
			return authorMapper.find_all_author_list();
		} finally {
			sqlSession.close();
		}
	}
	
	public Author find_author_by_id(int author_id) {
		logger.debug("find author by id {}", author_id);
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
			return authorMapper.find_author_by_id(author_id);
		} finally {
			sqlSession.close();
		}
	}
	
	public int insert_author(Author author) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
			int count = authorMapper.insert_author(author);
			count = author.getId();
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	public int update_author(Author author) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
			int count = authorMapper.update_author(author);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	public int delete_author(int author_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingXML.openSession();
		try {
			AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
			int count = authorMapper.delete_author(author_id);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
}
