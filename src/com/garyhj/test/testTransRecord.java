package com.garyhj.test;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.garyhj.dao.TransRecordDAO;
import com.garyhj.entity.CustInfo;
import com.garyhj.entity.TransRecord;

public class TestTransRecord {
	/*	@Test
	public void testCreate() throws IOException{
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);

		CustInfo custInfo = new CustInfo(88,"张三");

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
	}*/
	
	
		@Test
	public void testReadAll() throws IOException{
		TransRecordDAO dao = new TransRecordDAO();
		ArrayList<TransRecord> lists = new ArrayList<TransRecord>(); 
		lists = dao.findAll();
		for (TransRecord transRecord : lists) {
			System.out.println(transRecord.toString());
		}
	}
		
		
		@Test
		public void testquery(){
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);

			CustInfo custInfo = new CustInfo(88,"张三");

			TransRecord transRecord = new TransRecord();
			transRecord.setCreate_time(time);
			transRecord.setCust_info(custInfo.toString());
			transRecord.setTrans_amount("88.5");
			transRecord.setTrans_currency("1");
			transRecord.setTrans_id("1");
			transRecord.setTrans_status("T");
			transRecord.setTrans_type("111");
			System.out.println(transRecord.toString());
		}
	
}
