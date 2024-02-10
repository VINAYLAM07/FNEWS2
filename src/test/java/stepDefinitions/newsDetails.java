package stepDefinitions;


import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.NewsPage;

public class newsDetails {
	public static WebDriver driver;
	HomePage hp;
	HomePage hp1;
	HomePage hp2;
	NewsPage np;
	String	file = System.getProperty("user.dir")+"\\Book.xlsx";
	public static String heading1, heading2,heading3,heading4,heading5,
	acthd1,acthd2,acthd3,acthd4,acthd5,
	content1,content2,content3,content4,content5,
	tooltip1,tooltip2,tooltip3,tooltip4,tooltip5;
	@Given("the news block is displayed")
	public void the_news_block_is_displayed() throws InterruptedException {
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
	    hp = new HomePage(driver);
	    boolean news = hp.isNewsDisplayed();
		Assert.assertTrue(news);
	    if(news){
	    	System.out.println("news is displayed");
	    }else {
	    	System.out.println("news is not displayed");
	    }
	}

	@When("print count of total no of news")
	public void print_count_of_total_no_of_news() throws IOException {
		System.out.println("div--------");
		System.out.println(hp.getNews());
		System.out.println(hp.getNewsCount());
		
		hp.setNewSheet(file, "News_Validation", 0, 1, "Count of news displayed");
		hp.setCellRowAgain(file, "News_Validation", 2, 1, hp.getNewsCount());
	}

	@When("print the headers of all news displayed")
	public void print_the_headers_of_all_news_displayed() throws IOException {
		List<WebElement> newst = hp.getNewsList();
		String[] linkTexts = new String[newst.size()];
		
	     for (int i = 0; i < newst.size(); i++) {
	         linkTexts[i] = newst.get(i).getText();    
	     }
	     
	     for (String linkText : linkTexts) {
	         System.out.println(linkText);
	     }
	     heading1 = linkTexts[0];
	     heading2 = linkTexts[1];
	     heading3 = linkTexts[2];
	     heading4 = linkTexts[3];
	     heading5 = linkTexts[4];  
	     hp.setCellDataAgain(file, "News_Validation", 0, 5, "News Heading on HomePage");
	     hp.setCellDataAgain(file, "News_Validation", 2, 5, heading1);
	     hp.setCellRowAgain(file, "News_Validation", 3, 5, heading2);
	     hp.setCellRowAgain(file, "News_Validation", 4, 5, heading3);
	     hp.setCellRowAgain(file, "News_Validation", 5, 5, heading4);
	     hp.setCellRowAgain(file, "News_Validation", 6, 5, heading5);
	}
	@Given("all the news is displayed and there related info")
	public void all_the_news_is_displayed_and_there_related_info() {

		List<WebElement> newst  = driver.findElements(By.xpath("//div[@data-automation-id='HeroPatternElement']"));
	}

	@When("clicking the news one by one")
	public void clicking_the_news_one_by_one() throws IOException {
		hp1 = new HomePage(driver);
		np = new NewsPage(driver);
		//1
		hp1.clickOnNews1();
		acthd1 = np.getHead();
		content1 = np.getNews();
//        String title1 = hp1.getTitle();
//		System.out.println("heading  "+acthd1+"title after---"+title1);
//		System.out.println("divyesh---"+content1);
		hp.setCellDataAgain(file, "News_Validation", 0, 7, "News Heading on Each Page");
		hp.setCellDataAgain(file, "News_Validation", 2, 7, acthd1);
		hp.setCellDataAgain(file, "News_Validation", 0, 15, "News Content--");
		hp.setCellDataAgain(file, "News_Validation", 2, 15, content1);
		
		//2
		hp1.clickOnNews2();
		acthd2 = np.getHead();
//		String title2 = hp1.getTitle();
		content2 = np.getNews();
		hp.setCellDataAgain(file, "News_Validation", 3, 7, acthd2);
		hp.setCellDataAgain(file, "News_Validation", 3, 15, content2);
//		System.out.println("heading  "+acthd2+"title after---"+title2);
//		System.out.println("second content--------"+content2);
		
		//3
		hp1.clickOnNews3();
		acthd3 = np.getHead();
		content3 = np.getNews();
//		String title3 = hp1.getTitle();
		hp.setCellDataAgain(file, "News_Validation", 4, 7, acthd3);
		hp.setCellDataAgain(file, "News_Validation", 4, 15, content3);
//		System.out.println("heading  "+acthd3+"title after---"+title3);
//		System.out.println("third content--------"+content3);
		
		//4
		hp1.clickOnNews4();
		acthd4 = np.getHead();
		content4 = np.getNews();
//		String title4 = hp1.getTitle();
		hp.setCellDataAgain(file, "News_Validation", 5, 7, acthd4);
		hp.setCellDataAgain(file, "News_Validation", 5, 15, content4);
//		System.out.println("heading  "+acthd4+"title after---"+title4);
//		System.out.println("fourth content--------"+content4);
	
	
	   //5
		hp1.clickOnNews5();
		acthd5 = np.getHead();
		content5 = np.getNews();
//		String title5 = hp1.getTitle();
		hp.setCellDataAgain(file, "News_Validation", 6, 7, acthd5);
		hp.setCellDataAgain(file, "News_Validation", 6, 15, content1);
//		System.out.println("heading  "+acthd5+"title after---"+title5);
//		System.out.println("fifth content--------"+content5);
	}

	@Then("validating the data is relevent to the link clicked")
	public void validating_the_data_is_relevent_to_the_link_clicked() {
	    System.out.println("heading----"+heading1+"=="+heading2+"=="+heading3+"=="+heading4+"=="+heading5);
	    System.out.println(acthd1+acthd2+acthd3+acthd4+acthd5);
	    Assert.assertEquals(heading1, acthd1);
	    Assert.assertEquals(heading2, acthd2);
	    Assert.assertEquals(heading3, acthd3);
	    Assert.assertEquals(heading4, acthd4);
	    Assert.assertEquals(heading5, acthd5);
	}
	@Given("all the news are displayed")
	public void all_the_news_are_displayed() {
		hp2 = new HomePage(driver);
		List<WebElement> newst = hp2.getNewsList();
		String[] linkTexts = new String[newst.size()];
		System.out.println("size--"+newst.size());
  
	}

	@When("on mouse hover the tooltip appears")
	public void on_mouse_hover_the_tooltip_appears() {

		System.out.println("list----"+hp2.getToolTipsCount());
	}

	@Then("validate each tooltip with it's headline")
	public void validate_each_tooltip_with_it_s_headline() throws IOException {
		List<WebElement> news = hp2.getNewsList();
	    System.out.println("list----"+news.size());
	    String[] listOfNews = new String[5];
	    for(int j=0;j<5;j++) {
	    	listOfNews[j] = news.get(j).getText();
	    }
	    tooltip1 = listOfNews[0];
	    tooltip2 = listOfNews[1];
	    tooltip3 = listOfNews[2];
	    tooltip4 = listOfNews[3];
	    tooltip5 = listOfNews[4];
	    Assert.assertEquals(heading1, tooltip1);
	    Assert.assertEquals(heading2, tooltip2);
	    Assert.assertEquals(heading3, tooltip3);
	    Assert.assertEquals(heading4, tooltip4);
	    Assert.assertEquals(heading5, tooltip5);
	    hp.setCellDataAgain(file, "News_Validation", 0, 9, "ToolTip of every news--");
	    hp.setCellDataAgain(file, "News_Validation", 2, 9, tooltip1);
	    hp.setCellDataAgain(file, "News_Validation", 3, 9, tooltip2);
	    hp.setCellDataAgain(file, "News_Validation", 4, 9, tooltip3);
	    hp.setCellDataAgain(file, "News_Validation", 5, 9, tooltip4);
	    hp.setCellDataAgain(file, "News_Validation", 6, 9, tooltip5);
	    
	    for(String name: listOfNews) {
	    	System.out.println("final----------"+name);
	    }
	    driver.close();
	}

}

