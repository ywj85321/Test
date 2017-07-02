package inid.page;

import indi.touch.Do;
import indi.touch.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	private Do du;
	Wait wait;
	String usernameText= "//input[@name='email']";
	String passwordText= "//input[@name='password']";
	String loginButton= "//a[@id='dologin']";
	String email ="//span[@id='spnUid']";
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
	}
	
	public void login(String username,String password){
		du.what(this.usernameText).clear();
		du.what(this.usernameText).sendKeys(username);
		du.what(this.passwordText).sendKeys(password);
		du.what(this.loginButton).click();
//		wait.waitForElementPresent(email);
	}
}
