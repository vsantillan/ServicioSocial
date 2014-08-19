/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;


import edu.servicio.toluca.beans.Contacto;
import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.beans.SSLEmail;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.validation.Valid;
import org.openide.util.Exceptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Héctor
 */
@Controller
@RequestMapping("/contacto.do")
public class ContactoController {
    boolean enviado = false;
    final private String correosAdmins[] =
    {
        "viktor.santillan@gmail.com",
        "zizou.tol@gmail.com",
        "giovanni.fi05@gmail.com"
    };
    
    @RequestMapping(method = RequestMethod.GET)
    public String contacto(Model modelo) {
        modelo.addAttribute("Contacto",new Contacto());
        return "/NavegacionPrincipal/contacto";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String nuevoMensaje( @ModelAttribute("Contacto") @Valid Contacto contacto, BindingResult result,Map modelo) {
        if(result.hasErrors()) {            
            modelo.put("Contacto",contacto);
            return "/NavegacionPrincipal/contacto";
        }
        
        String mensajeContacto = "Mensaje <br>"
                + "<p>" + contacto.getNombre() + "</p>"
                + "<h3>" + contacto.getAsunto() + "</h3>"
                + "<p>" + contacto.getCorreo() + "</p>"
                + "<h4>" + contacto.getDetalle() + "</h4>";
        System.out.println("á");
        System.out.println(mensajeContacto);
        try
        {
            Thread hiloCorreo = new Thread(new HiloCorreo(mensajeContacto));
            hiloCorreo.start();
            enviado = true;
        } catch (Exception e)
        {
            System.out.println("error: " + e);
        }
        if (enviado)
        {
            modelo.put("message", "<div class='alert alert-success'>Gracias por tu comentario, lo tomaremos en cuenta. </div>");
            modelo.put("Contacto", new Contacto());
        } else
        {
            modelo.put("message", "<div class='alert alert-danger'>No se pudo enviar tu comentario, hubo un problema </div>");
            modelo.put("Contacto", new Contacto());
        }
        return "/NavegacionPrincipal/contacto";
    }
     
    private class HiloCorreo implements Runnable
    {
        private String mensaje;
        public HiloCorreo(String mensaje) {
            this.mensaje=mensaje;
        }
        
        @Override
        public void run()
        {
            try
            {
//                for (String emailsAdmins : correosAdmins)
////                for (int i = 0; i < 3; i++)
//                {
//                    //EnviarCorreo correoContacto = new EnviarCorreo("Contacto Servicio Social", correoDev,this.mensaje);
//                    //correoContacto.enviaCorreo();
//                        SSLEmail.send("zizou.tol@gmail.com", this.mensaje);
//
//                }
                SSLEmail.send("zizou.tol@gmail.com", this.mensaje);
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    
    }
}
