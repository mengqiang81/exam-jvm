package com.garyhj.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.garyhj.dao.TransRecordDAO;
import com.garyhj.entity.TransRecord;

@Path("/TransRecord")
public class TransRecordSV {

	@POST										//HTTP���������
	@Path("/create")								//��ע��Դ��򷽷������·��
	@Consumes(MediaType.APPLICATION_JSON)		//��ע�ɽ��������MIMEý������
	public String createTransByPost(TransRecord transRecord) {
		String retFlag = "����ʧ�ܣ�";
		try {
			TransRecordDAO dao = new TransRecordDAO();
			dao.saveTransRecords(transRecord);
			retFlag = "�����ɹ�";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retFlag;
	}
	
	@GET
	@Path("/findAll")
	@Produces(MediaType.TEXT_PLAIN)
	public String findAll() throws IOException{
		TransRecordDAO dao = new TransRecordDAO();
		ArrayList<TransRecord> lists = new ArrayList<TransRecord>(); 
		lists = dao.findAll();
		return lists+"";
	}
	
	@GET
	@Path("/findByType/{type}")
	@Produces(MediaType.TEXT_PLAIN)
	public String findByType(@PathParam("type") String type) throws IOException{
		TransRecordDAO dao = new TransRecordDAO();
		ArrayList<TransRecord> lists = new ArrayList<TransRecord>(); 
		lists = dao.findByType(type);
		return lists+"";
	}
}
