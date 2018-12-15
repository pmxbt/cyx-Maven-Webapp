package com.base.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.Region;
import com.base.service.RegionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/region")
public class RegionAction {
	
	
	@Autowired
	private RegionService	service;
	
	
	
	@RequestMapping("/list")
	public String list(Map<String , Object> map,String name,Integer pageNo){
		if(pageNo ==null){
			pageNo=1;
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<Region> list = service.getlist(name);
		PageInfo<Region> info = new PageInfo<>(list, 5);
		map.put("info", info);
		map.put("name", name);
		return "base/region/list";
	}
	
	
	
	@RequestMapping("/add")
	public String add(){
		return "base/region/add";
	}
	
	@RequestMapping("/save")
	public String save(Region r){
		r.setIfdelete(0);
		service.save(r);
		return "redirect:/region/list";
		
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		Region r = service.getRegionById(id);
		r.setIfdelete(1);
		service.update(r);
		return "redirect:/region/list";
	}
	
	@RequestMapping("/edit")
	public String edit(Map<String , Object> map,Integer id){
		Region r = service.getRegionById(id);
		map.put("r", r);
		return "base/region/edit";
	}
	
	
	@RequestMapping("/update")
	public String update(Region r){
		service.update(r);
		return "redirect:/region/list";
	}
	
	
}
