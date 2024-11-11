package vn.iotstar.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import vn.iotstar.config.DBConnectionSQL_22110446;
import vn.iotstar.dao.UserDao_22110446;
import vn.iotstar.model.User_22110446;


public class UserDaoImpl_22110446 implements UserDao_22110446 {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;


	@Override
	public User_22110446 findByEmail(String email) {
		conn = new DBConnectionSQL_22110446().GetConnection();
		User_22110446 user = null;

		String sql = "SELECT * FROM [USERS] WHERE email=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User_22110446();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getNString("fullname"));
				user.setPassword(rs.getString("passwd"));
				user.setPhone(rs.getInt("phone"));
				user.setAdmin(rs.getInt("is_admin") == 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public User_22110446 getUser(String email) {
		return this.findByEmail(email);
	}


	@Override
	public boolean checkExistPhone(int phone) {
		boolean duplicate = false;
		String query = "select * from [Users] where phone = ?";
		try {
			conn = new DBConnectionSQL_22110446().GetConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}


	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [Users] where email = ?";
		try {
			conn = new DBConnectionSQL_22110446().GetConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}


	@Override
	public void insertUser(User_22110446 user) {
		String sql = "INSERT INTO [Users](email, fullname,phone, passwd, signup_date,last_login,is_admin) VALUES (?,?,?,?,?,?,?)";
		try {
			conn = new DBConnectionSQL_22110446().GetConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getFullName());
			ps.setInt(3, user.getPhone());
			ps.setString(4, user.getPassword());
			long millis = System.currentTimeMillis();
			java.sql.Date sign_date = new java.sql.Date(millis);
			ps.setDate(5, sign_date);
			java.sql.Date log_date = new java.sql.Date(millis);
			ps.setDate(6, log_date);
			ps.setInt(7, user.isAdmin() == true ? 1 : 0);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public User_22110446 login(String email, String pass) {
		conn = new DBConnectionSQL_22110446().GetConnection();
		User_22110446 user = null;

		String sql = "SELECT * FROM [USERS] WHERE email=? and passwd=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User_22110446();
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getNString("fullname"));
				user.setPassword(rs.getString("passwd"));
				user.setPhone(rs.getInt("phone"));
				user.setAdmin(rs.getInt("is_admin") == 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int getUserIdByEmail(String email) {

		conn = new DBConnectionSQL_22110446().GetConnection();
		int id = -1;

		String sql = "SELECT * FROM [USERS] WHERE email=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	@Override
	public List<User_22110446> getUserPage(int index, int limit) {
	    List<User_22110446> list = new ArrayList<>();
	    conn = new DBConnectionSQL_22110446().GetConnection();
	    User_22110446 user = null;

	    // SQL query with OFFSET and FETCH for pagination
	    String sql = "SELECT * FROM [USERS] ORDER BY email OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
	    
	    try {
	        ps = conn.prepareStatement(sql);
	        // Set parameters for OFFSET and LIMIT
	        ps.setInt(1, (index) * limit);  // OFFSET
	        ps.setInt(2, limit);                // LIMIT
	        
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            user = new User_22110446();
	            user.setId(rs.getInt("id"));
	            user.setEmail(rs.getString("email"));
	            user.setFullName(rs.getNString("fullname"));
	            user.setPassword(rs.getString("passwd"));
	            user.setPhone(rs.getInt("phone"));
	            user.setAdmin(rs.getInt("is_admin") == 1);
	            list.add(user);  // Add user to the list
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	@Override
	public int countAllUsers() {
	    int totalUsers = 0;
	    conn = new DBConnectionSQL_22110446().GetConnection();

	    // SQL query to count all users
	    String sql = "SELECT COUNT(*) FROM [USERS]";
	    
	    try {
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            totalUsers = rs.getInt(1);  // Get the count from the result set
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return totalUsers;
	}
	@Override
	public void deleteUserById(int id) {

		conn = new DBConnectionSQL_22110446().GetConnection();

		String sql = "DELETE FROM [USERS] WHERE id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateUser(User_22110446 user) {
	    conn = new DBConnectionSQL_22110446().GetConnection();

	    String sql = "UPDATE [USERS] SET email = ?, fullname = ?, phone = ?, passwd = ?, last_login = ?, is_admin = ? WHERE id = ?";

	    try {
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getEmail());  
	        ps.setString(2, user.getFullName()); 
	        ps.setInt(3, user.getPhone());     
	        ps.setString(4, user.getPassword()); 
	        ps.setDate(5, user.getLastLogin()); 
	        ps.setInt(6, user.isAdmin() ? 1: 0);   
	        ps.setInt(7, user.getId());         
	        
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
