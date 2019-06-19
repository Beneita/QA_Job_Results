import java.util.List;

public class MainIndeed {

	public static void main(String[] args) {
		System.out.println( "Lancement de notre recherche de job de testeur!" );
		new MyDriver();
		IndeedAccess ia = new IndeedAccess();
		ia.openIndeed();
		ia.enterKeywordsWhat();
		ia.enterKeywordsWhere();
		ia.clickSearch();
		SortJobOffers jobOfr = new SortJobOffers();
		List<OffreEmploi> listOffres = jobOfr.ExtractOffers();
		
		EnvoyerMail test= new EnvoyerMail();
		test.envoyer();	 // envoi mail
		// ia.pause(30);
		// ia.closeIndeed();
	}
}
