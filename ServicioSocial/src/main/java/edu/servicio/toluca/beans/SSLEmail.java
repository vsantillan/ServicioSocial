/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.beans;

/**
 *
 * @author root
 */
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class SSLEmail
{
    /**
     * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
     * authentication) Use Authentication: Yes Port for SSL: 465
     */
    public static void send(String email, String body) throws MessagingException
    {
        final String fromEmail = "noreply.ittoluca@gmail.com"; //requires valid gmail id
        final String password = "halc0nSS/"; // correct password for gmail id
        final String toEmail = "zizou.tol@gmail.com"; // can be any email id

        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port
        System.out.println("Mail Server Properties have been setup successfully..");

        Authenticator auth = new Authenticator()
        {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication()
            {
                System.out.println("Try authenticate..");
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");

        String emailBody = "Test email by The Beast. " + "<br><br><h1> Regards!<h1><br><a href=\"http://www.google.com\">Visit us</a> <br><h2>SS Admin</h2>";

        EmailUtil.sendEmail(session, email, "SSLEmail Testing Subject", body); //toEmail,emailBody
    }

}
