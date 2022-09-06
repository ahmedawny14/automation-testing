package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	public static Properties prop ;
	public TestBase() throws IOException {
		  prop = new Properties();
		FileInputStream fis = new FileInputStream( "E:\\automationNewProject\\autoamtionproject\\src\\test\\resources\\configFiles\\config.properties");
		prop.load(fis);
		 
	}
  public static WebDriver driver;
	public static void setup()
	{
 		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("Url"));
		
		
	}
	
	
}
