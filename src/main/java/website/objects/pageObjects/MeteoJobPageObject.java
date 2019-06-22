package website.objects.pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import config.MyDriver;
import website.constants.WebsitesURLs;
import website.objects.OffreEmploi;

public class MeteoJobPageObject {
	public static List<OffreEmploi> run() {
		List<OffreEmploi> lesOffres = new ArrayList<>();

		// open home page and do request
		HomePageAcess hp = new HomePageAcess();

		// open, enter keywords and location, search
		hp.openHomePage(WebsitesURLs.METEOJOB_HOME_PAGE); // open homePage MeteoJob
		String jobSite3 = "HomePageConstants.METEOJOB_HOME_PAGE";
		hp.enterKeywordsWhat(jobSite3); // enter Keywords
		hp.pause(2);
		hp.enterKeywordsWhereMeteoJob(); // enter location

		// Sur la page de resultats de la recherche...
		ExtracteurOffresMultiSite extracteur = new ExtracteurOffresMultiSite();

		return extracteur.extractOffersMeteoJob();
	}

	public static String getTitreOffre(int i) {
		String titre = MyDriver.driver.findElements(By.cssSelector(".block-link")).get(i).getText();
		return titre;
	}

	public static String getDescriptionOffre(int i) {
		String descript = MyDriver.driver.findElements(By.cssSelector(".preview")).get(i).getText();
		return descript;
	}

	public static LocalDate getDateAnnonce(int i) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String dateString = MyDriver.driver
				.findElements(By.cssSelector(".header-data.logoPresent .tags .published-date")).get(i).getText();
		// date de l'offre d'emploi
		LocalDate dateOffre = null;
		if (dateString.contains("Il y a")) {
			dateOffre = LocalDate.now();
		} else {
			// split par spaces la string dateString
			String[] stringElments = dateString.split("\\ ");
			String jour = stringElments[1];
			String mois = stringElments[2];
			// si le 2ème element est un chiffre
			if (jour.length() == 1) {
				// rajouter un 0 devant
				jour = "0" + jour;
			}
			// si le 3ème element est un mois-->transformer en nombre
			switch (mois) {
			case "janvier":
				mois = "01";
				break;
			case "février":
				mois = "02";
				break;
			case "mars":
				mois = "03";
				break;
			case "avril":
				mois = "04";
				break;
			case "mai":
				mois = "05";
				break;
			case "juin":
				mois = "06";
				break;
			case "juillet":
				mois = "07";
				break;
			case "août":
				mois = "08";
				break;
			case "septembre":
				mois = "09";
				break;
			case "octobre":
				mois = "10";
				break;
			case "novembre":
				mois = "11";
				break;
			case "décembre":
				mois = "12";
				break;
			// default:
			// code block
			}
			// datestring devient un format jj//mm//aaaa
			dateString = jour + "/" + mois + "/" + "2019";
		}
		dateOffre = LocalDate.parse(dateString, formatter);
		return dateOffre;
	}

	public static String getLien(int i) {
		String offreLien = MyDriver.driver.findElements(By.cssSelector(".block-link")).get(i).getAttribute("href");
		return offreLien;
	}

	public static String getLocalisation(int i) {
		String offreLocalisation = MyDriver.driver
				.findElements(By.cssSelector(".header-data.logoPresent .info .list-unstyled")).get(i).getText();

		offreLocalisation = offreLocalisation.substring(6);

		return offreLocalisation;
	}

}
