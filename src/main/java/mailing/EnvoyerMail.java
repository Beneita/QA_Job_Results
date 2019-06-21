package mailing;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvoyerMail {
	// déclaration de variable
	private String username = "poecfantastic.five";
	private String password = "PoecFantastic";
	private String envoyeur = "poecfantastic.five@gmail.com";	
	private String destinataire = "garnier.oeliarisoa@gmail.com";
	private String sujet_mail = "Liste offre emploi testeur 37 ";
	private String contenu_mail=
	"Bonjour, \n"+
	"Vous trouverez ci-après la liste des liens des offres d'emploi les plus pertinentes. \n"+
	"Annonce 1: https://www.indeed.fr/jobs?q=testeur+logiciel&l=Alpes-maritimes \n"+
	"Annonce 2 :https://www.indeed.fr/viewjob?jk=0ec17dc5af7bb67c&q=testeur+logiciel&l=Alpes-maritimes&tk=1ddl6n6gr99l2803&from=web&vjs=3 \n";
	
	public EnvoyerMail() {
		//constructeur par défaut
	}
	
	
	public void envoyer() {
	// envoi un mail
		
		// Etape 1 : Création de la session
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		Session session = Session.getInstance(props,
		new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
		}
		});
		
		try {
		// Etape 2 : Création de l'objet Message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(envoyeur));
		message.setRecipients(Message.RecipientType.TO,
		InternetAddress.parse(destinataire));
		message.setSubject(sujet_mail);
		message.setText(contenu_mail);
		
		
		// Etape 3 : Envoyer le message
		Transport.send(message);
		System.out.println("Le mail a été envoyé avec succès à : "+ destinataire);
		} catch (MessagingException e) {
		throw new RuntimeException(e);
		} 
	}
	
	
	public void envoyerV2(String contenu) {
		// envoi un mail
			
			// Etape 1 : Création de la session
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host","smtp.gmail.com");
			props.put("mail.smtp.port","587");
			Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
			}
			});
			
			try {
			// Etape 2 : Création de l'objet Message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(envoyeur));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(destinataire));
			message.setSubject(sujet_mail);
			message.setText(contenu);
			
			
			// Etape 3 : Envoyer le message
			Transport.send(message);
			System.out.println("Le mail a été envoyé avec succès à : "+ destinataire);
			} catch (MessagingException e) {
			throw new RuntimeException(e);
			} 
		}
	
	
}
