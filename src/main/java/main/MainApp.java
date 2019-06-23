package main;

import java.util.ArrayList;
import java.util.List;

import config.MyDriver;
import mailing.BodyFormatter;
import mailing.EnvoyerMail;
import website.objects.OffreEmploi;
import website.objects.pageObjects.ApecPageObject;
import website.objects.pageObjects.HomePageAcess;
import website.objects.pageObjects.IndeedPageObject;
import website.objects.pageObjects.MeteoJobPageObject;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("Lancement de notre recherche de job de testeur!");

		new MyDriver();
		HomePageAcess hp = new HomePageAcess();
		List<OffreEmploi> lesOffres = new ArrayList<OffreEmploi>();
		// ajout des offres indeed à la collection d'offres d'emploi
		lesOffres.addAll(IndeedPageObject.run());
		// ouverture dans 1 nouvel onglet
		hp.openNewTab(1);
		// ajout des offres meteojob à la collection d'offres d'emploi
		lesOffres.addAll(MeteoJobPageObject.run());
		// ouverture dans 1 nouvel onglet
		hp.openNewTab(2);
		// ajout des offres apec à la collection d'offres d'emploi
		lesOffres.addAll(ApecPageObject.run());

		for (int i = 0; i < lesOffres.size(); i++) {
			System.out.println(lesOffres.get(i).getSite() + (i + 1) + ":\n " + lesOffres.get(i).getTitre() + "\n "
					+ lesOffres.get(i).getDateAnnonce() + "\n " + lesOffres.get(i).getLocalisation() + "\n "
					+ lesOffres.get(i).getDescription() + "\n " + lesOffres.get(i).getLien());
		}

		// send mail
		EnvoyerMail serviceEnvoieMail = new EnvoyerMail();
		serviceEnvoieMail.envoyerV2(BodyFormatter.formatMailBody(lesOffres));
	}
}
