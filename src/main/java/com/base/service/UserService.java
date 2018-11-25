package com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.bean.Catalog;
import com.base.bean.Department;
import com.base.bean.User;
import com.base.dao.CatalogMapper;
import com.base.dao.DepartmentMapper;
import com.base.dao.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CatalogMapper catalogMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public User getUserByUserName(String userName){
		return userMapper.getUserByUserName(userName);
	}

	public User getUserById(Integer id){
		return userMapper.getUserById(id);
	}
	
	
	public String checkUser(String userName, String password) {
		User user = userMapper.getUserByUserName(userName);
		if(password.equals(user.getPassword())){
			return "yes";
		}else{
			return "no";
		}
	}


	public List<Catalog> getCatalogByType(int type) {
		return catalogMapper.getCatalogByType(type);
	}
	
	

	
	public List<User> getUserList(){
		return userMapper.getUserList();
	}


	public List<Department> getDeptList() {
		return departmentMapper.getDeptList();
	}


	public void save(User u) {
		userMapper.save(u);
	}
	
	
	public void update(User u){
		userMapper.update(u);
	}

	public String addCheckUser(String userName) {
		User user = userMapper.getUserByUserName(userName);
		if(user==null){
			return "yes";
		}else{
			return "no";
		}
	}
	
	
}
