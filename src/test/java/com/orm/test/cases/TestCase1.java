package com.orm.test.cases;

import org.testng.annotations.Test;

import com.orm.base.BaseClass;
import com.orm.page.classes.LoginPage;

public class TestCase1 extends BaseClass {

	@Test(description = "Login Functionality with valid username and password")
	public void LoginFun() throws InterruptedException {

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.enterCred();
		lp.clickOnLoginbtn();
		Thread.sleep(5000);

	}

}
