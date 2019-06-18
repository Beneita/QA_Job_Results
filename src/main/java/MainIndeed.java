
public class MainIndeed {
	public static void main( String[] args )
    {
        System.out.println( "Lancement de notre recherche de job de testeur!" );
        
        IndeedAccess ia= new IndeedAccess();
        ia.openIndeed(); // ouvre la page web indeed.fr
        ia.enterKeywordsWhat();   // entre automatiquement les mots-clés     
        ia.enterKeywordsWhere();   // entre automatiquement le lieu de recherche     
        ia.clickSearch();    // clique sur le bouton rechercher 
        
		EnvoyerMail test= new EnvoyerMail();
		test.envoyer();	 // envoi mail
		
        ia.pause(30); 
        ia.closeIndeed();
    }
}
