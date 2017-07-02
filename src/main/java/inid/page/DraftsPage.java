package inid.page;

import java.util.List;

import indi.touch.Do;
import indi.touch.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftsPage {
	private WebDriver driver;
	Do du;
	Wait wait;
	
	@FindBy(xpath="//span[@id='_mail_tree_6_98count']")
	private WebElement drafts;
	
	private String caogx ="//span[@id='_mail_tree_6_98count']";
	
	private String checkbox = "//b[@class='nui-ico nui-ico-checkbox']";
	
	@FindBy(xpath="//span[@class='nui-select-text']")
	private WebElement numPage;
	
	@FindBy(xpath="//div[@class='nui-toolbar-item']//div[@title='下一页']")
	private WebElement nextPage;
	
	public DraftsPage(WebDriver driver){
		this.driver = driver;
		wait = new Wait(driver);
		du = new Do(driver);
		PageFactory.initElements(driver, this);	
	}
	
	public void nextPage1(){
		nextPage.click();
	}
	
	public int totalPageNum(){
		return Integer.valueOf(numPage.getText().split("/")[1]).intValue();
	}
	
	public int listNum(){
		return du.whats(checkbox).size();
	}
	
	public int getText(){
		String str = driver.findElement(By.xpath(caogx)).getText();
		String str2 = str.substring(1, str.length()-1);
		return Integer.parseInt(str2);
	}
	
	public void draftsClick(){
//		wait.waitForElementvisible(drafts);
		drafts.click();
	}
}
