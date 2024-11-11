package vn.iotstar.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBConnectionSQL_22110446;
import vn.iotstar.dao.bookDao_22110446;
import vn.iotstar.model.Book_22110446;


public class bookDaoImpl_22110446 implements bookDao_22110446{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	
	@Override
	public List<Book_22110446> getBookByAuthorId(int id)
	{
		List<Book_22110446> books = new ArrayList<>();
		String sql = "SELECT b.* FROM [BOOKS] b JOIN book_author ba ON b.bookid = ba.bookid where ba.author_id=?";
		conn = new DBConnectionSQL_22110446().GetConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Book_22110446 b = new Book_22110446();
				b.setBookId(rs.getInt("bookid"));
				b.setIsbn(rs.getInt("isbn"));
				b.setTitle(rs.getString("title"));
				b.setPublisher(rs.getString("publisher"));
				b.setPrice(rs.getInt("price"));
				b.setDescription(rs.getString("description"));
				b.setPublishDate(rs.getDate("publish_date"));
				b.setCoverImage(rs.getString("cover_image"));
				b.setQuantity(rs.getInt("quantity"));	
				books.add(b);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}


}
