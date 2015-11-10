# Q1_WalmartAutomationTest_LingJieNiu


Synopsis:

This project for question 1.

Automate an end-to-end user e-commerce transaction flow using any open source tool for www.walmart.com with an existing customer on Chrome or Safari browser.


Environment Requirement:

1.  Windows 
2.  Selenium - WebDriver
3.  Eclipse IDE Luna: Java version 1.8



INTRODUCTION:

Scenario to automate:

1. Login using existing account.
2. Perform a search on home page from a pool of key words given below.
3. Identify an item from the result set that you can add to cart.
4. Add the item to cart.
5. Validate that item added is present in the cart and is the only item in the cart.

Test Data:

1. Account details: create your own account(UserName: niulingjie@foxmail.com Password: walmarttest )
2. Search terms: tv, socks, dvd, toys, iPhone

Project description:

1. setUp: Setup the Webdriver engine. 
2. testLoginToExistAccount(): Login Walmart account. 
3. HomePage(): Go to the Home Page.
4. ReadFile(): Read test data from SearchItems.txt.
5. PerformSearch(): One by one to perform search follow the search terms: tv,  socks, dvd, toys, iPhone. ( In each CASE to do the key word search,and get item's name. ) 
6. AddToCart(): Add the second, fourth and fifth item to the cart.
7. assertEquals(ItemName, itemNameInCart): validate if item added is present in the cart.  
8. In the last step,assertEquals("1", item): validate if the only one Qty of item in the cart. , assertEquals("1 item.", itemList): validate if the only one item in the cart.
9. when all processes are finished, the browser will return to Home Page.


Run Process:

1. Download the project from: https://github.com/LingJieNiu/Q1_WalmartAutomationTest_LingJieNiu
2. Unzip the project: Q1_WalmartAutomationTest_LingJieNiu
3. Import this project into Eclipse.
4. Right click src/Q1_TestInChrome/AutomationTest.java, run as java application, or src/Q1_TestInChrome/AutomationJunit.java, run as Junit.
