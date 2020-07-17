package cn.zhr.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.zhr.entity.User;


public class UserDao implements IUserDao{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		String hql="from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public boolean delUser(String id) {
		String hql="delete User u where u.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (query.executeUpdate()>0);
	}

	@Override
	public User getUser(String id) {
		String hql="from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (User) query.uniqueResult();
	}

	@Override
	public boolean updateUser(User user) {
		String hql = "update User u set u.userName=?,u.age=? where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0,user.getUserName());
		query.setString(1, user.getAge());
		query.setString(2,user.getId());
		return (query.executeUpdate()>0);
	}
}
