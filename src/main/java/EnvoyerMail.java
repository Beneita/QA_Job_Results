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
		message.setFrom(new InternetAddress("poecfantastic.five@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
		InternetAddress.parse("garnier.oeliarisoa@gmail.com"));
		message.setSubject("Test email 6");
		message.setText("Bonjour, ce message est un test 6 ...");
		
		
		// Etape 3 : Envoyer le message
		Transport.send(message);
		System.out.println("Le message est envoyé avec succès à : "+ username);
		} catch (MessagingException e) {
		throw new RuntimeException(e);
		} 
	}
	
}
