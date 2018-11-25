package com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.bean.Device;
import com.base.bean.DeviceType;
import com.base.dao.DeviceMapper;
import com.base.dao.DeviceTypeMapper;

@Service
public class DeviceService {

	
	@Autowired
	private DeviceMapper m;
	@Autowired
	private DeviceTypeMapper m2;
	
	public List<Device> getDeviceList(Integer type_id) {
		return m.selectDeviceListByType(type_id);
	}


	public List<DeviceType> getDeviceTypeList() {
		return m2.selectAll();
	}


	public void save(Device device) {
		m.insert(device);
	}


	public Device getDeviceById(Integer id) {
		return m.selectByPrimaryKey(id);
	}


	public void update(Device device) {
		m.updateByPrimaryKey(device);
	}


	public void delete(Integer id) {
		m.deleteByPrimaryKey(id);
	}

}
