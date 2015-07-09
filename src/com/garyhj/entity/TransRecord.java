package com.garyhj.entity;

import java.util.Date;

public class TransRecord {
	public String trans_id;
	public String create_time;
	public String trans_status;
	public String trans_type;
	public String trans_amount;
	public String trans_currency;
	public String cust_info ;
	
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getTrans_status() {
		return trans_status;
	}
	public void setTrans_status(String trans_status) {
		this.trans_status = trans_status;
	}
	public String getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}
	public String getTrans_currency() {
		return trans_currency;
	}
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	public String getTrans_amount() {
		return trans_amount;
	}
	public void setTrans_amount(String trans_amount) {
		this.trans_amount = trans_amount;
	}
	public void setTrans_currency(String trans_currency) {
		this.trans_currency = trans_currency;
	}
	
	public String getCust_info() {
		return cust_info;
	}
	public void setCust_info(String cust_info) {
		this.cust_info = cust_info;
	}
	@Override
	public String toString() {
		return "TransRecord [trans_id=" + trans_id + ", create_time="
				+ create_time + ", trans_status=" + trans_status
				+ ", trans_type=" + trans_type + ", trans_amount="
				+ trans_amount + ", trans_currency=" + trans_currency
				+ ", cust_info=" + cust_info + "]";
	}


}
