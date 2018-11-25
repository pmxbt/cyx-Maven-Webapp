package com.base.bean;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Catalog implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String url;
	private String target;
	private int sort;
	private int type;
	private int parent_id;
	private List<Catalog> list = new ArrayList<Catalog>();
	private Catalog parent;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Catalog getParent() {
		return parent;
	}
	public void setParent(Catalog parent) {
		this.parent = parent;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	
	
	@Transient
	public List<Catalog> getList() {
		return list;
	}
	public void setList(List<Catalog> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Catalog [id=" + id + ", name=" + name + ", url=" + url + ", target=" + target + ", sort=" + sort
				+ ", type=" + type + ", parent_id=" + parent_id + ", list=" + list + ", parent=" + parent + "]";
	}
	
	
	
}
