package com.mainsoft.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.mainsoft.bean.Transactions;
import com.mainsoft.util.XmlImpl;
import com.mainsoft.util.XmlInterface;

/**
 * @author wgs
 * @version 1.0
 */
public class BaseDAO<T> {
	private final String str = "user.xml";
	@SuppressWarnings("unchecked")
	public BaseDAO() {
		
	}

	/**
	 * 条件查询(没有对查询进行封装，直接使用sql拼接操作)
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Transactions> findByWhere(String where) throws Exception {
		List<Transactions> results = new LinkedList<Transactions>();
		// Xml2JsonUtil x=new Xml2JsonUtil();
		XmlInterface x = new XmlImpl();
		List<String[]> l = new ArrayList<String[]>();
		// String str="user.xml";
		// System.out.println(where+"-----ff-----------");
		if (null == where || "".equals(where.trim())) {

			// 判断当前文件是否存在

			l = x.parserXml(str, "0");
			System.out.println(l.size() + "-----__+++----------------");
			// results = x.xml2JSON(file);
		} else if ("交易成功".equals(where)) {
			l = x.parserXml(str, "1");
		} else {
			l = x.parserXml(str, "2");
		}

		for (int i = 0; i < l.size(); i++) {
			String[] ts = l.get(i);
			Transactions t = new Transactions();
			t.setUserId(ts[0]);
			t.setTranType(ts[1]);
			t.setTranStatus(ts[2]);
			results.add(t);
		}
		if (where.equals("成功")) {
			// results = x.xml2JSON(file);
		}
		if (where.equals("失败")) {
			// results = x.xml2JSON(file);
		}
		// } else if( ""persistentClass.getSimpleName()){
		// sql = "select * from "
		// + persistentClass.getSimpleName().toLowerCase() + " where "
		// + where;
		// }

		return results;
	}

}
