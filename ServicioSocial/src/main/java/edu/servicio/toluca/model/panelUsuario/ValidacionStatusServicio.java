/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.panelUsuario;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.beans.egresado.EgresadoPanelUsuarioBean;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Egresado;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.VistaAlumno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bustedvillain
 */
public class ValidacionStatusServicio {

    public StatusServicioBean validaServicio(VistaAlumno vistaAlumno) {

        StatusServicioBean servicioBean = new StatusServicioBean();
        EgresadoPanelUsuarioBean egresadoBean = new EgresadoPanelUsuarioBean();
        try {
            List<DatosPersonales> datosPersonales = new ArrayList<DatosPersonales>(vistaAlumno.getDatosPersonalesCollection());
            List<FormatoUnico> formatoUnicoColl = new ArrayList<FormatoUnico>(datosPersonales.get(0).getFormatoUnicoCollection());
            FormatoUnico formatoUnico = formatoUnicoColl.get(0);

            int statusServicio = Integer.parseInt(formatoUnico.getStatusServicio().toString());
            servicioBean.setStatusServicio(statusServicio);
            servicioBean.setDatosPersonales(datosPersonales.get(0));
            servicioBean.setFormatoUnico(formatoUnico);
            servicioBean.setVistaAlumno(vistaAlumno);

            if (vistaAlumno.getStaActual().equals("EG")) {
                if (vistaAlumno.getEgresadoCollection() != null) {
                    List<Egresado> egresados = new ArrayList<Egresado>(vistaAlumno.getEgresadoCollection());
                    Egresado egresado = egresados.get(0);
                    int tipoPrograma = Integer.parseInt(egresado.getTipoPrograma());

                    switch (tipoPrograma) {
                        //Aceptado
                        case 1:
                            //Panel para alumno egresado + interno
                            servicioBean.setTipoPanel(2);
                            egresadoBean.setAccesoCartaMotivos(false);
                            egresadoBean.setMensajeCartaMotivos("Tu carta de motivos fue aceptada, puedes ahora comenzar tu proceso normal de servicio social.");
                            egresadoBean.setStatusCartaMotivos(1);
                            servicioBean.setEgresado(egresadoBean);
                            //Checa el status del servicio
                            switchStatus(servicioBean, statusServicio);
                            break;
                        //Rechazado
                        case 2:
                            //Panel para egresado
                            servicioBean.setTipoPanel(1);
                            egresadoBean.setAccesoCartaMotivos(false);
                            egresadoBean.setMensajeCartaMotivos("Tu carta de motivos fue rechazada");
                            egresadoBean.setStatusCartaMotivos(2);
                            servicioBean.setEgresado(egresadoBean);
                            break;
                        //Correccion
                        case 3:
                            //Panel para egresado
                            servicioBean.setTipoPanel(1);
                            egresadoBean.setAccesoCartaMotivos(true);
                            egresadoBean.setMensajeCartaMotivos("Tu carta de motivos se encuentra en corrección. Por favor revisa la sección de observaciones para saber que es lo que tienes que corregir en tu carta de motivos.");
                            egresadoBean.setStatusCartaMotivos(3);
                            servicioBean.setEgresado(egresadoBean);
                            break;
                        //No revisado
                        case 4:
                            //Panel para egresado
                            servicioBean.setTipoPanel(1);
                            egresadoBean.setAccesoCartaMotivos(false);
                            egresadoBean.setMensajeCartaMotivos("Tu carta de motivos se encuentra en revisión.");
                            egresadoBean.setStatusCartaMotivos(3);
                            servicioBean.setEgresado(egresadoBean);
                            break;
                    }
                }
            }

            if (vistaAlumno.getStaActual().equals("IN")) {
                //Panel para aluno interno
                servicioBean.setTipoPanel(0);
                //Checa el status del servicio
                switchStatus(servicioBean, statusServicio);
            }

        } catch (Exception e) {
            System.out.println("Newbie en el sistema sin datos personales");
            servicioBean.setMensaje("Servicio Social Activo");
            servicioBean.setStatusServicio(1);
            servicioBean.setDatosPersonales(null);
            servicioBean.setVistaAlumno(vistaAlumno);

            //Ver si es egresado o interno
            if (vistaAlumno.getStaActual().equals("IN")) {
                System.out.println("Ingresado alumno interno: IN");
                //Panel para interno;
                servicioBean.setTipoPanel(0);
            }
            if (vistaAlumno.getStaActual().equals("EG")) {
                System.out.println("Ingresando alumno egresado: EG");
                //Panel para egresado
                servicioBean.setTipoPanel(1);
                egresadoBean.setAccesoCartaMotivos(true);
                egresadoBean.setMensajeCartaMotivos("Hemos detectado que eres un alumno egresado. Debes proceder a subir una carta de motivos.");
                egresadoBean.setStatusCartaMotivos(2);
                servicioBean.setEgresado(egresadoBean);
            }
        }
        return servicioBean;
    }

    /**
     * Valida el status del servicio social
     *
     * @param servicioBean
     * @param statusServicio
     */
    public void switchStatus(StatusServicioBean servicioBean, int statusServicio) {
        switch (statusServicio) {
            //Activo
            case 1:
                servicioBean.setMensaje("Servicio Social Activo");
                break;
            //Cancelado
            case 2:
                servicioBean.setMensaje("Tu servicio social ha sido cancelado");
                break;
            //Baja Temporal
            case 3:
                servicioBean.setMensaje("Tu servicio social esta dado de baja temporalmente");
                break;
            //Terminado
            case 4:
                servicioBean.setMensaje("Tu servicio social ya ha concluido");
                break;
            default:
                servicioBean.setMensaje("Invalid status");
                break;
        }
    }
}
