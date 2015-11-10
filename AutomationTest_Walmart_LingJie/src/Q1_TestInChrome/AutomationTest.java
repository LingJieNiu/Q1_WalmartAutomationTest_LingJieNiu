package Q1_TestInChrome;



import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;


public class AutomationTest {
	private
	String ItemName="";
	String itemNameInCart="";
	WebDriver driver;
	ArrayList<String> ItermList=new ArrayList<String>();
	List<WebElement> SearchItermList=new ArrayList<WebElement>();
	FileReader fr ;
	BufferedReader br ;
	String searchitems;
	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver",
					
					"Webdriver/chromedriver.exe");
		 
		
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
	  
	  public void PerformSearch() throws InterruptedException, IOException{
		  ReadFile();
		 
		// Start the search
		    for (int i = 0; i < ItermList.size(); i++) {
		    	
		    	WebElement searchItems = driver.findElement(By.xpath("//*[@id='search']"));
		    	 WebElement choiceOne = null;
				switch(i=4) {
					case 0:
						searchItems.sendKeys(ItermList.get(i));//tv 
						driver.findElement(By.cssSelector("button.searchbar-submit.js-searchbar-submit")).click(); 
						Thread.sleep(2000); 

					
						SearchItermList=driver.findElements(By.xpath("//h4/a"));
						//put all products link to SearchItermList
					
					    choiceOne=SearchItermList.get(2);//choice the third product
						
						choiceOne.click();
						ItemName=driver.findElement(By.xpath("//h1[@class='js-product-heading heading-b product-name product-heading padding-ends']")).getText();
						//get the item name
						Thread.sleep(2000); 
			
						break;
					case 1:
						
						searchItems.sendKeys(ItermList.get(i));//socks 
						driver.findElement(By.cssSelector("button.searchbar-submit.js-searchbar-submit")).click(); 
						Thread.sleep(2000); 
						SearchItermList=driver.findElements(By.xpath("//li[@class='tile-grid-unit-wrapper']//a[@class='js-product-title']"));
						//put all products link to SearchItermList
						
					    choiceOne=SearchItermList.get(0);//choice the first product
						
						choiceOne.click();
						ItemName=driver.findElement(By.xpath("//h1[@class='js-product-heading heading-b product-name product-heading padding-ends']")).getText();
						//get the item name
						
					
						break;
					case 2:
						searchItems.sendKeys(ItermList.get(i));//tv 
						driver.findElement(By.cssSelector("button.searchbar-submit.js-searchbar-submit")).click(); 
						Thread.sleep(2000); 
						SearchItermList=driver.findElements(By.xpath("//h4/a"));//dvd
						//put all products link to SearchItermList
						
					    choiceOne=SearchItermList.get(2);//choice the third product
						
						choiceOne.click();
						ItemName=driver.findElement(By.xpath("//h1[@class='js-product-heading heading-b product-name product-heading padding-ends']")).getText();
						//get item name
						
				
						break;
					case 3:
						searchItems.sendKeys(ItermList.get(i));//toys 
						driver.findElement(By.cssSelector("button.searchbar-submit.js-searchbar-submit")).click(); 
						Thread.sleep(2000); 
						SearchItermList=driver.findElements(By.xpath("//a[@class='Tile-linkOverlay js-tile-link-overlay']"));
						//put all products link to SearchItermList
						
					    choiceOne=SearchItermList.get(2);//choice the third product
					    choiceOne.click();
					    ItemName=driver.findElement(By.xpath("//h1[@class='js-product-heading heading-b product-name product-heading padding-ends']")).getText();
					  //get the item name;
					    
				
						
						break;
					case 4:
						searchItems.sendKeys(ItermList.get(i));//iphone 
						driver.findElement(By.cssSelector("button.searchbar-submit.js-searchbar-submit")).click(); 
						Thread.sleep(2000); 
						SearchItermList=driver.findElements(By.xpath("//h4/a"));
						//put all products link to SearchItermList
						
					    choiceOne=SearchItermList.get(3);//choice the fourth product
						
						choiceOne.click();
						ItemName=driver.findElement(By.xpath("//h1[@class='js-product-heading heading-b product-name product-heading padding-ends']")).getText();
						//get the item name

					
						
						List<WebElement> ColorList=new ArrayList<WebElement>();
						
						ColorList=driver.findElements(By.xpath("//span[@class='js-variant-swatch-container variant-swatch-container']/label/span"));
						
						ColorList.get(0).click();
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
	  
	  
	  public void ReadFile() throws IOException{
			
			File input=new File("src/SearchItems.txt");
			fr=new FileReader(input);
			br=new BufferedReader(fr);
			while((searchitems=br.readLine())!=null){
				String[]arr=searchitems.split(",");
				for(String i:arr){
					
					ItermList.add(i);
				}
				
			}
		
		}
	  
	  
	  
	  
	  public static void main(String[] args) throws Exception {
		
			AutomationTest test=new AutomationTest();
			test.setUp();
			test.testLoginToExistAccount();
			
			test.PerformSearch();
		}
	  
	  

}
