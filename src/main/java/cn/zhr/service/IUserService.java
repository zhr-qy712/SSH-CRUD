package cn.zhr.service;

import java.util.List;

import cn.zhr.entity.User;

public interface IUserService {

	public void addUser(User user);
	public List<User> getAllUser();
	public boolean delUser(String id);
	public User getUser(String id);
	public boolean updateUser(User user);
}
