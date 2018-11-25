package com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.bean.Catalog;
import com.base.dao.CatalogMapper;

@Service
public class CatalogService {

	
	@Autowired
	private CatalogMapper m;
	

	public List<Catalog> getCatalogByParent_id(Integer pid){
		return m.getCatalogByParent_id(pid);
	}

	public Catalog getCatalogById(Integer id) {
		return m.getCatalogById(id);
	}

	public List<Catalog> getCatalogByType(int type) {
		return m.getCatalogByType(type);
	}

	public void save(Catalog c) {
		m.save(c);
	}

	public void delete(Catalog c) {
		m.delete(c);
	}

	public void update(Catalog c) {
		m.update(c);
	}
	
	
	
}
