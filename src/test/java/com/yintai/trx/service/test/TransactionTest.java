package com.yintai.trx.service.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.yintai.trx.service.TransactionService;
import com.yintai.trx.util.TransactionLookupValues;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/WEB-INF/dispatcher-servlet.xml")
public class TransactionTest {

	 @Autowired
	 WebApplicationContext wac;
	 private MockMvc mockMvc;

	 @Autowired
	 TransactionService trxService;

	 @Before
	 public void setUp() throws Exception {
	     this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	 }	
	 
	 @Test
	    public void testAddTransaction() {
	        try {
	            
	            //验证交易状态为等待付款，并且交易的金额是86.5
	            MvcResult result = mockMvc.perform(post("/trx/addTransaction")
	                    .param("createDate", "2015/06/21")
	                    .param("transactionStatus", "3")
	                    .param("transactionType", "1")
	                    .param("transactionAmount", "86.5")
	                    .param("currencyType", "1")
	                    .param("client.clientName", "张三")
	            )
	            .andExpect(status().isOk())
	            .andExpect(content().contentType("application/json;charset=UTF-8"))
	            .andExpect(jsonPath("$.transactionStatus", is(TransactionLookupValues.TRANSACTION_STATUS_PENDING)))
	            .andExpect(jsonPath("$.transactionAmount", is(86.5)))
	            .andDo(print())
	            .andReturn();
	            
	            Assert.assertNotNull(result);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 @Test
	 public void testGetTransactions() {
		try {
			//3条交易成功记录
			mockMvc.perform(post("/trx/addTransaction")
                    .param("createDate", "2015/06/21")
                    .param("transactionStatus", "1")
                    .param("transactionType", "1")
                    .param("transactionAmount", "86.5")
                    .param("currencyType", "1")
                    .param("client.clientName", "张三")
            );
			
			mockMvc.perform(post("/trx/addTransaction")
                    .param("createDate", "2015/06/21")
                    .param("transactionStatus", "1")
                    .param("transactionType", "1")
                    .param("transactionAmount", "86.5")
                    .param("currencyType", "2")
                    .param("client.clientName", "李四")
            );
			
			mockMvc.perform(post("/trx/addTransaction")
                    .param("createDate", "2015/06/21")
                    .param("transactionStatus", "1")
                    .param("transactionType", "2")
                    .param("transactionAmount", "86.5")
                    .param("currencyType", "2")
                    .param("client.clientName", "王五")
            );
			
			//两条交易失败记录
			mockMvc.perform(post("/trx/addTransaction")
                    .param("createDate", "2015/06/21")
                    .param("transactionStatus", "2")
                    .param("transactionType", "1")
                    .param("transactionAmount", "86.5")
                    .param("currencyType", "1")
                    .param("client.clientName", "王一")
            );
			
			mockMvc.perform(post("/trx/addTransaction")
                    .param("createDate", "2015/06/21")
                    .param("transactionStatus", "2")
                    .param("transactionType", "1")
                    .param("transactionAmount", "86.5")
                    .param("currencyType", "2")
                    .param("client.clientName", "王二")
            );
			
			//查询全部状态 5 条
            MvcResult result = mockMvc.perform(get("/trx/getTransactions")
                    .param("transactionStatus", "-1")
                    ).andExpect(status().isOk())
                    .andExpect(content().contentType("application/json;charset=UTF-8"))
                    .andExpect(jsonPath("$", hasSize(5)))
                    .andDo(print())
                    .andReturn();
            
            Assert.assertNotNull(result);
			
            // 查询成功记录 3 条
			result = mockMvc.perform(get("/trx/getTransactions")
					.param("transactionStatus","1")
					)
					.andExpect(status().isOk())
	                .andExpect(content().contentType("application/json;charset=UTF-8"))
	                .andExpect(jsonPath("$", hasSize(3)))
	                .andDo(print())
	                .andReturn();
		 
		 Assert.assertNotNull(result);
		 
		// 查询失败记录 2 条
			result = mockMvc.perform(get("/trx/getTransactions")
					.param("transactionStatus","2")
					)
					.andExpect(status().isOk())
			        .andExpect(content().contentType("application/json;charset=UTF-8"))
                    .andExpect(jsonPath("$", hasSize(2))) 
                    .andDo(print())
			        .andReturn();
				 
				 Assert.assertNotNull(result);
	 } catch (Exception e) {
         e.printStackTrace();
     }
	 }
}
