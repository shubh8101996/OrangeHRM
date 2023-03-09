package com.orm.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.orm.utility.PropertiesRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	PropertiesRead pr = new PropertiesRead();
	String BrowserVal = pr.Browser();
	public String URL = pr.URL();

	@BeforeTest
	public void BrowserSetup() {

		if (BrowserVal.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BrowserVal.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (BrowserVal.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (BrowserVal.equalsIgnoreCase("opera")) {

			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

		} else {

			System.out.println("browser value is wrong");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterTest
	public void Tearup() {

		driver.quit();

	}

	public void captureScreenShot(WebDriver driver, String testName) throws IOException {

		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//screenshots//" + testName + timestamp + ".png");

		FileUtils.copyFile(src, dest);
	}

}
