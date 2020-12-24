package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class CategoryRepository extends Repository {
	public int add(Category obj) {
		return jdbc.update("INSERT INTO Category(CategoryId, CategoryName, ParentId) VALUES(?, ?, ?)", obj.getId(), obj.getName(), obj.getParent());
	}
	
	public List<Category> getParents() 
	{
		return jdbc.query("Select * from Category where ParentID is null", new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
			}
			});
	}
	
	public List<Category> getCategory()
	{
		return jdbc.query("SELECT * FROM Category", new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
			}
			});
	}
	
	public int delete(int id)
	{
		return jdbc.update("delete from category where categoryId = ?", id);
	}
	
	public Category getCategory(int id)
	{
		return jdbc.queryForObject("SELECT * FROM Category WHERE CategoryId = ?", new RowMapper<Category>() {
		@Override
		public Category mapRow(ResultSet rs, int rowNumber) throws SQLException
		{
			return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
		}
		}, id);
	}
	
	public int edit(Category obj) 
	{
		return jdbc.update("UPDATE Category SET CategoryName = ? , ParentId = ? WHERE CategoryId = ?", obj.getName(), obj.getParent(), obj.getId());
	}
}
