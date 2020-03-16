package com.czq.Imooc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.czq.Imooc.runcase.BaseCase;
import com.google.common.io.Files;

public class TestNGListenerScreen extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		BaseCase tc = (BaseCase)tr.getInstance();
		WebDriver driver = tc.driver;
		this.TakeScreenShot(driver);
		super.onTestFailure(tr);
	}
	
	/**
	 * 截图
	 */
	public void TakeScreenShot(WebDriver driver) {
		File ScrFile = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String cruTime = sdf.format(new Date());
		//获取当前类名
		String curClassName = this.getClass().getName();
		//工程路径
		String curPath = System.getProperty("user.dir");
		
		String pngPath = curClassName + "_" + cruTime + ".png";
		
		try {
			Files.copy(ScrFile, new File(curPath + "\\" + pngPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
