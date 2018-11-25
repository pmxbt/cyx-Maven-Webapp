package com.base.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.bean.Catalog;
import com.base.service.CatalogService;
import com.tomcong.util.DataRow;

@Controller
@RequestMapping("/catalog")
public class CatalogAction {

	@Autowired
	private CatalogService service;
	
	
	@RequestMapping("/list")
	public String list(Map<String, Object> map,Integer parent_id){
		List<Catalog> list1 = service.getCatalogByType(1); 
		map.put("list1", list1);
		map.put("parent_id", parent_id);
		List<Catalog> list2 = service.getCatalogByParent_id(parent_id);
		map.put("list2", list2);
		return "base/catalog/list";
	}
	
	@RequestMapping("/add")
	public String add(Map<String, Object> map,int type,Integer parent_id){
		int type1 = type+1;
		if(type1==2){
			List<Catalog> list1 = service.getCatalogByType(type); 
			map.put("list1", list1);
		}else if(type1==3){
			Catalog parent1 = service.getCatalogById(parent_id);
			map.put("parent1", parent1);
		}
		map.put("type1", type1);
		return "base/catalog/add";
	}
	
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,int id){
		Catalog c = service.getCatalogById(id);
		map.put("c", c);
		Catalog c1 = service.getCatalogById(c.getParent_id());
		map.put("c1", c1);
		return "base/catalog/edit";
	}

	@RequestMapping("/update")
	public String update(Catalog c){
		service.update(c);
		return "redirect:/catalog/list";
	}
	
	@RequestMapping("/delete")
	public String delete(int id){
		Catalog c = service.getCatalogById(id);
		service.delete(c);
		return "redirect:/catalog/list";
	}
	
	
	@RequestMapping("/save")
	public String save(Catalog c){
		c.setTarget("openlink");
		service.save(c);
		return "redirect:/catalog/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/getSubMenu", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<DataRow> getSubMenu(Integer id){
		List<DataRow> list1 = new ArrayList<DataRow>();
		List<Catalog> list = service.getCatalogByParent_id(id);
		for (Catalog catalog : list) {
			DataRow d = new DataRow();
			d.set("name", catalog.getName());
			d.set("id", catalog.getId());
			d.set("url", catalog.getUrl());
			list1.add(d);
		}
		return list1;
	}
	
	
	
}
