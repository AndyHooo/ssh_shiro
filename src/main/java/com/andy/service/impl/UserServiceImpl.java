package com.andy.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.andy.dao.UserDao;
import com.andy.model.Permission;
import com.andy.model.User;
import com.andy.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	@Resource(name="userDao")
	private UserDao dao;
	
	@Override
	public void add(User user) throws Exception {
		dao.add(user);
	}

	@Override
	public void delById(int id) throws Exception {
		dao.delById(id);

	}

	@Override
	public void update(User user) throws Exception {
		dao.update(user);

	}

	@Override
	public User getById(int id) throws Exception {
		return dao.getById(id);
	}

	@Override
	public List<User> getUser() throws Exception {
		return dao.getUser();
	}

	@Override
	public User queryUserByName(String name) throws Exception {
		
		return dao.queryUserByName(name);
	}

	@Override
	public User queryByNameAndPass(String name, String pass) throws Exception {
		
		return dao.queryByNameAndPass(name, pass);
	}

	@Override
	public List<Permission> getPermissionsByUserId(int id) throws Exception {
		return dao.getPermissionsByUserId(id);
	}

}
