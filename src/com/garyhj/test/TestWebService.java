package com.garyhj.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import com.garyhj.entity.CustInfo;
import com.garyhj.entity.TransRecord;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TestWebService {
	static String URL = "http://localhost:8080/web_rest/rest/TransRecord";
	public static void main(String[] asdf) {
		System.out.println("2222");
		//TestWebService.testCreat();
		TestWebService.testfindByType();
		System.out.println("3333");
	}
	
	//���Դ���һ�����׼�¼
	public static void testCreat(){
//		TransRecord tRecord = new TransRecord("33", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "failure", "pay", "999.9", "CNY", new CustInfo(66, "����").toString());
//		TransRecord tRecord = new TransRecord("44", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "failure", "prefunday", "899.9", "CNY", new CustInfo(12, "����").toString());
//		TransRecord tRecord = new TransRecord("55", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "completed", "refund", "699.9", "USD", new CustInfo(45, "����").toString());
//		TransRecord tRecord = new TransRecord("66", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "completed", "prefunday", "799.9", "USD", new CustInfo(78, "����").toString());
		TransRecord tRecord = new TransRecord("88", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "completed", "pay", "699.9", "CNY", new CustInfo(39, "����").toString());
		String url = URL + "/create";
		Client client = Client.create();
		WebResource resource = client.resource(url);
		String response = resource.entity(tRecord, MediaType.APPLICATION_JSON).post(String.class);
		System.out.println(response);
	}
	
	//���Ը���ָ���Ľ�������ɸѡ���
	public static void testfindByType(){
		String type = "failure";
		String url = URL + "/findByType/"+type;
		Client client = Client.create();
		WebResource resource = client.resource(url);
		String response = resource.accept(MediaType.TEXT_PLAIN).get(String.class);  
		System.out.println(response);
	}
}


