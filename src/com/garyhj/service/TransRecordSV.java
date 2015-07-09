package com.garyhj.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.garyhj.dao.TransRecordDAO;
import com.garyhj.entity.CustInfo;
import com.garyhj.entity.TransRecord;

@Path("/createTrans")
public class TransRecordSV {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String createTransByGet(@QueryParam("name") String name) throws IOException{
		return createTrans(name);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String createTransByPost(@QueryParam("name") String name) throws IOException{
		return createTrans(name);
	}
	
	public String createTrans(String name) throws IOException{
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);

		CustInfo custInfo = new CustInfo(88,"ÕÅÈý");

		TransRecord transRecord = new TransRecord();
		transRecord.setCreate_time(time);
		transRecord.setCust_info(custInfo.toString());
		transRecord.setTrans_amount("88.5");
		transRecord.setTrans_currency("1");
		transRecord.setTrans_id("1");
		transRecord.setTrans_status("T");
		transRecord.setTrans_type("111");
		System.out.println(transRecord.toString());
		
		TransRecordDAO dao = new TransRecordDAO();
		dao.saveTransRecords(transRecord);
		
		ArrayList<TransRecord> lists = new ArrayList<TransRecord>(); 
		lists = dao.readAndShow();
//		for (TransRecord transRecord : lists) {
//			System.out.println(transRecord.toString());
//		}
		return "test rest " +lists;
	}
}
