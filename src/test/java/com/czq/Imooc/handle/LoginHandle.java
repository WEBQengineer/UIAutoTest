package com.czq.Imooc.handle;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.czq.Imooc.page.LoginPage;

public class LoginHandle {
	public LoginPage loginpage;
	
	public LoginHandle(WebDriver driver) {
		loginpage = new LoginPage(driver);
	}
	
	public void sendEmail(String email) {
		loginpage.GetEmailElement().sendKeys(email);
	}
	
	public void sendPassword(String password) {
		loginpage.GetPasswordElement().sendKeys(password);
	}
	
	public void ClickSeven() {
		loginpage.GetSenvenElement().click();
	}
	
	public void ClickLogin() {
		loginpage.GetLoginButtonElement().click();
	}
	
	
	public void GetUserinfoAndContrast() {
		WebElement ui = loginpage.GetUserPicture();
		loginpage.MoveToElement(ui);
	}
	
	public String GetUserinfoText() {
		WebElement ele = loginpage.GetUserName();
		String userName = ele.getText();
		return userName;
	}

}
