package com.czq.Imooc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;


@Listeners({TestNGListenerScreen.class})
public class TestngCase {
      private static Logger logger = Logger.getLogger(TestngCase.class);
	  public WebDriver driver;
	
	  @Test
	  public void test01() {
		  logger.debug("1111asdasdasd");
		  System.out.println("第一个case");
	  }
	  @Test
	  public void test02() {
//		  Assert.assertEquals(1, 2);
		  System.out.println("第二个case");
	  }
	  @Test
	  public void test03() {
		  System.out.println("第一个case");
	  }
	  @BeforeClass
	  public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", "E:\\EduPac\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.imooc.com/user/newlogin/from_url/1023/");
		  PropertyConfigurator.configure("log4j.properties");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.close();
		  SendToEmail();
	  }
	
	  @BeforeTest
	  public void beforeTest() {
	  }
	
	  @AfterTest
	  public void afterTest() {
	  }

	  public void SendToEmail(){
		  SimpleEmail email = new SimpleEmail();
		  email.setHostName("smtp.163.com");
		  email.setAuthentication("a17604515131@163.com", "111111a");
		  try {
			email.setFrom("a17604515131@163.com");
			email.addTo("a18846768058@163.com");
			email.setSubject("seleniumm subject");
			email.setMsg("this is test chenzhiqiang");
			email.send();
			logger.debug("邮件发送成功");
//			logger.error("邮件发送成功");
			System.out.println("邮件发送成功");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	  }
	  
}
