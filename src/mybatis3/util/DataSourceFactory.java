package mybatis3.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class DataSourceFactory {
	
	private static final Properties PROPERTIES = new Properties();
	static {
		InputStream is = DataSourceFactory.class.getResourceAsStream("/application.properties");
		try {
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		String driver = PROPERTIES.getProperty("jdbc.driver");
		String url = PROPERTIES.getProperty("jdbc.url");
		String username = PROPERTIES.getProperty("jdbc.username");
		String password = PROPERTIES.getProperty("jdbc.password");
		PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
		return dataSource;
	}
	
	public static DataSource getJNDIDataSource() {
		String jndiName = "java:comp/env/jdbc/MyBatisDemoDS";
		try {
			InitialContext ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup(jndiName);
			return dataSource;
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
