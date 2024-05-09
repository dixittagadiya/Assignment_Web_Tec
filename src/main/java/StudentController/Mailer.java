package StudentController;

import java.net.PasswordAuthentication;
import java.util.Properties;

import jakarta.websocket.Session; 


public class Mailer {

	public static void send(String to,String sub,String msg) {  
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465"); 
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    

        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new jakarta.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("dixittagadiya08@gmail.com","kyko dtje sumu cvzw");  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (Exception e) {throw new RuntimeException(e);}    

  }  

}