package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
 
 import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
 
import base.TestBase;

public class register extends TestBase { 
	

	
	public register() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public static void beforeMethod() throws InterruptedException
	{
		
		 setup();    
		  
		 driver.manage().window().maximize();
   }
	
	
	@AfterMethod
	public static void aftermethod()
	{
		
	  driver.quit();
 	
	}
	@Test(priority=1)
	public static void clickOnLogo()  // it should go to home page
	
	{
 	 driver.findElement(By.xpath("//img[@title='Ultimate QA']")).click();
 		String ExpectedResult ="https://courses.ultimateqa.com/collections";
 		String actualResult=driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult);
	}
	
	@Test(priority=2)
	public static void checkTitle()   // check the title of the page
	{
		String ExpectedResult ="Ultimate QA";
		String ActualResult= driver.getTitle();
		Assert.assertEquals(ActualResult , ExpectedResult);
	}
	
	@Test(priority=3)
	public static void  checkUrl()    // check the url of the page
	{
		String ExpectedResult ="https://courses.ultimateqa.com/users/sign_up";
		String ActualResult=driver.getCurrentUrl();
		Assert.assertEquals(ActualResult , ExpectedResult);
	}
	
	
	@Test(priority=4)
	public static void  check_Signin_Link()     // It should go to login page
	{
		driver.findElement(By.linkText("Sign In")).click() ;
       String ExpectedResult ="https://courses.ultimateqa.com/users/sign_in";
 		String actualResult=driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult);
		}
	
	
	@Test (priority=5)
	
	public static void  check_I_already_have_account_Link()     // It should go to login page
	{
		driver.findElement(By.linkText("I already have an account!")).click() ;
		String ExpectedResult ="https://courses.ultimateqa.com/users/sign_in";
 		String actualResult=driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult);
     }
	
	
	@Test (priority=6)
	public static void check_terms_of_use_Link()    //it should open terms page in another tab 
	{
		driver.findElement(By.linkText("Terms of Use")).click();
		Set<String>handle=  driver.getWindowHandles();
		   Iterator<String>iterator= handle.iterator();
		  String window1= iterator.next();
		   String window2 = iterator.next();
		   driver.switchTo().window(window2);
		   String ExpectedResult ="https://courses.ultimateqa.com/pages/terms";
	 		String actualResult=driver.getCurrentUrl();
			Assert.assertEquals(actualResult, ExpectedResult);
	}
	
	
	@Test(priority=7)
	public static void check_CustomerPrivacyPolicy_Link()    //it should open policy page in another tab
	{
		driver.findElement(By.linkText("Customer Privacy Policy")).click();
		Set<String>handle=  driver.getWindowHandles();
		   Iterator<String>iterator= handle.iterator();
		  String window1= iterator.next();
		   String window2 = iterator.next();
		   driver.switchTo().window(window2);
		   String ExpectedResult ="https://courses.ultimateqa.com/pages/privacy";
	 		String actualResult=driver.getCurrentUrl();
			Assert.assertEquals(actualResult, ExpectedResult);
	}

	
	
	@Test (priority=8)
	
	public static void register_With_ValidData() throws InterruptedException  // Entering all fields with valid data
	 {
		
 		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	 
 		 driver.findElement(By.id("user[first_name]")).sendKeys("Ahmed");
		 driver.findElement(By.id("user[last_name]")).sendKeys("awny");
		 driver.findElement(By.name("user[email]")).sendKeys("ahmedeldaly005@gmail.com");
		 driver.findElement(By.name("user[password]")).sendKeys("Ahmedawny_14");
	 
		 driver.findElement(By.id("user[terms]")).click();
		 driver.findElement(By.xpath("//*[@class='button button-primary g-recaptcha']")).click();
		   String ExpectedResult ="https://courses.ultimateqa.com/collections";
		   WebDriverWait wait = new WebDriverWait (driver,  20);
		    wait.until(ExpectedConditions.  urlToBe("https://courses.ultimateqa.com/collections") );
	 		String actualResult=driver.getCurrentUrl();
			Assert.assertEquals(actualResult, ExpectedResult);

		  }
@Test (priority=9)
	
	public static void EmptyFirstName() throws InterruptedException    // don't enter a value in first name field
	 {
	
         driver.findElement(By.id("user[first_name]")).sendKeys(" ");
		 driver.findElement(By.id("user[last_name]")).sendKeys("awny");
		 driver.findElement(By.name("user[email]")).sendKeys("ahmedeldaly77@gmail.com");
		 driver.findElement(By.name("user[password]")).sendKeys("Ahmedawny_14");
		 driver.findElement(By.id("user[terms]")).click();
		 driver.findElement(By.xpath("//*[@class='button button-primary g-recaptcha']")).click();
 		    String  ExpectedMsg="First name can't be blank";
 		   WebDriverWait wait = new WebDriverWait (driver,  20);
 		    wait.until(ExpectedConditions. presenceOfElementLocated( By.xpath( "//*[@id=\"notice\"]/ul/li[1]")));
  		  String ActualMsg=driver.findElement(By.xpath ("//*[@id=\"notice\"]/ul/li[1]")). getText();
  		  Assert.assertEquals(ActualMsg, ExpectedMsg);
  		 
	 }


@Test (priority=10)
public static void EmptyLastName() throws InterruptedException        // don't enter a value in last name field
{

 
	 driver.findElement(By.id("user[first_name]")).sendKeys("Ahmed ");
	 driver.findElement(By.id("user[last_name]")).sendKeys(" ");
	 driver.findElement(By.name("user[email]")).sendKeys("ahmedeldaly@gmail.com");
	 driver.findElement(By.name("user[password]")).sendKeys("Ahmedawny_14");
	 driver.findElement(By.id("user[terms]")).click();
	 driver.findElement(By.xpath("//*[@class='button button-primary g-recaptcha']")).click();
	    String  ExpectedMsg="Last name can't be blank";
	   WebDriverWait wait1 = new WebDriverWait (driver,  20);
	    wait1.until(ExpectedConditions.   presenceOfElementLocated( By.xpath( "//*[@id=\"notice\"]/ul/li")));
	    String ActualMsg = driver.findElement(By.xpath ("//*[@id=\"notice\"]/ul/li")). getText();
		  Assert.assertEquals(ActualMsg, ExpectedMsg);
		 
} 


@Test (priority=11)

public static void EmptyEmail() throws InterruptedException         // don't enter a value in email field
 {

     driver.findElement(By.id("user[first_name]")).sendKeys("Ahmed ");
	 driver.findElement(By.id("user[last_name]")).sendKeys("awny");
	 driver.findElement(By.name("user[email]")).sendKeys(" ");
	 driver.findElement(By.name("user[password]")).sendKeys("Ahmedawny_14");
	 driver.findElement(By.id("user[terms]")).click();
	 driver.findElement(By.xpath("//*[@class='button button-primary g-recaptcha']")).click();
	 String  ExpectedMsg="Email can't be blank";
	 WebDriverWait wait = new WebDriverWait (driver,  20);
    wait.until(ExpectedConditions. presenceOfElementLocated( By.xpath( "//*[@id=\"notice\"]/ul/li")));
	String ActualMsg=driver.findElement(By.xpath ("//*[@id=\"notice\"]/ul/li")). getText();
	Assert.assertEquals(ActualMsg, ExpectedMsg);
		 
 }


@Test (priority=12)

public static void TakenEmail() throws InterruptedException           //   enter an email that is existed before
 {

	 driver.findElement(By.id("user[first_name]")).sendKeys("Ahmed ");
	 driver.findElement(By.id("user[last_name]")).sendKeys("awny");
	 driver.findElement(By.name("user[email]")).sendKeys("ahmedeldaly685@gmail.com ");
	 driver.findElement(By.name("user[password]")).sendKeys("Ahmedawny_14");
	 driver.findElement(By.id("user[terms]")).click();
	 driver.findElement(By.xpath("//*[@class='button button-primary g-recaptcha']")).click();
		    String  ExpectedMsg="Email has already been taken";
	 		   WebDriverWait wait = new WebDriverWait (driver,  20);
		    wait.until(ExpectedConditions. presenceOfElementLocated( By.xpath( "//*[@id=\"notice\"]/ul/li")));
		  String ActualMsg=driver.findElement(By.xpath ("//*[@id=\"notice\"]/ul/li")). getText();
		  Assert.assertEquals(ActualMsg, ExpectedMsg);
		 }


@Test (priority=13)

public static void InvalidEmail() throws InterruptedException      // enter an email without @ and .com
 {

 
	driver.findElement(By.id("user[first_name]")).sendKeys("Ahmed ");
	 driver.findElement(By.id("user[last_name]")).sendKeys("awny");
	 driver.findElement(By.name("user[email]")).sendKeys("ahmedeldaly68");
	 driver.findElement(By.name("user[password]")).sendKeys("Ahmedawny_14");
	 driver.findElement(By.id("user[terms]")).click();
	 driver.findElement(By.xpath("//*[@class='button button-primary g-recaptcha']")).click();
		    String  ExpectedMsg="Email is invalid";
	 		   WebDriverWait wait = new WebDriverWait (driver,  20);
		    wait.until(ExpectedConditions. presenceOfElementLocated( By.xpath( "//*[@id=\"notice\"]/ul/li")));
		  String ActualMsg=driver.findElement(By.xpath ("//*[@id=\"notice\"]/ul/li")). getText();
		  Assert.assertEquals(ActualMsg, ExpectedMsg);
		 
 }


@Test (priority=14)

public static void Emptypassword() throws InterruptedException //  // don't enter a value in password field
 {

 
		 driver.findElement(By.id("user[first_name]")).sendKeys("Ahmed ");
	 driver.findElement(By.id("user[last_name]")).sendKeys("awny");
	 driver.findElement(By.name("user[email]")).sendKeys(" ahmedawny14@gmail.com");
	 driver.findElement(By.name("user[password]")).sendKeys(" ");
	 driver.findElement(By.id("user[terms]")).click();
	 driver.findElement(By.xpath("//*[@class='button button-primary g-recaptcha']")).click();
		    String  ExpectedMsg="Password can't be blank";
	 		   WebDriverWait wait = new WebDriverWait (driver,  20);
		    wait.until(ExpectedConditions. presenceOfElementLocated( By.xpath( "//*[@id=\"notice\"]/ul/li")));
		  String ActualMsg=driver.findElement(By.xpath ("//*[@id=\"notice\"]/ul/li")). getText();
		  Assert.assertEquals(ActualMsg, ExpectedMsg);
		 
 }


@Test (priority=15)

public static void Invalidpassword() throws InterruptedException     //enter a password less than 8 characters
 {

 
		 driver.findElement(By.id("user[first_name]")).sendKeys("Ahmed ");
	 driver.findElement(By.id("user[last_name]")).sendKeys("awny");
	 driver.findElement(By.name("user[email]")).sendKeys(" ahmedawny14@gmail.com");
	 driver.findElement(By.name("user[password]")).sendKeys("12345 ");
	 driver.findElement(By.id("user[terms]")).click();
	 driver.findElement(By.xpath("//*[@class='button button-primary g-recaptcha']")).click();
		    String  ExpectedMsg="Password must be at least 8 characters.";
	 		   WebDriverWait wait = new WebDriverWait (driver,  20);
		    wait.until(ExpectedConditions. presenceOfElementLocated( By.xpath( "//*[@id=\"notice\"]/ul/li")));
		  String ActualMsg=driver.findElement(By.xpath ("//*[@id=\"notice\"]/ul/li")). getText();
		  Assert.assertEquals(ActualMsg, ExpectedMsg);
		 
 }



@Test (priority=16)
public static void signUpWithFacbook() throws InterruptedException   // click on facebook icon
{

		 

		 driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/article/div/ul/li[2]/a")).click();
		 boolean Expectedresult=true;
		boolean ActualResult= driver.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div[1]/div/div/h1/a/i")).isDisplayed();
		Assert.assertEquals(ActualResult, Expectedresult);
		 

}


@Test (priority=17)
public static void signUpWithLinkedin() throws InterruptedException    //click on linkedin icon icon
{

		 

		 driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/article/div/ul/li[1]/a/i")).click();
		 boolean Expectedresult=true;
		boolean ActualResult= driver.findElement(By.xpath("//div[@class='header__logo']//li-icon[@alt='LinkedIn']//*[name()='svg']//*[name()='path'][1]")).isDisplayed();
		Assert.assertEquals(ActualResult, Expectedresult);
	 
		 }



@Test (priority=18)
public static void signUpWithGmail() throws InterruptedException    //click on gmail icon
{

		 

		 driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/article/div/ul/li[3]/a")).click();
		 boolean Expectedresult=true;
		boolean ActualResult= driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).isDisplayed();
		Assert.assertEquals(ActualResult, Expectedresult);
	 }


}
