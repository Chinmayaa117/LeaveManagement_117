package project;

import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Properties;
 

public class SendEmailServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve form data from request parameters
		String message = request.getParameter("message");
        String subject = request.getParameter("subject");
        String to = "krishchin777@gmail.com";
        String from = request.getParameter("senderEmail");;
		String host = "smtp.office365.com";
        Properties properties = System.getProperties();
        System.out.println("Properties : "+properties);
       
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","587");
        //properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.auth","true");
 
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,"1234chinnu");
            }
        });
 
        session.setDebug(true);
        MimeMessage m =  new MimeMessage(session);
        
        properties.put("mail.debug", "true");

     // Trust all certificates
     TrustManager[] trustAllCerts = new TrustManager[]{
         new X509TrustManager() {
             public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                 return null;
             }
             public void checkClientTrusted(
                 java.security.cert.X509Certificate[] certs, String authType) {
             }
             public void checkServerTrusted(
                 java.security.cert.X509Certificate[] certs, String authType) {
             }
         }
     };
     try {
         SSLContext sc = SSLContext.getInstance("SSL");
         sc.init(null, trustAllCerts, new java.security.SecureRandom());
         properties.put("mail.smtp.ssl.socketFactory", sc.getSocketFactory());
     } catch (Exception e) {
         e.printStackTrace();
     }
     
       try {
            m.setFrom(from);
            m.addRecipients(Message.RecipientType.TO , String.valueOf(new InternetAddress(to)));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);
            System.out.println("Success .. . . . . .  ");
            response.sendRedirect("Success.jsp");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	    
	}

}