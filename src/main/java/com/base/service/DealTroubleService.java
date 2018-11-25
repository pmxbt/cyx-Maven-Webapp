package com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.bean.DealDeviceCost;
import com.base.bean.DealTrouble;
import com.base.bean.Device;
import com.base.bean.DeviceType;
import com.base.bean.User;
import com.base.dao.DealDeviceCostMapper;
import com.base.dao.DealTroubleMapper;
import com.base.dao.DeviceMapper;
import com.base.dao.DeviceTypeMapper;
import com.base.dao.UserMapper;

@Service
public class DealTroubleService {

	
	@Autowired
	private DealTroubleMapper m;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private DeviceTypeMapper deviceTypeMapper;
	
	@Autowired
	private DeviceMapper deviceMapper;
	
	@Autowired
	private DealDeviceCostMapper deviceCostMapper;
	
	public List<DealTrouble> getDealTroubleList(String startTime, String endTime, Integer dept_id) {
		return m.selectAll(startTime,endTime,dept_id);
	}



	public void save(DealTrouble deal) {
		m.insert(deal);
	}



	public DealTrouble getDealTroubleById(Integer id) {
		return m.selectByPrimaryKey(id);
	}



	public List<User> getUserByDeptId(int deptId) {
		return userMapper.getUserListByDeptId(deptId);
	}



	public List<DeviceType> getDeviceType() {
		return deviceTypeMapper.selectAll();
	}



	public List<Device> getDeviceByType(Integer type_id) {
		return deviceMapper.selectDeviceListByType(type_id);
	}



	public Device getDeviceById(Integer device_id) {
		return deviceMapper.selectByPrimaryKey(device_id);
	}



	public void update(DealTrouble deal) {
		m.updateByPrimaryKey(deal);
	}



	public void saveDealDeviceCost(DealDeviceCost dealDeviceCost) {
		deviceCostMapper.insert(dealDeviceCost);
	}



	public List<DealTrouble> getDealTroubleByState(Integer[] state) {
		return m.getDealTroubleByState(state);
	}

	
	
}
