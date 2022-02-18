package com.example.demo.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bankDetails")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@Value("${sources.url}")
	List<String> bankSourcesUrl;
	 
	@PostMapping("/validateAccNumber") 
	public BankResponse[] validateAccountNumber(@RequestBody BankAccount bankAccount)
	{
		if(bankAccount.getSourcesName() == null || bankAccount.getSourcesName().isEmpty())
		{
			return bankAccountService.validateBankAccNumberWithoutSource(bankAccount,bankSourcesUrl);
		}
		else
		{
			return bankAccountService.validateBankAccNumberWithSource(bankAccount,bankSourcesUrl);
		}
	}
	
	

}
