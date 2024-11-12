package qa.gunnerroofing.com.qa.gunnerroofing.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Header extends launchSite {

	@Test(priority = 0)
	public void siteImage() {
		String siteUrl=driver.findElement(By.id("site-title")).getAttribute("href");
		if(siteUrl.equals(url))
		{
			driver.findElement(By.id("site-title")).click();
		}else {
			assertTrue(false, "Problem in site url");
		}
		assertEquals(driver.findElement(By.id("site-title")).getAttribute("href"), url);
		String siteImgUrl=driver.findElement(By.xpath("//a[@id='site-title']//img")).getAttribute("src");
		assertEquals(siteImgUrl, "https://qa.gunnerroofing.com/wp-content/uploads/2023/10/GNR_Logo_Gunner_H_White-1.svg");
	}
	
	@Test(priority = 1)
	public void services() {
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='Services']")).click();
		driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu')]//a[text()='Roofing']")).click();
		String roofUrl=driver.getCurrentUrl();
		assertEquals(roofUrl, "https://qa.gunnerroofing.com/roofing/");
		String title=driver.getTitle();
		assertEquals(title, "Nationwide Roofing Contractor | Gunner Roofing");
	}
	@Test(priority = 2)
	public void Resources()
	{
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='Resources']")).click();
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='News']")).click();
		String newsUrl=driver.getCurrentUrl();
		assertEquals(newsUrl, "https://qa.gunnerroofing.com/news/");
		String newsTitle=driver.getTitle();
		assertEquals(newsTitle, "News - Gunner Roofing");
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='Resources']")).click();
		driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu')]//a[text()='Blog']")).click();
		String blogUrl=driver.getCurrentUrl();
		assertEquals(blogUrl, "https://qa.gunnerroofing.com/blog/");
		String blogTitle=driver.getTitle();
		assertEquals(blogTitle, "Blog - Gunner Roofing");
		
	}
	@Test(priority = 3)
	public void ourWork()
	{
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='Our Work']")).click();
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://qa.gunnerroofing.com/our-work/");
		 String title=driver.getTitle();
		 assertEquals(title, "Roofing, Siding, and Window Projects | Gunner Roofing");
	}
	
	@Test(priority = 4)
	public void ContactUs()
	{
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='Contact Us']")).click();
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://qa.gunnerroofing.com/contact-us/");
		 String title=driver.getTitle();
		 assertEquals(title, "Contact Gunner Roofing | Gunner Roofing");
	}
	
	@Test(priority = 5)
	public void Financing()
	{
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='Financing']")).click();
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://qa.gunnerroofing.com/financing/");
		 String title=driver.getTitle();
		 assertEquals(title, "Financing Options | Gunner Roofing");
	}
	
	@Test(priority = 6)
	public void AboutUs()
	{
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='About Us']")).click();
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://qa.gunnerroofing.com/about-us/");
		 String title=driver.getTitle();
		 assertEquals(title, "Trusted Home Renovation Specialists | Gunner Roofing");
	}
	
	@Test(priority = 7)
	public void MyAccount()
	{
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='My Account']")).click();
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://estimatorqa.gunnerroofing.com/login");
		 String title=driver.getTitle();
		 assertEquals(title, "Nationwide Roofing Quotes | Gunner");
	}
	@Test(priority = 7)
	public void getQuoteinHeader()
	{
		driver.navigate().back();
		driver.findElement(By.xpath("//ul[@id='primary']//a[text()='GET YOUR QUOTE']")).click();
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://qa.gunnerroofing.com/register/");
		 String title=driver.getTitle();
		 assertEquals(title, "Nationwide Roofing Quotes | Gunner Roofing");
	}
	



}
