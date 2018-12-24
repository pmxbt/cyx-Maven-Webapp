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
	
	public List<Department> getDeptList(int regionId) {
		return m.getDeptList(regionId);
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

	public List<Department> getDeptListByMold(int mold,int regionId){
		return m.getDeptListByMold(mold, regionId);
	}
	
	public String addCheckDept(int mold, int regionId) {
		if(mold ==3){
			return "yes";
		}else{
			List<Department> list = m.getDeptListByMold(mold,regionId);
			if(list.size()>0){
				return "no";
			}else{
				return "yes";
			}
		}
	}

	
	
	
}
