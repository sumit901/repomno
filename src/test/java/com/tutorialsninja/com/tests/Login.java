package com.tutorialsninja.com.tests;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	// add testng, webdrivermanager, selenium java repositories inside pom
	
	@Test(priority=1)
	
	public void loginWithValidCredentials() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
		
	}
	
	@Test(priority=2)
	public void loginWithInvalidCredentials() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys(generateTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		driver.quit();
		
	}
	
	
	public String generateTimeStamp()
	{
		Date date = new Date();
		return date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
	}
	
	
}
