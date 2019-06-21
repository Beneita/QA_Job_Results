import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import annex_data.HomePageConstants;

public class HomePageAcess {	
	
	public HomePageAcess() {
		//Default constructor
	}
	public void openHomePage(String URL) {
		// Open Home page
		MyDriver.driver.manage().window().maximize();
		MyDriver.driver.get(URL);
	}
	

	/*public void enterKeywordsWhat() {
		// Enter the Keywords for the job
		MyDriver.driver.findElement(By.id("text-input-what")).sendKeys("testeur logiciel");
	}*/
	
	public void enterKeywordsWhat(String str) {
		// Enter the Keywords for the job		
        switch(str) 
        { 
            case "HomePageConstants.INDEED_HOME_PAGE": 
                System.out.println("Requête sur Indeed"); 
                MyDriver.driver.findElement(By.id("text-input-what")).sendKeys("testeur logiciel");
                break; 
            case "HomePageConstants.APEC_HOME_PAGE": 
                System.out.println("Requête sur Apec"); 
                MyDriver.driver.findElement(By.id("keywords")).sendKeys("testeur logiciel");
                break; 
            case "HomePageConstants.METEOJOB_HOME_PAGE": 
                System.out.println("Requête sur MeteoJob"); 
                break; 
            default: 
                System.out.println("unknow job site"); 
        } 
		
	}

	public void enterKeywordsWhere() {
		// Enter the Keywords for the location
		WebElement text = MyDriver.driver.findElement(By.xpath("//*[@id=\"text-input-where\"]"));
		text.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Alpes-maritimes");
	}

	public void clickSearchIndeed() {
		// Click on the button "Rechercher"
		WebElement element = MyDriver.driver.findElement(By.xpath("//*[@id=\"whatWhere\"]/div/div/form/div[3]/button"));
		element.click();
	}
	public void clickSearchApec() {
		// Click on the button "Rechercher"
		WebElement element = MyDriver.driver.findElement(By.xpath("//*[@id=\"section-recherche\"]/div[2]/div[1]/form/div[2]/button"));
		element.click();
	}
	
	public void openNewTab() {
		//open a new Tab
		((JavascriptExecutor)MyDriver.driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(MyDriver.driver.getWindowHandles());
		MyDriver.driver.switchTo().window(tabs.get(1));
	}

	public static void pause(int seconds) {
		// Explicit wait
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void closeHomePage() {
		// close home Page
		MyDriver.driver.close();
	}

	
}
