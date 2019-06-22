package website.objects.pageObjects;

import java.util.List;

import website.constants.WebsitesURLs;
import website.objects.OffreEmploi;

public class IndeedPageObject {

	public static List<OffreEmploi> run() {
		// open home page and do request
		HomePageAcess hp = new HomePageAcess();

		// INDEED //open, enter keywords and location, search
		hp.openHomePage(WebsitesURLs.INDEED_HOME_PAGE); // open homePage Indeed
		String jobSite = "HomePageConstants.INDEED_HOME_PAGE";
		hp.enterKeywordsWhat(jobSite);

		// enter Keywords
		hp.enterKeywordsWhere(); // enter location
		hp.clickSearchIndeed(); // click on search //sort job offers
		ExtracteurOffresMultiSite jobOfr = new ExtracteurOffresMultiSite();
		List<OffreEmploi> listOffres = jobOfr.extractOffersIndeed();

		return listOffres;
	}

}
