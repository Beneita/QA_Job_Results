
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import annex_data.HomePageConstants;

public class IndeedAccess {
	//private static final String URL = "https://www.indeed.fr/";
	//private static final String URL = HomePageConstants.INDEED_HOME_PAGE;
	//private static final String URL = HomePageConstants.APEC_HOME_PAGE;
	private static final String URL = HomePageConstants.METEOJOB_HOME_PAGE;
	
	public IndeedAccess() {

	}

	public void openIndeed() {
		// Open Home page

		MyDriver.driver.manage().window().maximize();
		MyDriver.driver.get(URL);
	}

	public void enterKeywordsWhat() {
		// Enter the Keywords for the job
		MyDriver.driver.findElement(By.id("text-input-what")).sendKeys("testeur logiciel");
	}

	public void enterKeywordsWhere() {
		// Enter the Keywords for the location
		WebElement text = MyDriver.driver.findElement(By.xpath("//*[@id=\"text-input-where\"]"));
		text.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Alpes-maritimes");
	}

	public void clickSearch() {
		// Click on the button "Rechercher"
		WebElement element = MyDriver.driver.findElement(By.xpath("//*[@id=\"whatWhere\"]/div/div/form/div[3]/button"));
		element.click();
	}

	public static void pause(int seconds) {
		// Explicit wait
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void closeIndeed() {
		// close home Page
		MyDriver.driver.close();
	}

}
