package com.base.bean;

public class Department {

	
	private int id;   
	private String name;                    //��������
	private int sort;                       //����
	private int ifdelete;                   //�Ƿ�ɾ��0 ��   1��
	private int type;                       //����
	
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
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", sort=" + sort + ", ifdelete=" + ifdelete + ", type="
				+ type + "]";
	}
	
	
	
}
