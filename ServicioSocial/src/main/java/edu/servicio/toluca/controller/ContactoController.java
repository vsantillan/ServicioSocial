/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;


import edu.servicio.toluca.beans.Contacto;
import edu.servicio.toluca.beans.EnviarCorreo;
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
    
        final private String correosDevelopers[]={"rehoscript@gmail.com",
                                              "wind.saber@hotmail.com",
                                              "roy_006@hotmail.com",
                                              "manolo7221@gmail.com",
                                              "m.jonatan.diaz@gmail.com",
                                              "regulesteban@gmail.com",
                                                "oima_91@hotmail.com"};
    
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
        
        String mensajeContacto="<h1>"+contacto.getNombre()+"</h1>" +
                                "<h1>"+contacto.getAsunto()+"</h1>" +
                                "<h1>"+contacto.getCorreo()+"</h1>" +
                                "<p>"+contacto.getDetalle()+"</p>";
        System.out.println("á");
        System.out.println(mensajeContacto);
         
        Thread hiloCorreo=new Thread(new HiloCorreo(mensajeContacto));
        hiloCorreo.start();
        modelo.put("message","<div class='alert alert-success'>Gracias por tu comentario, lo tomaremos en cuenta. </div>");
        modelo.put("Contacto",new Contacto());
        return "/NavegacionPrincipal/contacto";
    }
    
    
    ///----------------------------------------------------------------------------
   
    
   
    
    private class HiloCorreo implements Runnable
    {
        private String mensaje;
        public HiloCorreo(String mensaje) {
            this.mensaje=mensaje;
        }
        
        
        @Override
        public void run() {
            
            try
            {
                
                for(String correoDev: correosDevelopers)
                {
                    EnviarCorreo correoContacto = new EnviarCorreo("Contacto Servicio Social",
                                               correoDev,
                                               this.mensaje
                                               );
                    correoContacto.enviaCorreo();
                }
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    
    }
}
