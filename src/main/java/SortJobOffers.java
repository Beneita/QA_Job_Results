import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;



public class SortJobOffers {

	public List<OffreEmploi> ExtractOffers() {
		// listes de web elements
		List<WebElement> elmtOffre = MyDriver.driver.findElements(By.cssSelector(".jobtitle.turnstileLink"));
		List<WebElement> elmtcontent = MyDriver.driver.findElements(By.cssSelector(".summary"));
		List<WebElement> elmtLocalisation = MyDriver.driver.findElements(By.cssSelector(".location"));
		List<WebElement> elmtDate = MyDriver.driver.findElements(By.cssSelector(".date"));

		// liste d'offres d'emploi
		List<OffreEmploi> offrEmploi = new ArrayList<OffreEmploi>();

		// taille de la collection d'éléments web
		int sizeCollection = elmtOffre.size();
		if (sizeCollection != 0) {// si la collection de web elements n'est pas vide
			// boucler sur chaque élément de la collection de web elements
			for (int i = 0; i < sizeCollection; i++) {
				// extraire le titre et forcer en minuscule, puis l'assigner à la variable titre
				String titre = elmtOffre.get(i).getAttribute("title").toLowerCase();
				// extraire le lien et l'assigner à la variable lien
				String lien = elmtOffre.get(i).getAttribute("href");
				// extraire le descriptif et l'assigner à la variable descriptif
				String descriptif = elmtcontent.get(i).getText();
				// extraire la localisation et l'assigner à la variable localisation
				String localisation = elmtLocalisation.get(i).getText();
				// récupère le "title" du site et l'affecte à la variable siteName
				String siteName = MyDriver.driver.getTitle();
				// recupère valeur String il y a X jours
				String textDateAnnonce = elmtDate.get(i).getText();
				// split par spaces la string textDateAnnonce
				String[] stringElments = textDateAnnonce.split("\\ ");
				// récupérer la 4ème valeur et l'affecter à nbJourPast = nb de jours depuis la
				// parution de l'annonce
				String nbJourPast = stringElments[3];
				// nb de jours à soustraire (type long)
				long daysToSubtract = 0;
				// date de l'offre d'emploi
				LocalDate dateOffre = null;
				// si dans la string textDateAnnonce il y a le mot "jour"
				if (textDateAnnonce.contains("jours")) {
					// si nbJourPast contient "+"
					if (!nbJourPast.contains("+")) {
						// transformer valeur String nbJourPast en Long
						daysToSubtract = Long.parseLong(nbJourPast);
					} else {
						// ne garder que les 2 premiers chiffres
						nbJourPast = nbJourPast.substring(0, 2);
						// transformer valeur String nbJourPast en Long
						daysToSubtract = Long.parseLong(nbJourPast);
					}
					// date de l'offre = date du jour - nb de jours depuis parution de l'annonce
					dateOffre = LocalDate.now().minusDays(daysToSubtract);
				}
				// sinon prends la date du jour
				else {
					dateOffre = LocalDate.now();
				}
				if (textDateAnnonce.contains("mois")) {
					// transformer valeur String nbJourPast en Long
					daysToSubtract = Long.parseLong(nbJourPast) * 30;
				}
				// si le site est indeed
				if (siteName.contains("Indeed")) {
					siteName = "Indeed";
				}
				// si le titre contient le mot 'testeur'
				if (titre.contains("testeur")) {
					// instanciation d'un objet offre avec 3 attributs: titre, lien, descriptif
					OffreEmploi offre = new OffreEmploi(titre, lien, descriptif, localisation, siteName, dateOffre);
					// ajouter l'objet offre à la collection offrEmploi
					offrEmploi.add(offre);
					// System.out.println(offre.getSite());
				}
			}
		}
		// retourner le tableau offrEmploi
		return offrEmploi;
	}
	
	public List<OffreEmploi> ExtractOffersApec1() {
		// listes de web elements
		List<WebElement> elmtOffre = MyDriver.driver.findElements(By.cssSelector(".offre-title"));
		//List<WebElement> elmtcontent = MyDriver.driver.findElements(By.cssSelector(".summary"));
		//List<WebElement> elmtLocalisation = MyDriver.driver.findElements(By.cssSelector(".location"));
		//List<WebElement> elmtDate = MyDriver.driver.findElements(By.cssSelector(".date"));

		// liste d'offres d'emploi
		List<OffreEmploi> offrEmploi = new ArrayList<OffreEmploi>();

		// taille de la collection d'éléments web
		int sizeCollection = elmtOffre.size();
		System.out.println(sizeCollection);
		if (sizeCollection != 0) {// si la collection de web elements n'est pas vide
			// boucler sur chaque élément de la collection de web elements
			for (int i = 0; i < sizeCollection; i++) {
				// extraire le titre et forcer en minuscule, puis l'assigner à la variable titre
				String titre = elmtOffre.get(i).getText().toLowerCase();
				System.out.println(titre);
				/*//String titre = elmtOffre.get(i).getAttribute("title").toLowerCase();
				// extraire le lien et l'assigner à la variable lien
				String lien = elmtOffre.get(i).getAttribute("href");
				// extraire le descriptif et l'assigner à la variable descriptif
				
				// extraire la localisation et l'assigner à la variable localisation
				String localisation = elmtLocalisation.get(i).getText();
				// récupère le "title" du site et l'affecte à la variable siteName
				String siteName = MyDriver.driver.getTitle();
				// recupère valeur String il y a X jours
				String textDateAnnonce = elmtDate.get(i).getText();
				// split par spaces la string textDateAnnonce
				String[] stringElments = textDateAnnonce.split("\\ ");
				// récupérer la 4ème valeur et l'affecter à nbJourPast = nb de jours depuis la
				// parution de l'annonce
				String nbJourPast = stringElments[3];
				// nb de jours à soustraire (type long)
				long daysToSubtract = 0;
				// date de l'offre d'emploi
				LocalDate dateOffre = null;
				// si dans la string textDateAnnonce il y a le mot "jour"
				if (textDateAnnonce.contains("jours")) {
					// si nbJourPast contient "+"
					if (!nbJourPast.contains("+")) {
						// transformer valeur String nbJourPast en Long
						daysToSubtract = Long.parseLong(nbJourPast);
					} else {
						// ne garder que les 2 premiers chiffres
						nbJourPast = nbJourPast.substring(0, 2);
						// transformer valeur String nbJourPast en Long
						daysToSubtract = Long.parseLong(nbJourPast);
					}
					// date de l'offre = date du jour - nb de jours depuis parution de l'annonce
					dateOffre = LocalDate.now().minusDays(daysToSubtract);
				}
				// sinon prends la date du jour
				else {
					dateOffre = LocalDate.now();
				}
				if (textDateAnnonce.contains("mois")) {
					// transformer valeur String nbJourPast en Long
					daysToSubtract = Long.parseLong(nbJourPast) * 30;
				}
				// si le site est indeed
				if (siteName.contains("Indeed")) {
					siteName = "Indeed";
				}
				// si le titre contient le mot 'testeur'
				if (titre.contains("testeur")) {
					// instanciation d'un objet offre avec 3 attributs: titre, lien, descriptif
					OffreEmploi offre = new OffreEmploi(titre, lien, descriptif, localisation, siteName, dateOffre);
					// ajouter l'objet offre à la collection offrEmploi
					offrEmploi.add(offre);
					// System.out.println(offre.getSite());
				}*/
			}
		}
		// retourner le tableau offrEmploi
		return offrEmploi;
	}

	public List<OffreEmploi> ExtractOffersApec2() {
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

