package com.czq.Imooc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.czq.Imooc.util.ProUtil;

public class SeleniumMaven {
	
	public WebDriver driver;
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver","E:\\EduPac\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.imooc.com/user/newlogin/from_url/1023/");
	}
	@Test
	public void UserLogin() {
		String UserName = "username";
		String user = null;
		String username;
		String password;
		ProUtil pro = new ProUtil("user.properties");
		int lines = pro.GetLines();
		for (int i = 0; i < lines; i++) {
			InitDriver();
			user = pro.GetPro("user"+ i);
			WebElement EmailElement = GetElement2(UserName);
			WebElement PassWordElement = driver.findElement(By.name("password"));
			WebElement LoginButtonElement = driver.findElement(By.className("moco-btn-red"));
			username = user.split(">")[0];
			String[] p1 = user.split(">");
			System.out.println(p1.length);
			System.out.println("p1数组"+p1[0]);
			password = user.split(">")[1];

			System.out.println(username + "-----" + password);
			EmailElement.sendKeys(username);
			PassWordElement.sendKeys(password);
			LoginButtonElement.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			WebElement logOk = driver.findElement(GetByLocal("id","header-avator"));
			Actions MoseActions = new Actions(driver);
			MoseActions.moveToElement(logOk).perform();
			String headPic = driver.findElement(By.className("text-ellipsis")).getText();
			if (headPic.equals("慕沐8217016")) {
				System.out.println("登录OK");
			}else {
				System.out.println("登录失败");
			}			
		}
		
//		driver.close();		
	}

	public By GetByLocal(String method, String value) {
		if (method.equals("id")) {
			return By.id(value);
		}else if(method.equals("className")){
			return By.className(value);
		}else if(method.equals("name")){
			return By.name(value);
		}else {
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
		}else if(LocatorBy.equals("className")){
			return By.className(LocatorValue);
		}else if(LocatorBy.equals("name")){
			return By.name(LocatorValue);
		}else {
			return By.xpath(LocatorValue);
		}
	}
	/**
	 * 
	 * @param key  properties文件的key
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
	

}
