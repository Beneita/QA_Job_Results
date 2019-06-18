import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SortJobOffers {

	/*
	 * public String lien = public String description = OffreEmploi offre = new
	 * OffreEmploi(titre, lien, description);
	 */
	public List<OffreEmploi> offrEmploi;

	public List<OffreEmploi> ExtractOffers() {
		List<WebElement> elmtOffre = MyDriver.driver.findElements(By.cssSelector(".jobtitle.turnstileLink"));

		for (int i = 0; i < elmtOffre.size(); i++) {
			String titre = elmtOffre.get(i).getText();
			String lien = elmtOffre.get(i).getAttribute("href");
			// String descptif;
			OffreEmploi offre = new OffreEmploi(titre, lien/* , descptif */);
			// offrEmploi.add(offre);
			System.out.println(offre.getLien());
		}
		return offrEmploi;
	}

}
