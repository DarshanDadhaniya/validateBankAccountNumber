package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;


import com.example.demo.components.BankAccount;
import com.example.demo.components.BankAccountController;
import com.example.demo.components.BankAccountService;
import com.example.demo.components.BankResponse;


@WebMvcTest(BankAccountController.class)
public class BankAccountControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BankAccountService bankAccountService;
	private BankAccount bankAccount;
	private BankResponse bankResponse;
	
	@Test
	public void validateAccountNumber() throws Exception
	{
		List<String> sourcesName = new ArrayList();
		sourcesName.add("source1");
		sourcesName.add("source2");
		bankAccount = new BankAccount();
		bankAccount.setAccountNumber("123");
		bankAccount.setSourcesName(sourcesName);
		
		BankResponse[] bankResponseList = new BankResponse[2];
		bankResponse = new BankResponse();
		bankResponse.setSourceName("source1");
		bankResponse.setIsValid(true);
		bankResponseList[0] = bankResponse;
		bankResponse = new BankResponse();
		bankResponse.setSourceName("source2");
		bankResponse.setIsValid(false);
		
		List<String> bankSourcesUrl = new ArrayList();
		bankSourcesUrl.add("https://source1.com/v1/api/account/validate");
		bankSourcesUrl.add("https://source2.com/v1/api/account/validate");
		
		Mockito.when(bankAccountService.validateBankAccNumberWithSource(bankAccount,bankSourcesUrl)).thenReturn(bankResponseList);
		
		mockMvc.perform(post("/bankDetails/validateAccNumber").contentType(MediaType.APPLICATION_JSON).content("{\n"
				+ "    \"accountNumber\" : \"123\",\n"
				+ "    \"sourcesName\" : [\n"
				+ "        \"source1\",\n"
				+ "        \"source2\"\n"
				+ "    ]\n"
				+ "}")).andExpect(status().isOk());
		
	}

}
