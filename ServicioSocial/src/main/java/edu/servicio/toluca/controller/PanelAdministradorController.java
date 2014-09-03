/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.entidades.UsuarioInstancia;
import edu.servicio.toluca.sesion.UsuarioInstanciaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ekt
 */
@Controller
public class PanelAdministradorController
{

    @EJB(mappedName = "java:global/ServicioSocial/UsuarioInstanciaFacade")
    private UsuarioInstanciaFacade usuarioInstanciaFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/panelAdministrador.do")
    public String panelAdministrador(Model model, HttpSession session, HttpServletRequest request)
    {
        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador())
        {
            return "/PanelAdministrador/panelAdministrador";
        } else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administrarUsuarios.do")
    public String administrarUsuarios(Model model, HttpSession session, HttpServletRequest request)
    {

        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador())
        {
            List<UsuarioInstancia> listaUsuarios = usuarioInstanciaFacade.findBySpecificField("status", "1", "equal", null, null);
            ArrayList<UsuarioInstancia> usuarioList = new ArrayList<UsuarioInstancia>();

            for (int i = 0; i < listaUsuarios.size(); i++)
            {
                short listStatus = listaUsuarios.get(i).getStatus();
                String estatus = Short.toString(listStatus);
                if ((estatus.equals("1")))
                {
                    usuarioList.add(listaUsuarios.get(i));
                }
            }

            model.addAttribute("usuarios", usuarioList);

            return "/Usuarios/administrarUsuarios";
        } else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }

    }

}
