package com.suite1.lamda;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class case3 {
	static WebDriver driver;

	
	@Test
	public void getFrames() { 

		driver.get("http://the-internet.herokuapp.com/nested_frames");



		int size = driver.findElements(By.xpath("//frame")).size();
		System.out.println("Total Frames --" + size);  // prints the total number of frames 

		driver.switchTo().frame(0); // Switching the Frame   
		int size2 = driver.findElements(By.xpath("//frame")).size();
		System.out.println("Total Frames2 --" + size2);  // prints the total number of frames 

		driver.switchTo().frame(0);	    
		System.out.println (driver.findElement(By.xpath("//body")).getText());

		driver.switchTo().parentFrame();
		driver.switchTo().frame(1); // Switching the Frame    		
		System.out.println (driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2); // Switching the Frame     		
		System.out.println (driver.findElement(By.xpath("//body")).getText());

		driver.switchTo().defaultContent();
		driver.switchTo().frame(1); // Switching the Frame   		
		System.out.println (driver.findElement(By.xpath("//body")).getText());






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
