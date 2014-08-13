/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Regules
 */
public class EnviarCorreo implements Runnable 
{
    //luevanoguzman@gmail.com
    //      Tristan13
    private String remitente = "noreply.ittoluca@hotmail.com";
    private String destinatario;
    private String mensaje;
    private String asunto;
    private String pass = "halc0nSS/";

    public EnviarCorreo(String nombre, String destinatario, String mensaje) 
    {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        String str = fecha.format(new Date());
        
        this.asunto = "Notificación  Servicio Social " + str + " " + nombre;
    }

    public boolean enviaCorreo() {
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            //props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "465");//587,465,
            props.setProperty("mail.smtp.user", remitente);
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(destinatario));
            message.setSubject(asunto,"UTF-8");
            message.setText(mensaje, "UTF-8", "html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(remitente, pass);
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void run() 
    {
        try {
            enviaCorreo();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
