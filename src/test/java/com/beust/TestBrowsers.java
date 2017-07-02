package com.beust;

import indi.launc.Browsers;
import indi.launc.BrowsersType;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestBrowsers {
	private WebDriver driver;
	@BeforeClass
	public void beforeClass(){	
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
	}

	
	@Test
	public void start(){
		driver.get("https://www.baidu.com");
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
