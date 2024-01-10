package mybatis3.services;

import java.util.List;

import mybatis3.domain.Publisher;
import mybatis3.util.MyBatisSqlSessionFactoryUsingJavaAPI;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Publisher> find_all_publisher_list() {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingJavaAPI.openSession();
		try {
			return sqlSession.selectList("mybatis3.mappers.PublisherMapper.find_all_publisher_list");
		} finally {
			sqlSession.close();
		}
	}
	
	public Publisher find_publisher_by_id(int publisher_id) {
		logger.debug("find publisher by id {}", publisher_id);
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingJavaAPI.openSession();
		try {
			return sqlSession.selectOne("mybatis3.mappers.PublisherMapper.find_publisher_by_id", Integer.valueOf(publisher_id));
		} finally {
			sqlSession.close();
		}
	}
	
	public int insert_publisher(Publisher publisher) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingJavaAPI.openSession();
		try {
			int count = sqlSession.insert("mybatis3.mappers.PublisherMapper.insert_publisher", publisher);
			count = publisher.getId();
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	public int update_publisher(Publisher publisher) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingJavaAPI.openSession();
		try {
			int count = sqlSession.update("mybatis3.mappers.PublisherMapper.update_publisher", publisher);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	public int delete_publisher(int publisher_id) {
		SqlSession sqlSession = MyBatisSqlSessionFactoryUsingJavaAPI.openSession();
		try {
			int count = sqlSession.delete("mybatis3.mappers.PublisherMapper.delete_publisher", publisher_id);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
}
