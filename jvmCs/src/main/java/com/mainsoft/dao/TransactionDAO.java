package com.mainsoft.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mainsoft.bean.Transactions;
import com.mainsoft.util.XmlImpl;
import com.mainsoft.util.XmlInterface;

/**
 *交易访问数据
 * @authorwgs
 */
public class TransactionDAO extends BaseDAO<Transactions> {
private  final String str = "user.xml";//文件字符串
	/**
	 * 创建交易记录
	 * 
	 * @param transaction 交易添加的数据类
	 * @return
	 * @throws Exception
	 */
	public void addTransaction(String[] transaction) throws Exception {
		System.out.println("-----------------------------------");
		XmlInterface x = new XmlImpl();
		//String str = "user.xml";
		File f = new File(str);
		List<String[]> l = new ArrayList<String[]>();
		//判断当前文件是否存在  当前只能添加一条 如果 文件存在 不添加  为实现添加
		if (!f.exists()) {
			l.add(transaction);
			x.createXml(str, l);
			//f.delete();
		}
	
	}
}
