package cn.zhr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.zhr.dao.IUserDao;
import cn.zhr.dao.UserDao;
import cn.zhr.entity.User;


public class UserService implements IUserService{

	
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}
}
