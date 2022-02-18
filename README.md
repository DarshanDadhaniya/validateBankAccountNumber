# validateBankAccountNumber
 validateBankAccountNumber
 
Requirements:

Rest api, all messages in json.
Spring boot app.
Sufficient tests to demonstrate the app is working correctly.
Data sources' url are set as properties and must not be stored in code. Demonstrate how the urls can be set for production and non-production 
environments. 
The rest api should return response within 2 seconds. It is guaranteed that all external data sources will return data within 1 second.
The code is uploaded to github. Please share a link to the code with your recruiter

HomeTaskApplication.java
-It is a entry point of application

BankAccountController.java
- is a controller which handle request for validateBankAccountNumber with source and withoutSource

BankAccountService.java
- Writing 4 services inside it
1. validateBankAccNumberWithoutSource - it validate BankAccountNUmber without sources means check with all sources which is available in application.properties file
2. validateBankAccNumberWithSource - it validate BankAccountNUmber for given source , to find url from sourceName I use findSourceUrlForGivenSourceName method 
3. findSourceUrlForGivenSourceName - It gives sourceUrl on the basis of sourceName
4. isValidAccount - It return random boolean value to check accountNumber is valid or not

BankAccount.java 
- it is a entity class which is use for input request
- It has two parameters 
1. bankAccountNumber
2. list of sourcesName

BankResponse.java
- I use it to send response as array of BankResponse
- It has two parameters
1. sourceName
2. isValid - for bankAccountNUmberValidation

BankAccountControllerTest.java
- Write test case for BankAccountController

application.properties
- for banksourcesName,url


