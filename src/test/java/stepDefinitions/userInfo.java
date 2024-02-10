package stepDefinitions;


import factory.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

//import factory.BaseClass;

public class userInfo {
	public WebDriver driver;
	HomePage hp;
	String	file = System.getProperty("user.dir")+"\\Book.xlsx";
	
	@Given("the user is on page")
	public void the_user_is_on_page() throws InterruptedException {
	 driver = new ChromeDriver();
	 driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().window().maximize();	
	 String url = driver.getCurrentUrl();
	 // BaseClass.setup();
	 if(!url.equalsIgnoreCase("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx")) {
		 Thread.sleep(8000);
	 }else {
		 System.out.println("No authentication required");
	 }
	 }

	@When("user click on details")
	public void user_click_on_details() throws InterruptedException {                                                   
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='O365_MainLink_MePhoto']/div/div/div/div/div[2]")));
//	   img.click();
		hp = new HomePage(driver);
		hp.clickOnUserIcon();
		
	}

	@Then("user should see the details")
	public void user_should_see_the_details() throws IOException {
//	   String details = driver.findElement(By.xpath("//*[@id=\"mectrl_currentAccount_primary\"]")).getText();
//	   String id = driver.findElement(By.xpath("//*[@id='mectrl_currentAccount_secondary']")).getText();
//	   System.out.println("details--------------"+details+"id--------"+id);
		 System.out.println("details--------------"+hp.getuseName()+"id--------"+hp.getUserId());
		 //Setting up the sheet and row 
		 hp.setCellData(file, "User_Validation", 2, 1, hp.getuseName());
		 //Adding the data to the first row set
		 hp.setCellDataAgain(file, "User_Validation", 2, 6, hp.getUserId());
		 //Setting another row
		 hp.setCellRowAgain(file, "User_Validation", 0, 1, "User Name");
		 //Setting the data in the same row 
		 hp.setCellDataAgain(file, "User_Validation", 0, 6, "Email");
		 driver.close();
		 
	}
//	public static WebDriver getDriver() {
//		// TODO Auto-generated method stub
//		return driver;
//	}

}
