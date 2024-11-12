package qa.gunnerroofing.com.qa.gunnerroofing.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class container1 extends launchSite {
	
	
	@Test(priority = 0)
	public void slides()
	{ 
		driver.navigate().to(url);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<String> itemTexts = (List<String>) js.executeScript(
            "return Array.from(document.querySelectorAll('.scrolling-words-box .slides li')).map(item => item.innerText.trim()).filter(text => text);" );

        // Print the collected text
        System.out.println(itemTexts);
        
        assertEquals(itemTexts.get(0), "Roofing");
        assertEquals(itemTexts.get(1), "Siding");
        assertEquals(itemTexts.get(2), "Windows");
        boolean Made_Easier=driver.findElement(By.xpath("//span[text()='Made Easier.']")).isDisplayed();
        assertTrue(Made_Easier,"Problem in Made Easier");
        
        WebElement descriptive_content=driver.findElement(By.xpath("//div[@class='descriptive-content']//ul"));
        List<WebElement> contentText=descriptive_content.findElements(By.tagName("li"));
        assertEquals(contentText.get(0).getText(), "Real Quotes.");
        assertEquals(contentText.get(1).getText(), "Purchase And Schedule Online.");
        assertEquals(contentText.get(2).getText(), "No Gimmicks.");
        
	}
	
	@Test(priority = 1)
	public void video()
	{
		boolean  video=driver.findElement(By.xpath("//video[@id='heroVideo']")).isDisplayed();
		if(video==true)
		{
			String video_poster=driver.findElement(By.xpath("//video[@id='heroVideo']")).getAttribute("poster");
			assertEquals(video_poster, "https://qa.gunnerroofing.com/wp-content/themes/gunner/assets/images/hero-image-background-white.png");
			String video_src=driver.findElement(By.xpath("//video[@id='heroVideo']//source")).getAttribute("src");
			assertEquals(video_src, "https://customer-1cx432u4tgh3hvea.cloudflarestream.com/b5adec49523ea97e01ab55189a3c0220/downloads/default.mp4");
		}else {
			assertTrue(false, "Error in video");
		}
		
	}
	
	
	@Test(priority = 2)
	public void getYourQuote_InContainer1()
	{
		driver.findElement(By.xpath("//section[@class='hero']//a[contains(text(),'Get your quote')]")).click();
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://qa.gunnerroofing.com/register/");
		 String title=driver.getTitle();
		 assertEquals(title, "Nationwide Roofing Quotes | Gunner Roofing");
	}

}
