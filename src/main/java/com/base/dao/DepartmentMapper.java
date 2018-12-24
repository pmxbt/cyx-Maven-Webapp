package com.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.bean.Department;

public interface DepartmentMapper {

	
	public Department getDeptById(int id);

	public List<Department> getDeptList(@Param("regionId")int regionId);

	public void save(Department d);

	public void update(Department d);

	public List<Department> getDeptListByMold(@Param("mold")int mold, @Param("regionId")int regionId);
}
