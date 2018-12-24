package com.base.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.Department;
import com.base.bean.Region;
import com.base.bean.User;
import com.base.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tools.BaseAction;

@Controller
public class UserAction extends BaseAction{

	
	@Autowired
	private UserService service;
	
	
	
	@RequestMapping("/user/list")
	public String list(Map<String , Object> map,Integer pageNo,Integer dept_id){
		if(pageNo ==null){
			pageNo=1;
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<User> list = service.getUserList(user.getRegionId());
		PageInfo<User> info = new PageInfo<>(list, 5);
		map.put("info", info);
		List<Department> deptList = service.getDeptList(user.getRegionId());
		map.put("deptList", deptList);
		map.put("dept_id", dept_id);
		return "base/user/list";
	}
	
	
	@RequestMapping("/user/add")
	public String add(Map<String , Object> map){
		List<Department> deptList = service.getDeptList(user.getRegionId());
		map.put("deptList", deptList);
		List<Region> regionList = service.getRegionAllList();
		map.put("regionList", regionList);
		return "base/user/add";
	}
	
	@RequestMapping("/user/save")
	public String save(User u){
		if(user.getRegionId() !=1){
			u.setRegionId(user.getRegionId());
		}
		u.setIfdelete(0);
		service.save(u);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/user/delete")
	public String delete(Integer id){
		User u = service.getUserById(id);
		u.setIfdelete(0);
		service.save(u);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/user/edit")
	public String edit(Map<String , Object> map,Integer id){
		User u= service.getUserById(id);
		List<Department> deptList = service.getDeptList(u.getRegionId());
		map.put("deptList", deptList);
		map.put("u", u);
		return "base/user/edit";
	}
	
	@RequestMapping("/user/update")
	public String update(User u){
		service.update(u);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/user/check")
	public String check(Map<String , Object> map,Integer id){
		User u = service.getUserById(id);
		map.put("u", u);
		return "base/user/check";
	}
	
	
	

	@RequestMapping("/user/addCheckUser")
	public String addCheckUser(String userName,HttpServletResponse response){
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(service.addCheckUser(userName));
		} catch (Exception e) {
		}
		return null;
	}
}
