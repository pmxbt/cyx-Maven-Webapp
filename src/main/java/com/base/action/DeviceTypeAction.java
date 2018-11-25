package com.base.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.DeviceType;
import com.base.service.DeviceTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tools.CommonUtil;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeAction {

	@Autowired
	private DeviceTypeService service;
	
	
	@RequestMapping("/list")
	public String list(Map<String , Object> map,Integer pageNo){
		if(pageNo ==null){
			pageNo=1;
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<DeviceType> list = service.getDeviceTypeList();
		PageInfo<DeviceType> info = new PageInfo<>(list, 5);
		map.put("info", info);
		return "base/deviceType/list";
	}
	
	@RequestMapping("/add")
	public String add(){
		return "base/deviceType/add";
	}
	
	@RequestMapping("/save")
	public  String save(DeviceType deviceType){
		deviceType.setCreatetime(CommonUtil.getCurrentDateDetail());
		deviceType.setIfdelete(0);
		service.save(deviceType);
		return "redirect:/deviceType/list";
	}
	
	@RequestMapping("/edit")
	public String edit(Map<String , Object> map,Integer id){
		DeviceType deviceType = service.getDeviceTypeById(id);
		map.put("deviceType", deviceType);
		return "base/deviceType/edit";
	}
	
	@RequestMapping("/update")
	public String update(DeviceType deviceType){
		service.update(deviceType);
		return "redirect:/deviceType/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		DeviceType deviceType = service.getDeviceTypeById(id);
		deviceType.setIfdelete(1);
		service.update(deviceType);
		return "redirect:/deviceType/list";
	}
	
	
}
