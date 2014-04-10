/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Programa;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.ProgramaFacade;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.sound.midi.Soundbank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rodrigo
 */
@Controller
public class EstadisticasController {

    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ProgramaFacade")
    private ProgramaFacade programaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/programasEstadisticas.do")
    public @ResponseBody
    String dameProgramas(Model modelo, String ano, String periodo) {
        String arrJSON = "";
        System.out.println("Año" + ano + "Periodo:" + periodo);
        arrJSON = programaFacade.programasTotales(ano, periodo);
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/programasEstadisticasLiberados.do")
    public @ResponseBody
    String dameProgramasLiberados(Model modelo, String ano, String periodo) {
        String arrJSON = "";
        arrJSON = programaFacade.programasTotalesLiberaciones(ano, periodo);
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/programasEstadisticasLiberadosTabla.do")
    public @ResponseBody
    String dameProgramasLiberadosTabla(Model modelo, String ano, String periodo) {
        String arrJSON = "";
        arrJSON = programaFacade.programasTotalesTabla(ano, periodo);
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/instanciasEstadisticas.do")
    public @ResponseBody
    String dameInstanciasTotales(Model modelo, String ano, String periodo) {
        String arrJSON = "";
        arrJSON = instanciaFacade.instanciasTotales(ano, periodo);
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/estadisticas.do")
    public String estadisticasAdmn(Model modelo) {
        //Falta hacer el filtrado por año y periodo actual
        int anioInicioServicio = 2014;
        String periodoActual="";
        int sexoIAltas = 0;
        int sexoILiberaciones = 0;
        int sexoMAltas = 0;
        int sexoMLiberaciones = 0;
        int sexoFAltas = 0;
        int sexoFLiberaciones = 0;
        //Ingenieria Quimica
        //Ingenieria Industrial
        //Ingenieria Electromecanica
        //Ingenieria Mecatronica
        //Licensiatura en Administración
        //Ingenieria Electronica
        //Ingenieria en Sistemas Computacionel
        int carreasAltas[] = new int[7];
        Calendar fecha = Calendar.getInstance();
        int carreasLiberaciones[] = new int[7];
        List<FormatoUnico> formatoUnicosFiltrados = new ArrayList<FormatoUnico>();
        List<FormatoUnico> formatosUnicos = formatoUnicoFacade.findAll();
        
        //Funcion para obtener periodo Actual
          periodoActual=(fecha.get(Calendar.MONTH)<=6)?"ENE-JUN":"JUL-DIC";
          
        //FIltrando por el año
        for (FormatoUnico formatoActual : formatosUnicos) {
            String aniosSplit[] = formatoActual.getFechaInicio().toString().split("-");
            if (Integer.parseInt(aniosSplit[0])==fecha.get(Calendar.YEAR)) {
                if (formatoActual.getPeriodoInicio().equals(periodoActual)) {
                    formatoUnicosFiltrados.add(formatoActual);
                }
            }
        }

        ////////Validacion para regresar los años de historial en el sistema//////////////
        List<Integer> anios = new ArrayList<Integer>();
        int anioActual = fecha.get(Calendar.YEAR);
        if (anioActual == anioInicioServicio) {
            anios.add(anioActual);
        } else {
            for (anioInicioServicio = 2014; anioInicioServicio <= anioActual; anioInicioServicio++) {
                anios.add(anioInicioServicio);
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////

        for (FormatoUnico formatoActual : formatoUnicosFiltrados) {
            if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("QUIMICA")) {
                carreasAltas[0] = carreasAltas[0] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[0] = carreasLiberaciones[0] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("INSDUSTRIAL")) {
                carreasAltas[1] = carreasAltas[1] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[1] = carreasLiberaciones[1] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("EMECANICA")) {
                carreasAltas[2] = carreasAltas[2] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[2] = carreasLiberaciones[2] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("MECATRONICA")) {
                carreasAltas[3] = carreasAltas[3] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[3] = carreasLiberaciones[3] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("ADMON")) {
                carreasAltas[4] = carreasAltas[4] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[4] = carreasLiberaciones[4] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("ELECTRONICA")) {
                carreasAltas[5] = carreasAltas[5] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[5] = carreasLiberaciones[5] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("SIST COMP")) {
                carreasAltas[6] = carreasAltas[6] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[6] = carreasLiberaciones[6] + 1;
                }
            }

            if (formatoActual.getDatosPersonalesId().getSexo().equals("MASCULINO") || formatoActual.getDatosPersonalesId().getSexo().equals("M")) {
                sexoMAltas++;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    sexoMLiberaciones++;
                }

            } else if (formatoActual.getDatosPersonalesId().getSexo().equals("FEMENINO") || formatoActual.getDatosPersonalesId().getSexo().equals("F")) {
                sexoFAltas++;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    sexoFLiberaciones++;
                }

            } else if (formatoActual.getDatosPersonalesId().getSexo().equals("INDEFINIDO") || formatoActual.getDatosPersonalesId().getSexo().equals("I")) {
                sexoIAltas++;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    sexoILiberaciones++;
                }
            }
        }
        modelo.addAttribute("totalMasculino", sexoMAltas);
        modelo.addAttribute("totalFemenino", sexoFAltas);
        modelo.addAttribute("totalIndefinido", sexoIAltas);
        modelo.addAttribute("totalMasculinoLiberaciones", sexoMLiberaciones);
        modelo.addAttribute("totalFemeninoLiberaciones", sexoFLiberaciones);
        modelo.addAttribute("totalIndefinidoLiberaciones", sexoILiberaciones);
        modelo.addAttribute("carrerasAltas", carreasAltas);
        modelo.addAttribute("carrerasLiberaciones", carreasLiberaciones);
        modelo.addAttribute("anio", anios);

        return "/Estadisticas/estadisticas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/datosSexoCarreras.do")
    public @ResponseBody
    String dameDatosSexoCarreras(Model modelo, String anio, String periodo) {
        String arrJSON = "";
        int anioInicioServicio = 2014;
        int sexoIAltas = 0;
        int sexoILiberaciones = 0;
        int sexoMAltas = 0;
        int sexoMLiberaciones = 0;
        int sexoFAltas = 0;
        int sexoFLiberaciones = 0;
        //Ingenieria Quimica
        //Ingenieria Industrial
        //Ingenieria Electromecanica
        //Ingenieria Mecatronica
        //Licensiatura en Administración
        //Ingenieria Electronica
        //Ingenieria en Sistemas Computacionel
        int carreasAltas[] = new int[7];
        Calendar fecha = Calendar.getInstance();
        int carreasLiberaciones[] = new int[7];
        List<FormatoUnico> formatoUnicosFiltrados = new ArrayList<FormatoUnico>();
        List<FormatoUnico> formatosUnicos = formatoUnicoFacade.findAll();

        //FIltrando por el año
        for (FormatoUnico formatoActual : formatosUnicos) {
            String aniosSplit[] = formatoActual.getFechaInicio().toString().split("-");
            if (aniosSplit[0].equals(anio)) {
                if (formatoActual.getPeriodoInicio().equals(periodo)) {
                    formatoUnicosFiltrados.add(formatoActual);
                }
            }
        }

        ////////Validacion para regresar los años de historial en el sistema//////////////
        List<Integer> anios = new ArrayList<Integer>();
        int anioActual = fecha.get(Calendar.YEAR);
        if (anioActual == anioInicioServicio) {
            anios.add(anioActual);
        } else {
            for (anioInicioServicio = 2014; anioInicioServicio <= anioActual; anioInicioServicio++) {
                anios.add(anioInicioServicio);
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////

        for (FormatoUnico formatoActual : formatosUnicos) {
            if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("QUIMICA")) {
                carreasAltas[0] = carreasAltas[0] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[0] = carreasLiberaciones[0] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("INSDUSTRIAL")) {
                carreasAltas[1] = carreasAltas[1] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[1] = carreasLiberaciones[1] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("EMECANICA")) {
                carreasAltas[2] = carreasAltas[2] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[2] = carreasLiberaciones[2] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("MECATRONICA")) {
                carreasAltas[3] = carreasAltas[3] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[3] = carreasLiberaciones[3] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("ADMON")) {
                carreasAltas[4] = carreasAltas[4] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[4] = carreasLiberaciones[4] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("ELECTRONICA")) {
                carreasAltas[5] = carreasAltas[5] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[5] = carreasLiberaciones[5] + 1;
                }
            } else if (formatoActual.getDatosPersonalesId().getAlumnoId().getCarrera().equals("SIST COMP")) {
                carreasAltas[6] = carreasAltas[6] + 1;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    carreasLiberaciones[6] = carreasLiberaciones[6] + 1;
                }
            }

            if (formatoActual.getDatosPersonalesId().getSexo().equals("MASCULINO") || formatoActual.getDatosPersonalesId().getSexo().equals("M")) {
                sexoMAltas++;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    sexoMLiberaciones++;
                }

            } else if (formatoActual.getDatosPersonalesId().getSexo().equals("FEMENINO") || formatoActual.getDatosPersonalesId().getSexo().equals("F")) {
                sexoFAltas++;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    sexoFLiberaciones++;
                }

            } else if (formatoActual.getDatosPersonalesId().getSexo().equals("INDEFINIDO") || formatoActual.getDatosPersonalesId().getSexo().equals("I")) {
                sexoIAltas++;
                if (formatoActual.getStatusServicio().compareTo(BigInteger.valueOf(4)) == 0) {
                    sexoILiberaciones++;
                }
            }
        }
        arrJSON = "" + sexoMAltas + "," + sexoFAltas + "," + sexoIAltas + "|" + sexoMLiberaciones + "," + sexoFLiberaciones + "," + sexoILiberaciones + "|";
        for (int i = 0; i < carreasAltas.length; i++) {
            arrJSON += carreasAltas[i];
            if (i == (carreasAltas.length - 1)) {
                arrJSON += "|";
            } else {
                arrJSON += ",";
            }
        }
        for (int i = 0; i < carreasLiberaciones.length; i++) {
            arrJSON += carreasLiberaciones[i];
            if (i == (carreasLiberaciones.length - 1)) {
                arrJSON += "|";
            } else {
                arrJSON += ",";
            }
        }
        System.out.println("Json" + arrJSON);
        return arrJSON;
    }
}
