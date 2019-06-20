import java.util.List;

import annex_data.HomePageConstants;

public class MainHomePage {
	public static void main(String[] args) {
		System.out.println( "Lancement de notre recherche de job de testeur!" );
		new MyDriver();
		
		//open home page and do request
		HomePageAcess hp = new HomePageAcess();
		
		//INDEED		
		hp.openHomePage(HomePageConstants.INDEED_HOME_PAGE); // open homePage
		String jobSite="HomePageConstants.INDEED_HOME_PAGE";
		hp.enterKeywordsWhat(jobSite); //enter Keywords
		//ia.enterKeywordsWhere(); // enter location 
		hp.clickSearchIndeed(); // click on search			
		hp.pause(3); //pause
		//sort job offers
		SortJobOffers jobOfr = new SortJobOffers();
		List<OffreEmploi> listOffres = jobOfr.ExtractOffers();		
		
		//create content mail
		String offreTotal="Bonjour, \n"+ 
				"Vous trouverez ci-après la liste des liens des offres d'emploi les plus pertinentes. \n";
		for(int i = 0; i <listOffres.size(); i++)		
		{
			
			String offre="*******************\n"+(listOffres.get(i)).getTitre()+ "\n"+(listOffres.get(i)).getLien()+"\n"+(listOffres.get(i)).getDescription()+"\n*******************";
			offreTotal=offreTotal+offre;
		}		
		
		
				
		//APEC		
		hp.openHomePage(HomePageConstants.APEC_HOME_PAGE); // open homePage
		String jobSite2="HomePageConstants.APEC_HOME_PAGE";
		hp.enterKeywordsWhat(jobSite2); //enter Keywords
		//ia.enterKeywordsWhere(); // enter location 
		hp.clickSearchApec(); // click on search			
		hp.pause(3); //
		
		
		//send mail
		EnvoyerMail test= new EnvoyerMail();
		test.envoyerV2(offreTotal);	 // envoi mail	
		
		
		
		// close homePage
		//hp.closeHomePage();
	}
}
