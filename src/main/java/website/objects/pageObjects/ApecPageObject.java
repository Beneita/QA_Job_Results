package website.objects.pageObjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import website.constants.WebsitesURLs;
import website.objects.OffreEmploi;

public class ApecPageObject {

	public static List<OffreEmploi> run() {
		// APEC
		List<OffreEmploi> lesOffres = new ArrayList<>();

		// open home page and do request
		HomePageAcess hp = new HomePageAcess();

		// open, enter keywords and location, search
		hp.openHomePage(WebsitesURLs.APEC_HOME_PAGE); // open homePage
		String jobSite2 = "HomePageConstants.APEC_HOME_PAGE";
		hp.enterKeywordsWhat(jobSite2); // enter Keywords
		hp.pause(2);
		hp.enterKeywordsWhereApec(); // enter location

		// Sur la page de resultats de la recherche...
		ExtracteurOffresMultiSite extracteur = new ExtracteurOffresMultiSite();

		return extracteur.extractOffersApec2();
	}

	public static String getDescriptionOffre(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public static LocalDate getDateAnnonce(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getLien(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getLocalisation() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getTitreOffre() {
		// TODO Auto-generated method stub
		return null;
	}

}
