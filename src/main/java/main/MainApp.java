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

public class MainApp {
	public static void main(String[] args) {
		System.out.println("Lancement de notre recherche de job de testeur!");
		new MyDriver();
		
		HomePageAcess hp =new HomePageAcess();
		List<OffreEmploi> lesOffres = new ArrayList<>();
		lesOffres.addAll(IndeedPageObject.run());
		hp.openNewTab();
		lesOffres.addAll(ApecPageObject.run());

		// send mail
		EnvoyerMail serviceEnvoieMail = new EnvoyerMail();
		serviceEnvoieMail.envoyerV2(BodyFormatter.formatMailBody(lesOffres)); // envoi mail */
		
		
	}
}
