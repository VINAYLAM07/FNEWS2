package pageObjects;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fi;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//ELEMENTS
	By beCognizant = By.xpath("//*[@id=\"id__6\"]");
	
	By userIcon=By.xpath("//*[@id='O365_MainLink_MePhoto']/div/div/div/div/div[2]");
	
	By userName=By.xpath("//*[@id='mectrl_currentAccount_primary']");
	
	By userId=By.xpath("//*[@id='mectrl_currentAccount_secondary']");
	
	By newsD=By.xpath("//*[@data-automation-id='CanvasControl' and @id='4f7e87d5-f184-4501-8008-0ee4b0a38fcf']");
	
	By newsList = By.xpath("//div[@data-automation-id='HeroPatternElement']");
	
	By appsAndToolsTitle = By.xpath("//*[@id='QuicklinksItemTitle']");
	
	By AppsandTools = By.xpath("//*[@id='vpc_WebPart.QuickLinksWebPart.internal.89c5ffca-2ffb-4052-a723-e99c8c9a14ef']/div/div/div/div[2]");
	
	By news1 = By.xpath("//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[1]");
	
	By news2 = By.xpath("//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[2]");
	
	By news3 = By.xpath("//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[3]");
	
	By news4 = By.xpath("//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[4]");
	
	By news5 = By.xpath("//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[5]");
	
	By tooltips = By.xpath("//*[@id='news_text_title']");
	By settingIcon  = By.xpath("//*[@id='O365_MainLink_Settings']/div");
	By scroll =  By.xpath("//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong");
	
	//ACTION METHODS
	public void clickOnUserIcon() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement setting = wait.until(ExpectedConditions.visibilityOfElementLocated(settingIcon));
	    Thread.sleep(3000);
		WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(userIcon));
		img.click();
		
	}
	public String getuseName() {
		return driver.findElement(userName).getText();
	}
	public String getUserId() {
		return driver.findElement(userId).getText();
	}
	public String[] getAppsandToolsTitle() {
		WebElement appAndTool=driver.findElement(scroll);
		JavascriptExecutor j= (JavascriptExecutor)driver;
        j.executeScript("arguments[0].scrollIntoView();",appAndTool);
        List<WebElement> names = driver.findElements(appsAndToolsTitle);
        String[] name = new String[15];
        for(int i =0;i<names.size();i++) {
        	name[i] = names.get(i).getText();
        }

		return name;
	}
	public String getAppsandTools() {
		  return driver.findElement(AppsandTools).getText();	 
	}
	public boolean isNewsDisplayed() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement newsDD = wait.until(ExpectedConditions.visibilityOfElementLocated(newsD));
	    return newsDD.isDisplayed();
//		return driver.findElement(newsD).isDisplayed();
	}
	public WebElement getnewsD() {
		return driver.findElement(newsD);
	}
	
	public String getNews() {
		  String news =  driver.findElement(newsList).getText();	
		  return news;
	}
	public String getNewsCount() {
		  List<WebElement> news =  driver.findElements(newsList);	
		  int num = news.size();
		  return String.valueOf(num);
	}
	public List<WebElement> getNewsList() {
		  return driver.findElements(newsList);	
		  
	}
	public void clickOnNews1() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement news11 = wait.until(ExpectedConditions.visibilityOfElementLocated(news1));
	    news11.click();	
	    
	}
//	public String getHead() {
//		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		WebElement head11 =wait.until(ExpectedConditions.visibilityOfElementLocated(head));
//		String s =  head11.getText();
//		driver.navigate().back();
//		WebElement ex1 = wait.until(ExpectedConditions.visibilityOfElementLocated(newsD));
//		return s;
//	}
	public String getTitle() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String TitleWait = wait.until(ExpectedConditions.visibilityOfElementLocated(newsD)).getText();
		String mainTitle = driver.getTitle();
	    return mainTitle;		    
	}

	public void clickOnNews2() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,3000)","");
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement news22 = wait.until(ExpectedConditions.visibilityOfElementLocated(news2));
	    news22.click();	 
	}
	public void clickOnNews3() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement news33 = wait.until(ExpectedConditions.visibilityOfElementLocated(news3));
	    news33.click();	
	    
	}
	public void clickOnNews4() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement news44 = wait.until(ExpectedConditions.visibilityOfElementLocated(news4));
	    news44.click();	
	    
	}
	public void clickOnNews5() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement news55 = wait.until(ExpectedConditions.visibilityOfElementLocated(news5));
	    news55.click();	
	    
	}
	public List<WebElement> getToolTips() {
		return driver.findElements(tooltips);
	}
	public int getToolTipsCount() {
		List<WebElement> toolTipsCount = driver.findElements(tooltips);
		int toolcount  = toolTipsCount.size();
		return toolcount; 
		
	}
    public static void setCellData(String file,String xlsheet,int rownum,int colnum,String data) throws IOException{
		fo=new FileOutputStream(file);
		wb=new XSSFWorkbook();
		ws=wb.createSheet(xlsheet);
		row=ws.createRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		wb.write(fo);		
		wb.close();
		fo.close();
	}
    public static void setCellDataAgain(String file,String xlsheet,int rownum,int colnum,String data) throws IOException{
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(file);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
    public static void setCellRowAgain(String file,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.createRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(file);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
    public static void setNewSheet(String file,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.createSheet(xlsheet);
		row=ws.createRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(file);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	public void closeWindow() {
		driver.close();
	}
    
    
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//	WebElement news1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf']/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[1]/a/img")));
//	news1.click();
//	WebElement head1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='title_text']")));
//	acthd1 = head1.getText();
//	driver.navigate().back();
//	WebElement ex = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='CanvasControl' and @id='4f7e87d5-f184-4501-8008-0ee4b0a38fcf']")));
//	String title = driver.getTitle();
//	System.out.println("heading  "+acthd1+"title after---"+title);
//	
	
}	
