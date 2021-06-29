package com.suite1.lamda;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class case1 {
	static WebDriver driver;

	@Test
	public void edit_Text() {


		String url = "http://the-internet.herokuapp.com/tinymce";
		driver.get(url);


		String expectedTitle = "The Internet";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);


		driver.switchTo().frame("mce_0_ifr");
		WebElement searchText = driver.findElement(By.xpath("/html[1]/body[1]/p[1]"));
		searchText.clear();
		//Enter the text
		searchText.sendKeys("test1");
		searchText.sendKeys(Keys.ENTER);
		//Enter the text
		searchText.sendKeys("test2"); 	
		
		//select Bold
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/button[1]")).click();
		System.out.println("Bold selected");
		
		// change the Font size
		driver.findElement(By.xpath("//span[@class=\"tox-mbtn__select-label\" and text()='Format']")).click();
		driver.findElement(By.xpath("//div[@class=\"tox-collection__item-label\" and text()='Font sizes']") ).click()  ;
		driver.findElement(By.xpath("//div[@class=\"tox-collection__item-label\" and text()='8pt']") ).click()  ;
		System.out.println("Font Changed");

	}



	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shweta\\eclipse-workspace\\lamdaTest\\src\\drivers\\chromedriver.exe");

		//Setting the driver to chrome driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Starting the browser session");
	}


	@AfterMethod
	public void afterMethod() {

		System.out.println("Closing the browser session");
		driver.quit();
	}

}
