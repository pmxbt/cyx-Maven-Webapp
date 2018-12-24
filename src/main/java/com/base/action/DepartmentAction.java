package com.base.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.bean.Department;
import com.base.service.DepartmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tools.BaseAction;

@Controller
@RequestMapping("/department")
public class DepartmentAction extends BaseAction{

	@Autowired
	private DepartmentService service;
	
	
	private TreeMap<Integer, String> getMoldMap(){
		TreeMap<Integer, String> map = new TreeMap<Integer, String>(){{
			put(1, "维修部");
			put(2, "办公室");
			put(3, "其他");
		}};
		return map;
	}
	
	
	@RequestMapping("/list")
	public String list(Map<String , Object> map,Integer pageNo){
		if(pageNo ==null){
			pageNo=1;
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<Department> list = service.getDeptList(user.getRegionId());
		PageInfo<Department> info = new PageInfo<>(list, 5);
		map.put("info", info);
		return "base/department/list";
	}
	
	@RequestMapping("/add")
	public String add(Map<String , Object> map){
		TreeMap<Integer, String> moldMap = getMoldMap();
		map.put("moldMap", moldMap);
		return "base/department/add";
	}
	
	@RequestMapping("/save")
	public String save(Department d){
		d.setIfdelete(0);
		d.setType(0);
		d.setRegionId(user.getRegionId());
		service.save(d);
		return "redirect:/department/list";
	}
	
	@RequestMapping("/edit")
	public String edit(Map<String , Object> map,Integer id){
		Department dept = service.getDeptById(id);
		map.put("dept", dept);
		TreeMap<Integer, String> moldMap = getMoldMap();
		map.put("moldMap", moldMap);
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
	
	

	@RequestMapping("/addCheckDept")
	public String addCheckDept(Integer mold,HttpServletResponse response){
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(service.addCheckDept(mold,user.getRegionId()));
		} catch (Exception e) {
		}
		return null;
	}
	
	@RequestMapping("/updateCheckDept")
	public String updateCheckDept(Integer mold,int id,HttpServletResponse response){
		PrintWriter out;

		try {
			out = response.getWriter();
			Department d = service.getDeptById(id);
			if(d.getMold()==mold){
				out.print("yes");
			}else{
				if(d.getMold()==1||d.getMold()==2){
					List<Department> list = service.getDeptListByMold(mold, d.getRegionId());
					if(list.size()>0){
						out.print("no");
					}else{
						out.print("yes");
					}
				}
			}
		} catch (Exception e) {
		}
		return null;
	}
}
