package pageObjects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {
	WebDriver driver;
	WebDriverWait wait;

	public NewsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By head = By.xpath("//*[@id='title_text']");
	By info = By.xpath("//*[@id='spPageCanvasContent']/div/div/div/div/div/div/div/div[1]");
	By button = By.xpath("//*[@id='spTopPlaceholder']/div/div[2]/div/div/div/div/div/div/div[1]/a/span");
	
	public String getHead() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement head11 =wait.until(ExpectedConditions.visibilityOfElementLocated(head));
		String s =  head11.getText();
//		driver.navigate().back();
		return s;
	}
	public String getNews() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement head11 =wait.until(ExpectedConditions.visibilityOfElementLocated(info));
		String i =  head11.getText();
//		driver.navigate().back();
		WebElement beCogniBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(button));
		beCogniBtn.click();
		return i;
	}

}
