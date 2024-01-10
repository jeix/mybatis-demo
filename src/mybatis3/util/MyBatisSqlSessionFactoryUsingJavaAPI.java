package mybatis3.util;

import javax.sql.DataSource;

import mybatis3.domain.Author;
import mybatis3.domain.Book;
import mybatis3.domain.Publisher;
import mybatis3.mappers.AuthorMapper;
import mybatis3.mappers.BookMapper;
import mybatis3.mappers.PublisherMapper;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MyBatisSqlSessionFactoryUsingJavaAPI {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			DataSource dataSource = DataSourceFactory.getDataSource();
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment = new Environment("development", transactionFactory, dataSource);
			
			Configuration configuration = new Configuration(environment);
			
			configuration.getTypeAliasRegistry().registerAlias("Author", Author.class);
			configuration.getTypeAliasRegistry().registerAlias("Publisher", Publisher.class);
			configuration.getTypeAliasRegistry().registerAlias("Book", Book.class);
			
			//configuration.getTypeHandlerRegistry().register(PhoneTypeHandler.class);
			
			configuration.addMapper(AuthorMapper.class);
			configuration.addMapper(PublisherMapper.class);
			configuration.addMapper(BookMapper.class);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}
