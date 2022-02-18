package com.example.demo.components;
import java.util.List;
import java.util.Random;


import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
	
	public BankResponse[] validateBankAccNumberWithoutSource(BankAccount bankAccount,List<String> bankSourcesUrlList)
	{
		String accounNumber = bankAccount.getAccountNumber();
		BankResponse bankResponse;
		BankResponse[] bankResponseList = new BankResponse[bankSourcesUrlList.size()];
		int count = 0;

		for (String source : bankSourcesUrlList) {
			bankResponse = new BankResponse();
			bankResponse.setSourceName(source.substring(8, 15));
			bankResponse.setIsValid(isValidAccount(source, accounNumber));
			bankResponseList[count++] = bankResponse;
		}
		return bankResponseList;
	}
	
	public BankResponse[] validateBankAccNumberWithSource(BankAccount bankAccount,List<String> bankSourcesUrlList)
	{
		String accounNumber = bankAccount.getAccountNumber();
		List<String> sourceNameList = bankAccount.getSourcesName();
		int count = 0;
		String bankSourcesUrl = "";
		BankResponse bankResponse;
		BankResponse[] bankResponseList = new BankResponse[sourceNameList.size()];

		for (String sourceName : sourceNameList) {
			bankSourcesUrl = findSourceUrlForGivenSourceName(sourceName, bankSourcesUrlList);
			bankResponse = new BankResponse();
			bankResponse.setSourceName(sourceName);
			bankResponse.setIsValid(isValidAccount(bankSourcesUrl, accounNumber));
			bankResponseList[count++] = bankResponse;
		}
		return bankResponseList;
	}
	
	private String findSourceUrlForGivenSourceName(String sourceName, List<String> bankSourcesUrlList) {
		String sourcesUrl = "";
		for (String bankSourcesUrl : bankSourcesUrlList) {
			if (bankSourcesUrl.contains(sourceName)) {
				sourcesUrl = bankSourcesUrl;
				break;
			}
		}
		return sourcesUrl;
	}

	public Boolean isValidAccount(String source, String accounNumber) {
		Random rand = new Random();
		return rand.nextBoolean();
	}
	

}
