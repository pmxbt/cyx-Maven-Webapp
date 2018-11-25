package com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.bean.Department;
import com.base.dao.DepartmentMapper;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper m;
	
	public List<Department> getDeptList() {
		return m.getDeptList();
	}

	public void save(Department d) {
		m.save(d);
	}

	public Department getDeptById(Integer id) {
		return m.getDeptById(id);
	}

	public void update(Department d) {
		m.update(d);
	}

	
	
	
}
