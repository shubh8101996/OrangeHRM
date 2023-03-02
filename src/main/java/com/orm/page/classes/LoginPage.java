package com.orm.page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orm.utility.PropertiesRead;

public class LoginPage {

	PropertiesRead pr = new PropertiesRead();

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginbtn;
	
	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMsg;

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void enterCred() {

		username.sendKeys(pr.Username());
		password.sendKeys(pr.Password());

	}

	public void enteruser(String user) {

		username.sendKeys(user);

	}

	public void enterpass(String pass) {

		password.sendKeys(pass);

	}

	public void clickOnLoginbtn() {

		loginbtn.click();

	}
	
	
	public String ErrorMsg() {
		
		String msg=errorMsg.getText();
		
		return msg;
		
	}

}
