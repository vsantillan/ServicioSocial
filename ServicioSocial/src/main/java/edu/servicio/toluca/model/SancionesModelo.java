/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model;

import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.entidades.CatalogoSanciones;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.sesion.SancionesFacade;
import edu.servicio.toluca.sesion.CatalogoSancionesFacade;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author SATELLITE
 */
public class SancionesModelo {

    java.util.Date fecha_max;
    CatalogoSancionesFacade catalogoSancionesFacade;
    SancionesFacade sancionesFacade;
    DatosPersonales dp;
    String clave_sancion;

    /**
     * Para que funcione requiere 4 parámetros, 2 de ellos son Facades, el de
     * CatalogoSanciones y el de Sanciones, como 3er parámetro requiere la fecha
     * máxima, pasando esa fecha aplicará la sación, el 4to parámero es el
     * objeto de datos personales a quien se aplicará la sanción, el último
     * parámetro es el nombre en clave de la sanción por ejemplo S01
     *
     * @param catalogoSancionesFacade Es el facade de CatalogoSanciones
     * @param sancionesFacade Es el facade de Sanciones
     * @param fecha_max Es la fecha máxima o la que limita la sanción
     * @param dp Es el objeto de datos personales al que se le aplicará la
     * sanción
     * @param clave_sancion Es la clave de la sanción en la BD por ejemplo S01
     *
     */
    public SancionesModelo(CatalogoSancionesFacade catalogoSancionesFacade, SancionesFacade sancionesFacade, java.util.Date fecha_max, DatosPersonales dp, String clave_sancion) {
        this.fecha_max = fecha_max;
        this.catalogoSancionesFacade = catalogoSancionesFacade;
        this.sancionesFacade = sancionesFacade;
        this.dp = dp;
        this.clave_sancion = clave_sancion;
    }

    public void asignaSancion() {
        java.util.Date fecha_actual = new java.util.Date();
        System.out.println("La fecha actual es: " + fecha_actual);
        System.out.println("La fecha máxima es:" + fecha_max);
        if (fecha_actual.after(fecha_max))//fecha_max el la fecha máxima que tengas definida
        {
            System.out.println("La fecha actual sobrepasa la fecha máxima, procedo a revisar tolerancia");
            if (catalogoSancionesFacade.count() < 1) {
                System.out.println("La tabla de sanciones está vacía");
                //return "redirect:panelUsuario.do";
            }
            List<CatalogoSanciones> listaCatalogoSanciones = catalogoSancionesFacade.findBySpecificField("detalle", clave_sancion, "like", null, null);
            if (listaCatalogoSanciones.isEmpty()) {
                System.out.println("La sanción no pudo ser encontrada");
                //return "redirect:panelUsuario.do";
            }
            CatalogoSanciones catalogoSancion = listaCatalogoSanciones.get(0);//Se obtiene el registro de la sanción para tratar sus datos
            Calendar fecha_max_x = Calendar.getInstance();
            fecha_max_x.setTime(fecha_max);
            fecha_max_x.add(Calendar.DATE, 5);
            fecha_max = fecha_max_x.getTime();
            System.out.println("La fecha con la tolerancia es" + fecha_max);
            if (fecha_actual.after(fecha_max)) {
                System.out.println("La fecha actual sobrepasa la de con tolerancia");
                edu.servicio.toluca.entidades.Sanciones sancion = new edu.servicio.toluca.entidades.Sanciones();
                sancion.setCatalogoSancionesId(catalogoSancion);
                sancion.setDatosPersonalesId(dp);//Id corresponde al objeto datos personales de mi alumno a sancionar
                sancion.setFecha(fecha_actual);
                sancion.setHorasSancion(catalogoSancion.getHorasSancion());
                System.out.println("Sancion: " + catalogoSancion.getDetalle() + "\nAplicada a: " + dp.getNumeroControl() + "-" + dp.getNombre() + "\nHoras:" + catalogoSancion.getHorasSancion());
                System.out.println("Y su correo es:" + dp.getCorreoElectronico());
                EnviarCorreo correo = new EnviarCorreo("Se te ha asignado una sanción", dp.getCorreoElectronico(), "Tienes una sanción de " + sancion.getHorasSancion() + "horas. La sanción es: " + catalogoSancion.getDetalle());
                correo.enviaCorreo();
                try {
                    sancionesFacade.create(sancion);

                } catch (Exception e) {
                    System.out.println("Problema al crear" + e.getMessage());
                }
            } else {
                System.out.println("La fecha actual no sobrepasa la de con tolerancia, no hay sancion");
            }
        } else {
            System.out.println("La fecha actual está dentro de la fecha máxima. No hay sanción");
        }
    }
}
