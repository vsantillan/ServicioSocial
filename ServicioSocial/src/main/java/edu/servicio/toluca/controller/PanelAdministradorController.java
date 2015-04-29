/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import edu.servicio.toluca.entidades.CatalogoObservaciones;
import edu.servicio.toluca.entidades.RegObservacionGeneral;
import edu.servicio.toluca.entidades.UsuarioInstancia;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ekt
 */
@Controller
public class PanelAdministradorController
{

    private GenericDao<UsuarioInstancia> daoUsuarioInstancia;
    private GenericDao<CatalogoObservaciones> daoCatalogoObservaciones;
    private GenericDao<RegObservacionGeneral> daoRegObservacionGeneral;

    @Autowired
    public void setDaoUsuarioInstancia(GenericDao<UsuarioInstancia> daoUsuarioInstancia)
    {
        this.daoUsuarioInstancia = daoUsuarioInstancia;
        daoUsuarioInstancia.setClass(UsuarioInstancia.class);
    }
    
    @Autowired
    public void setDaoCatalogoObservaciones (GenericDao<CatalogoObservaciones> daoCatalogoObservaciones)
    {
        this.daoCatalogoObservaciones = daoCatalogoObservaciones;
        daoCatalogoObservaciones.setClass(CatalogoObservaciones.class);
    }
    @Autowired
    public void setDaoRegObservacionGeneral (GenericDao<RegObservacionGeneral> daoRegObservacionGeneral)
    {
        this.daoRegObservacionGeneral = daoRegObservacionGeneral;
        daoRegObservacionGeneral.setClass(RegObservacionGeneral.class);
    }
    


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

            List<CatalogoObservaciones> catalogo = daoCatalogoObservaciones.findBySpecificField("tipo", "6", "equal", null, null);
            List<UsuarioInstancia> listaUsuarios = daoUsuarioInstancia.findBySpecificField("status", "1", "equal", null, null);
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

            model.addAttribute("listadoObservaciones", catalogo);
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
            List<UsuarioInstancia> listaUsuarios = daoUsuarioInstancia.findBySpecificField("status", "0", "equal", null, null);
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
            System.err.println(usuarioInstancia.getPassword());
            System.err.println(usuarioInstancia.getApellidoMat());
            System.err.println(usuarioInstancia.getApellidoPat());
            if(usuarioInstancia.getPassword().length() >= 6){
                
            
            try
            {
                usuarioInstancia.setStatus((short) 1);
                usuarioInstancia.setPassword(StringMD.getStringMessageDigest(usuarioInstancia.getPassword(), StringMD.SHA1));
                daoUsuarioInstancia.create(usuarioInstancia);
            } catch (Exception e)
            {
                System.out.println("Match");
            }
            }else{
                      model.addAttribute("error", "<div class='alter alert-warning error'>La contraseña debe de tener mas de 6 caracteres.</div>");
                      usuarioInstancia.setPassword(null);
                      model.addAttribute("usuarios", usuarioInstancia);
            return "/Usuarios/altaUsuarios";
            }
           
            return "redirect:administrarUsuarios.do";
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
        usuario = (UsuarioInstancia) daoUsuarioInstancia.find(BigDecimal.valueOf(id));
        usuario.setStatus((short) 1);
        daoUsuarioInstancia.edit(usuario);

        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editUser.do")
    public String editUser(int id, Model model, HttpSession session, HttpServletRequest request)
    {

        UsuarioInstancia usuario = (UsuarioInstancia) daoUsuarioInstancia.find(BigDecimal.valueOf(id));
        model.addAttribute("usuarios", usuario);
        System.out.println(usuario.getPassword());
        System.out.println(usuario.getIdUsuarioInstancia());

        System.out.println("ENTRO A EDIT USER");
        return "/Usuarios/editarUsuario";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/downUser.do")
    public @ResponseBody
    String downUser(@RequestParam(value = "observaciones[]", required = false) String[] observaciones, int id, int status, Model model, HttpSession session, HttpServletRequest request)
    {

        System.out.println("ENTRANDO......................................");

        UsuarioInstancia usuario = (UsuarioInstancia) daoUsuarioInstancia.find(BigDecimal.valueOf(id));
        System.out.println(usuario.getIdUsuarioInstancia());
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getApellidoMat());
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getPassword());

        for (String Observacion : observaciones)
        {

            CatalogoObservaciones catObser = (CatalogoObservaciones) daoCatalogoObservaciones.find(BigDecimal.valueOf(Integer.parseInt(Observacion)));
            //Objeto a Registrar
            RegObservacionGeneral registro = new RegObservacionGeneral();
            //Buscar Objeto Pertenciente al CatalogoObservaciones con el id recibido y asignarlo
            registro.setCatalogoObservacionId(catObser);
            //Buscar Objeto Pertenciente a la Tabla de DatosPersonales con el id recibido y asignarlo
            registro.setIdLlaveUnica(usuario.getIdUsuarioInstancia().toBigInteger());
            //Asignar Fecha Actual al momento para registro 
            registro.setFecha(new Date());
            //Creacion de Registro
            daoRegObservacionGeneral.create(registro);
            System.out.println("las observaciones son: " + Observacion);
        }
        usuario.setStatus((short) status);

        daoUsuarioInstancia.edit(usuario);

        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateUserData.do")
    public String updateUser(UsuarioInstancia usuario, String lockPass)
    {
        System.out.println("..............\n\n\n Entrando a controlador para modificar usuarios");
        System.out.println(usuario.getPassword());
        System.out.println("s:" + lockPass);

//        if (usuario.getPassword().equals(""))
//        {
        UsuarioInstancia usuarioL = (UsuarioInstancia) daoUsuarioInstancia.find(usuario.getIdUsuarioInstancia());
        usuarioL.setApellidoMat(usuario.getApellidoMat());
        usuarioL.setApellidoPat(usuario.getApellidoPat());
        usuarioL.setEmail(usuario.getEmail());
        usuarioL.setPuesto(usuario.getPuesto());
        usuarioL.setExtension(usuario.getExtension());
        usuarioL.setTelefono(usuario.getTelefono());
        usuarioL.setNombre(usuario.getNombre());
        usuarioL.setStatus((short) 1);
//        } else
//        {
        if ("".equals(usuario.getPassword()))
        {
            System.out.println("Mantener contraseña");
            usuarioL.setPassword(usuarioL.getPassword());
        } else
        {
            usuarioL.setPassword(StringMD.getStringMessageDigest(usuario.getPassword(), StringMD.SHA1));
        }

        daoUsuarioInstancia.edit(usuarioL);
//        }|
        return "redirect:administrarUsuarios.do";
    }
}
