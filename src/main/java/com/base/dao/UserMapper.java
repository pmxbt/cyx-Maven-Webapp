package com.base.dao;

import java.util.List;

import com.base.bean.User;

public interface UserMapper {

	
	public User getUserByUserName(String userName);
	
	public List<User> getUserList();

	public void save(User u);

	public User getUserById(Integer id);

	public void update(User u);
	
	public List<User> getUserListByDeptId(Integer deptId);
}
