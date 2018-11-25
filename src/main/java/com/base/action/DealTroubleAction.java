package com.base.action;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.bean.Catalog;
import com.base.bean.DealDeviceCost;
import com.base.bean.DealTrouble;
import com.base.bean.Device;
import com.base.bean.DeviceType;
import com.base.bean.User;
import com.base.service.CatalogService;
import com.base.service.DealTroubleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomcong.util.DataRow;

import tools.BaseAction;
import tools.CommonUtil;
import tools.ExcelUtil;

@Controller
@RequestMapping("/dealTrouble")
public class DealTroubleAction extends BaseAction{
	
	
	@Autowired
	private DealTroubleService service;
	
	
	
	DecimalFormat df = new DecimalFormat("0.0");
	
	private TreeMap<Integer, String> getState(){
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(0, "文员处理");
		map.put(1, "维修部修理");
		map.put(2, "打印回执、收费、文员确认");
		map.put(3, "文员回访");
		map.put(4, "处理完毕");
		return map;
	}
	
	@RequestMapping("/list")
	public String list(Map<String , Object> map,Integer pageNo,String startTime,String endTime,Integer dept_id){
		if(pageNo ==null){
			pageNo=1;
		}
		Page<Object> page = PageHelper.startPage(pageNo, 20);
		List<DealTrouble> list = service.getDealTroubleList(startTime,endTime,dept_id);
		PageInfo<DealTrouble> info = new PageInfo<>(list, 5);
		map.put("info", info);
		TreeMap<Integer, String> stateMap = getState();
		map.put("stateMap", stateMap);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("dept_id", dept_id);
		return "base/dealTrouble/list";
	}
	
	@RequestMapping("/dealList")
	public String dealList(Map<String , Object> map){
		Integer[] state1 = {0,2,3};
		Integer[] state2 = {1};
		List<DealTrouble> list = new ArrayList<DealTrouble>();
		if(user.getDept().getId() ==13){
			list = service.getDealTroubleByState(state1);
		}else if(user.getDept().getId() ==12){
			list = service.getDealTroubleByState(state2);
		}
		TreeMap<Integer, String> stateMap = getState();
		map.put("stateMap", stateMap);
		map.put("list", list);
		return "base/dealTrouble/dealList";
	}
	
	@RequestMapping("/add")
	public String add(){
		
		return "base/dealTrouble/add";
	}
	
	@RequestMapping("/save")
	public String save(DealTrouble deal){
		deal.setCreateTime(CommonUtil.getCurrentDateDetail());
		deal.setState(0);
		deal.setIfdelete(0);
		service.save(deal);
		return "redirect:/dealTrouble/list";
	}
	
	@RequestMapping("/deal")
	public String deal(Map<String , Object> map,Integer id){
		DealTrouble dt = service.getDealTroubleById(id);
		map.put("dt", dt);
		List<User> dealUser = service.getUserByDeptId(12);
		map.put("dealUser", dealUser);
		List<DeviceType> dtList = service.getDeviceType();
		map.put("dtList", dtList);
		return "base/dealTrouble/deal";
		
	}
	
	@RequestMapping("/check")
	public String check(Map<String , Object> map,Integer id){
		DealTrouble dt = service.getDealTroubleById(id);
		map.put("dt", dt);
		return "base/dealTrouble/check";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		DealTrouble dt = service.getDealTroubleById(id);
		dt.setIfdelete(1);
		service.update(dt);
		return "redirect:/dealTrouble/list";
	}
	
	@RequestMapping("/update")
	public String update(DealTrouble deal){
		if(deal.getState()==0){
			deal.setState(1);
			service.update(deal);
		}else if(deal.getState()==2){
			deal.setState(3);
			service.update(deal);
		}else if(deal.getState()==3){
			deal.setState(4);
			service.update(deal);
		}
		return "redirect:/dealTrouble/dealList";
	}
	
	
	
	@RequestMapping("/dc")
	public void dc(Integer id,HttpServletRequest request,HttpServletResponse response){
		DealTrouble dt = service.getDealTroubleById(id);
		String rq = dt.getRq1().substring(0, 10);
		String dept_name = dt.getDept().getName();
		String fileName = rq+dept_name+"维修单"+System.currentTimeMillis()+".xls";
		HSSFWorkbook wb = ExcelUtil.dcDealTrouble(dt);
		try {
			ExcelUtil.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	@RequestMapping(value = "/update2", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String update2(@RequestBody DealDeviceCost[] ddcs){
		String total = "0.0";
		int id = 0;
		for (DealDeviceCost dealDeviceCost : ddcs) {
			id = dealDeviceCost.getDealId();
			if(dealDeviceCost.getDeviceId() !=null&&dealDeviceCost.getDeviceId() !=0){
				total = df.format(Double.parseDouble(total)+Double.parseDouble(dealDeviceCost.getTotalCost()));
				service.saveDealDeviceCost(dealDeviceCost);
			}
		}
		DealTrouble dt = service.getDealTroubleById(id);
		return "{\"data\":\""+total+"\"}";
	}

	
	@RequestMapping("/update3")
	public String update3(String total,String rq, Integer id,String reason){
		DealTrouble dt = service.getDealTroubleById(id);
		dt.setRq2(rq);
		dt.setState(2);
		dt.setTotalCost(total);
		dt.setReason(reason);
		service.update(dt);
		return "redirect:/dealTrouble/list";
	}
	
	
	
	@RequestMapping(value = "/getDeviceByType", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody       
	public List<DataRow> getDeviceByType(Integer type_id){
		List<DataRow> list1 = new ArrayList<DataRow>();
		List<Device> list = service.getDeviceByType(type_id);
		for (Device de : list) {
			DataRow d = new DataRow();
			d.set("name", de.getName());
			d.set("id", de.getId());
			d.set("price", de.getPrice());
			list1.add(d);
		}
		return list1;
	}
	
	
	@RequestMapping(value = "/getTotalCost", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody       
	public String getTotalCost(Integer device_id,String count){
		Device de = service.getDeviceById(device_id);
		String cost = df.format(Double.parseDouble(de.getPrice())*Double.parseDouble(count));
		return cost;
	}
	

	
	
}
