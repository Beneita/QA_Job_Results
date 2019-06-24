package mailing;

import java.util.List;

import website.objects.OffreEmploi;

public class BodyFormatter {

	public static String formatMailBody(List<OffreEmploi> lesOffres) {
		String offre = "Bonjour, \n"
				+ "Vous trouverez ci-après l'ensemble des offres d'emploi de Testeur Logiciel : \n";

		// add selected results in mail
		for (int i = 0; i < lesOffres.size(); i++) {
			offre = offre + "*******************\n Site : " + (lesOffres.get(i)).getSite() + "\n Date : "
					+ (lesOffres.get(i)).getDateAnnonce() + "\n Titre : " + (lesOffres.get(i)).getTitre() + "\n Lien : "
					+ (lesOffres.get(i)).getLien() + "\n Description : " + (lesOffres.get(i)).getDescription()
					+ "\n Localisation : " + (lesOffres.get(i)).getLocalisation() + "\n*******************";
		}
		return offre;
	}
}
