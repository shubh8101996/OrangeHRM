package com.orm.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orm.base.BaseClass;
import com.orm.page.classes.LoginPage;

public class TestCase2 extends BaseClass {

	@Test(description = "Login Functionality with Invalid username and Invalid password")
	public void LoginFun() throws InterruptedException {

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.enteruser("Admin");
		lp.enterpass("admin123");
		lp.clickOnLoginbtn();
//		Thread.sleep(2000);
		Assert.assertEquals(lp.ErrorMsg(), "Invalid credentials");

	}

}
