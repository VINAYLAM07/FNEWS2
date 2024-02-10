package stepDefinitions;


import java.io.IOException;

import java.time.Duration;


//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class appsAndTools {
	public static WebDriver driver;
	String	file = System.getProperty("user.dir")+"\\Book.xlsx";
	HomePage hp;
	@Given("be on the be cognizant page")
	public void be_on_the_be_cognizant_page() throws InterruptedException {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		String url = driver.getCurrentUrl();
		 // BaseClass.setup();
		 if(!url.equalsIgnoreCase("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx")) {
			 Thread.sleep(8000);
		 }else {
			 System.out.println("No authentication required");
		 }
	}

	@When("go to all the apps and tools")
	public void go_to_all_the_apps_and_tools() throws IOException {

		hp = new HomePage(driver);
		String[] list = hp.getAppsandToolsTitle();
		
		System.out.println(list[1]+"7-------"+list[7]+"list6---"+list[6]);
		hp.setNewSheet(file, "AppsAndTools", 0, 1, "Apps and Tools List");
		hp.setCellRowAgain(file, "AppsAndTools", 2, 1, list[6]);
		hp.setCellRowAgain(file, "AppsAndTools", 3, 1, list[7]);
		hp.setCellRowAgain(file, "AppsAndTools", 4, 1, list[8]);
		hp.setCellRowAgain(file, "AppsAndTools", 5, 1, list[9]);
		hp.setCellRowAgain(file, "AppsAndTools", 6, 1, list[10]);
		hp.setCellRowAgain(file, "AppsAndTools", 7, 1, list[11]);
		hp.setCellRowAgain(file, "AppsAndTools", 8, 1, list[12]);
		hp.setCellRowAgain(file, "AppsAndTools", 9, 1, list[13]);
		hp.setCellRowAgain(file, "AppsAndTools", 10, 1, list[14]);
		
		
	}

	@Then("names of all the apps and tools")
	public void names_of_all_the_apps_and_tools() {
		
		System.out.println("names----------"+hp.getAppsandToolsTitle());	
		driver.close();
	}
}

