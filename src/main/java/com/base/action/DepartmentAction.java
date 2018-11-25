package com.base.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.Department;
import com.base.service.DepartmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("department")
public class DepartmentAction {

	@Autowired
	private DepartmentService service;
	
	@RequestMapping("/list")
	public String list(Map<String , Object> map,Integer pageNo){
		if(pageNo ==null){
			pageNo=1;
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<Department> list = service.getDeptList();
		PageInfo<Department> info = new PageInfo<>(list, 5);
		map.put("info", info);
		return "base/department/list";
	}
	
	@RequestMapping("/add")
	public String add(){
		return "base/department/add";
	}
	
	@RequestMapping("/save")
	public String save(Department d){
		d.setIfdelete(0);
		d.setType(0);
		service.save(d);
		return "redirect:/department/list";
	}
	
	@RequestMapping("/edit")
	public String edit(Map<String , Object> map,Integer id){
		Department dept = service.getDeptById(id);
		map.put("dept", dept);
		return "base/department/edit";
	}
	
	@RequestMapping("/update")
	public String update(Department d){
		service.update(d);
		return "redirect:/department/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		Department dept = service.getDeptById(id);
		dept.setIfdelete(1);
		service.update(dept);
		return "redirect:/department/list";
	}
	
}
