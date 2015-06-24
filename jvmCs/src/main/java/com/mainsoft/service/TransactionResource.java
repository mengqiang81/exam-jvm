package com.mainsoft.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.mainsoft.bean.Transactions;
import com.mainsoft.common.TransactionStatus;
import com.mainsoft.dao.TransactionDAO;

/**
 * 交易REST接口服务
 * 
 @author wgs
 */

@Path("/transaction")
public class TransactionResource {
	TransactionDAO tranDAO = new TransactionDAO();

	/**
	 * 创建交易
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newTransaction(@FormParam("useName") String useName,
			@FormParam("tradeMoneny") String tradeMoneny,
			@FormParam("tradeState") String tradeState,
			@Context HttpServletResponse servletResponse) {

		try {
			System.out.println(useName+"||"+tradeMoneny+"||"+tradeState);
			// 保存数据
			tranDAO.addTransaction(new String[]{useName,tradeMoneny,tradeState});
	
			// 返回创建信息
			servletResponse.sendRedirect("../index.jsp");
			servletResponse.setCharacterEncoding("UTF-8");
			servletResponse.setContentType("text/json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
