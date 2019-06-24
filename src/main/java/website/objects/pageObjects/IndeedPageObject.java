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
		// enter Keywords
		hp.enterKeywordsWhat(jobSite);
		// enter location
		hp.enterKeywordsWhereIndeed();
		// click on search
		// hp.clickSearchIndeed();
		// sort job offers
		ExtracteurOffresMultiSite jobOfr = new ExtracteurOffresMultiSite();
		List<OffreEmploi> listOffres = jobOfr.extractOffersIndeed();

		return listOffres;
	}

}
