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

		lesOffres.addAll(IndeedPageObject.run());

		hp.openNewTab();
		lesOffres.addAll(MeteoJobPageObject.run());

		hp.openNewTab();
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
