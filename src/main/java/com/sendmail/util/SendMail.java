package com.sendmail.util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mail.config.AppConf;
import com.mailsign.entities.Email;
import com.mailsign.entities.Utilisateur;

public class SendMail { 
    public void send(Email email, Utilisateur user){
        System.out.println("\nSendMail Class : \n user from : "+user.getEmail()+"\t pass : "+user.getPassword());
        System.out.println("\n email info ::  from: "+email.getFrom()+"\t to: "+email.getTo()+"\t subject: "+email.getSubject()+"\t msg : "+email.getMessage());

        Properties properties = new Properties();
        Session session;
        MimeMessage message;
        properties.put("mail.smtp.host", AppConf.MAIL_HOST);
        properties.put("mail.smtp.port","25");
        properties.put("mail.smtp.auth","true");
        System.out.println("1");
        System.out.println(AppConf.MAIL_HOST);

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.println("2");
              //return new PasswordAuthentication(user.getEmail(),user.getPassword());
                return new PasswordAuthentication(user.getEmail(),"123456789");

            }
        };
        System.out.println("3");

        session = Session.getDefaultInstance(properties,authenticator);
        
        System.out.println("4");

        try {
            System.out.println("5");
            InternetAddress[] recipients = new InternetAddress[1];
            System.out.println("6");
            recipients[0] = new InternetAddress(email.getTo());
            System.out.println("email.getTo()+++++++"+email.getTo());
            message = new MimeMessage(session);
            System.out.println("7");            
            message.setFrom(new InternetAddress(email.getFrom()));
            System.out.println("8");
            message.addRecipients(Message.RecipientType.TO,recipients);
            System.out.println("9");
            message.setSubject(email.getSubject());
            System.out.println("10");
            message.setText(email.getMessage());
            System.out.println("11");
            Transport.send(message);
            System.out.println("Mail sent");
        }catch (Exception e){
            System.out.println("13");

            System.out.println(e.getMessage());
        }
  }
}