package com.base.dao;

import java.util.List;

import com.base.bean.Catalog;

public interface CatalogMapper {

	public List<Catalog> getCatalogByParent_id(Integer pid);
	
	public Catalog getCatalogById(Integer id);

	public List<Catalog> getCatalogByType(int type);

	public void save(Catalog c);

	public void delete(Catalog c);

	public void update(Catalog c);

	public List<Catalog> getAllCatalog();
}
