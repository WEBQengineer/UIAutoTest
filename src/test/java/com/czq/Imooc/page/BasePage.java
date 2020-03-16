package com.czq.Imooc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.czq.Imooc.util.ProUtil;

public class BasePage {
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * 获取WebElment
	 * @param key
	 * @return
	 */
	public WebElement GetElement(String key) {
		WebElement element = driver.findElement(this.GetByLocal(key));
		return element;
	}
	/**
	 * 获取By
	 * @param key
	 * @return
	 */
	public By GetByLocal(String key) {
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
	
	public void MoveToElement(WebElement element) {
		Actions MoseActions = new Actions(driver);
		MoseActions.moveToElement(element).perform();
	}
}
