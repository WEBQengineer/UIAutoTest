package com.czq.Imooc.runcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.czq.Imooc.TestNGListenerScreen;


@Listeners({TestNGListenerScreen.class})
public class BaseCase {
	public WebDriver driver;
	public static Logger logger = Logger.getLogger(BaseCase.class);
	@BeforeClass
	public void beforeClass() {
		PropertyConfigurator.configure("log4j.properties");
	}
	public WebDriver GetDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\EduPac\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "E:\\EduPac\\geckodriver.exe");
//			System.setProperty("webdriver.firefox.bin", "C:\\user-defined\\firefox\\firefox.exe");  
		  	driver = new FirefoxDriver();
		}
		return driver;
	}
}
