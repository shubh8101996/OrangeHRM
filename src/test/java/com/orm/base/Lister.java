package com.orm.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orm.utility.PropertiesRead;

public class Lister implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	PropertiesRead pr;
	BaseClass b;

	public void configureReport() {

		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "Batch48" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		pr = new PropertiesRead();

		reports.setSystemInfo("Machine", "Hp PC");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Browser", pr.Browser());
		reports.setSystemInfo("username", "Shubham Shedge");

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Reports of batch 48");
		htmlReporter.config().setDocumentTitle("This is reports of Batch 48");

	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Name of test method is started: " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Name of test method succesfully excuted: " + result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: "+result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Name of test method failed: " + result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+result.getName(), ExtentColor.RED));

        b=new BaseClass();
        try {
			b.captureScreenShot(BaseClass.driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Name of test method Skipped: " + result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case is: "+result.getName(), ExtentColor.ORANGE));

	}

	@Override
	public void onStart(ITestContext context) {

		configureReport();
		System.out.println("On start Method invoked: ");

	}

	@Override
	public void onFinish(ITestContext context) {

		reports.flush();

	}

}
