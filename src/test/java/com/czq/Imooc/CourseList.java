package com.czq.Imooc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.czq.Imooc.util.ProUtil;

public class CourseList {
	public WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "E:\\EduPac\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("https://coding.imooc.com/");
		driver.get("https://coding.imooc.com/?c=fe");
        driver.manage ().window ().maximize ();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	/**
	 * 遍历慕课网课程列表
	 */
	@Test
	public void test02() {
		List<Integer> pageNum = GetPageNum();
		for (int j=0; j<pageNum.size()-1; j++) {
			List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
			for (int i = 0; i < courseList.size(); i++) {
				i = courseList.size()-1;
				((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
				ProUtil.threadSleep(1.5);
				driver.findElement(By.className("js-close")).click();
				courseList.get(i).click();
				ProUtil.threadSleep(1);
				driver.navigate().back();
				courseList = driver.findElements(By.className("shizan-name"));
			}
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
			ProUtil.threadSleep(1);
//			driver.findElement(By.linkText("下一页")).click();
			driver.findElement(By.partialLinkText("下一")).click();
		}
	}
	
	/**
	 * 获取页码集合
	 * @return
	 */
	public List<Integer> GetPageNum() {
		List<WebElement> pageList = driver.findElement(By.className("page")).findElements(By.tagName("a"));
		List<Integer> aElementList = new ArrayList<Integer>();
		for (WebElement aElement : pageList) {
			String pageName = aElement.getText();
			if (isNumber(pageName) == true) {
				aElementList.add(Integer.valueOf(pageName).intValue());
			}
		}
		return aElementList;
	}
	
	/**
	 * 判断输入是否是数字
	 * @param pageNum
	 * @return
	 */
	public boolean isNumber(String pageNum) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher m = pattern.matcher(pageNum);
		if (m.matches()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取Webelement名字集合
	 * @return
	 */
	public List<String> ListCourseTitle() {
		List<String> listCourseTitle = new ArrayList<String>();
		List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
		for (WebElement courseName : courseList) {
			listCourseTitle.add(courseName.getText());
		}
		return listCourseTitle;
	}

}
