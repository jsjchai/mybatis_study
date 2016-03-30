package com.mybatis.model;

public class QueryCondition {

	private String likeCondition;
	private int min;
	private int max;
	
	
	
	public QueryCondition(String likeCondition, int min, int max) {
		super();
		this.likeCondition = likeCondition;
		this.min = min;
		this.max = max;
	}
	public QueryCondition() {
		super();
	}
	public String getLikeCondition() {
		return likeCondition;
	}
	public void setLikeCondition(String likeCondition) {
		this.likeCondition = likeCondition;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}
