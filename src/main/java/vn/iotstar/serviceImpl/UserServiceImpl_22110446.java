package vn.iotstar.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import vn.iotstar.dao.UserDao_22110446;
import vn.iotstar.daoImpl.UserDaoImpl_22110446;
import vn.iotstar.model.User_22110446;
import vn.iotstar.service.UserService_22110446;

public class UserServiceImpl_22110446 implements UserService_22110446{
	
	UserDao_22110446 dao = new UserDaoImpl_22110446();

	@Override
	public int login(String email, String pass)
	{
		User_22110446 us = dao.login(email, pass);
		if (us != null)
		{
			us.setLastLogin(Date.valueOf(LocalDate.now()));
			dao.updateUser(us);
			return 1;
		}
		
		return 0;
	}
	

	@Override
	public int register(User_22110446 user)
	{
		if (dao.checkExistEmail(user.getEmail()))
		{
			return 1;
		}
		else if (dao.checkExistPhone(user.getPhone()))
		{
			return 2;
		}
		else {
			dao.insertUser(user);
			return 0;
		}
	}

	@Override
	public User_22110446 getUser(String email)
	{
		return dao.getUser(email);
	}
	

	@Override
	public int getUserIdByEmail(String email)
	{
		return dao.getUserIdByEmail(email);
	}
	
	@Override
	public List<User_22110446> getUserPage(int index, int limit)
	{
		return dao.getUserPage(index, limit);
	}
	@Override
	public int countAllUser()
	{
		return dao.countAllUsers();
	}
	@Override
	public void updateUser(User_22110446 user)
	{
		dao.updateUser(user);
	}
	@Override
	public void deleteUser(int id)
	{
		dao.deleteUserById(id);
	}
	@Override
	public void insertUser(User_22110446 user)
	{
		dao.insertUser(user);
	}
}
