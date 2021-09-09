package com.runnertest.com;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.FBLogin.helper.FileReadManager;
import com.projectmaven.FBcucumber.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\com\\feature\\com",
					glue="com.stepdefinition.com",
					monochrome = true,
					plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Report/FBlogintest.html",
								"pretty"})

public class RunTest {
	public static WebDriver driver;
	@BeforeClass
	public static void Setup() throws Throwable {
		
		String browser = FileReadManager.getInstanceFR().getInstanceCR().getBrowser();
		driver = BaseClass.BrowserLaunch(browser);
	}
	
	@AfterClass
	public static void Teardown() {
		driver.close();
	}

}
