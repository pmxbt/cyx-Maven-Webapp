package com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.bean.Region;
import com.base.dao.RegionMapper;

@Service
public class RegionService {

	@Autowired
	private RegionMapper m;
	
	public List<Region> getlist(String name) {
		return m.selectByName(name);
	}

	public void save(Region r) {
			m.insert(r);
	}

	public Region getRegionById(Integer id) {
		return m.selectByPrimaryKey(id);
	}

	public void update(Region r) {
		m.updateByPrimaryKey(r);
	}

	public List<Region> getRegionAllList() {
		return m.selectAll();
	}

}
