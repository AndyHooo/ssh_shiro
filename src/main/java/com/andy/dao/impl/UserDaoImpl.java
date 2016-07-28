package com.andy.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.andy.dao.BasedDao;
import com.andy.dao.UserDao;
import com.andy.model.Permission;
import com.andy.model.User;

@Repository("userDao")
public class UserDaoImpl extends BasedDao implements UserDao {

	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	public void add(User user) {
		Session session = null;
		try {
			session = getSession();
			session.save(user);
		} catch (Exception e) {
			log.error("添加失败");
		}
	}

	@Override
	public void delById(int id) {
		Session session = null;
		try {
			session = getSession();
			User user = (User) session.get(User.class, id);
			session.delete(user);
		} catch (Exception e) {
			log.error("删除失败");
		}
	}

	@Override
	public void update(User user) {
		Session session = null;
		try {
			session = getSession();
			session.saveOrUpdate(user);
		} catch (Exception e) {
			log.error("更新失败");
		}
	}

	@Override
	public User getById(int id) {
		Session session = null;
		User user = null;
		try {
			session = getSession();
			user = (User) session.get(User.class, id);
		} catch (Exception e) {
			log.error("查询失败");
		}
		return user;
	}

	@Override
	public List<User> getUser() {
		Session session = null;
		List<User> users = null;
		try {
			session = getSession();
			Query query = session.createQuery("from User");
			users = query.list();
		} catch (Exception e) {
			log.error("查询失败");
		}
		return users;
	}

	@Override
	public User queryUserByName(String name) throws Exception {
		User user = null;
		Session session = getSession();
		String hql = "from User where userName='"+name+"'";
		Query query = session.createQuery(hql);
		List list = query.list();
		if(list != null && list.size()>0){
			user = (User) list.get(0);
		}
		return user;
	}

	@Override
	public User queryByNameAndPass(String name, String pass) throws Exception {
		User user = null;
		Session session = getSession();
		String hql = "from User where userName='"+name+"' and userPass='"+pass+"'";
		Query query = session.createQuery(hql);
		List list = query.list();
		if(list != null && list.size()>0){
			user = (User) list.get(0);
		}
		return user;
	}

	@Override
	public List<Permission> getPermissionsByUserId(int id) throws Exception {
		Session session = getSession();
		User user = (User) session.get(User.class, id);
		List<Permission> permissions = user.getPermissions();
		return permissions;
	}

}
