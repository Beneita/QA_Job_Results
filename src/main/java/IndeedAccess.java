import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedAccess {
	// Variable declaration
	private static final String URL="https://www.indeed.fr/";
	private static final String PATH_CHROME_DRIVER="C:\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	
	public IndeedAccess(){
		// Default constructor
	}
	
	public static void openIndeed() {
		// Open Home page
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        driver = new ChromeDriver();        
        driver.get(URL);
	}
	
	public static void closeIndeed() {
		// Close Home page
		driver.close();
	}
	
	public static void enterKeywordsWhat() {
		// Enter the Keywords for the job 
		driver.findElement(By.id("text-input-what")).sendKeys("testeur logiciel");
	}
	
	public static void enterKeywordsWhere() {
		// Enter the Keywords for the location		
		WebElement text= driver.findElement(By.xpath("//*[@id=\"text-input-where\"]"));		
		text.sendKeys(Keys.chord(Keys.CONTROL,"a"),"Alpes-maritimes");	
	}
	
	public static void clickSearch() {
		// Click on the button "Rechercher"
		WebElement element = driver.findElement(By.xpath("//*[@id=\"whatWhere\"]/div/div/form/div[3]/button"));
		element.click();		
	}	
	
	public static void pause(int seconds) {
		// Explicit wait
		 try {
			Thread.sleep(seconds*1000);
		 }catch(InterruptedException ex) {
			 Thread.currentThread().interrupt();
		 }
	 }
	
}
