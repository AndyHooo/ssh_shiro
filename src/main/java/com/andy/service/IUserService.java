package com.andy.service;

import java.util.List;

import com.andy.model.Permission;
import com.andy.model.User;

public interface IUserService {

	void add(User user) throws Exception;
	void delById(int id) throws Exception;
	void update(User user) throws Exception;
	User getById(int id) throws Exception;
	List<User> getUser() throws Exception;
	User queryUserByName(String name) throws Exception;
	User queryByNameAndPass(String name,String pass) throws Exception;
	List<Permission> getPermissionsByUserId(int id) throws Exception;
}
