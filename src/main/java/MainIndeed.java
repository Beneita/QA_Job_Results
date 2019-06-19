import java.util.List;

public class MainIndeed {

	public static void main(String[] args) {
		System.out.println( "Lancement de notre recherche de job de testeur!" );
		
		new MyDriver();
		
		//open home page and do request
		IndeedAccess ia = new IndeedAccess();
		ia.openIndeed(); // open homePage
		ia.enterKeywordsWhat(); //enter Keywords
		ia.enterKeywordsWhere(); // enter location 
		ia.clickSearch(); // click on search
		
		//sort job offers
		SortJobOffers jobOfr = new SortJobOffers();
		List<OffreEmploi> listOffres = jobOfr.ExtractOffers();		
		
		//send mail
		String offreTotal="Bonjour, \n"+ 
				"Vous trouverez ci-après la liste des liens des offres d'emploi les plus pertinentes. \n";
		for(int i = 0; i <listOffres.size(); i++)		
		{
			
			String offre="*******************\n"+(listOffres.get(i)).getTitre()+ "\n"+(listOffres.get(i)).getLien()+"\n"+(listOffres.get(i)).getDescription()+"\n*******************";
			offreTotal=offreTotal+offre;
		}		
		EnvoyerMail test= new EnvoyerMail();
		test.envoyerV2(offreTotal);	 // envoi mail		
		
		//pause and close home page
		ia.pause(10);
		ia.closeIndeed();
	}
}
