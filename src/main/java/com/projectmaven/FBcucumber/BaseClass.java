package com.projectmaven.FBcucumber;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	static WebDriver driver;
//browser launch 
	public static WebDriver BrowserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\LINGARAJ\\eclipse-workspace\\SeleniumProject\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\LINGARAJ\\eclipse-workspace\\StudentDetails\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("Invalid Input");
		}
		
		driver.manage().window().maximize();
		return driver;
	}
//close
	public static void Browserclose() {
		driver.close();
	}
//quit
	public static void BrowserQuit() {
		driver.quit();
	}
//navigate
	public static void navigateOptions(String options, String url) {
		if (options.equalsIgnoreCase("navigateTo")) {
			driver.navigate().to(url);
		}else if (options.equalsIgnoreCase("navigateback")) {
			driver.navigate().back();
		}else if (options.equalsIgnoreCase("navigateforward")) {
			driver.navigate().forward();
		}else if (options.equalsIgnoreCase("navigateRefresh")) {
			driver.navigate().refresh();
		}
	}
//get
	public static void BrowserUrlLaunch(String url) {
		driver.get(url);
	}
//alert
	public static void AlertTypes(String AlertType, String popup) {
		if (AlertType.equalsIgnoreCase("simplealert") && 
				popup.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		}else if (AlertType.equalsIgnoreCase("confirmAlert") && 
				popup.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		}else if (AlertType.equalsIgnoreCase("confirmalert") && 
				popup.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();
		}else if (AlertType.equalsIgnoreCase("promptalert")) {
			Alert prompt = driver.switchTo().alert();
			prompt.sendKeys(popup);
			prompt.accept();
		}
	}
//action
	public static void ActionClass(WebElement element, String Mouseactions) {
		Actions act = new Actions(driver);
		if (Mouseactions.equalsIgnoreCase("GoToElement")) {
			act.moveToElement(element).build().perform();
		}else if (Mouseactions.equalsIgnoreCase("Doubleclick")) {
			act.doubleClick(element).build().perform();
		}else if (Mouseactions.equalsIgnoreCase("rightclick")) {
			act.contextClick().build().perform();
		}
	}
//framebasedonelement
	public static void FrameBasedElement(WebElement element) {
		driver.switchTo().frame(element);
	}
//framebasedonIndex
	public static void FramebasedIndex() {
		driver.switchTo().frame(0);
	}
//robotclass
	public static void robotClass(String options) throws AWTException {
		Robot rob = new Robot();
		if (options.equalsIgnoreCase("enter")) {
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
		} else if (options.equalsIgnoreCase("keydown")) {
			rob.keyPress(KeyEvent.VK_DOWN);
			rob.keyRelease(KeyEvent.VK_DOWN);
		}
	}

//clickthelement
	public static void clickthelement(WebElement element) {
		element.click();
	}
//windowHanding
	public static void singlewindowHandle() {
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
	}
	
	public static void Multiwindowhandling(String title) {
	Set<String> windowHandles = driver.getWindowHandles();
	for (String str : windowHandles) {
		String text = driver.switchTo().window(str).getTitle();
		System.out.println(text);
	}
	
	for (String str : windowHandles) {
		driver.switchTo().window(str).getTitle().equalsIgnoreCase(title);
		break;
	}
}
	
//dropdown
	public static void DropDownBox(WebElement element, String selectOptions, String value, int index) {
		if (selectOptions.equalsIgnoreCase("value")) {
			Select s = new Select(element);
			s.selectByValue(value);
		}else if (selectOptions.equalsIgnoreCase("index")) {
			Select s = new Select(element);
			s.selectByIndex(index);
		}else if (selectOptions.equalsIgnoreCase("visibletext")) {
			Select s = new Select(element);
			s.selectByVisibleText(value);
		}
	}
	
//passtheValues
	public static void passtheValues(WebElement element, String values) {
		element.sendKeys(values);
	}
//checkbox
	public static void clickingcheckbox(WebElement element) {
		element.click();
	}
	
//implicitWait
	public static void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

//explicitWait
	
	public static void explicitWait(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
//Screenshot
	public static void Screenshot(String Storagepath) throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File(Storagepath);
		FileUtils.copyFile(src, dest);
	}

//javasciptsOptionsScroll
	public static void javascriptsScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}
	
	public static void javascriptsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", element);
	}
}
