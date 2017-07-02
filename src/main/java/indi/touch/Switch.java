package indi.touch;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Switch {
	private WebDriver driver;
	   private String currentwindow;
	   
		public Switch(WebDriver driver){
			this.driver = driver;	
			currentwindow = driver.getWindowHandle();
		}
		
		/**
		 * Description : 切换到特定窗口
		 * @author 杨文杰
		 * @param :窗口的部分标题名称.
		 */
		public void toSpecificWindow(String partialTitleName){
			Set<String> handles = driver.getWindowHandles();
			String titlename;
			for(String handle:handles){
				titlename = driver.switchTo().window(handle).getTitle();
				if(titlename.contains(partialTitleName))
					break;				
			}
		}
		/**
		 * Description : 返回到父窗口，但不关闭源窗口
		 * @author 杨文杰
		 * @param :窗口的部分标题名称.
		 */

		public void backToCurrentWindow(){
			driver.switchTo().window(currentwindow);
		}
}
