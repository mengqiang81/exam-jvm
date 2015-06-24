package com.mainsoft;

import org.junit.Test;

import com.mainsoft.common.TransactionStatus;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * 模拟请求测试REST接口
 * 
 * @version 1.0
 */
public class ClientTest {

	/**
	 * 查询全部交易
	 */
	@Test
	public void queryAll() {
		Client client = Client.create();
		WebResource r = client.resource("http://localhost:8080/rest/query");
		ClientResponse response = r.get(ClientResponse.class);
		System.out.println(response.getStatus());
		System.out.println(response.getHeaders().get("Content-Type"));
		String entity = response.getEntity(String.class);
		System.out.println(entity);
	}

	/**
	 * 测试查看交易成功对记录
	 */
	@Test
	public void querySucceed() {
		Client client = Client.create();
		WebResource r = client
				.resource("http://localhost:8080/rest/query?tranStatus="
						+ TransactionStatus.SUCCEED);
		ClientResponse response = r.get(ClientResponse.class);
		System.out.println(response.getStatus());
		System.out.println(response.getHeaders().get("Content-Type"));
		String entity = response.getEntity(String.class);
		System.out.println(entity);
	}

	/**
	 * 测试查看交易失败记录
	 */
	@Test
	public void queryFail() {
		Client client = Client.create();
		WebResource r = client
				.resource("http://localhost:8080/rest/query?tranStatus="
						+ TransactionStatus.FAIL);
		ClientResponse response = r.get(ClientResponse.class);
		System.out.println(response.getStatus());
		System.out.println(response.getHeaders().get("Content-Type"));
		String entity = response.getEntity(String.class);
		System.out.println(entity);
	}



}
