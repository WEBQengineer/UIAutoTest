package com.czq.Imooc.runcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.czq.Imooc.handle.LoginHandle;
import com.czq.Imooc.util.ProUtil;

public class LoginCase extends BaseCase {
	
	public WebDriver driver;
	LoginHandle lh;
	
	@Parameters({"url","browser"})
	@BeforeClass
	public void beforeClass(String url, String browser) {
//		System.setProperty("webdriver.chrome.driver", "E:\\EduPac\\chromedriver_win32\\chromedriver.exe");
		driver = GetDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
		ProUtil.threadSleep(1);
		driver.findElement(By.id("js-signin-btn")).click();
		ProUtil.threadSleep(1);
		lh = new LoginHandle(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	@Parameters({"username","password"})
//	@Test
	public void TestLoginSucess(String username, String password) {
		lh.sendEmail(username);
		lh.sendPassword(password);
		lh.ClickSeven();
		lh.ClickLogin();
		ProUtil.threadSleep(2);
		lh.GetUserinfoAndContrast();
		System.out.println(lh.GetUserinfoText());
//		if (userName.equals("慕沐8217016")) {
//			System.out.println("登录成功! " + "名字是: " + userName);
//			System.out.println("方法内部");
//		}
//		System.out.println("方法外部");
//		ProUtil.threadSleep(2);
//		lh.GetUserinfoAndContrast();
	}
	
	@Test
	public void test02() {
		System.out.println("test02");
	}
	
	@Test
	public void test03() {
		System.out.println("test03");
	}
	
	@Test
	public void test04() {
		System.out.println("test04");
	}
	
	@Test
	public void test05() {
		System.out.println("test05");
		logger.error("3和4");
		logger.debug("34不相等");
		Assert.assertEquals(1, 2);
		logger.error("不相等");
		logger.debug("不相等");
	}

}
