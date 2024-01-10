package mybatis3.mappers.ann;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import mybatis3.domain.Author;
import mybatis3.domain.Book;
import mybatis3.domain.Publisher;
import mybatis3.mappers.ann.sql.BookSqlProvider;

public interface BookMapper {
	
	@Select("SELECT id, isbn, title, published_on FROM books a")
	@Results({
		@Result(id=true, property="id", column="id"),
		@Result(property="isbn", column="isbn"),
		@Result(property="title", column="title"),
		@Result(property="published_on", column="published_on")
	})
	List<Book> find_all_book_list();
	
	@Select(
		"SELECT b.id, b.isbn, b.title, b.published_on, p.name publisher_name" +
		" FROM books b, publishers p" +
		" WHERE b.publisher_id = #{publisher_id}" +
		" AND b.publisher_id = p.id"
	)
	@ResultMap("mybatis3.mappers.BookMapper.book_with_publisher_result")
	List<Book> find_book_list_by_publisher_id(int publisher_id);
	
	@Select(
		"SELECT b.id, b.isbn, b.title, b.published_on," +
		"	p.id publisher_id, p.name publisher_name, p.phone_number" +
		" FROM books b, publishers p" +
		" WHERE b.id = #{id}" +
		" AND b.publisher_id = p.id"
	)
	@ResultMap("mybatis3.mappers.BookMapper.book_detail_result_1")
	Book find_book_by_id_1(int id);

	@Select(
		"SELECT id, isbn, title, published_on, publisher_id" +
		" FROM books" +
		" WHERE id = #{id}"
	)
	@Results({
		@Result(id=true, property="id", column="id"),
		@Result(property="isbn", column="isbn"),
		@Result(property="title", column="title"),
		@Result(property="published_on", column="published_on"),
		@Result(property="publisher", column="publisher_id",
				one=@One(select="mybatis3.mappers.ann.BookMapper._find_publisher_by_id")
		)
	})
	Book find_book_by_id_3(int id);
	
	@Select("SELECT id, name, phone_number FROM publishers WHERE id = #{id}")
	Publisher _find_publisher_by_id(int id);
	
	@Select("SELECT id, name, email FROM authors WHERE id = #{id}")
	Author _find_author_by_id(int id);
	
	@Select(
		"SELECT b.id, b.isbn, b.title, b.published_on," +
		"	p.id publisher_id, p.name publisher_name, p.phone_number," +
		"	a.id author_id, a.name author_name, a.email" +
		" FROM books b" +
		"	LEFT OUTER JOIN publishers p ON b.publisher_id = p.id" +
		"	LEFT OUTER JOIN books_authors ba ON b.id = ba.book_id" +
		"	LEFT OUTER JOIN authors a ON ba.author_id = a.id" +
		" WHERE b.id = #{id}"
	)
	@ResultMap("mybatis3.mappers.BookMapper.book_detail_result_4")
	Book find_book_by_id_4(int id);

	// @Select(
	// 	"SELECT b.id, b.isbn, b.title, b.published_on, b.publisher_id, ba.author_id" +
	// 	" FROM books b LEFT OUTER JOIN books_authors ba ON b.id = ba.book_id" +
	// 	" WHERE b.id = #{id}"
	// )
	@Select(
		"SELECT b.id, b.isbn, b.title, b.published_on, b.publisher_id, b.id book_id" +
		" FROM books b" +
		" WHERE b.id = #{id}"
	)
	@Results({
		@Result(id=true, property="id", column="id"),
		@Result(property="isbn", column="isbn"),
		@Result(property="title", column="title"),
		@Result(property="published_on", column="published_on"),
		@Result(property="publisher", column="publisher_id",
				one=@One(select="mybatis3.mappers.ann.BookMapper._find_publisher_by_id")
		),
		@Result(property="author_list", column="book_id",
				many=@Many(select="mybatis3.mappers.ann.BookMapper._find_author_by_book_id")
		)
	})
	Book find_book_by_id_5(int id);

	@Select(
		"SELECT a.id, a.name, a.email" +
		" FROM books b" +
		"	LEFT OUTER JOIN books_authors ba ON b.id = ba.book_id" +
		"	LEFT OUTER JOIN authors a ON ba.author_id = a.id" +
		" WHERE b.id = #{book_id}"
	)
	List<Author> _find_author_by_book_id(int book_id);
	
	@SelectProvider(type=BookSqlProvider.class, method="select_book_by_id")
	Book find_book_by_id(int id);
	
	@SelectProvider(type=BookSqlProvider.class, method="select_book_list_by_author_id_or_publisher_id")
	List<Book> find_book_list_by_author_id_or_publisher_id(String search_by, int id);
	
	@InsertProvider(type=BookSqlProvider.class, method="insert_book")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert_book(Book book);
//	int insert_book_author(Map<String,Integer> id_map);
	@UpdateProvider(type=BookSqlProvider.class, method="update_book")
	int update_book(Book book);
//	int delete_book_author(Map<String,Integer> id_map);
	@DeleteProvider(type=BookSqlProvider.class, method="delete_book")
	int delete_book(int id);
}
