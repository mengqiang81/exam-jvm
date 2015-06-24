package com.mainsoft.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.mainsoft.bean.Transactions;
import com.mainsoft.dao.TransactionDAO;

/**
 * 交易列表REST接口服务
 * 
 * @version 1.0
 */

@Path("/query")
public class TransactionsResource {
	/**
	 * 查询交易列表
	 * 
	 * @param tranStatus
	 * @param servletResponse
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transactions> getTransactions(
			@QueryParam("tranStatus") String tranStatus,
			@Context HttpServletResponse servletResponse) {
		System.out.println("getTransactions+//"+tranStatus);
		/* 设置字符集为'UTF-8' */
		servletResponse.setCharacterEncoding("UTF-8");
		List<Transactions> list = new ArrayList<Transactions>();
		TransactionDAO tranDao = new TransactionDAO();
		if (null == tranStatus || "".equals(tranStatus.trim())) {
			try {
				list.addAll(tranDao.findByWhere(""));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				list.addAll(tranDao.findByWhere( ""
						+ tranStatus + ""));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
