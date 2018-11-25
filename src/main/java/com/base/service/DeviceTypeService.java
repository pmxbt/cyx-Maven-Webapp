package com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.bean.DeviceType;
import com.base.dao.DeviceTypeMapper;

@Service
public class DeviceTypeService {

	@Autowired
	private DeviceTypeMapper m;
	
	public List<DeviceType> getDeviceTypeList() {
		return m.selectAll();
	}

	public void save(DeviceType deviceType) {
		m.insert(deviceType);
	}

	public DeviceType getDeviceTypeById(Integer id) {
		return m.selectByPrimaryKey(id);
	}

	public void update(DeviceType deviceType) {
		m.updateByPrimaryKey(deviceType);
	}

	public void delete(Integer id) {
		m.deleteByPrimaryKey(id);
	}

}
