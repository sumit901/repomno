package com.tutorialsninja.com.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersOptional {
	
	@Parameters({"url","email","password"})
	@Test()
	public void loginWithValidCredentials(@Optional("http://www.tutorialsninja.com/demo/") String URL, String Email, String Password) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys(Email);
		driver.findElement(By.id("input-password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
		
	}

}
