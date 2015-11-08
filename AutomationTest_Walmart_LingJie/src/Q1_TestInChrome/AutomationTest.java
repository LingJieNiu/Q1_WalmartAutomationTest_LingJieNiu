package Q1_TestInChrome;



import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Before;


public class AutomationTest {
	String ItemName="";
	String itemNameInCart="";
	private WebDriver driver;
	
	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver",
					
					"Webdriver/chromedriver.exe");
		 
		//  D:/SoftwareTest/Webdrive/chromedriver_win32/chromedriver.exe
	    driver = new ChromeDriver();
	 
	    driver.get("http://www.walmart.com/");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[@type='button']/i[@class='wmicon wmicon-remove']")).click();
	  
	  }
	  
	  public void testLoginToExistAccount() throws Exception {
		  
		 
		    driver.findElement(By.linkText("Sign In")).click();
		    driver.findElement(By.id("login-username")).clear();
		    driver.findElement(By.id("login-username")).sendKeys("niulingjie@foxmail.com");
		    driver.findElement(By.id("login-password")).clear();
		    driver.findElement(By.id("login-password")).sendKeys("walmarttest");
		    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		  
		
		    HomePage();
		
		
	  }
	  
	  public void PerformSearch() throws InterruptedException{
		
		 
		// Start the search
		    for (int i = 0; i < 5; i++) {
		    	
		    	WebElement searchItems = driver.findElement(By.xpath("//*[@id='search']"));
		    	WebElement getoneItem = null;
				switch(i) {
					case 0:
						searchItems.sendKeys("tv");
						driver.findElement(By.cssSelector("button.searchbar-submit.js-searchbar-submit")).click();
						Thread.sleep(2000);
						getoneItem=driver.findElement(By.xpath("//*[@id='tile-container']/div[1]/div/div/h4/a"));
						ItemName=getoneItem.getText();//get the item name;
						getoneItem.click();
						Thread.sleep(2000);
						break;
					case 1:
						searchItems.sendKeys("socks");
						driver.findElement(By.cssSelector("button.searchbar-submit.js-searchbar-submit")).click();
						Thread.sleep(2000);
						getoneItem=driver.findElement(By.xpath("//*[@id='tile-container']/ul/li[1]/div/a[2]"));
						ItemName=getoneItem.getText();//get the item name;
						getoneItem.click();
						Thread.sleep(2000);
						break;
					case 2:
						searchItems.sendKeys("dvd");
						driver.findElement(By.xpath("//*[@id='top']/div[3]/div/div/div/div/div[3]/form/div/div[3]/button")).click();
						Thread.sleep(2000);
						getoneItem=driver.findElement(By.xpath("//*[@id='tile-container']/div[2]/div/div/h4/a"));
						
						
						ItemName=getoneItem.getText();//get the item name;
						getoneItem.click();
						Thread.sleep(2000);
						break;
					case 3:
						searchItems.sendKeys("toys");
						driver.findElement(By.xpath("//*[@id='top']/div[3]/div/div/div/div/div[3]/form/div/div[3]/button")).click();
						Thread.sleep(2000);
						
						getoneItem=driver.findElement(By.xpath("//*[@id='sponsored-container-middle-2']/div/div[2]/ol/div/div/li[1]/div/div[2]/a/span"));
						
						ItemName=getoneItem.getText();//get the item name;
						getoneItem.click();
						Thread.sleep(2000);
						break;
					case 4:
						searchItems.sendKeys("iphone");
						driver.findElement(By.xpath("//*[@id='top']/div[3]/div/div/div/div/div[3]/form/div/div[3]/button")).click();
						
						getoneItem=driver.findElement(By.xpath("//*[@id='tile-container']/div[1]/div/div/h4/a"));
						ItemName=getoneItem.getText();//get the item name;
						getoneItem.click();
						 Thread.sleep(2000);
						
						
						
						 driver.findElement(By.xpath("//section[@class='body']/section[@class='center']/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div/div/span[1]/label/span")).click();
						//choose a color;
						
						
						
						Thread.sleep(2000);
						driver.findElement(By.xpath("//section[@class='body']/section[@class='center']/div/div[2]/div[1]/div[5]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div/div/button/i")).click();
						//click small button to close extra choice
						
						break;
				}
				
				
		
				
				if (i == 1) {
					AddToCart();
					driver.findElement(By.xpath("//*[@id='CartRemItemBtn']")).click();//remove
				//	
					
				}else if (i == 3) {
					AddToCart();
					driver.findElement(By.xpath("//*[@id='CartRemItemBtn']")).click();//remove
				//	
				}else if (i == 4){
					
					AddToCart();
						String item=driver.findElement(By.xpath("//*[@id='spa-layout']/div/div/div[1]/div/div[3]/div[2]/div/div/div[4]/div/div[1]/div/div/div/div[1]/div/div")).getText();
						
						assertEquals("1", item);//validate if the only item in the cart.
						String itemList=driver.findElement(By.xpath("//*[@id='spa-layout']/div/div/div[1]/div/h3/span")).getText();
						assertEquals("1 item.", itemList);
						HomePage();
						//continue shopping
				}
				
			
				
				
		    }
	  }
	  
	  public void AddToCart() throws InterruptedException{
		  
			driver.findElement(By.xpath("//*[@id='WMItemAddToCartBtn']")).click();
			//add to cart
				
				driver.findElement(By.xpath("//*[@id='PACViewCartBtn']")).click();
				//View cart
				
				itemNameInCart=driver.findElement(By.xpath("//div[@class='cart-item-name js-product-title']/a[@id='CartItemInfo']")).getText();
				
				//get Item name in the cart
				
				
				assertEquals(ItemName, itemNameInCart);//validate that item  added is present in the cart.
				
		  
		  
		  
	  }
	 
	  
	  public void HomePage() throws InterruptedException {
			
		  
		  driver.navigate().to("https://www.walmart.com");
		
		  
		}
	  
	  
	  
	  public static void main(String[] args) throws Exception {
		
			AutomationTest test=new AutomationTest();
			test.setUp();
			test.testLoginToExistAccount();
			
			test.PerformSearch();
		}
	  
	  

}
