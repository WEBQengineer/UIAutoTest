package com.czq.Imooc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);//父类需要的driver
	}

	public WebElement GetEmailElement() {
		return GetElement("username");		
	}
	
	public WebElement GetPasswordElement() {
		return GetElement("password");			
	}
	
	public WebElement GetSenvenElement() {
		return GetElement("seven");		
	}
	
	public WebElement GetLoginButtonElement() {
		return GetElement("loginbutton");
	}
	
	/**
	 * 获取用户信息
	 * @return
	 */	
	public WebElement GetUserName() {
		return GetElement("userinfo");
	}
	
	/**
	 * 右上角图片
	 * @return
	 */
	public WebElement GetUserPicture() {
		return GetElement("headpng");
	}
}
