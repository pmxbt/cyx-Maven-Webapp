package com.base.bean;

public class Department {

	
	private int id;   
	private String name;                    //部门名称
	private int sort;                       //排序
	private int ifdelete;                   //是否删除0 否   1是
	private int type;                       //类型
	private int regionId;                   //地区
	private int mold;                       //1:维修部  2：文员   3：其他
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getIfdelete() {
		return ifdelete;
	}
	public void setIfdelete(int ifdelete) {
		this.ifdelete = ifdelete;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public int getMold() {
		return mold;
	}
	public void setMold(int mold) {
		this.mold = mold;
	}
	
	
}
