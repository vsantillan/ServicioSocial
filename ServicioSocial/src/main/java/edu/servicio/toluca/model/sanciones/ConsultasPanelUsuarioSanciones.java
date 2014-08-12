/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.sanciones;

import edu.servicio.toluca.beans.FechaAPalabras;
import edu.servicio.toluca.beans.SancionBean;
import edu.servicio.toluca.beans.SancionesBean;
import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Sanciones;
import edu.servicio.toluca.sesion.SancionesFacade;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author bustedvillain
 */
public class ConsultasPanelUsuarioSanciones
{

    public SancionesBean consultaHorasSancion(StatusServicioBean servicioBean)
    {
        SancionesBean sancionesBean = new SancionesBean();

        List<Sanciones> sanciones = new ArrayList<Sanciones>(servicioBean.getDatosPersonales().getSancionesCollection());
        for (int i = 0; i < sanciones.size(); i++)
        {
            int horas = Integer.parseInt(sanciones.get(i).getHorasSancion().toString());
            sancionesBean.sumaHoras(horas);
        }

        if (sancionesBean.getHorasSancion() > 0)
        {
            sancionesBean.setMensaje("Tienes un total de " + sancionesBean.getHorasSancion() + " horas de sancion, favor de acudir a la oficina de servicio social para que se te asigne una instancia donde pagar tu horas de sancion.");
            sancionesBean.setTieneSancion(true);
        } else
        {
            sancionesBean.setMensaje("No tienes sanciones");
            sancionesBean.setTieneSancion(false);
        }

        return sancionesBean;
    }

    public List<SancionBean> listaSanciones(DatosPersonales datosPersonales, SancionesFacade sancionesFacade, String orden)
    {
        FechaAPalabras fecha = new FechaAPalabras();
        List<SancionBean> sancionesBean = new ArrayList<SancionBean>();
        List<Sanciones> sanciones = null;
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();

        if (orden.equals("desc"))
        {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc"))
        {
            ordenamiento.put("fecha", "asc");
        }
        //Consulta a las sanciones
        sanciones = sancionesFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", ordenamiento, null);

        //Imprime noticias en consola
//        System.out.println("Observaciones");
        if (!sanciones.isEmpty())
        {
            for (int i = 0; i < sanciones.size(); i++)
            {

                SancionBean sancion = new SancionBean();
                //sancion.setFecha(sanciones.get(i).getFecha());

                int horasSancion = Integer.parseInt(sanciones.get(i).getHorasSancion().toString());
                if (horasSancion > 0)
                {
                    sancion.setConcepto(0);
                    sancion.setDetalle("<b>Motivo de la sanción:</b> " + sanciones.get(i).getCatalogoSancionesId().getDetalle() + "<br/><br/><b> Horas Restantes:</b> " + sanciones.get(i).getHorasSancion());
                } else
                {
                    sancion.setConcepto(1);
                    sancion.setDetalle("PAGO DE SANCION: " + sanciones.get(i).getCatalogoSancionesId().getDetalle() + " HORAS:" + sanciones.get(i).getHorasSancion());
                }
                sancionesBean.add(sancion);
            }
        }
        return sancionesBean;

    }
}
