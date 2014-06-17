package edu.servicio.toluca.model.documentosFinales;

import edu.servicio.toluca.beans.ReportesFinalesBean;
import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.entidades.DocumentosFinales;
import edu.servicio.toluca.entidades.Reportes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Realiza validaciones para decidir si el alumno puede acceder a los reportes
 * finales a traves del panel usuario
 *
 * @author bustedvillain
 */
public class ValidaDocumentosFinalesModel {

    public ReportesFinalesBean validaDocumentosFinales(StatusServicioBean servicioBean) {
        ReportesFinalesBean reportesFinales = new ReportesFinalesBean();

        //Valida si asistio a la platica
        if (servicioBean.getPlaticaBean().isTienePlatica()) {
            //Valida las horas del servicio
            if (servicioBean.getHorasServicio() >= 480) {
                int statusDocFinales = Integer.parseInt(servicioBean.getFormatoUnico().getStatusFuf().toString());
                ArrayList<Reportes> reportes = new ArrayList<Reportes>(servicioBean.getDatosPersonales().getReportesCollection());
                Collections.sort(reportes, new OrdenarPersonaPorId());
                                            int nReporte = reportes.size() - 1;
                            Reportes ultimoBimestral = reportes.get(nReporte);
                if (statusDocFinales != 0 && ultimoBimestral.getStatus().toString().equals("1")) {



                    switch (statusDocFinales) {
                        //Aceptado
                        case 1:
                            try {
                                //Valida si ya lo tiene completo
                                ArrayList<DocumentosFinales> documentosFinales = new ArrayList<DocumentosFinales>(servicioBean.getDatosPersonales().getDocumentosFinalesCollection());
                                if (!documentosFinales.isEmpty() && documentosFinales != null && documentosFinales.size() > 0) {
                                    DocumentosFinales docFinal = documentosFinales.get(0);
                                    if (docFinal.getDocumentoFisico().toString().equals("1")) {
                                        //Entrego sus documentos en fisico
                                        reportesFinales.setMensaje(" Y ya has entregado tus documentos en original.");
                                        reportesFinales.setPuedeAccesar(false);
                                        reportesFinales.setStatus(1);
                                    } else {
                                        //NO ha entregado en original
                                        reportesFinales = aceptadoPendiente(" Ya puedes pasar a entregar tu documentos en original para poder recibir la carta de liberación del servicio social");
                                    }
                                } else {
                                    //No ha entregado  en original
                                    reportesFinales = aceptadoPendiente(" Ya puedes pasar a entregar tu documentos en original para poder recibir la carta de liberación del servicio social");
                                }
                            } catch (Exception e) {
                                //Hubo algun error 
                                reportesFinales = aceptadoPendiente(" Ya puedes pasar a entregar tu documentos en original para poder recibir la carta de liberación del servicio social");
                            }
                            break;
                        //Rechazado
                        case 2:
                            reportesFinales.setMensaje("Tu documentación final ha sido rechazada.");
                            reportesFinales.setPuedeAccesar(false);
                            reportesFinales.setStatus(2);
                            break;
                        //Correccion
                        case 3:
                            int revisionesFuf = 0;
                            try {
                                revisionesFuf = Integer.parseInt(servicioBean.getFormatoUnico().getRevisionesFuf().toString());
                            } catch (Exception ex) {
                            }

                            if (revisionesFuf <= 5) {
                                reportesFinales.setMensaje("Tu documentación final se encuentra en corrección. Por favor revisa la sección de observaciones para saber lo que tienes que corregir.");
                                reportesFinales.setPuedeAccesar(true);
                                reportesFinales.setStatus(3);
                            } else {
                                reportesFinales.setMensaje("Lo sentimos, has sobrepasado el número máximo de correcciones en la documentación final.");
                                reportesFinales.setPuedeAccesar(false);
                                reportesFinales.setStatus(2);
                            }
                            break;
                        //No Revisisado
                        case 4:
                            reportesFinales.setMensaje("Tu documentación final se encuentra en revisión.");
                            reportesFinales.setPuedeAccesar(false);
                            reportesFinales.setStatus(3);
                            break;
                        default:
                            reportesFinales.setMensaje("Invalid Status");
                            reportesFinales.setPuedeAccesar(false);
                            reportesFinales.setStatus(2);
                            break;

                    }
                } else {
                    reportesFinales.setMensaje("Ahora puedes dar de alta tus Documentos Finales.");
                    reportesFinales.setPuedeAccesar(true);
                    reportesFinales.setStatus(2);
                }

            } else {
                reportesFinales.setMensaje("No has completado el total de horas de servicio. Al completarlas podrás dar de alta tus documentos finales");
                reportesFinales.setPuedeAccesar(false);
                reportesFinales.setStatus(2);
            }
        } else {
            reportesFinales.setMensaje("No puedes acceder dado que no asististe a la platica de induccion");
            reportesFinales.setPuedeAccesar(false);
            reportesFinales.setStatus(2);
        }

        return reportesFinales;
    }

    /**
     * Metodo creado dado que se pueden repetir varias veces esta respueta en la
     * validacion del reporte
     *
     * @param mensaje
     * @return
     */
    public ReportesFinalesBean aceptadoPendiente(String mensaje) {
        String mensajeInicio = "Tus documentación final ya ha sido aceptada.";
        ReportesFinalesBean bean = new ReportesFinalesBean();
        bean.setMensaje(mensajeInicio + mensaje);
        bean.setStatus(4);
        bean.setPuedeAccesar(false);
        return bean;

    }

    class OrdenarPersonaPorId implements Comparator<Reportes> {

        public int compare(Reportes o1, Reportes o2) {
            return Integer.valueOf(String.valueOf(o1.getId())) - Integer.valueOf(String.valueOf(o2.getId()));
        }
    }
}
