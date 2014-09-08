/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.UsuarioInstancia;
import edu.servicio.toluca.sesion.UsuarioInstanciaFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

            for (UsuarioInstancia listaUsuario : listaUsuarios)
            {
                short listStatus = listaUsuario.getStatus();
                String estatus = Short.toString(listStatus);
                if (estatus.equals("1"))
                {
                    usuarioList.add(listaUsuario);
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

    @RequestMapping(method = RequestMethod.GET, value = "/altaUsuarios.do")
    public String altaUsuarios(Model model, HttpSession session, HttpServletRequest request, UsuarioInstancia usuarioInstancia)
    {

        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador())
        {
            model.addAttribute("usuarios", usuarioInstancia);
            return "/Usuarios/altaUsuarios";
        } else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarUsuarios.do")
    public String validarUsuarios(Model model, HttpSession session, HttpServletRequest request, UsuarioInstancia usuarioInstancia)
    {
        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador())
        {
            List<UsuarioInstancia> listaUsuarios = usuarioInstanciaFacade.findBySpecificField("status", "0", "equal", null, null);
            ArrayList<UsuarioInstancia> usuarioList = new ArrayList<UsuarioInstancia>();

            for (UsuarioInstancia listaUsuario : listaUsuarios)
            {
                short listStatus = listaUsuario.getStatus();
                String estatus = Short.toString(listStatus);
                if (estatus.equals("0"))
                {
                    usuarioList.add(listaUsuario);
                }
            }

            model.addAttribute("usuarios", usuarioList);
            return "/Usuarios/validarUsuarios";

        } else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/upUserAdmin.do")
    public String upUserAdmin(Model model, HttpSession session, HttpServletRequest request, UsuarioInstancia usuarioInstancia)
    {
        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador())
        {
            try{
            usuarioInstancia.setStatus((short) 1);
            usuarioInstancia.setPassword(StringMD.getStringMessageDigest(usuarioInstancia.getPassword(), StringMD.SHA1));
            usuarioInstanciaFacade.create(usuarioInstancia);
            }
            catch(Exception e){
                System.out.println("Match");
            }
            return "Usuarios/administrarUsuarios";
        } else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }

    }
    
          @RequestMapping(method = RequestMethod.POST, value = "/addUsuariosAdmin.do")
    public @ResponseBody
    String actualizarStatusOrganizaciones(UsuarioInstancia usuario, int id, Model model, HttpSession session, HttpServletRequest request)
    {
        usuario = usuarioInstanciaFacade.find(BigDecimal.valueOf(id));
        usuario.setStatus((short) 1);
        usuarioInstanciaFacade.edit(usuario);

        return "ok";
    }
}
