/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.organizaciones.BorrarInstancia;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.sesion.InstanciaFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rodrigo
 */
@Controller
public class OrganizacionesController3 {

    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/borrarOrganizacion.do")
    public @ResponseBody
    String borrarOrganizacion(int id, String descripcion,String correo, HttpSession session, HttpServletRequest request) {
        System.out.println("Mando el POST--id: "+id);

//            System.out.println("Antes del update");
//            Instancia instancia;
//            instancia = instanciaFacade.find(BigDecimal.valueOf(id));
//            instancia.setEstatus(BigInteger.valueOf(0));
//            if(retroalimentacionInstancia.getControl()==0)
//                 instancia.setEstatus(BigInteger.valueOf(0));
//             else
//                instancia.setValidacionAdmin(BigInteger.valueOf(2));
            //instanciaFacade.edit(instancia);
//            System.out.println("Despues del update");
            return "ok";
//            return "<script>"
//                    + "alert('¡Correo enviado exitosamente a: " + correo + "!');"
//                    + "</script>";
        
    }
}
