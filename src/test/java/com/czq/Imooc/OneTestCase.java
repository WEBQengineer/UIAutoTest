package com.czq.Imooc;

import org.testng.annotations.Test;
import com.czq.Imooc.util.ProUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;
import org.apache.log4j.Logger;



//@Listeners({TestNGListenerScreen.class})
public class OneTestCase {
	private static Logger logger = Logger.getLogger(OneTestCase.class);
	public WebDriver driver;

	@Test
	public void f() {
		System.out.println("this is test case");
	}

	@Test
	public void f1() {
		String UserName = "username";
		String user = null;
		String username;
		String password;
		ProUtil pro = new ProUtil("user.properties");
		int lines = pro.GetLines();
		for (int i = 0; i < lines; i++) {
			user = pro.GetPro("user" + i);
			WebElement EmailElement = GetElement2(UserName);
			WebElement PassWordElement = driver.findElement(By.name("password"));
			WebElement LoginButtonElement = driver.findElement(By.className("moco-btn-red"));
			username = user.split(">")[0];
			String[] p1 = user.split(">");
			System.out.println(p1.length);
			System.out.println("p1数组" + p1[0]);
			password = user.split(">")[1];

			System.out.println(username + "-----" + password);
			EmailElement.sendKeys(username);
			PassWordElement.sendKeys(password);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LoginButtonElement.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				WebElement logOk = driver.findElement(GetByLocal("id", "header-avator"));
				Actions MoseActions = new Actions(driver);
				MoseActions.moveToElement(logOk).perform();
				String headPic = driver.findElement(By.className("text-ellipsis")).getText();
//				if (headPic.equals("慕沐8217016")) {
//					System.out.println("登陆成功");
//				}else {
//					System.out.println("用户信息不匹配:"+headPic);
//				}
			}catch(Exception e) {
				System.out.println("登陆失败");
				Assert.assertEquals(1, 2);
			}
			EmailElement.clear();
			PassWordElement.clear();
		}
	}
	
	 
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "E:\\EduPac\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.imooc.com/user/newlogin/from_url/1023/");
	}

	@AfterClass
	public void afterClass() {
//		driver.close();
	}
	/**
	 * 
	 * @param method
	 * @param value
	 * @return
	 */
	public By GetByLocal(String method, String value) {
		if (method.equals("id")) {
			return By.id(value);
		} else if (method.equals("className")) {
			return By.className(value);
		} else if (method.equals("name")) {
			return By.name(value);
		} else {
			return null;
		}
	}

	public By GetByLocal2(String key) {
		ProUtil pro = new ProUtil("element.properties");
		String Locator = pro.GetPro(key);
		String LocatorBy = Locator.split(">")[0];
		String LocatorValue = Locator.split(">")[1];
		if (LocatorBy.equals("id")) {
			return By.id(LocatorValue);
		} else if (LocatorBy.equals("className")) {
			return By.className(LocatorValue);
		} else if (LocatorBy.equals("name")) {
			return By.name(LocatorValue);
		} else {
			return By.xpath(LocatorValue);
		}
	}

	/**
	 * 
	 * @param key properties文件的key
	 * @return
	 */
	public WebElement GetElement2(String key) {
		WebElement element = driver.findElement(this.GetByLocal2(key));
		return element;
	}

	public WebElement GetElement(String method, String value) {
		WebElement element = driver.findElement(this.GetByLocal(method, value));
		return element;
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("this is test beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("this is test afterTest");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is test beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("this is test afterMethod");
	}

}
