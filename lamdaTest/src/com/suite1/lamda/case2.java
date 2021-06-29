package com.suite1.lamda;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class case2 {
	static WebDriver driver;


	@Test
	public void getString() { 

		driver.get("http://the-internet.herokuapp.com/shadowdom");
		String expectedHeading = "Let's have some different text!";

		//Storing the text of the heading in a string 		
		String heading = driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
		if(expectedHeading.equalsIgnoreCase(heading))
			System.out.println("The expected heading is same as actual heading --- "+heading);
		else
			System.out.println("Print the string --- "+heading);


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
