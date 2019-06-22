package website.objects.pageObjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import config.MyDriver;
import website.objects.OffreEmploi;

public class ExtracteurOffresMultiSite {

	private static final int NOMBRE_OFFRES = 3;

	public List<OffreEmploi> extractOffersIndeed() {
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
			for (int i = 0; i < NOMBRE_OFFRES; i++) {

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
				} else {
					// sinon prends la date du jour

					dateOffre = LocalDate.now();
				}

				if (textDateAnnonce.contains("mois")) {
					// transformer valeur String nbJourPast en Long
					daysToSubtract = Long.parseLong(nbJourPast) * 30;
				}
				// si le site est indeed
				if (siteName.contains("Indeed")) {
					siteName = "Indeed";
				} else {
					siteName = "";
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

	public List<OffreEmploi> extractOffersApec2() {
		List<OffreEmploi> lesOffres = new ArrayList<>();
		HomePageAcess hp = new HomePageAcess();
		for (int i = 0; i < NOMBRE_OFFRES; i++) {
			// System.out.println("Recuperations des offres de Aspec: On est sur la page de
			// resultatsde la recherche" + i);
			// instanciation d'un objet OffreEmploi
			OffreEmploi offre = new OffreEmploi();
			hp.pause(5);
			offre.setTitre(ApecPageObject.getTitreOffre(i));
			offre.setDateAnnonc(ApecPageObject.getDateAnnonce(i));
			offre.setLocalisation(ApecPageObject.getLocalisation(i));
			if (MyDriver.driver.getTitle().contains("Apec")) {
				offre.setSite("Apec");
			} else {
				offre.setSite("");
			}
			if (i == 0) {
				offre.setDescription(ApecPageObject.getDescriptionOffre(i));
				offre.setLien(ApecPageObject.getLien(i));
			} else {
				offre.setDescription(ApecPageObject.getDescriptionOffre(2 * i));
				offre.setLien(ApecPageObject.getLien(2 * i));
			}
			System.out.println("************" + "\n" + offre.getTitre() + "\n" + offre.getDescription() + "\n"
					+ offre.getLien() + "\n*****************");
			lesOffres.add(offre);
		}
		return lesOffres;
	}

}
