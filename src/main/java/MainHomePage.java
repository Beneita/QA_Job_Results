import java.util.List;

import org.openqa.selenium.WebElement;

import annex_data.HomePageConstants;

public class MainHomePage {
	public static void main(String[] args) {
		System.out.println( "Lancement de notre recherche de job de testeur!" );
		new MyDriver();
		
		//open home page and do request
		HomePageAcess hp = new HomePageAcess();	
		HomePageAcess hp2 = new HomePageAcess();	
		//create content mail
		String offreTotal="Bonjour, \n"+ 
				"Vous trouverez ci-après l'ensemble des offres d'emploi de Testeur Logiciel : \n";
		
		//INDEED
		//open, enter keywords and location, search
		hp.openHomePage(HomePageConstants.INDEED_HOME_PAGE); // open homePage
		String jobSite="HomePageConstants.INDEED_HOME_PAGE";
		hp.enterKeywordsWhat(jobSite); //enter Keywords
		hp.enterKeywordsWhere(); // enter location 
		hp.clickSearchIndeed(); // click on search			
		//sort job offers
		SortJobOffers jobOfr = new SortJobOffers();
		List<OffreEmploi> listOffres = jobOfr.ExtractOffers();			
		
		//add selected results in mail
		for(int i = 0; i <listOffres.size(); i++)		
		{			
			String offre="*******************\n Site : "+(listOffres.get(i)).getSite()+"\n Date : "+(listOffres.get(i)).getDateAnnonce()+"\n Titre : "+(listOffres.get(i)).getTitre()+ "\n Lien : "+(listOffres.get(i)).getLien()+"\n Description : "+(listOffres.get(i)).getDescription()+"\n Localisation : "+(listOffres.get(i)).getLocalisation()+"\n*******************";
			offreTotal=offreTotal+offre;
		}
		
		hp.pause(3); //pause		
		hp.openNewTab(); //open new Tab
		
		
		//APEC	
		//open, enter keywords and location, search			
		hp.openHomePage(HomePageConstants.APEC_HOME_PAGE); // open homePage
		String jobSite2="HomePageConstants.APEC_HOME_PAGE";
		hp.enterKeywordsWhat(jobSite2); //enter Keywords
		//hp.enterKeywordsWhere(); // enter location 
		hp.clickSearchApec(); // click on search
		//sort job offers
		//SortJobOffers jobOfrApec = new SortJobOffers();
		//List<OffreEmploi> listOffresApec = jobOfrApec.ExtractOffersApec1();
		//add selected results in mail
		hp.pause(3); //pause
		
		
		//send mail
		EnvoyerMail test= new EnvoyerMail();
		test.envoyerV2(offreTotal);	 // envoi mail	
		
		// close homePage
		//hp.closeHomePage();
		
	}
}
