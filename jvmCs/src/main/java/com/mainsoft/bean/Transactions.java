package com.mainsoft.bean;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 交易记录
 *  未显示所有属性
 *  @author wgs
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "root")
public class Transactions {
//	private String id;//	 交易IDaaaa
//	private Timestamp createTime;// 创建时间
	
	private String tranStatus; // 交易状态
	private String tranType;	// 交易类型
//	private String tranAmount;// 交易金额
//	private String tranCurrency;	// 交易币种
	private String userId;	// 用户ID
	public Transactions() {
	}

	public Transactions(String tranStatus, String tranType,
			BigDecimal tranAmount, String tranCurrency, String userId) {
		this.tranStatus = tranStatus;
		this.tranType = tranType;
		this.userId = userId;

	}

	public String getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}