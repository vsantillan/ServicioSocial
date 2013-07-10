/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.organizaciones;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ekt
 */
public class EnviaRetroalimentacion 
{
    String remitente;
    String correo;
    String mensaje;
    String asunto;
    
    public EnviaRetroalimentacion(String asunto,String remitente,String correo,String mensaje)
    {
        this.remitente=remitente;
        this.correo=correo;
        this.mensaje=mensaje;
        this.asunto=asunto;
    }
    
    public boolean enviarCorreo()
    {
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "regulesteban@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("yo@yo.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress("roy_006@hotmail.com"));
            message.setSubject("Hola "+asunto);
            message.setText(
                "Mensajito con Java Mail" + "de los buenos." + "poque si");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("regulesteban@gmail.com", "liliwiko");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
