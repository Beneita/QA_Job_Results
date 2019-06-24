package website.objects.pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import config.MyDriver;
import website.constants.WebsitesURLs;
import website.objects.OffreEmploi;

public class ApecPageObject {

	public static List<OffreEmploi> run() {
		List<OffreEmploi> lesOffres = new ArrayList<>();

		// open home page and do request
		HomePageAcess hp = new HomePageAcess();

		// open, enter keywords and location, search
		hp.openHomePage(WebsitesURLs.APEC_HOME_PAGE); // open homePage Apec
		String jobSite2 = "HomePageConstants.APEC_HOME_PAGE";
		hp.enterKeywordsWhat(jobSite2); // enter Keywords
		hp.pause(2);
		hp.enterKeywordsWhereApec(); // enter location

		// Sur la page de resultats de la recherche...
		ExtracteurOffresMultiSite extracteur = new ExtracteurOffresMultiSite();

		return extracteur.extractOffersApec2();
	}

	public static String getTitreOffre(int i) {
		String titre = MyDriver.driver.findElements(By.cssSelector(".offre-title .ng-binding")).get(i).getText();
		return titre;
	}

	public static String getDescriptionOffre(int i) {
		String descript = MyDriver.driver.findElements(By.cssSelector("p.detail")).get(i).getText();
		return descript;
	}

	public static LocalDate getDateAnnonce(int i) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String dateString = MyDriver.driver.findElements(By.cssSelector(".pull-left.offre-date")).get(i).getText();
		LocalDate dateOffre = LocalDate.parse(dateString, formatter);
		return dateOffre;
	}

	public static String getLien(int i) {
		String offreLien = MyDriver.driver.findElements(By.cssSelector(".offre-title a")).get(i).getAttribute("href");
		return offreLien;
	}

	public static String getLocalisation(int i) {
		String offreLocalisation = MyDriver.driver.findElements(By.cssSelector(".pull-left span.ng-scope")).get(i)
				.getText();
		return offreLocalisation;
	}

}
