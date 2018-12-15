package com.base.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.Catalog;
import com.base.bean.Department;
import com.base.bean.User;
import com.base.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tools.CommonUtil;

@Controller
public class UserAction {

	
	@Autowired
	private UserService service;
	
	
	@RequestMapping("/login")
	public String login(Map<String, Object> map,String userName,HttpSession session){
		User user = service.getUserByUserName(userName);
		session.setAttribute("user", user);
		List<Department> dept_list = service.getDeptList();
		session.setAttribute("dept_list", dept_list);

		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index(Map<String, Object> map){
		List<Catalog> menu = service.getCatalogByType(1);
		map.put("menu", menu);
		String date1 = CommonUtil.getCurrentDate();
		map.put("date1", date1);
		return "index";
	}
	
	
	
	@RequestMapping("/checkUser")
	public String checkUser(String userName,String password,HttpServletResponse response){
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(service.checkUser(userName,password));
		} catch (Exception e) {
		}
		return null;
	}
	
	@RequestMapping("/user/list")
	public String list(Map<String , Object> map,Integer pageNo,Integer dept_id){
		if(pageNo ==null){
			pageNo=1;
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<User> list = service.getUserList();
		PageInfo<User> info = new PageInfo<>(list, 5);
		map.put("info", info);
		List<Department> deptList = service.getDeptList();
		map.put("deptList", deptList);
		map.put("dept_id", dept_id);
		return "base/user/list";
	}
	
	
	@RequestMapping("/user/add")
	public String add(Map<String , Object> map){
		List<Department> deptList = service.getDeptList();
		map.put("deptList", deptList);
		return "base/user/add";
	}
	
	@RequestMapping("/user/save")
	public String save(User u){
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
		User user = service.getUserById(id);
		List<Department> deptList = service.getDeptList();
		map.put("deptList", deptList);
		map.put("user", user);
		return "base/user/edit";
	}
	
	@RequestMapping("/user/update")
	public String update(User u){
		service.update(u);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/user/check")
	public String check(Map<String , Object> map,Integer id){
		User user = service.getUserById(id);
		map.put("user", user);
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
