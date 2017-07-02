package indi.launc;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public WebDriver driver = null;
	private FirefoxProfile firefoxprofile = null;
	private static DesiredCapabilities caps = null;
	private String projectpath ="G:\\SeleniumTraining1\\FireflyAutomation\\trunk";

	public Browsers(BrowsersType browserstype){
		switch(browserstype){
		    case firefox:
		    	caps = DesiredCapabilities.firefox();		
		    	System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
		    	/*File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
			    File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");*/
				firefoxprofile =  new FirefoxProfile();
//				try {
/*					firefoxprofile.addExtension(firebug);
					firefoxprofile.addExtension(firepath);*/
//					firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
//					firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
				/*} catch (IOException e) {
					e.printStackTrace();
				}*/
				driver = new FirefoxDriver(firefoxprofile);
				driver.manage().window().maximize();
				break;
		    case ie:	
		    	System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer32.exe"); 
				caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);   
				caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");		
		        caps.setCapability("ignoreZoomSetting", true);
				driver = new ChromeDriver(caps);
		        driver.manage().window().maximize();
		        break;
		    case chrome:
				System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver.exe"); 
				caps = DesiredCapabilities.chrome();
				caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));  //×î´ó»¯browser
				driver = new InternetExplorerDriver(caps);
				driver.manage().window().maximize();
				break;
		}
		
			
	}

}
