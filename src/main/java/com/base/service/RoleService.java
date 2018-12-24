package com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.bean.Catalog;
import com.base.bean.Role;
import com.base.dao.CatalogMapper;
import com.base.dao.RoleMapper;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private CatalogMapper catalogMapper;
	
	public List<Role> getlist(Integer regionId) {
		return roleMapper.selectAll(regionId);
	}


	public List<Catalog> getCatalogAllList() {
		return catalogMapper.getAllCatalog();
	}

}
