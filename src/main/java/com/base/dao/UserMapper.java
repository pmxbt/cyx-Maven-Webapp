package com.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.bean.User;

public interface UserMapper {

	
	public User getUserByUserName(String userName);
	
	public List<User> getUserList(@Param("regionId")Integer regionId);

	public void save(User u);

	public User getUserById(Integer id);

	public void update(User u);
	
	public List<User> getUserListByDeptId(Integer deptId);
}
