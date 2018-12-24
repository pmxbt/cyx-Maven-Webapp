package com.base.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.Catalog;
import com.base.bean.Department;
import com.base.bean.Region;
import com.base.bean.User;
import com.base.service.UserService;

import tools.CommonUtil;


@Controller
public class LoginAction {

	
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping("/login")
	public String login(Map<String, Object> map,String userName,HttpSession session){
		User user = service.getUserByUserName(userName);
		session.setAttribute("user", user);
		List<Department> dept_list = service.getDeptList(user.getRegionId());
		session.setAttribute("dept_list", dept_list);
		Region region = service.getRegionById(user.getRegionId());
		session.setAttribute("region", region);
		List<Region> region_list =new ArrayList<Region>();
		if(user.getRegionId() ==1){
			region_list = service.getRegionAllList();
		}
		session.setAttribute("region_list", region_list);
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
	
}
