package com.projectmaven.FBcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMfbLogin {

	@FindBy(id = "email")
	private WebElement Username;
	

	public POMfbLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginBut() {
		return LoginBut;
	}

	@FindBy(id ="pass")
	private WebElement Password;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")
	private WebElement LoginBut;
	
}
