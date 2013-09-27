/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.egresado.EgresadoBean;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.Egresado;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.RegObservaciones;
import edu.servicio.toluca.model.formatoUnico.FormatoUnicoAdminModel;
import edu.servicio.toluca.sesion.CatalogoDocumentoFacade;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.CatalogoPlanFacade;
import edu.servicio.toluca.sesion.CatalogoSancionesFacade;
import edu.servicio.toluca.sesion.CiudadesFacade;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.EgresadoFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.HorariosAlumnoFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.MunicipiosSiaFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import edu.servicio.toluca.sesion.SancionesFacade;
import edu.servicio.toluca.sesion.TipoLocalidadFacade;
import edu.servicio.toluca.sesion.VaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SATELLITE
 */
@Controller
public class EgresadoAdminController {

    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
    private EstadosSiaFacade estadosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
    private ProyectosFacade proyectoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/HorariosAlumnoFacade")
    private HorariosAlumnoFacade horarioFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
    private ColoniaFacade coloniaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoDocumentoFacade")
    private CatalogoDocumentoFacade catalogoDocumentoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoPlanFacade")
    private CatalogoPlanFacade catalogoPlanFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FoliosPlaticaFacade")
    private FoliosPlaticaFacade foliosPlaticaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VaFacade")
    private VaFacade vaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    private CodigosPostalesFacade codigosPostalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CiudadesFacade")
    private CiudadesFacade ciudadesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/MunicipiosSiaFacade")
    private MunicipiosSiaFacade municipiosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/TipoLocalidadFacade")
    private TipoLocalidadFacade tipoLocalidadFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoSancionesFacade")
    private CatalogoSancionesFacade catalogoSancionesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/SancionesFacade")
    private SancionesFacade sancionesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/EgresadoFacade")
    private EgresadoFacade egresadoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/RegObservacionesFacade")
    private RegObservacionesFacade regisObservacionesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoObservacionesFacade")
    private CatalogoObservacionesFacade observacionesCatalogoFacade;
    
    //Status de FormatoUnico FUI en  base al documento status_DOC_1.doc
    final String VALOR_NO_REVISADOS = "4";
    final int VALOR_ACEPTADOS = 1;
    final int VALOR_RECHAZADOS = 2;
    final int VALOR_CORRECCION = 3;
    //ID CatalogoDocumentos CartaDeMotivos
    final long DOC_CAT_FU = 3;
    
    //Pruebas Developer
    //**********************************************
    //Desactivar para Produccion, Activar para Desarrollo
    final boolean banderaPrueba = true;
    final String correoTest="rehoscript@gmail.com";
    //**********************************************

    @RequestMapping(method = RequestMethod.GET, value = "/egresadoAdministrador.do")
    public String egresadoAdministrador(Model model, HttpSession session, HttpServletRequest request) {
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador()) {

            //Listas de Formato Unico en los diferentes Status
            List<EgresadoBean> listadoCartasNoRevisadas = new ArrayList<EgresadoBean>();
            List<EgresadoBean> listadoCartasAceptadas = new ArrayList<EgresadoBean>();
            List<EgresadoBean> listadoCartasRechazadas = new ArrayList<EgresadoBean>();
            List<EgresadoBean> listadoCartasCorreccion = new ArrayList<EgresadoBean>();

            for (Egresado egresado : egresadoFacade.findAll()) {
                System.out.println("Dentro del foreach de egresado");
                //------------------Formatos No Revisados------------------------
                if (egresado.getTipoPrograma() != null
                        && egresado.getTipoPrograma().equals(VALOR_NO_REVISADOS)) {
                    //Asignando Datos A Formato Unico en estado NO_REVISADO
                    EgresadoBean cartaNR = new EgresadoBean();
                    cartaNR.setIdDocumentoCartaMotivos(documentoFacade.findBySpecificField("datosPersonalesId", egresado.getDatosPersonalesId(), "equal", null, null).get(0).getId().toString());
                    cartaNR.setNoControl(egresado.getDatosPersonalesId().getNumeroControl());
                    cartaNR.setNombre(egresado.getDatosPersonalesId().getNombre()
                            + " " + egresado.getDatosPersonalesId().getApellidoP()
                            + " " + egresado.getDatosPersonalesId().getApellidoM());
                    cartaNR.setIdDatosPersonales(egresado.getDatosPersonalesId().getId().toString());
                    System.out.println("Lo que setie en la cartaNR es idDOcCartamotivos=" + cartaNR.getIdDocumentoCartaMotivos() + "No control" + cartaNR.getNoControl());
//                    cartaNR.setPeriodo(egresado.getPeriodoInicio());
                    //Buscar FormatoUnico en Tabla Documentos Regresa todos los .pdf .jpg .png
                    //En caso de que HIBERNATE se generen consultas con AND, se tiene que modificar este query 
                    // y se reducen lineas de codigo
                    List<Documentos> listaDocumentos = documentoFacade.findBySpecificField("datosPersonalesId",
                            egresado.getDatosPersonalesId(),
                            "equal", null, null);
                    //Filtrar Resultado 
                    String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos);
                    if (fechaSubida != null) {
                        /*
                         Si es diferente de null, el documento de FormatoUnico se encuentra en la tabla de Documentos
                         */
                        cartaNR.setFechaSubida(fechaSubida);
                        String idDocumento = obtenerIDDocumentoCarta(listaDocumentos);

                        if (idDocumento != null) {
                            cartaNR.setIdDocumentoCartaMotivos(idDocumento);
                            //Se Agrega El Objeto FormatoUnico a la lista de FomatoUnicos en estado NO_REVISADOS
                            listadoCartasNoRevisadas.add(cartaNR);
                        }

                    }
                }
                //------------------Formatos Aceptados------------------------    
                if (egresado.getTipoPrograma() != null && egresado.getTipoPrograma().equals(BigInteger.valueOf(VALOR_ACEPTADOS)))//
                {
                    EgresadoBean cartaAceptada = new EgresadoBean();
                    cartaAceptada.setIdDocumentoCartaMotivos(documentoFacade.findBySpecificField("datosPersonalesId", egresado.getDatosPersonalesId(), "equal", null, null).get(0).getId().toString());
                    cartaAceptada.setNoControl(egresado.getDatosPersonalesId().getNumeroControl());
                    cartaAceptada.setNombre(egresado.getDatosPersonalesId().getNombre()
                            + " " + egresado.getDatosPersonalesId().getApellidoP()
                            + " " + egresado.getDatosPersonalesId().getApellidoM());
//                    formatoAceptados.setPeriodo(egresado.getPeriodoInicio());
                    List<Documentos> listaDocumentos2 = documentoFacade.findBySpecificField("datosPersonalesId",
                            egresado.getDatosPersonalesId(),
                            "equal", null, null);

                    String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos2);
                    if (fechaSubida != null) {
                        String idDocumento = obtenerIDDocumentoCarta(listaDocumentos2);
                        cartaAceptada.setFechaSubida(fechaSubida);
                        if (idDocumento != null) {
                            cartaAceptada.setIdDocumentoCartaMotivos(idDocumento);
                            listadoCartasAceptadas.add(cartaAceptada);
                        }
                    }
                }
                //------------------Formatos Rechazados------------------------   
                if (egresado.getTipoPrograma() != null && egresado.getTipoPrograma().equals(BigInteger.valueOf(VALOR_RECHAZADOS)))//
                {
                    EgresadoBean cartasRechazadas = new EgresadoBean();
                    cartasRechazadas.setNoControl(egresado.getDatosPersonalesId().getNumeroControl());
                    cartasRechazadas.setNombre(egresado.getDatosPersonalesId().getNombre()
                            + " " + egresado.getDatosPersonalesId().getApellidoP()
                            + " " + egresado.getDatosPersonalesId().getApellidoM());
//                    formatoRechazados.setPeriodo(egresado.getPeriodoInicio());
                    cartasRechazadas.setIdDatosPersonales(egresado.getDatosPersonalesId().getId().toString());
                    List<Documentos> listaDocumentos3 = documentoFacade.findBySpecificField("datosPersonalesId",
                            egresado.getDatosPersonalesId(),
                            "equal", null, null);

                    String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos3);
                    if (fechaSubida != null) {
                        String idDocumento = obtenerIDDocumentoCarta(listaDocumentos3);
                        cartasRechazadas.setFechaSubida(fechaSubida);
                        if (idDocumento != null) {
                            cartasRechazadas.setIdDocumentoCartaMotivos(idDocumento);
                            listadoCartasRechazadas.add(cartasRechazadas);
                        }
                    }
                }
                //------------------//Formatos Correccion-----------------------   
                if (egresado.getTipoPrograma() != null && egresado.getTipoPrograma().equals(BigInteger.valueOf(VALOR_CORRECCION))) {
                    EgresadoBean cartaCorreccion = new EgresadoBean();
                    cartaCorreccion.setNoControl(egresado.getDatosPersonalesId().getNumeroControl());
                    cartaCorreccion.setNombre(egresado.getDatosPersonalesId().getNombre()
                            + " " + egresado.getDatosPersonalesId().getApellidoP()
                            + " " + egresado.getDatosPersonalesId().getApellidoM());
//                    formatoCorreccion.setPeriodo(egresado.getPeriodoInicio());
                    cartaCorreccion.setIdDatosPersonales(egresado.getDatosPersonalesId().getId().toString());
                    List<Documentos> listaDocumentos4 = documentoFacade.findBySpecificField("datosPersonalesId",
                            egresado.getDatosPersonalesId(),
                            "equal", null, null);


                    String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos4);

                    if (fechaSubida != null) {
                        String idDocumento = obtenerIDDocumentoCarta(listaDocumentos4);
                        cartaCorreccion.setFechaSubida(fechaSubida);
                        if (idDocumento != null) {
                            cartaCorreccion.setIdDocumentoCartaMotivos(idDocumento);
                            listadoCartasCorreccion.add(cartaCorreccion);
                        }

                    }
                }
            }
            //Formatos Unicos No Revisados 
            model.addAttribute("listadoCartasNoRevisadas",listadoCartasNoRevisadas);
            //Formato Unico Aceptados
            model.addAttribute("listadoCartasAceptadas",listadoCartasAceptadas);
            //Formato Rechazados
            model.addAttribute("listadoCartasRechazadas",listadoCartasRechazadas);
            //Formato Correccion
            model.addAttribute("listadoCartasCorreccion",listadoCartasCorreccion);
            //Catalogo Sanciones
            model.addAttribute("listadoObservaciones", observacionesCatalogoFacade.findAll()); 

            return "/Egresados/egresadoAdministrador";
        } else {
            return "redirect:index.do";
        }
        
    }
    
    
    
     /**
      * 
      * @param listaDocumentos
      * @return Fecha de Subida de Formato Unico
      * De todos los documentos, se obtiene solo los documentos con CATALOGO_ID= 1
      * En caso de no encontrar nada devuelve null, en caso contrario la Fecha de Subida
      */
     
     private  String  obtenerFechaSubidaFormatoU(List<Documentos> listaDocumentos)
     {
         for (Documentos docu : listaDocumentos) 
         {
                    if(docu.getCatalogoDocumentosId().getId().equals(BigDecimal.valueOf(DOC_CAT_FU)) )//Es igual a formato Unico
                    {
                        return docu.getFechaSubida().toString();
                    }
         }
         return null;
     }
     /**
      * 
      * @param listaDocumentos
      * @return ID_DOCUMENTO del FormatoUnico, en caso de no encontrarse retorna null
      */
     
     private String  obtenerIDDocumentoCarta(List<Documentos> listaDocumentos)
     {
         for (Documentos docu : listaDocumentos) 
         {
                    if(docu.getCatalogoDocumentosId().getId().equals(BigDecimal.valueOf(DOC_CAT_FU)) )//Es igual a formato Unico
                    {
                        return docu.getId().toString();
                    }
         }
         return null;
     }


    /**
     * 
     * Metodo que se encarga de enviar notificacion al alumno en base a su correo
     * @param tipo
     * @param correoDestinatario
     * @param nombre
     * @param dtp 
     */
    private void enviarCorreo(int tipo,String correoDestinatario,String nombre,DatosPersonales dtp)
    {
        //Romper metodo en caso de que correo no se encuentre
        if(correoDestinatario==null)
            return;
        else if(banderaPrueba)    
            correoDestinatario=correoTest;
         //En caso de que BanderaPrueba este activa se envia Correo al correo de Test
        
        String mensaje=" ";
        switch(tipo)
        {
            case 1://Aceptados
                mensaje="<h1>Notificación Servicio Social</h1>\n" +
                "<h2>Estimado  <b>"+nombre+"</b>:</h2> \n" +
                "<p>\n" +
                "Te informamos que  tu  Formato Único que has llenado, fue revisado por la Oficina de Servicio Social  y ha sido <b>Aceptado</b> Satisfactoriamente. \n" +
                "</p>\n" +
                "<p>Por lo que te recordamos, que a partir de este momento cada 2 meses tienes que subir tu   reporte bimestral, el cual será revisado de la misma manera  por la Oficina de Servicio Social. \n" +
                "</p>\n" +
                "<p>\n" +
                "Oficina de Servicio Social<br> \n" +
                "Instituto Tecnológico  de Toluca\n" +
                "</p>";
                break;
            case 2://Correccion
                String mns1="<h1>Notificación Servicio Social</h1>\n" +
                "<h2>Estimado  <b>"+nombre+"</b>:</h2> \n" +
                "<p>\n" +
                "Te informamos que   tu  Formato Único que has llenado, ha sido revisado por la Oficina de Servicio Social  y este tiene errores.  Favor de corregirlos lo más pronto posible.\n" +
                "</p>\n" +
                "<ul>\n";
                mensaje += mns1;
                
                for (RegObservaciones reg : regisObservacionesFacade.findBySpecificField("datosPersonalesId",
                                                            dtp,
                                                            "equal", null, null)) {
                       
                     String detalle=reg.getCatalogoObservacionId().getDetalle();
                     mensaje += "<li>"+detalle+"</li>\n";
                }
                
                
                String mns2 = 
                "</ul>\n" +
                "<p>\n" +
                "Oficina de Servicio Social <br>\n" +
                "Instituto Tecnológico  de Toluca\n" +
                "</p>";
                mensaje += mns2;
                break;
            case 3://No aceptados
                mensaje="<h1>Notificación Servicio Social</h1>\n" +
                "<h2>Estimado  <b>"+nombre+"</b>:</h2> \n" +
                "<p>\n" +
                "Te informamos que   tu  Formato Único que has llenado, fue revisado por la Oficina de Servicio Social  y este ha sido <b>Rechazado</b>.\n" +
                "</p>\n" +
                "<p>\n" +
                "Si esto ha sucedido, es porque has rebasado el número de intentos  para corregir tu Formato  Único.  Para mayor información  presentarse en la Oficina de Servicio Social o intentar de  nuevo para la siguiente convocatoria.  \n" +
                "</p>\n" +
                "<p>\n" +
                "Oficina de Servicio Social <br>\n" +
                "Instituto Tecnológico  de Toluca\n" +
                "</p>";
                break;
            default:
                return;
        }

        SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
        String str=fecha.format(new Date());
        
        Thread hiloCorreo=new Thread(new EgresadoAdminController.HiloE(str,nombre,correoDestinatario,mensaje));
        hiloCorreo.start();
        
    }
    
    
    public class HiloE implements Runnable
    {
        private String fecha,
                       nombre,
                       correo,
                       mensaje;
        public HiloE(String fecha,String nombre,String correo,String mensaje) {
            this.fecha=fecha;
            this.nombre=nombre;
            this.correo=correo;
            this.mensaje=mensaje;
        }
        
        
        @Override
        public void run() {
            
            try
            {
                EnviarCorreo correo2 = new EnviarCorreo("Notificación  Servicio Social "+this.fecha+" "+this.nombre,
                                               this.correo,
                                               this.mensaje
                                               );
                correo2.enviaCorreo();
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
        }
    
    }
    
    
    
    //No-Visible 
}
