package com.orm.test.cases;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.orm.base.BaseClass;
import com.orm.base.Lister;
import com.orm.page.classes.LoginPage;

@Listeners(Lister.class)
public class TestCase1 extends BaseClass {

	@Test(description = "Login Functionality with valid username and password")
	public void LoginFun() throws InterruptedException, IOException {

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.enterCred();
		lp.clickOnLoginbtn();
		Thread.sleep(3000);
		captureScreenShot(driver, "loginFun");
		

	}

}
