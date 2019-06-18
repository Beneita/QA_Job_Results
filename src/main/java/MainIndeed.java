
public class MainIndeed {
	public static void main( String[] args )
    {
        System.out.println( "coucou ici" );
        IndeedAccess ia= new IndeedAccess();
        ia.openIndeed();
        ia.enterKeywordsWhat();        
        ia.enterKeywordsWhere();        
        ia.clickSearch();         
        //ia.pause(30); 
        //ia.closeIndeed();
    }
}
