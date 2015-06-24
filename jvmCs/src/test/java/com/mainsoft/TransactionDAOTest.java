package com.mainsoft;

import java.util.List;

import org.junit.Test;

import com.mainsoft.bean.Transactions;
import com.mainsoft.dao.TransactionDAO;

/**
 * 测试TransactionDAO
 * 
 * @version 1.0
 */
public class TransactionDAOTest {

	/**
	 * 测试插入数据
	 */
	@Test
	public void addTransaction() {
		TransactionDAO tranDao = new TransactionDAO();
		
		try {
			tranDao.addTransaction(new String[]{"李四","22.5","1"});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试条件查询
	 */
	@Test
	public void qurryList() {
		TransactionDAO tranDao = new TransactionDAO();
		List<Transactions> list = null;
		try {
			list = tranDao.findByWhere("TRANAMOUNT < 100");
			System.out.println("总记录数：" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
