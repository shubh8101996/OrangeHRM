package com.orm.page.classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PimClassPage {
	
	
	

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
	private WebElement addbtn;
	
	@FindBy(name = "firstName")
	private WebElement firstName;
	
	@FindBy(name = "middleName")
	private WebElement middleName;
	
	@FindBy(name = "lastName")
	private WebElement lastName;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement id;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	private WebElement savebtn;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]")
	private WebElement cancelbtn;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button/i")
	private WebElement addphoto;
	

}
