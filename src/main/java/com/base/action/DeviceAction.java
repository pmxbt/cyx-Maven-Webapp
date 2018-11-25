package com.base.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.Device;
import com.base.bean.DeviceType;
import com.base.service.DeviceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/device")
public class DeviceAction {

	@Autowired
	private DeviceService service;
	
	
	@RequestMapping("/list")
	public String list(Map<String , Object> map,Integer pageNo,Integer type_id){
		if(pageNo ==null){
			pageNo=1;
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<Device> list = service.getDeviceList(type_id);
		PageInfo<Device> info = new PageInfo<>(list, 5);
		map.put("info", info);
		List<DeviceType> typeList = service.getDeviceTypeList();
		
		map.put("typeList", typeList);
		map.put("type_id", type_id);
		return "base/device/list";
	}
	
	
	
	@RequestMapping("/add")
	public String add(Map<String , Object> map){
		List<DeviceType> typeList = service.getDeviceTypeList();
		map.put("typeList", typeList);
		return "base/device/add";
	}
	
	
	@RequestMapping("/save")
	public String save(Device device){
		device.setIfdelete(0);
		service.save(device);
		return "redirect:/device/list";
	}
	
	@RequestMapping("/check")
	public String check(Map<String , Object> map,Integer id){
		Device device = service.getDeviceById(id);
		map.put("device", device);
		return "base/device/check";
	}
	
	@RequestMapping("/edit")
	public String eidt(Map<String , Object> map,Integer id){
		Device device = service.getDeviceById(id);
		map.put("device", device);
		return "base/device/edit";
	}
	
	@RequestMapping("/update")
	public String update(Device device){
		service.update(device);
		return "redirect:/device/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		Device device = service.getDeviceById(id);
		device.setIfdelete(1);
		service.update(device);
		return "redirect:/device/list";
	}
}
