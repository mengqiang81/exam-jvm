package com.garyhj.entity;

public class CustInfo {
	public int cust_id;
	public String cust_name;
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	@Override
	public String toString() {
		return "CustInfo [cust_id=" + cust_id + ", cust_name=" + cust_name
				+ "]";
	}
	public CustInfo(int cust_id, String cust_name) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
	}
	
}
