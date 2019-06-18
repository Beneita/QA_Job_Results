import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import tuto.eclipse.jal.selenium.loaders.MyDriver;

public class SortJobOffers {

	/*
	 * public String lien = public String description = OffreEmploi offre = new
	 * OffreEmploi(titre, lien, description);
	 */

	public void ExtractText() {
		Select s = new Select(MyDriver.driver.findElement(By.cssSelector(".jobtitle.turnstileLink")));

		System.out.println(titre.getText());
	}

}
