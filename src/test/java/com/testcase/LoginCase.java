package com.testcase;

import indi.launc.Browsers;
import indi.launc.BrowsersType;
import indi.touch.Do;
import indi.touch.Wait;
import inid.page.LoginPage;

import org.eclipse.jetty.util.component.Dumpable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginCase {
	private WebDriver driver;
	LoginPage loPage;
	Wait wait;
	@BeforeClass
	public void beforeClass(){	
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		loPage = new LoginPage(driver);
		wait = new Wait(driver);
	}

	
	@Test
	public void start(){
		driver.get("http://mail.163.com/");
//		driver.switchTo().frame("iframe#x-URS-iframe");
		wait.waitFor(5000);
		driver.switchTo().frame("x-URS-iframe");
		loPage.login("m15121093229", "85321ywj.#");
		wait.waitFor(10000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//li[@id='_mail_tabitem_1_45']")).click();
		wait.waitFor(5000);
	}
	
/*	@AfterClass
	public void quit(){
		driver.quit();
	}*/
	
}
