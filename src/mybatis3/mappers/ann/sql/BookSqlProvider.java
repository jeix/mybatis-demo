package mybatis3.mappers.ann.sql;

import java.util.Map;

import mybatis3.domain.Book;

import org.apache.ibatis.jdbc.SQL;

public class BookSqlProvider {
	
	public String select_book_by_id() {
		return new SQL() {{
			SELECT("id, isbn, title, published_on");
			FROM("books");
			WHERE("id=#{id}");
		}}.toString();
	}
	
	public String select_book_list_by_author_id_or_publisher_id(final Map<String,Object> map) {
		return new SQL() {{
			SELECT("b.id, b.isbn, b.title, b.published_on");
			FROM("books b");
			String search_by = (String) map.get("param1"); // "0"
			if ("author".equals(search_by)) {
				LEFT_OUTER_JOIN("books_authors ba ON b.id = ba.book_id");
				WHERE("ba.author_id = #{param2}"); // "1"
			} else if ("publisher".equals(search_by)) {
				WHERE("b.publisher_id = #{1}");
			}
		}}.toString();
	}
	
	public String insert_book(Book book) {
		return new SQL() {{
			INSERT_INTO("books");
			VALUES("isbn", "#{isbn}");
			VALUES("title", "#{title}");
			VALUES("publisher_id", "#{publisher.id}");
			VALUES("published_on", "#{published_on}");
		}}.toString();
	}
	
	public String update_book(Book book) {
		return new SQL() {{
			UPDATE("books");
			SET("isbn = #{isbn}");
			SET("title = #{title}");
			SET("publisher_id = #{publisher.id}");
			SET("published_on = #{published_on}");
			WHERE("id = #{id}");
		}}.toString();
	}
	
	public String delete_book(int id) {
		return new SQL() {{
			DELETE_FROM("books");
			WHERE("id = #{id}");
		}}.toString();
	}
}
