package com.testcase;

import indi.launc.Browsers;
import indi.launc.BrowsersType;
import indi.touch.Wait;
import inid.page.DraftsPage;
import inid.page.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraftNumCase {
	private WebDriver driver;
	DraftsPage drPage;
	LoginPage loPage;
	Wait wait;
	@BeforeClass
	public void beforeClass(){	
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		drPage = new DraftsPage(driver);
		loPage = new LoginPage(driver);
		wait = new Wait(driver);
	}

	
	@Test
	public void start(){
		driver.get("http://mail.163.com/");
		wait.waitFor(5000);
		driver.switchTo().frame("x-URS-iframe");
		loPage.login("m15121093229", "85321ywj.#");
		driver.switchTo().defaultContent();
		wait.waitFor(5000);
		
		int numPage = 0;
		drPage.draftsClick();
		int draftNum = drPage.getText();
		int buttonNumPage = drPage.totalPageNum();
		while (buttonNumPage>=1) {
			numPage = numPage+drPage.listNum();
			try {
				wait.waitFor(5000);
				drPage.nextPage1();
			} catch (Exception e) {
				break;
			}
			buttonNumPage--;
		}
		Assert.assertEquals(true, draftNum==numPage);
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
