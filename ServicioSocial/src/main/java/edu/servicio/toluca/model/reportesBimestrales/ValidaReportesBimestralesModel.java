package edu.servicio.toluca.model.reportesBimestrales;

import edu.servicio.toluca.beans.ReportesBean;
import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.beans.bimestrales.fechas;
import edu.servicio.toluca.entidades.Reportes;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.openide.util.Exceptions;

/**
 *
 * @author bustedvillain
 */
public class ValidaReportesBimestralesModel
{

    public ReportesBean validaReportesBimestrales(StatusServicioBean servicioBean)
    {
        ReportesBean reportesBean = new ReportesBean();

        //Condición que valída si el alumno se ha registrado a alguna plática.
        if (servicioBean.getPlaticaBean().isTienePlatica())
        {
            //Condición que valida si ya cumplió el proceso del formato único.
            if (servicioBean.getFormatoUnico() != null && servicioBean.getFormatoUnico().getStatusFui() != null)
            {
                //Valida que el alumno no haya excedido el tiempo de dos años.
                fechas manejadorFechas = new fechas();
                Calendar fecha = Calendar.getInstance();
                fecha.setTime(servicioBean.getFormatoUnico().getFechaInicio());
                fecha.add(Calendar.YEAR, 2);
                Date fechaMaxima = manejadorFechas.covierteString(manejadorFechas.convierteDate(fecha.getTime()));
                Calendar fechaActual = Calendar.getInstance();
                Date fechaActualDate = manejadorFechas.covierteString(manejadorFechas.convierteDate(fechaActual.getTime()));
                //If de las líneas de arriba
                if (!servicioBean.getFormatoUnico().getStatusFui().toString().equals("2") && !fechaActualDate.after(fechaMaxima))
                {
                    //Condidición que valida el proceso del formato único (¿Otra vez?)
                    if (servicioBean.getFormatoUnico().getStatusFui().toString().equals("1"))
                    {
                        ArrayList<Reportes> reportes = new ArrayList<Reportes>(servicioBean.getDatosPersonales().getReportesCollection());
                        Collections.sort(reportes, new OrdenarPersonaPorId());
                        int horasServicio = 0;
                        int nReportes = 0;
                        nReportes = reportes.size();
                        servicioBean.setReportesBimestrales(reportes);
                        System.out.println("Size reportes:" + nReportes);
                        //Valida si ha dado de alta reportes bimestrales
                        if (!reportes.isEmpty() && reportes != null && nReportes > 0)
                        {
                            System.out.println("Entro a validar bien los reportes bimestrales");
                            for (int i = 0; i < reportes.size(); i++)
                            {
                                System.out.println("calculando horas...");
                                int horas = Integer.parseInt(reportes.get(i).getHoras().toString());
                                horasServicio += horas;
                            }
                            int nReporte = reportes.size() - 1;
                            Reportes ultimoBimestral = reportes.get(nReporte);
                            int status = Integer.parseInt(ultimoBimestral.getStatus().toString());
                            System.out.println("tiene " + horasServicio + " horas..." + " plan " + String.valueOf(servicioBean.getFormatoUnico().getCatalogoPlanId().getDetalle()));
                            servicioBean.setHorasServicio(horasServicio);
                            //Valida si tiene menos de 480 horas, más que obvio esto
                            if (horasServicio < 480)
                            {
                                //if (horasServicio < 480) {
                                System.out.println("Menos 480 horas");
                                //Validar el ultimo reporte bimestral
//                            int nReporte = reportes.size() - 1;
//                            Reportes ultimoBimestral = reportes.get(nReporte);
//                            int status = Integer.parseInt(ultimoBimestral.getStatus().toString());
                                System.out.println("Checando status del ultimo reporte:" + status);
                                switch (status)
                                {
                                    //Descargado
                                    case 0:
                                        reportesBean.setAccesoFormato(true);
                                        reportesBean.setMensaje("Ya has generado y descargado tu último Reporte Bimestral. Sólo falta que subas tu Reporte escaneado y sellado.");
                                        reportesBean.setStatus(3);
                                        break;
                                    //Aceptado
                                    case 1:
                                        Date ahora = new Date();
                                        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                                        try
                                        {
                                            ahora = formateador.parse(formateador.format(ahora));
                                        } catch (ParseException ex)
                                        {
                                            Exceptions.printStackTrace(ex);
                                        }
//                                    System.out.println("fecha sistema" + ahora);
//                                    if (ahora.before(ultimoBimestral.getFechaFin())) {
//                                        reportesBean.setAccesoFormato(false);
//                                        reportesBean.setMensaje("Tu Reporte Bimestral número " + ultimoBimestral.getNumeroReporte() + " fue aceptado. Tienes un total de " + horasServicio + " horas de servicio.Espera al siguiente bimestre para continuar con tu proceso");
//                                        reportesBean.setStatus(3);
//                                    } else {
                                        reportesBean.setAccesoFormato(true);
                                        reportesBean.setMensaje("Tu Reporte Bimestral número " + ultimoBimestral.getNumeroReporte() + " fue aceptado. Tienes un total de " + horasServicio + " horas de servicio.");
                                        reportesBean.setStatus(3);
//                                    }
                                        break;
                                    //Rechazado:
                                    case 2:
                                        reportesBean.setAccesoFormato(false);
                                        reportesBean.setMensaje("Tu Reporte Bimestral número " + ultimoBimestral.getNumeroReporte() + " fue rechazado. Favor de acudir a la oficina de servicio social, dado que no puedes continuar con tu proceso hasta que soluciones esta situación.");
                                        reportesBean.setStatus(2);
                                        break;
                                    //Correccion
                                    case 3:
                                        int nRevisiones = 0;
                                        try
                                        {
                                            nRevisiones = Integer.parseInt(ultimoBimestral.getNumeroRevisiones().toString());
                                        } catch (Exception e)
                                        {
                                        }

                                        if (nRevisiones <= 5)
                                        {
                                            reportesBean.setAccesoFormato(true);
                                            reportesBean.setMensaje("Tu Reporte Bimestral número " + ultimoBimestral.getNumeroReporte() + " se encuentra en corrección. Por favor revisa la sección de observaciones para saber que es lo que tienes que corregir en tu Reporte Bimestral.");
                                            reportesBean.setStatus(3);
                                        } else
                                        {
                                            reportesBean.setAccesoFormato(false);
                                            reportesBean.setMensaje("Lo sentimos, has sobrepasado el número máximo de correcciones en tu Reporte Bimestral " + ultimoBimestral.getNumeroReporte());
                                            reportesBean.setStatus(2);
                                        }
                                        break;
                                    //No revisado
                                    case 4:
                                        reportesBean.setAccesoFormato(false);
                                        reportesBean.setMensaje("Tu Reporte Bimestral se encuentra en revisión.");
                                        reportesBean.setStatus(3);
                                        break;
                                    default:
                                        reportesBean.setAccesoFormato(false);
                                        reportesBean.setMensaje("Invalid status");
                                        reportesBean.setStatus(2);
                                        break;
                                }
                            } else
                            {
                                //Valida si el reporte bimestral tiene status 0, si es así al parecer ya completó las horas en el servicio
                                if (ultimoBimestral.getStatus().compareTo(BigInteger.ONE) == 0)
                                {
                                    reportesBean.setAccesoFormato(false);
                                    reportesBean.setMensaje("Ya haz completado las horas de servicio social. Subiste " + nReportes + " Reportes Bimestrales");
                                    reportesBean.setStatus(1);
                                } else
                                {
                                    reportesBean.setAccesoFormato(false);
                                    reportesBean.setMensaje("Tu Reporte Bimestral se encuentra en revisión.");
                                    reportesBean.setStatus(3);
                                }
                            }

                        } else
                        {
                            //Si no tiene ningun reporte
                            reportesBean.setAccesoFormato(true);
                            reportesBean.setMensaje("No haz dado de alta ningun Reporte Bimestral");
                            reportesBean.setStatus(2);
                        }
                    } else
                    {
                        reportesBean.setAccesoFormato(false);
                        reportesBean.setMensaje("No puedes proceder a dar de alta tus Reportes Bimestrales, dado que no has completado el proceso de formato unico.");
                        reportesBean.setStatus(2);
                    }
                } else
                {
                    reportesBean.setAccesoFormato(false);
                    reportesBean.setMensaje("No puedes continuar con tu proceso debido a que excediste los 2 años de tiempo para concluir.");
                    reportesBean.setStatus(2);
                }
            } else
            {
                reportesBean.setAccesoFormato(false);
                reportesBean.setMensaje("No puedes proceder a dar de alta tus Reportes Bimestrales, dado que no has completado el proceso de formato unico.");
                reportesBean.setStatus(2);
            }
        } else
        {
            reportesBean.setAccesoFormato(false);
            reportesBean.setMensaje("No puedes proceder a dar de alta tus Reportes Bimestrales, dado que no asististe a la platica de induccion, favor de comunicarse con el Jefe de la Oficina del Servicio Social");
            reportesBean.setStatus(2);
        }
        return reportesBean;
    }
}

class OrdenarPersonaPorId implements Comparator<Reportes>
{

    @Override
    public int compare(Reportes o1, Reportes o2)
    {
        return Integer.valueOf(String.valueOf(o1.getId())) - Integer.valueOf(String.valueOf(o2.getId()));
    }
}
