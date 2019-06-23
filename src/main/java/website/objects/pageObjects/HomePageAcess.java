package website.objects.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import config.MyDriver;

public class HomePageAcess {

	public HomePageAcess() {
		// Default constructor
	}

	public void openHomePage(String URL) {
		// Open Home page
		MyDriver.driver.manage().window().maximize();
		MyDriver.driver.get(URL);
	}

	/*
	 * public void enterKeywordsWhat() { // Enter the Keywords for the job
	 * MyDriver.driver.findElement(By.id("text-input-what")).
	 * sendKeys("testeur logiciel"); }
	 */

	public void enterKeywordsWhat(String str) {
		// Enter the Keywords for the job
		switch (str) {
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
			final String TESTEUR = "Testeur d'applications (H/F)";
			MyDriver.driver.findElements(By.cssSelector(".form-control.tt-input")).get(2).sendKeys(TESTEUR);
			// MyDriver.driver.findElements(By.cssSelector(".form-control.tt-input")).get(3).sendKeys(Keys.ENTER);

			break;
		default:
			System.out.println("unknow job site");
		}

	}

	public void enterKeywordsWhereIndeed() {
		WebElement text = MyDriver.driver.findElement(By.id("text-input-where"));
		text.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Alpes-maritimes");
		text.sendKeys(Keys.ENTER);
	}

	/**
	 * Enter the Keywords for the location for site Apec<br>
	 * Par defaut on selectionne <b>Alpes-Maritimes - 06</b>
	 */
	public void enterKeywordsWhereApec() {
		final String ALPES_MARITIMES = "Alpes-Maritimes - 06";
		MyDriver.driver.findElements(By.cssSelector(".form-control.lieuautocomplete.ui-autocomplete-input")).get(0)
				.sendKeys(ALPES_MARITIMES);
		MyDriver.driver.findElements(By.cssSelector(".form-control.lieuautocomplete.ui-autocomplete-input")).get(0)
				.sendKeys(Keys.ENTER);

	}

	/**
	 * Enter the Keywords for the location for site MeteoJob<br>
	 * Par defaut on selectionne <b>Alpes-Maritimes</b>
	 */
	public void enterKeywordsWhereMeteoJob() {
		final String ALPES_MARITIMES = "Alpes-Maritimes";
		MyDriver.driver.findElements(By.cssSelector(".form-control.tt-input")).get(3).sendKeys(ALPES_MARITIMES);
		MyDriver.driver.findElements(By.cssSelector(".form-control.tt-input")).get(3).sendKeys(Keys.ENTER);

	}

	public void clickSearchIndeed() {
		// Click on the button "Rechercher"
		WebElement element = MyDriver.driver.findElement(By.xpath("//*[@id=\"whatWhere\"]/div/div/form/div[3]/button"));
		element.click();
	}

	public void clickSearchApec() {
		// Click on the button "Rechercher"
		WebElement element = MyDriver.driver
				.findElement(By.xpath("//*[@id=\"section-recherche\"]/div[2]/div[1]/form/div[2]/button"));
		element.click();

	}

	public void openNewTab() {
		// open a new Tab
		((JavascriptExecutor) MyDriver.driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(MyDriver.driver.getWindowHandles());
		MyDriver.driver.switchTo().window(tabs.get(1));
	}

	public void pause(int seconds) {
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
