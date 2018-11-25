package com.base.dao;

import java.util.List;

import com.base.bean.Department;

public interface DepartmentMapper {

	
	public Department getDeptById(int id);

	public List<Department> getDeptList();

	public void save(Department d);

	public void update(Department d);
}
