/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.FormatoUnicoDatosAcademicosBean;
import edu.servicio.toluca.beans.FormatoUnicoDatosContactoBean;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersonalesBean;
import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoHorariosBean;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoProyectosJSON;
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.CatalogoPlan;
import edu.servicio.toluca.entidades.CatalogoSanciones;
import edu.servicio.toluca.entidades.Ciudades;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.entidades.FoliosPlatica;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.HorariosAlumno;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.MunicipiosSia;
import edu.servicio.toluca.entidades.Platica;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.RegObservaciones;
import edu.servicio.toluca.entidades.Sanciones;
import edu.servicio.toluca.entidades.TipoLocalidad;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.login.Conexion;
import edu.servicio.toluca.model.SancionesModelo;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.openide.util.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author WindSaber
 */
@Controller
public class FormatoUnicoController
{

//    // <editor-fold defaultstate="collapsed" desc="EJB Facades Formato Único">
//    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
//    private DatosPersonalesFacade datosPersonalesFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
//    private VistaAlumnoFacade vistaAlumnoFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
//    private FormatoUnicoFacade formatoUnicoFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
//    private EstadosSiaFacade estadosFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
//    private InstanciaFacade instanciaFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
//    private ProyectosFacade proyectoFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/HorariosAlumnoFacade")
//    private HorariosAlumnoFacade horarioFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
//    private ColoniaFacade coloniaFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
//    private DocumentosFacade documentoFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/CatalogoDocumentoFacade")
//    private CatalogoDocumentoFacade catalogoDocumentoFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/CatalogoPlanFacade")
//    private CatalogoPlanFacade catalogoPlanFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/FoliosPlaticaFacade")
//    private FoliosPlaticaFacade foliosPlaticaFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
//    private CodigosPostalesFacade codigosPostalesFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/CiudadesFacade")
//    private CiudadesFacade ciudadesFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/MunicipiosSiaFacade")
//    private MunicipiosSiaFacade municipiosFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/TipoLocalidadFacade")
//    private TipoLocalidadFacade tipoLocalidadFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/CatalogoSancionesFacade")
//    private CatalogoSancionesFacade catalogoSancionesFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/SancionesFacade")
//    private SancionesFacade sancionesFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/RegObservacionesFacade")
//    private RegObservacionesFacade regisObservacionesFacade;
    // </editor-fold>
    private GenericDao<DatosPersonales> daoDatosPersonales;
    private GenericDao<VistaAlumno> daoVistaAlumno;
    private GenericDao<FormatoUnico> daoFormatoUnico;
    private GenericDao<EstadosSia> daoEstadosSia;
    private GenericDao<Instancia> daoInstancia;
    private GenericDao<Proyectos> daoProyectos;
    private GenericDao<HorariosAlumno> daoHorariosAlumno;
    private GenericDao<Colonia> daoColonia;
    private GenericDao<Documentos> daoDocumentos;
    private GenericDao<CatalogoDocumento> daoCatalogoDocumento;
    private GenericDao<CatalogoPlan> daoCatalogoPlan;
    private GenericDao<FoliosPlatica> daoFoliosPlatica;
    private GenericDao<CodigosPostales> daoCodigosPostales;
    private GenericDao<Ciudades> daoCiudades;
    private GenericDao<MunicipiosSia> daoMunicipiosSia;
    private GenericDao<TipoLocalidad> daoTipoLocalidad;
    private GenericDao<CatalogoSanciones> daoCatalogoSanciones;
    private GenericDao<Sanciones> daoSanciones;
    private GenericDao<RegObservaciones> daoRegObservaciones;

    @Autowired
    public void setDaoDatosPersonales(GenericDao<DatosPersonales> daoDatosPersonales)
    {
        this.daoDatosPersonales = daoDatosPersonales;
        daoDatosPersonales.setClass(DatosPersonales.class);
    }

    @Autowired
    public void setDaoVistaAlumno(GenericDao<VistaAlumno> daoVistaAlumno)
    {
        this.daoVistaAlumno = daoVistaAlumno;
        daoVistaAlumno.setClass(VistaAlumno.class);
    }

    @Autowired
    public void setDaoFormatoUnico(GenericDao<FormatoUnico> daoFormatoUnico)
    {
        this.daoFormatoUnico = daoFormatoUnico;
        daoFormatoUnico.setClass(FormatoUnico.class);
    }

    @Autowired
    public void setDaoEstadosSia(GenericDao<EstadosSia> daoEstadosSia)
    {
        this.daoEstadosSia = daoEstadosSia;
        daoEstadosSia.setClass(EstadosSia.class);
    }

    @Autowired
    public void setDaoInstancia(GenericDao<Instancia> daoInstancia)
    {
        this.daoInstancia = daoInstancia;
        daoInstancia.setClass(Instancia.class);
    }

    @Autowired
    public void setDaoProyectos(GenericDao<Proyectos> daoProyectos)
    {
        this.daoProyectos = daoProyectos;
        daoProyectos.setClass(Proyectos.class);
    }

    @Autowired
    public void setDaoHorariosAlumno(GenericDao<HorariosAlumno> daoHorariosAlumno)
    {
        this.daoHorariosAlumno = daoHorariosAlumno;
        daoHorariosAlumno.setClass(HorariosAlumno.class);
    }

    @Autowired
    public void setDaoColonia(GenericDao<Colonia> daoColonia)
    {
        this.daoColonia = daoColonia;
        daoColonia.setClass(Colonia.class);
    }

    @Autowired
    public void setDaoDocumentos(GenericDao<Documentos> daoDocumentos)
    {
        this.daoDocumentos = daoDocumentos;
        daoDocumentos.setClass(Documentos.class);
    }

    @Autowired
    public void setDaoCatalogoDocumento(GenericDao<CatalogoDocumento> daoCatalogoDocumento)
    {
        this.daoCatalogoDocumento = daoCatalogoDocumento;
        daoCatalogoDocumento.setClass(CatalogoDocumento.class);
    }

    @Autowired
    public void setCatalogoPlan(GenericDao<CatalogoPlan> daoCatalogoPlan)
    {
        this.daoCatalogoPlan = daoCatalogoPlan;
        daoCatalogoPlan.setClass(CatalogoPlan.class);
    }

    @Autowired
    public void setDaoFoliosPlatica(GenericDao<FoliosPlatica> daoFoliosPlatica)
    {
        this.daoFoliosPlatica = daoFoliosPlatica;
        daoFoliosPlatica.setClass(FoliosPlatica.class);
    }

    @Autowired
    public void setDaoCodigosPostales(GenericDao<CodigosPostales> daoCodigosPostales)
    {
        this.daoCodigosPostales = daoCodigosPostales;
        daoCodigosPostales.setClass(DatosPersonales.class);
    }

    @Autowired
    public void setDaoCiudades(GenericDao<Ciudades> daoCiudades)
    {
        this.daoCiudades = daoCiudades;
        daoCiudades.setClass(Ciudades.class);
    }

    @Autowired
    public void setDaoMunicipiosSia(GenericDao<MunicipiosSia> daoMunicipiosSia)
    {
        this.daoMunicipiosSia = daoMunicipiosSia;
        daoMunicipiosSia.setClass(MunicipiosSia.class);
    }

    @Autowired
    public void setDaoTipoLocalidad(GenericDao<TipoLocalidad> daoTipoLocalidad)
    {
        this.daoTipoLocalidad = daoTipoLocalidad;
        daoTipoLocalidad.setClass(TipoLocalidad.class);
    }

    @Autowired
    public void setDaoCatalogoSanciones(GenericDao<CatalogoSanciones> daoCatalogoSanciones)
    {
        this.daoCatalogoSanciones = daoCatalogoSanciones;
        daoCatalogoSanciones.setClass(CatalogoSanciones.class);
    }

    @Autowired
    public void setDaoSanciones(GenericDao<Sanciones> daoSanciones)
    {
        this.daoSanciones = daoSanciones;
        daoSanciones.setClass(Sanciones.class);
    }

    @Autowired
    public void setDaoRegObservaciones(GenericDao<RegObservaciones> daoRegObservaciones)
    {
        this.daoRegObservaciones = daoRegObservaciones;
        daoRegObservaciones.setClass(RegObservaciones.class);
    }

    private static final Logger logger = LoggerFactory.getLogger(OrganizacionesController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/showpdf.do")
    public String showpdf(Model modelo, String alumno_id)
    {
        return "/FormatoUnico/showpdf";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuario.do")
    public String formatoUnico(Model modelo, String alumno_id, HttpSession session, HttpServletRequest request) throws ParseException
    {
        if (daoFoliosPlatica.count() == 0)
        {
            return "PanelUsuario/panelUsuario";
        }
        if (!new ValidaSesion().validaAlumno(session, request))
        {
            modelo.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }

        System.out.println("* EL número de control de la sessión es: " + session.getAttribute("NCONTROL").toString());
        alumno_id = session.getAttribute("NCONTROL").toString();
        modelo.addAttribute("formatoUnicoDatosPersonales", new FormatoUnicoDatosPersonalesBean());
        FormatoUnicoDatosPersonalesBean formatoUnicoDatosPersonalesbean = new FormatoUnicoDatosPersonalesBean();
        FormatoUnicoDatosContactoBean formatoUnicoDatosContacoBean = new FormatoUnicoDatosContactoBean();

        List<VistaAlumno> listaAlumnos = daoVistaAlumno.findBySpecificField("id", alumno_id, "equal", null, null);
        if (listaAlumnos.isEmpty())
        {
            System.err.println("La lista de alumnos está vacía");
            return "PanelUsuario/panelUsuario";
        }

        VistaAlumno alumno = listaAlumnos.get(0);
        System.out.println("Alumno encontrado: Nombre:" + alumno.getNombre() + " id:" + alumno.getId());

        // Check creditos necesarios
        if (Float.parseFloat(alumno.getPorcentaje()) < 70)
        {
            System.err.println("El alumno no tiene los créditos necesarios");
            return "PanelUsuario/panelUsuario";
        }

        //Creación de los objetos necesarios para inserción y lectura
        DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.setAlumnoId(alumno);
        FormatoUnico formatoUnico = new FormatoUnico();

        // Verificar si ya está en datos personales
        List<DatosPersonales> listaDatosPersonales = daoDatosPersonales.findBySpecificField("alumnoId", alumno, "equal", null, null);
        if (listaDatosPersonales.isEmpty())
        {
            // Si No fue dado de alta el alumno
            // Configura sus datos personales
            datosPersonales.setNombre(alumno.getNombre());
            datosPersonales.setApellidoP(alumno.getApellidoPat());
            datosPersonales.setApellidoM(alumno.getApellidoMat());
            datosPersonales.setCurp(alumno.getCurp().trim());
            datosPersonales.setSexo(alumno.getSexo());
            datosPersonales.setTelefonoCasa(alumno.getTelefono());
            datosPersonales.setCorreoElectronico(alumno.getEMail());
            datosPersonales.setEstadoCivil("SOLTERO");
            datosPersonales.setOcupacion("");
            datosPersonales.setClaveDocIdentificacion("");
            datosPersonales.setFolioDocIdentificaciin(BigInteger.ZERO);

            // Configura datos de domicilio
            datosPersonales.setCalle("");
            datosPersonales.setNumeroI("");
            datosPersonales.setNumeroE("");

            Colonia co = (Colonia) daoColonia.find(BigDecimal.ONE);
            datosPersonales.setIdColonia(co);
            datosPersonales.setEntreCalles("");
            datosPersonales.setReferencia("");
            datosPersonales.setTelefonoCasa("");
            datosPersonales.setTelefonoCel("");
            datosPersonales.setTelefonoOficina("");
            datosPersonales.setTwitter("");
            datosPersonales.setFacebook("");

            // Persistimos el objeto datosPersonales
            daoDatosPersonales.create(datosPersonales);

            // Configuración de datos de Formato Unico
            formatoUnico.setDatosPersonalesId(datosPersonales);
            formatoUnico.setNumeroCreditos(alumno.getCreditosAcumulados());
            formatoUnico.setPorcentajeCreditos(Double.valueOf(alumno.getPorcentaje()));
            formatoUnico.setStatusServicio(BigInteger.ONE);

            CatalogoPlan plan = (CatalogoPlan) daoCatalogoPlan.find(new BigDecimal(alumno.getPlanId()));
            formatoUnico.setCatalogoPlanId(plan);

            List<FoliosPlatica> listaFolios = daoFoliosPlatica.findBySpecificField("alumnoId", alumno, "equal", null, null);
            if (listaFolios.isEmpty())
            {
                return "PanelUsuario/panelUsuario";
            }

            // Si asisitio a la platica
            FoliosPlatica platica = listaFolios.get(0);
            formatoUnico.setPeriodoInicio(platica.getPlaticaId().getPeriodo());
            formatoUnico.setTipoServicio(BigInteger.ONE);
            formatoUnico.setStatusServicio(BigInteger.ONE);
            formatoUnico.setHorasAcumuladas(BigInteger.ZERO);
            formatoUnico.setStatusFuf(BigInteger.ZERO);

            // Asigna proyecto al alumno
            List<Proyectos> listaProyectos = daoProyectos.findAll();
            if (listaProyectos.isEmpty())
            {
                System.err.println("La lista de proyectos está vacía");
                return "PanelUsuario/panelUsuario";
            }

            Proyectos proyecto = listaProyectos.get(0);
            System.err.println("Nombre del responsable del proyecto-----------------------------------------------------------");
            System.out.println(proyecto.getNombreResponsable());
            formatoUnico.setIdproyecto(proyecto);
//            fechas manejoFechas = new fechas();
//            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
//            formatoUnico.setFechaInicio(manejoFechas.covierteString(formatoFecha.format(new java.util.Date())));
            formatoUnico.setFechaInicio(new java.util.Date());
            daoFormatoUnico.create(formatoUnico);

            // Setear en vacío los horarios alumno 
            // Recuperar el objeto FormatoUnico que se acaba de insertar para insertarlo en los horarios_alumno
            List<FormatoUnico> listaFormatoUnico = daoFormatoUnico.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
            if (listaFormatoUnico.isEmpty())
            {
                System.err.println("La lista de formatoUnico está vacía");
                return "PanelUsuario/panelUsuario";
            }

            FormatoUnico fuiAux = listaFormatoUnico.get(0);
            for (int i = 1; i <= 5; i++) // Día{1=Lunes, 2=Martes, 3=Miercoles ...}
            {
                HorariosAlumno horariosAlumno2 = new HorariosAlumno();
                horariosAlumno2.setFormatoUnicoId(fuiAux);
                horariosAlumno2.setDia(i + "");
                horariosAlumno2.setHoraInicio(" ");
                horariosAlumno2.setHoraFin(" ");
                daoHorariosAlumno.create(horariosAlumno2);
            }
        } else // Si el alumno ya existe en la base de datos de servicio social
        {
            // Recuperación del Objeto DatosPersonales
            DatosPersonales dp2 = listaDatosPersonales.get(0);

            // Consultas de los objetos necesarios para el despliegue de la vista alumno
            //Aquí en esta línea no funciona el DAO y no sé por qué, perdón les he fallado.
            List<FormatoUnico> listaFormatoUnico = daoFormatoUnico.findBySpecificField("datosPersonalesId", dp2, "equal", null, null);
            System.err.println("El alumno ya está, su id de datosPersonales es " + listaDatosPersonales.get(0).getId());

            // Asignación a objetos para posteriormente preparar
            datosPersonales = listaDatosPersonales.get(0);
            formatoUnico = listaFormatoUnico.get(0);

            // Validar que el alumno esté rechazado o en correción
            if (formatoUnico.getStatusFui() != null)
            {
                System.out.println("El status del fui es" + formatoUnico.getStatusFui().toString());
                if (formatoUnico.getStatusFui().toString().equals("5") || formatoUnico.getStatusFui().toString().equals("2") || formatoUnico.getStatusFui().toString().equals("3") || formatoUnico.getStatusFui() == null)
                {
                    System.out.println("Su formato único está en correción o fue rechazado, puede entrar");
                } else
                {
                    System.out.println("El formato único no puede entrar, anda en validaciones o ya fue aceptado");
                    return "PanelUsuario/panelUsuario";
                }
            }
        }

        // Datos personales
        formatoUnicoDatosPersonalesbean.setId(datosPersonales.getId());
        formatoUnicoDatosPersonalesbean.setNombre(datosPersonales.getNombre());
        formatoUnicoDatosPersonalesbean.setApellidoP(datosPersonales.getApellidoP());
        formatoUnicoDatosPersonalesbean.setApellidoM(datosPersonales.getApellidoM());
        formatoUnicoDatosPersonalesbean.setSexo(datosPersonales.getSexo());
        formatoUnicoDatosPersonalesbean.setCurp(datosPersonales.getCurp().trim());
        formatoUnicoDatosPersonalesbean.setEstado_civil(datosPersonales.getEstadoCivil());
        formatoUnicoDatosPersonalesbean.setOcupacion(datosPersonales.getOcupacion());
        formatoUnicoDatosPersonalesbean.setClaveDocIdentificacion(datosPersonales.getClaveDocIdentificacion());
        formatoUnicoDatosPersonalesbean.setFolioDocIdentificacion(datosPersonales.getFolioDocIdentificaciin().toString());
        formatoUnicoDatosPersonalesbean.setLugar_nacimiento(datosPersonales.getLugarNacimiento());
        modelo.addAttribute("formatoUnicoDatosPersonales", formatoUnicoDatosPersonalesbean);

        // Datos de contacto
        formatoUnicoDatosContacoBean.setCalle(datosPersonales.getCalle());
        formatoUnicoDatosContacoBean.setId(datosPersonales.getId());
        formatoUnicoDatosContacoBean.setNumeroE(datosPersonales.getNumeroE());
        formatoUnicoDatosContacoBean.setNumeroI(datosPersonales.getNumeroI());
        //formatoUnicoDatosContacoBean.setColonia(datosPersonales.getIdColonia());
        formatoUnicoDatosContacoBean.setEntreCalles(datosPersonales.getEntreCalles());
        formatoUnicoDatosContacoBean.setReferencias(datosPersonales.getReferencia());
        formatoUnicoDatosContacoBean.setTelefono_casa(datosPersonales.getTelefonoCasa());
        formatoUnicoDatosContacoBean.setTelefono_cel(datosPersonales.getTelefonoCel());
        formatoUnicoDatosContacoBean.setTelefono_oficina(datosPersonales.getTelefonoOficina());
        formatoUnicoDatosContacoBean.setCorreo_electronico(datosPersonales.getCorreoElectronico());
        formatoUnicoDatosContacoBean.setTwitter(datosPersonales.getTwitter());
        formatoUnicoDatosContacoBean.setFacebook(datosPersonales.getFacebook());
        modelo.addAttribute("formatoUnicoDatosContacto", formatoUnicoDatosContacoBean);

        // Datos academicos
        FormatoUnicoDatosAcademicosBean formatoUnicoDatosAcademicos = new FormatoUnicoDatosAcademicosBean();
        formatoUnicoDatosAcademicos.setNcontrol(alumno.getId());
        formatoUnicoDatosAcademicos.setCarrera(alumno.getCarrera());
        formatoUnicoDatosAcademicos.setPeriodo("AGO-DIC");
        formatoUnicoDatosAcademicos.setSemestre(alumno.getSemActual());
        formatoUnicoDatosAcademicos.setCc(alumno.getCreditosAcumulados());
        formatoUnicoDatosAcademicos.setPcc(alumno.getPorcentaje());
        modelo.addAttribute("academicos", formatoUnicoDatosAcademicos);

        // Estados
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        modelo.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));

        // Instancias
        List<Instancia> listaInstancias = daoInstancia.findBySpecificField("status", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
        for (int i = 0; i < listaInstancias.size(); i++)
        {
            if (listaInstancias.get(i).getStatus() == 1)
            {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }

        listaInstancias = daoInstancia.findBySpecificField("status", "3", "equal", null, null);
        for (Instancia ins : listaInstancias)
        {
            System.out.println("Revisando si la instancia es propuesta");
            System.out.println("La que se tiene en el fui es " + formatoUnico.getIdproyecto().getIdInstancia().getNombre());
            System.out.println("La que está en el foreach es " + ins.getNombre());
            String idLeido = formatoUnico.getIdproyecto().getIdInstancia().getIdInstancia().toString();
            String idInstFU = ins.getIdInstancia().toString();
            if (idLeido.equals(idInstFU))
            {
                System.out.println("Se agregará a la lista una instancia del alumno");
                filtroInstancias.add(ins);
            }
        }

        modelo.addAttribute("instancias", filtroInstancias);
        System.err.println("lo que mando al facade es: " + datosPersonales.getIdColonia().getIdColonia());
        Colonia col = (Colonia) daoColonia.find(datosPersonales.getIdColonia().getIdColonia());
        System.out.println("CP: " + col.getIdCp().getCp());
        modelo.addAttribute("codigoPostal", col.getIdCp().getCp());
        modelo.addAttribute("preColonia", datosPersonales.getIdColonia().getIdColonia());

        // Carga la información que se tiene en la bd del alumno
        FormatoUnicoProyectosJSON formatoUnicoProyectosJON = new FormatoUnicoProyectosJSON();
        formatoUnicoProyectosJON.setId(datosPersonales.getId());
        formatoUnicoProyectosJON.setIdProyecto(formatoUnico.getIdproyecto().getIdProyecto());
        System.out.println("Id de fui" + formatoUnico.getId());
        System.out.println("id de datos perso del fui" + formatoUnico.getDatosPersonalesId().getId());
        System.out.println("El  proy asignado es " + formatoUnico.getIdproyecto().getIdProyecto());
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        formatoUnicoProyectosJON.setFecha_inicio(formatoUnico.getFechaInicio());
        modelo.addAttribute("formatoUnicoDatosOrganizaciones", formatoUnicoProyectosJON);

        // Formato de los horarios
        FormatoUnicoHorariosBean formatoUnicoHorariosBean = new FormatoUnicoHorariosBean();
        formatoUnicoHorariosBean.setId(formatoUnico.getId());
        List<HorariosAlumno> listaHorariosAlumno = daoHorariosAlumno.findBySpecificField("formatoUnicoId", formatoUnico, "equal", null, null);
        for (HorariosAlumno hor : listaHorariosAlumno)
        {
            if (hor.getDia().equals("1"))
            {
                if (hor.getHoraInicio() == null)
                {
                    formatoUnicoHorariosBean.setLuI(" ");
                } else
                {
                    formatoUnicoHorariosBean.setLuI(hor.getHoraInicio());
                }
                if (hor.getHoraFin() == null)
                {
                    formatoUnicoHorariosBean.setLuF(" ");
                } else
                {
                    formatoUnicoHorariosBean.setLuF(hor.getHoraFin());
                }
            }
            if (hor.getDia().equals("2"))
            {
                if (hor.getHoraInicio() == null)
                {
                    formatoUnicoHorariosBean.setMaI(" ");
                }
                formatoUnicoHorariosBean.setMaI(hor.getHoraInicio());
                if (hor.getHoraFin() == null)
                {
                    formatoUnicoHorariosBean.setMaF(" ");
                } else
                {
                    formatoUnicoHorariosBean.setMaF(hor.getHoraFin());
                }
            }
            if (hor.getDia().equals("3"))
            {
                System.out.println("horario" + hor.getHoraFin());
                if (hor.getHoraInicio() == null)
                {
                    formatoUnicoHorariosBean.setMiI(" ");
                } else
                {
                    formatoUnicoHorariosBean.setMiI(hor.getHoraInicio());
                }
                if (hor.getHoraFin() == null)
                {
                    formatoUnicoHorariosBean.setMiF(" ");
                } else
                {
                    formatoUnicoHorariosBean.setMiF(hor.getHoraFin());
                }
            }
            if (hor.getDia().equals("4"))
            {
                if (hor.getHoraInicio() == null)
                {
                    formatoUnicoHorariosBean.setJuI(" ");
                } else
                {
                    formatoUnicoHorariosBean.setJuI(hor.getHoraInicio());
                }
                if (hor.getHoraFin() == null)
                {
                    formatoUnicoHorariosBean.setJuF(" ");
                } else
                {
                    formatoUnicoHorariosBean.setJuF(hor.getHoraFin());
                }
            }
            if (hor.getDia().equals("5"))
            {
                if (hor.getHoraInicio() == null)
                {
                    formatoUnicoHorariosBean.setViI(" ");
                } else
                {
                    formatoUnicoHorariosBean.setViI(hor.getHoraInicio());
                }
                if (hor.getHoraFin() == null)
                {
                    formatoUnicoHorariosBean.setViF(" ");
                } else
                {
                    formatoUnicoHorariosBean.setViF(hor.getHoraFin());
                }
            }

        }
        modelo.addAttribute("formatoUnicoHorarios", formatoUnicoHorariosBean);

        // Para subir archivos
        modelo.addAttribute("idDatSubida", datosPersonales.getId());
        System.out.println("Antes de mostrar el status fui es:" + formatoUnico.getStatusFui());
        if (formatoUnico.getStatusFui() != null)
        {
            modelo.addAttribute("infoDescarga", "<div class='form-group'><label>Seleccione un Formato &Uacute;nico</label><br><input type='file' id='idfile' name ='file' class='btn btn-primary' title='Buscar en mi equipo'></input></div>\n"
                    + "                         <div class='form-group'><label>&nbsp;</label><input type='button' id='subeFui' value='Subir' class='btn btn-primary' /></div>"
                    + "                         <div class='error alert alert-danger' style=\"display:none;\"></div> ");
        } else
        {
            modelo.addAttribute("infoDescarga", "<h1 style='color: #990000'>Se ha detectado que aun no descargas tu formato &uacute;nico, dicha tarea la puedes hacer en la secci&oacute; anterior. Gracias</h1>");
        }

        return "/FormatoUnico/formatoUnicoUsuario";
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new FormatoUnicoDatosPersoValidaciones()); // registramos el validador
//    }
    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosPersonales.do")
    public @ResponseBody
    String modificarDatosPersonalesAlumno(@Valid FormatoUnicoDatosPersonalesBean dt, BindingResult resultado)
    {
        String arrJSON = "[";
        dt.arregla();
        ArrayList<String> listaErrores = dt.Valida();
        if (!dt.isAcuerdoC())
        {
            listaErrores.add("No has seleccionado la opción del Acuerdo de confidencialidad");
        }

        if (resultado.hasErrors())
        {
            System.out.println("#####Todo estaa mal####");
            for (int i = 0; i < resultado.getAllErrors().size(); i++)
            {
                System.out.println("Los errores son: " + resultado.getAllErrors().get(i).getDefaultMessage());
                listaErrores.add(resultado.getAllErrors().get(i).getDefaultMessage());
            }
        }

        if (listaErrores.isEmpty())
        {
            System.out.println("No hubo errores");
            System.out.println(dt.getId());
            System.out.println(dt.getSexo());
            DatosPersonales datosPersonales = (DatosPersonales) daoDatosPersonales.find(dt.getId());
            datosPersonales.setNombre(dt.getNombre());
            datosPersonales.setApellidoP(dt.getApellidoP());
            datosPersonales.setApellidoM(dt.getApellidoM());
            datosPersonales.setSexo(dt.getSexo());
            datosPersonales.setEstadoCivil(dt.getEstado_civil());
            datosPersonales.setOcupacion(dt.getOcupacion());
            datosPersonales.setCurp(dt.getCurp().trim());
            datosPersonales.setLugarNacimiento(dt.getLugar_nacimiento());
            datosPersonales.setFolioDocIdentificaciin(new BigInteger(dt.getFolioDocIdentificacion()));
            datosPersonales.setClaveDocIdentificacion(dt.getClaveDocIdentificacion());
            daoDatosPersonales.edit(datosPersonales);

        } else
        {
            int i = 1;
            for (String s : listaErrores)
            {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("["))
        {
            arrJSON = "noInfo";
        } else
        {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }

        System.out.println("Arrjson" + arrJSON);
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosContacto.do")
    public @ResponseBody
    String modificarDatosContactoAlumno(Model modelo, @Valid FormatoUnicoDatosContactoBean dt, BindingResult resultado,
            String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad)
    {
        MetodosValidacion mv = new MetodosValidacion();
        String arrJSON = "[";
        dt.arregla();

        ArrayList<String> listaErrores = dt.Valida();
        if (resultado.hasErrors())
        {
            System.out.println("#####Todo estaa mal####");
            for (int i = 0; i < resultado.getAllErrors().size(); i++)
            {
                System.out.println("Los errores son: " + resultado.getAllErrors().get(i).getDefaultMessage());
                listaErrores.add(resultado.getAllErrors().get(i).getDefaultMessage());
            }
        }
        //Checa Numero Interior

        if (!dt.getNumeroI().equals(""))
        {
            System.out.println(dt.getNumeroI() + "el numero interio");
            try
            {
                int numeroInterior = Integer.parseInt(dt.getNumeroI());
            } catch (Exception e)
            {
                listaErrores.add("El Número interior debe ser númerico");
            }
        }
        //Checa codigo postal
        if (codigo_postal.equals(""))
        {
            listaErrores.add("Ingrese un codigo postal");
        } else
        {
            if (codigo_postal.length() != 5)
            {
                listaErrores.add("El codigo posta debe de tener 5 digitos");
            }
        }
        try
        {
            Integer.parseInt(codigo_postal);
        } catch (Exception e)
        {
            listaErrores.add("El codigo postal debe ser númerico");
        }
        if (listaErrores.isEmpty())
        {
            DatosPersonales datosPersonales = (DatosPersonales) daoDatosPersonales.find(dt.getId());
            datosPersonales.setCalle(dt.getCalle());
            datosPersonales.setNumeroI(dt.getNumeroI());
            datosPersonales.setNumeroE(dt.getNumeroE());
            datosPersonales.setEntreCalles(dt.getEntreCalles());
            datosPersonales.setReferencia(dt.getReferencias());
            datosPersonales.setTelefonoCasa(dt.getTelefono_casa());
            datosPersonales.setTelefonoCel(dt.getTelefono_cel());
            datosPersonales.setTelefonoOficina(dt.getTelefono_oficina());
            datosPersonales.setCorreoElectronico(dt.getCorreo_electronico());
            datosPersonales.setFacebook(dt.getFacebook());
            datosPersonales.setTwitter(dt.getTwitter());

///////////Nueva manera de códigos postales
            //Valida codigo postal
//        if (existeCP.equals("true")) {
//            try {
//                if (dt.getIdColonia().getIdColonia().toString().equals("0")) {
//                    if (otra_colonia.equals("")) {
//                        resultado.addError(new ObjectError("error_otra_colonia", "No ha ingresado el nombre de la colonia."));
//                        //modelo.addAttribute ("error_otra_colonia", error("No ha ingresado el nombre de la colonia."));
//                    }
//                }
//            } catch (Exception e) {
//            }
//        } else {
//            if (otra_colonia.equals("")) {
//                resultado.addError(new ObjectError("error_otra_colonia", "No ha ingresado el nombre de la colonia."));
//                //modelo.addAttribute("error_otra_colonia", error("No ha ingresado el nombre de la colonia."));
//            }
//        }
            if (existeCP.equals("true"))
            {
                if (dt.getIdColonia().getIdColonia().toString().equals("0"))
                {
                    //Agregar colonia                   
//                    instancia.setIdColonia(new CodigosPostalesController().agregaColonia(model, codigo_postal, otra_colonia));
                    System.out.println("AgregarColonia");
                    System.out.println("codigo postal:" + codigo_postal.toString());
                    List<CodigosPostales> codigosPostales = daoCodigosPostales.findBySpecificField("cp", codigo_postal, "equal", null, null);
                    CodigosPostales codigoPostal = codigosPostales.get(0);
                    Colonia nvaColonia = new Colonia();
                    otra_colonia = mv.tuneaStringParaBD(otra_colonia);
                    nvaColonia.setNombre(otra_colonia);
                    nvaColonia.setIdCp(codigoPostal);
                    nvaColonia.setStatus(BigInteger.ONE);
                    daoColonia.create(nvaColonia);

                    //Obtenemos la ultima colonia
                    LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                    ordenamiento.put("idColonia", "desc");
                    Colonia colonia = (Colonia) daoColonia.findAll(ordenamiento).get(0);
                    dt.setIdColonia(colonia);
                    System.out.println("Nueva colonia agregada!");
                }
            } else
            {
                //Agregar codigo postal + colonia
//                instancia.setIdColonia(new CodigosPostalesController().agregarCodigoPostal(codigo_postal, otra_colonia, estado, municipio, ciudad));
                EstadosSia estadoP = (EstadosSia) daoEstadosSia.find(BigDecimal.valueOf(Double.parseDouble(estado)));
                MunicipiosSia municipioP = (MunicipiosSia) daoMunicipiosSia.find(BigDecimal.valueOf(Double.parseDouble(municipio)));
                TipoLocalidad localidad = (TipoLocalidad) daoTipoLocalidad.find(BigDecimal.ONE);
                Ciudades ciudadP = null;
                try
                {
                    ciudadP = (Ciudades) daoCiudades.find(BigDecimal.valueOf(Double.parseDouble(ciudad)));
                } catch (Exception e)
                {
                    System.out.println("No tiene ciudad");
                }

                CodigosPostales codigoPostal = new CodigosPostales();
                codigoPostal.setCp(Integer.parseInt(codigo_postal));
                codigoPostal.setIdMunicipio(municipioP);
                codigoPostal.setIdEstado(estadoP);
                codigoPostal.setIdTipoLocalidad(localidad);
                if (ciudad != null)
                {
                    codigoPostal.setIdCiudad(ciudadP);
                }
                daoCodigosPostales.create(codigoPostal);

                //Obtenemos el Ultimo codigo postal
                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("idCp", "desc");
                CodigosPostales codigoPostalNew = (CodigosPostales) daoCodigosPostales.findAll(ordenamiento).get(0);

                Colonia colonia = new Colonia();
                colonia.setIdCp(codigoPostal);
                otra_colonia = mv.tuneaStringParaBD(otra_colonia);
                colonia.setNombre(otra_colonia);
                colonia.setStatus(BigInteger.ONE);

                daoColonia.create(colonia);

                //Obtenemos la ultima colonia
                ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("idColonia", "desc");
                Colonia coloniaNew = (Colonia) daoColonia.findAll(ordenamiento).get(0);
                dt.setIdColonia(coloniaNew);
                System.out.println("Nuevo codigo postal + colonia agregado!");
            }

///////////Termina códigos postales        
            System.out.println("coloonia" + dt.getIdColonia() + "  " + dt.getIdColonia().getNombre());
            datosPersonales.setIdColonia(dt.getIdColonia());
            daoDatosPersonales.edit(datosPersonales);
        } else
        {
            int i = 1;
            for (String s : listaErrores)
            {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("["))
        {
            arrJSON = "noInfo";
        } else
        {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }

        System.out.println("Arrjson" + arrJSON);
        return arrJSON;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosOrganizaciones.do")
    public @ResponseBody
    String modificarDatosOrganizaciones(FormatoUnicoDatosContactoBean dt, Date fecha_inicio, BigDecimal proyecto, BindingResult resultado)
    {
        System.out.println("recibí" + proyecto);
        DatosPersonales datosPersonales = (DatosPersonales) daoDatosPersonales.find(dt.getId());
        System.out.println("Datos per" + datosPersonales.getNombre());
        System.out.println("Rec" + dt.getId());

        System.out.println("La fecha recibida es" + fecha_inicio);
        List<FoliosPlatica> listaF = daoFoliosPlatica.findBySpecificField("alumnoId", datosPersonales.getAlumnoId(), "equal", null, null);
        FoliosPlatica fp = listaF.get(0);
        Date fechaMax = new java.sql.Date(fp.getPlaticaId().getFechaMxFui().getTime());
        if (fecha_inicio == null)
        {
            System.out.println("fallo el vacio");
            return "El campo Fecha de Inicio está vacío. Verificalo";
        }
        if (fecha_inicio.after(fechaMax))
        {
            System.out.println("Fallo la fecha");
            return "fallo fecha";
        }

        List<FormatoUnico> listaFormatoUnico = daoFormatoUnico.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        FormatoUnico formatoUnico = listaFormatoUnico.get(0);
        // System.out.println("Recibí" + organizacion);
        Proyectos proyectoG = new Proyectos();
        proyectoG.setIdProyecto(proyecto);
        formatoUnico.setIdproyecto(proyectoG);
        formatoUnico.setFechaInicio(fecha_inicio);

        // formatoUnico.setFechaInicio(fj.getFecha_inicio());
        try
        {
            daoFormatoUnico.edit(formatoUnico);
            return "Informacion Almacenada correctamente";
        } catch (Exception e)
        {
            return "Hubo un Problema al Guardar tu información";
        }

        //return new FormatoUnicoErrores();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuarioObservaciones.do")
    public String formatoUnicoObservaciones(Model a)
    {

        return "/FormatoUnico/formatoUnicoUsuarioObservaciones";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pruebaDT.do")
    public String formatoUnicoPruebaDT(Model a)
    {

        return "/FormatoUnico/pruebaDT";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cargarProyectos.do")
    public @ResponseBody
    FormatoUnicoProyectosJSON cargarProyectos(Model a, String id_instancia, String id_datos_personales)
    {
        if (id_instancia == null && id_instancia.trim().equals(""))
        {
            // Abortar la busqueda
        }

        System.err.println("Cargando proyectos para: " + id_instancia);

        BigDecimal idDP = new BigDecimal(id_datos_personales);
        List<Instancia> listaInstancias = daoInstancia
                .findBySpecificField("idInstancia", BigDecimal.valueOf(Double.valueOf(id_instancia.trim())), "equal", null, null);
        Instancia instancia = listaInstancias.get(0);

        FormatoUnicoProyectosJSON fuiJSON = new FormatoUnicoProyectosJSON();
        DatosPersonales dp = (DatosPersonales) daoDatosPersonales.find(idDP);
        VistaAlumno alumno = (VistaAlumno) daoVistaAlumno.find(dp.getAlumnoId().getId());

        List<Proyectos> proyectos = new ArrayList<Proyectos>(instancia.getProyectosCollection());
        System.err.println("Se encontraron " + proyectos.size() + " proyectos para la instancia: " + instancia.getIdInstancia() + ": " + instancia.getNombre());

        for (Proyectos proy : proyectos)
        {
            int vacantesDisp = Integer.parseInt(proy.getVacantesDisponibles().toString());
            if (vacantesDisp > 0)
            {
                if (proy.getProyectoPerfilCollection().isEmpty())
                {
                    System.err.println("oxx Agregando uno sin coleccion perfiles");
                    fuiJSON.getId_instancia().add(instancia.getIdInstancia());
                    fuiJSON.getId_proyecto().add(proy.getIdProyecto());
                    fuiJSON.getNombre().add(proy.getNombre());
                    fuiJSON.getDomicilio().add(proy.getDomicilio());
                    fuiJSON.getNombre_responsable().add(proy.getNombreResponsable());
                    fuiJSON.getTelefono_responsable().add(proy.getTelefonoResponsable());
                } else
                {
                    for (ProyectoPerfil per : proy.getProyectoPerfilCollection())
                    {
                        System.out.println("xxx Carrera id: " + alumno.getCarreraId());
                        System.out.println("xxx Perfil p/proy" + per.getIdPerfil());
                        System.out.println("xxx Proyecto id ..... p/proy" + per.getIdProyecto());
                        System.out.println("xxx Nombre: " + per.getIdProyecto().getNombre());
                        System.out.println("id persona: " + per.getIdPerfil().getIdPerfil().toString() + "   id carrera " + (new BigDecimal(alumno.getCarreraId()).toString()));

                        if (per.getIdPerfil().getIdPerfil().toString().equals(new BigDecimal(alumno.getCarreraId()).toString()))
                        {
                            System.err.println("oxx Agregando uno de perfil");

                            fuiJSON.getId_instancia().add(instancia.getIdInstancia());
                            fuiJSON.getId_proyecto().add(proy.getIdProyecto());
                            fuiJSON.getNombre().add(proy.getNombre());
                            fuiJSON.getDomicilio().add(proy.getDomicilio());
                            fuiJSON.getNombre_responsable().add(proy.getNombreResponsable());
                            fuiJSON.getTelefono_responsable().add(proy.getTelefonoResponsable());
                        }
                    }
                }
            }

        }
        return fuiJSON;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/idInstancia.do")
    public @ResponseBody
    FormatoUnicoProyectosJSON idInstancia(Model a, BigDecimal idProyecto)
    {

        List<Proyectos> listaProys = daoProyectos.findBySpecificField("idProyecto", idProyecto, "equal", null, null);
        Proyectos pr = listaProys.get(0);
        FormatoUnicoProyectosJSON fuiJSON = new FormatoUnicoProyectosJSON();
        fuiJSON.setIdProyecto(pr.getIdInstancia().getIdInstancia());
        return fuiJSON;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarHorarios.do")
    public @ResponseBody
    String modificarHorarios(Model a, FormatoUnicoHorariosBean hb) throws ParseException
    {
        String arrJSON = "[";
        //hb.arregla();
        ArrayList<String> listaErrores = hb.Valida();
        if (listaErrores.isEmpty())
        {
            System.out.println("No hubo errores");
            List<FormatoUnico> listaFui = daoFormatoUnico.findBySpecificField("id", hb.getId(), "equal", null, null);
            FormatoUnico formatoUnico = listaFui.get(0);
            List<HorariosAlumno> listaHorariosAlumno = daoHorariosAlumno.findBySpecificField("formatoUnicoId", formatoUnico, "equal", null, null);
            for (HorariosAlumno hor : listaHorariosAlumno)
            {
                if (hor.getDia().equals("1"))
                {
                    hor.setHoraInicio(hb.getLuI());
                    hor.setHoraFin(hb.getLuF());
                    daoHorariosAlumno.edit(hor);
                }
                if (hor.getDia().equals("2"))
                {
                    hor.setHoraInicio(hb.getMaI());
                    hor.setHoraFin(hb.getMaF());
                    daoHorariosAlumno.edit(hor);
                }
                if (hor.getDia().equals("3"))
                {
                    hor.setHoraInicio(hb.getMiI());
                    hor.setHoraFin(hb.getMiF());
                    daoHorariosAlumno.edit(hor);
                }
                if (hor.getDia().equals("4"))
                {
                    hor.setHoraInicio(hb.getJuI());
                    hor.setHoraFin(hb.getJuF());
                    daoHorariosAlumno.edit(hor);
                }
                if (hor.getDia().equals("5"))
                {
                    hor.setHoraInicio(hb.getViI());
                    hor.setHoraFin(hb.getViF());
                    daoHorariosAlumno.edit(hor);
                }

            }
        } else
        {
            int i = 1;
            for (String s : listaErrores)
            {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("["))
        {
            arrJSON = "noInfo";
        } else
        {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }

        System.out.println("Arrjson" + arrJSON);
        return arrJSON;

    }
    ////PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!

    @RequestMapping(value = "/subirFui.do", method = RequestMethod.POST)
    public String save(MultipartFile file, BigDecimal id, Model modelo) throws IOException
    {
        List<Documentos> listaDocumento = daoDocumentos.findBySpecificField("datosPersonalesId", id, "equal", null, null);
        List<CatalogoDocumento> listaCatalogoDocumento = daoCatalogoDocumento.findBySpecificField("tipo", "Formato_Unico", "equal", null, null);
        System.out.println("Inicia subida de info");
        System.out.println("Original filename: " + file.getOriginalFilename());
        System.out.println("File:" + file.getName());
        System.out.println("Size:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        Documentos doc = new Documentos();
        if (!listaDocumento.isEmpty())
        {
            doc = (Documentos) daoDocumentos.find(listaDocumento.get(0).getId());
        }
        doc.setDatosPersonalesId((DatosPersonales) daoDatosPersonales.find(id));
        doc.setArchivo(file.getBytes());
        doc.setCatalogoDocumentosId(listaCatalogoDocumento.get(0));
        int mid = file.getOriginalFilename().lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(mid + 1, file.getOriginalFilename().length());
        //String extension = file.getOriginalFilename();
        //extension = extension.substring(extension.length() - 3, extension.length());
        //**doc.setExtension("pdf");
        doc.setExtension(extension);
        doc.setFechaSubida(new java.util.Date());
        DatosPersonales dp = (DatosPersonales) daoDatosPersonales.find(id);
        List<FormatoUnico> listaFui = daoFormatoUnico.findBySpecificField("datosPersonalesId", dp, "equal", null, null);
        FormatoUnico fui = listaFui.get(0);
        fui.setStatusFui(new BigInteger("4"));
        daoFormatoUnico.edit(fui);
        if (listaDocumento.isEmpty())
        {
            System.out.println("Subida nueva");
            remueveObservaciones(id);
            daoDocumentos.create(doc);
        } else
        {
            System.out.println("Ya estaba");
            remueveObservaciones(id);
            daoDocumentos.edit(doc);

        }

//        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", id.toString(), "equal", null, null);
//        VistaAlumno alumno = listaAlumnos.get(0);
        List<FoliosPlatica> listaFolios = daoFoliosPlatica.findBySpecificField("alumnoId", dp.getAlumnoId(), "equal", null, null);
        if (listaFolios.isEmpty())
        {
            System.out.println("No aexiste alumno en platica");
        }
        FoliosPlatica folioPlatica = listaFolios.get(0);
        Platica platica = folioPlatica.getPlaticaId();
        java.util.Date fecha_max = platica.getFechaMxFui();
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        //----Asignar la sanción---
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        SancionesModelo sm = new SancionesModelo(daoCatalogoSanciones, daoSanciones, fecha_max, dp, "S001");
        sm.asignaSancion();

//        java.util.Date fecha_actual = new java.util.Date();
//        System.out.println("La fecha actual es: " + fecha_actual);
//        System.out.println("La fecha máxima es:" + fecha_max);
//        if(fecha_actual.after(fecha_max))//fecha_max el la fecha máxima que tengas definida
//        {
//            System.out.println("La fecha actual sobrepasa la fecha máxima, procedo a revisar tolerancia");
//            if(catalogoSancionesFacade.count()<1)
//            {
//                System.out.println("La tabla de sanciones está vacía");
//                return "redirect:panelUsuario.do";
//            }
//            List<CatalogoSanciones> listaCatalogoSanciones = catalogoSancionesFacade.findBySpecificField("detalle", "S001", "like", null, null);
//            if(listaCatalogoSanciones.isEmpty())
//            {
//                System.out.println("La sanción no pudo ser encontrada");
//                return "redirect:panelUsuario.do";
//            }
//            CatalogoSanciones catalogoSancion = listaCatalogoSanciones.get(0);//Se obtiene el registro de la sanción para tratar sus datos
//            Calendar fecha_max_x = Calendar.getInstance();  
//            fecha_max_x.setTime(fecha_max);  
//            fecha_max_x.add(Calendar.DATE, 5);  
//            fecha_max = fecha_max_x.getTime();
//            System.out.println("La fecha con la tolerancia es" + fecha_max);
//            if(fecha_actual.after(fecha_max))
//            {
//                System.out.println("La fecha actual sobrepasa la de con tolerancia");
//                Sanciones sancion = new Sanciones();
//                sancion.setCatalogoSancionesId(catalogoSancion);
//                sancion.setDatosPersonalesId(dp);//Id corresponde al objeto datos personales de mi alumno a sancionar
//                sancion.setFecha(fecha_actual);
//                sancion.setHorasSancion(catalogoSancion.getHorasSancion());
//                try
//                {
//                    sancionesFacade.create(sancion);
//                    System.out.println("Sancion: "+ catalogoSancion.getDetalle() + "\nAplicada a: "+ dp.getNumeroControl()+"-"+dp.getNombre() + "\nHoras:" + catalogoSancion.getHorasSancion());
//                }
//                catch(Exception e)
//                {
//                    System.out.println("Problema al crear" + e.getMessage());
//                } 
//            }
//            else
//            {
//                System.out.println("La fecha actual no sobrepasa la de con tolerancia, no hay sancion");
//            }
//        }
//        else
//        {
//            System.out.println("La fecha actual está dentro de la fecha máxima. No hay sanción");
//        }
        //
//        System.out.println("id:" + vistaAlumno.getId());
//        String id=vistaAlumno.getId();
//        
//        VistaAlumno vistaAlumno1;
//        vistaAlumno1 = vistaAlumnoFacade.find(id);
//        System.out.println("find:" + vistaAlumno.getApellidoPat());
//        vistaAlumno1.setFoto(file.getBytes());
//
//        vistaAlumnoFacade.edit(vistaAlumno1);
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        Documentos doc = documentoFacade.find(BigDecimal.valueOf(Long.parseLong(id)));
//        System.out.println(doc);
//        doc.setArchivo(file.getBytes());
//        doc.setExtension("pdf");
//        documentoFacade.edit(doc);
        return "redirect:panelUsuario.do";
    }

    @RequestMapping(value = "/guardarImagenFui.do", method = RequestMethod.POST)
    public String guardarImagenFui(
            @RequestParam("file") MultipartFile file, String id) throws IOException
    {
        System.out.println("Buscare pa subir foto el id" + id);
        List<VistaAlumno> listaAlumnos = daoVistaAlumno.findBySpecificField("id", id, "equal", null, null);
        if (listaAlumnos.isEmpty())
        {
            return "redirect:panelUsuario.do";
        }
        VistaAlumno alumno = listaAlumnos.get(0);
        System.out.println("Inicia subida de info");
        System.out.println("Original filename: " + file.getOriginalFilename());
        System.out.println("File:" + file.getName());
        System.out.println("Size:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        if (alumno.getFoto() == null)
        {
            System.out.println("ya tenía foto");
            alumno.setFoto(file.getBytes());
            daoVistaAlumno.edit(alumno);
        } else
        {
            System.out.println("No tenía foto");
            alumno.setFoto(file.getBytes());
            daoVistaAlumno.create(alumno);
        }

        return "redirect:formatoUnicoUsuario.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bajaImagenes.do")
    public @ResponseBody
    String bajaImagenes(Model a, String id) throws ParseException
    {

        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteFUI.pdf")
    public @ResponseBody
    void muestraReporteFUI(Model modelo, String nControl, String idProyecto, HttpSession session, HttpServletRequest request, HttpServletResponse httpServletResponse) throws ParseException, JRException
    {
        try
        {
            String noControl = session.getAttribute("NCONTROL").toString();

            System.out.println("En el muestra :D" + noControl);
            VistaAlumno alumno = (VistaAlumno) daoVistaAlumno.find(noControl);
            System.out.println(alumno);

            List<DatosPersonales> listaDatosPersonales = daoDatosPersonales.findBySpecificField("alumnoId", alumno, "equal", null, null);
            DatosPersonales dp = listaDatosPersonales.get(0);
            List<FormatoUnico> listaFormatoUnico = daoFormatoUnico.findBySpecificField("datosPersonalesId", dp, "equal", null, null);
            if (listaFormatoUnico.isEmpty())
            {
                System.out.println("La lista de formatoUnico está vacía");
                //return "PanelUsuario/panelUsuario";
            }

            Conexion conn = new Conexion();
            /*
             * Establecemos la ruta del reporte
             */
            File reportFile = new File(request.getRealPath("reportes//FormatoUnico.jasper"));
            /*
             * No enviamos parámetros porque nuestro reporte no los necesita asi
             * que escriba cualquier cadena de texto ya que solo seguiremos el
             * formato del método runReportToPdf
             */
            Map parameters = new HashMap();
            parameters.put("noControl", noControl);
            parameters.put("idProyecto", listaFormatoUnico.get(0).getIdproyecto().getIdProyecto().toString());//idProyecto
            //parameters.put("Nombre_parametro", "Valor_Parametro"); 
                /*
             * Enviamos la ruta del reporte, los parámetros y la conexión(objeto
             * Connection)
             */
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn.conectarAux("ges_vin2", "gst05a"));
            /*
             * Indicamos que la respuesta va a ser en formato PDF
             */
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setContentLength(bytes.length);
            httpServletResponse.getOutputStream().write(bytes);

        } catch (Exception ex)
        {
            Exceptions.printStackTrace(ex);
        }

        //return "OK";
    }

    @RequestMapping(value = "/cambiaStatusSubidaFui.do", method = RequestMethod.GET)
    public @ResponseBody
    String cambiaStatusSubidaFui(Model a, BigDecimal id_datos_personales) throws ParseException
    {
        System.out.println("En el cambia status subida fui se buscara " + id_datos_personales);
        DatosPersonales datosPersonales = (DatosPersonales) daoDatosPersonales.find(id_datos_personales);
        System.out.println("En el cambia status subida fui se halló id" + datosPersonales.getId().toString());
        List<FormatoUnico> listaFormatoUnico = daoFormatoUnico.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        if (listaFormatoUnico.isEmpty())
        {
            System.out.println("La lista de formatoUnico está vacía");
            return "PanelUsuario/panelUsuario";
        }
        FormatoUnico formatoUnico = listaFormatoUnico.get(0);
        //Cambiando el status a descargado.
        formatoUnico.setStatusFui(new BigInteger("5"));
        daoFormatoUnico.edit(formatoUnico);
        return "";
    }

    public void remueveObservaciones(BigDecimal idDatosPersonales)
    {
        List<RegObservaciones> observacionesAlumno = daoRegObservaciones.findBySpecificField("datosPersonalesId", idDatosPersonales, "equal", null, null);
        for (RegObservaciones observacionActual : observacionesAlumno)
        {
            daoRegObservaciones.remove(observacionActual);
        }
    }
}
