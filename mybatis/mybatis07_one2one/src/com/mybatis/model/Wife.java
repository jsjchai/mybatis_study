package com.mybatis.model;

public class Wife {

	private int id;
	private String name;
	private Husband Husband;
	
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
	public Husband getHusband() {
		return Husband;
	}
	public void setHusband(Husband husband) {
		Husband = husband;
	}
	@Override
	public String toString() {
		return "Wife [id=" + id + ", name=" + name + ", Husband=" + Husband
				+ "]";
	}
	
	
}
