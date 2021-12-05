import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Emailclientmain {
	static String email;
	static String password;
	static String to;
	static String sub;
	static String emsg;
	
	static void getLoginDetails() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your email: ");
		email = input.nextLine();
		System.out.print("Enter your password: ");
		password = input.nextLine();
		System.out.print("To: ");
		to = input.nextLine();
		System.out.print("Subject: ");
		sub = input.nextLine();
		System.out.print("Message: ");
		emsg = input.nextLine();
		input.close();
	}
	
	static void sendEmail() {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.scoketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(prop);
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(sub);
			msg.setText(emsg);
			Transport.send(msg, email, password);
			System.out.println("Message sent");
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	public static void main(String[] args) {
		getLoginDetails();
		System.out.println("Email : " + email + "\nPassword: " + password);
		sendEmail();
	}
}
