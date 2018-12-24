package com.base.action;

import java.util.List;
import java.util.Map;

import org.apache.catalina.startup.Catalina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.Catalog;
import com.base.bean.Role;
import com.base.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tools.BaseAction;


@Controller
@RequestMapping("/role")
public class RoleAction extends BaseAction{

	@Autowired
	private RoleService service;
	
	
	
	@RequestMapping("/list")
	public String list(Map<String , Object> map,Integer pageNo,Integer regionId){
		if(pageNo ==null){
			pageNo=1;
		}
		if(user.getRegionId() !=1){
			regionId =user.getRegionId();
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<Role> list = service.getlist(regionId);
		PageInfo<Role> info = new PageInfo<>(list, 5);
		map.put("info", info);
		return "base/role/list";
	}
	
	@RequestMapping("/add")
	public String add(Map<String , Object> map){
		List<Catalog> catalogs = service.getCatalogAllList();
		StringBuffer catalog_list = new StringBuffer("[");
		for (Catalog c:catalogs) {
			catalog_list.append("{id:").append(c.getId()+",");
			catalog_list.append("pid:").append(c.getParent_id()+",");
			catalog_list.append("name:'").append(c.getName()+"'},");
		}
		map.put("catalog_list", catalog_list.substring(0, catalog_list.length()-1)+"]");
		return "base/role/add";
	}
	
	
	
}
