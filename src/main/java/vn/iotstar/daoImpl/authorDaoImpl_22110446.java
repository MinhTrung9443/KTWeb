package vn.iotstar.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBConnectionSQL_22110446;
import vn.iotstar.dao.authorDao_22110446;
import vn.iotstar.model.Author_22110446;

public class authorDaoImpl_22110446 implements authorDao_22110446{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<Author_22110446> getAuthor()
	{
		List<Author_22110446> authors = new ArrayList<>();
		conn = new DBConnectionSQL_22110446().GetConnection();
		try
		{
			String sql = "SELECT A.* FROM [AUTHOR] A";
			ps =conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Author_22110446 author= new Author_22110446();
				author.setAuthorId(rs.getInt("author_id"));
				author.setAuthorName(rs.getString("author_name"));
				author.setDateOfBirth(rs.getDate("date_of_birth"));
				authors.add(author);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return authors;
	}
}
