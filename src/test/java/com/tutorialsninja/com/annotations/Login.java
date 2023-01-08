package com.tutorialsninja.com.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;
	
	@BeforeSuite
	
	public void beforeSuite() {
		
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	
	public void afterSuite() {
		
		System.out.println("After Suite");
		
	}
	
	@BeforeTest
	
	public void beforeTest() {
		
		System.out.println("Before Test");
	}
	
	@AfterTest
	
	public void afterTest() {
		
		System.out.println("After Test");
		
	}
	
	@BeforeClass
	
	public void beforeClass() {
		
		System.out.println("Before Class");
	}
	
	@AfterClass
	
	public void afterClass() {
		
		System.out.println("After Class");
		
	}
	
	
	@AfterMethod
	
	public void tearDown() {
		
		System.out.println("After Method");
		driver.quit();
	}
	
	@BeforeMethod
	
	public void setUp() {
		
		System.out.println("Before Method");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialsninja.com/demo/");
		
	}
	
	@Test(priority=1)
	
	public void verifyUserLoginWithValidCredentials() throws InterruptedException
	{
		System.out.println("Test 1");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

		
	}
	
	@Test(priority=2)
	
	public void verifyUserLoginWithValidUsernameInvalidPassword() throws InterruptedException
	{
		System.out.println("Test 2");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}
	
@Test(priority=3)
	
	public void verifyUserLoginWithInvalidUsernameValidPassword() throws InterruptedException
	{
	System.out.println("Test 3");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys("amotooricap@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}

@Test(priority=4)

public void verifyUserLoginWithInvalidUsernameInvalidPassword() throws InterruptedException
{
	System.out.println("Test 4");
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Login")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("input-email")).sendKeys("amotooricap@gmail.com");
	driver.findElement(By.id("input-password")).sendKeys("12345888");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	
}

@Test(priority=5)

public void verifyUserLoginWithoutGivingCredentials() throws InterruptedException
{
	System.out.println("Test 5");
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Login")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("input-email")).sendKeys("");
	driver.findElement(By.id("input-password")).sendKeys("");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	
}

}
