package com.mainsoft.bean;

/**
 * 客户信息
 *@author wgs
 *客户未取用  ---未做登录  ：  名字直接默认
 */
public class UserInfo {
	// 客户ID
	private Integer id;
	// 客户姓名
	private String name;

	public UserInfo() {
	}

	public UserInfo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"-"+this.name;
	}

	
	
}
