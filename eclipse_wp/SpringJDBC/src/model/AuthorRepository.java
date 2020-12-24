package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class AuthorRepository extends Repository {
	public List<Author> getAuthors()
	{
		return jdbc.query("SELECT * FROM Author", new RowMapper<Author>() {
		@Override
		public Author mapRow(ResultSet rs, int numRow) throws SQLException {
			return new Author(rs.getInt("AuthorId"), rs.getString("AuthorName"));
		}
		});
	}
	
	public Author getAuthorById(int id)
	{
		return jdbc.queryForObject("SELECT * FROM Author where authorid = ?", new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numrow) throws SQLException {
				return new Author(rs.getInt("AuthorId"), rs.getString("AuthorName"));
			}
		}, id);
	}
	
	public int addAuthor(Author au)
	{
		return jdbc.update("insert into Author values (?,?)", au.getId(), au.getName());
	}
	
	public int delete(int id)
	{
		return jdbc.update("delete from Author where authorid = ?", id);
	}
	
	public int updateAuthor(Author au)
	{
		return jdbc.update("update Author set authorname = ? where authorid = ?", au.getName(), au.getId());
	}
	
	
}
