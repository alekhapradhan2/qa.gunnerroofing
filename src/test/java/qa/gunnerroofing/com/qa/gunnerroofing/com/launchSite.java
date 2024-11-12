package qa.gunnerroofing.com.qa.gunnerroofing.com;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class launchSite {
	static  WebDriver driver;
	 static String url="https://qa.gunnerroofing.com/";
	
	@BeforeSuite
	public void launchUrl() {
		
       System.setProperty("webdriver.chrome.driver","chromedriver.exe");
       driver=new ChromeDriver();
       driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
       driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);	 
  	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	   driver.manage().window().maximize();
  	   driver.get(url);
		   driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 String actulaUrl=driver.getCurrentUrl();
		 assertEquals(actulaUrl, url);
		 String siteHeader=driver.getTitle();
		 assertEquals(siteHeader, "Roofing, Siding, and Window Contractors | Gunner Roofing");
	}
	
	@AfterSuite
	public void closeSite() {
		driver.close();
	}
	
	
    public static String takeScreenshot(String methodName) throws IOException
	{
 		String path=System.getProperty("user.dir")+"/screenshot/"+methodName+".png";
 		try {
 			TakesScreenshot screenshot = (TakesScreenshot)driver;
     		File source = screenshot.getScreenshotAs(OutputType.FILE);
     		FileUtils.copyFile(source, new File(path));
     		
		} catch (Exception e) {
			 System.err.println("Error during test: " + e.getMessage());
		}
 		return path;
	
	}
	

}
