package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.User_22110446;

public interface UserDao_22110446 {

	int getUserIdByEmail(String email);

	User_22110446 login(String email, String pass);

	void insertUser(User_22110446 user);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(int phone);

	User_22110446 getUser(String email);

	User_22110446 findByEmail(String email);

	List<User_22110446> getUserPage(int index, int limit);

	int countAllUsers();

	void updateUser(User_22110446 user);

	void deleteUserById(int id);


	
}
