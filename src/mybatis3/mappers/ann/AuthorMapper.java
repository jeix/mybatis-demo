package mybatis3.mappers.ann;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mybatis3.domain.Author;

public interface AuthorMapper {
	
	@Select("SELECT id, name, email FROM authors")
	List<Author> find_all_author_list();
	@Select(
		"SELECT id, name, email" +
		" FROM authors" +
		" WHERE id = #{id}"
	)
	Author find_author_by_id(int id);
	
	@Insert("INSERT INTO authors (name, email) VALUES (#{name}, #{email})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert_author(Author author);
	@Update(
		"UPDATE authors" +
		" SET name = #{name}, email = #{email}" +
		" WHERE id = #{id}"
	)
	int update_author(Author author);
	@Delete("DELETE FROM authors WHERE id = #{id}")
	int delete_author(int id);
}
