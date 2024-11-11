package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.User_22110446;

public interface UserService_22110446 {

	int getUserIdByEmail(String email);

	User_22110446 getUser(String email);

	int register(User_22110446 user);

	int login(String email, String pass);

	List<User_22110446> getUserPage(int index, int limit);

	int countAllUser();

	void deleteUser(int id);

	void updateUser(User_22110446 user);

	void insertUser(User_22110446 user);
	


}
