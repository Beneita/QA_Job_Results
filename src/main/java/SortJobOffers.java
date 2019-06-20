import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SortJobOffers {

	public List<OffreEmploi> ExtractOffers() {
		// listes de web elements
		List<WebElement> elmtOffre = MyDriver.driver.findElements(By.cssSelector(".jobtitle.turnstileLink"));
		List<WebElement> elmtcontent = MyDriver.driver.findElements(By.cssSelector(".summary"));
		// liste d'offres d'emploi
		List<OffreEmploi> offrEmploi = new ArrayList<OffreEmploi>();
		// taille de la collection d'éléments web
		int sizeCollection = elmtOffre.size();
		if (sizeCollection != 0) {// si la collection n'est pas vide
			// boucler sur chaque élément de la collection de wb elements
			for (int i = 0; i < sizeCollection; i++) {
				// extraire le titre et forcer en minuscule, puis l'assigner à la variable titre
				String titre = elmtOffre.get(i).getAttribute("title").toLowerCase();
				// extraire le lien et l'assigner à la variable lien
				String lien = elmtOffre.get(i).getAttribute("href");
				// extraire le descriptif et l'assigner à la variable descriptif
				String descriptif = elmtcontent.get(i).getText();
				// si le titre contient le mot 'testeur'
				if (titre.contains("testeur")) {
					// instanciation d'un objet offre avec 3 attributs: titre, lien, descriptif
					OffreEmploi offre = new OffreEmploi(titre, lien, descriptif);
					// ajouter l'objet offre à la collection offrEmploi
					offrEmploi.add(offre);
				}
			}
		}
		// retourner le tableau offrEmploi
		return offrEmploi;
	}
	
	
	public List<OffreEmploi> ExtractOffersApec() {
		System.out.println("oki");
		// listes de web elements
		List<WebElement> elmtOffre = MyDriver.driver.findElements(By.cssSelector(".offre-title"));
		//List<WebElement> elmtOffre = MyDriver.driver.findElements(By.xpath("//*[@id=\"offre-emploi-result-page\"]/div[4]/div[3]/div[4]/div[1]/div[1]/h2/a/span"));
		System.out.println(elmtOffre.get(0));
		System.out.println("***");
		System.out.println(elmtOffre.size());
		System.out.println("***");
		//List<WebElement> elmtOffre = MyDriver.driver.findElements(By.xpath("//*[@id=\"offre-emploi-result-page\"]/div[4]/div[3]/div[4]/div[1]/div[1]/h2/a/span"));
		//List<WebElement> elmtcontent = MyDriver.driver.findElements(By.cssSelector(".summary"));
		// liste d'offres d'emploi
		List<OffreEmploi> offrEmploi = new ArrayList<OffreEmploi>();
		// taille de la collection d'éléments web
		int sizeCollection = elmtOffre.size();
		if (sizeCollection != 0) {// si la collection n'est pas vide
			// boucler sur chaque élément de la collection de wb elements
			for (int i = 0; i < sizeCollection; i++) {
				// extraire le titre et forcer en minuscule, puis l'assigner à la variable titre
				//String titre = elmtOffre.get(i).getAttribute("innerHTML").toLowerCase();
				String titre = elmtOffre.get(i).getAttribute("innerHTML").toLowerCase();
				System.out.println(titre);
				//String titre = elmtOffre.get(i).getAttribute("title").toLowerCase();
				// extraire le lien et l'assigner à la variable lien
				String lien = elmtOffre.get(i).getAttribute("href");
				// extraire le descriptif et l'assigner à la variable descriptif
				//String descriptif = elmtcontent.get(i).getText();
				// si le titre contient le mot 'testeur'
				/*if (titre.contains("testeur")) {
					// instanciation d'un objet offre avec 3 attributs: titre, lien, descriptif
					OffreEmploi offre = new OffreEmploi(titre, lien, descriptif);
					// ajouter l'objet offre à la collection offrEmploi
					offrEmploi.add(offre);
				}*/
			}
		}
		// retourner le tableau offrEmploi
		return offrEmploi;
	}

}
