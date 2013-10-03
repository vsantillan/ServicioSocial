/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.formatoUnico;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoPanelUsuarioBean;
import edu.servicio.toluca.beans.platica.FoliosPlaticaBean;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;

/**
 *
 * @author bustedvillain
 */
public class ValidacionPanelUsuarioFU {

    FormatoUnicoFacade formatoUnicoFacade;

    public ValidacionPanelUsuarioFU(FormatoUnicoFacade formatoUnicoFacade) {
        this.formatoUnicoFacade = formatoUnicoFacade;
    }

    public ValidacionPanelUsuarioFU() {
    }

    public FormatoUnicoPanelUsuarioBean validaPanelUsuario(StatusServicioBean servicioBean) {
        System.out.println("Validacion Formato Unico");
        FormatoUnicoPanelUsuarioBean beanFU = new FormatoUnicoPanelUsuarioBean();

        if (servicioBean.getPlaticaBean().isTienePlatica()) {
            if (servicioBean.getFormatoUnico().getStatusFui() == null) {
                beanFU.setAccesoFormatoUnico(true);
                beanFU.setMensaje("No has dado de alta tu Formato Único");
                beanFU.setStatusFui(2);
            } else {
                int statusFui = Integer.parseInt(servicioBean.getFormatoUnico().getStatusFui().toString());
                switch (statusFui) {
                    //Aceptado
                    case 1:
                        beanFU.setAccesoFormatoUnico(false);
                        beanFU.setStatusFui(1);
                        beanFU.setMensaje("Tu Formato Único ha sido aceptado");
                        break;
                    //Rechazado
                    case 2:
                        beanFU.setAccesoFormatoUnico(false);
                        beanFU.setStatusFui(2);
                        beanFU.setMensaje("Tu Formato Único fue rechazado.");
                        break;
                    //Correccion
                    case 3:
                        int revisionesFui = 0;
                        try {
                            revisionesFui = Integer.parseInt(servicioBean.getFormatoUnico().getRevisionesFui().toString());
                        } catch (Exception ex) {
                        }

                        if (revisionesFui <= 5) {
                            beanFU.setAccesoFormatoUnico(true);
                            beanFU.setStatusFui(3);
                            beanFU.setMensaje("Tu Formato Único se encuentra en corrección. Por favor revisa a la sección de observaciones para saber que es lo que tienes que corregir en tu Formato Unico.");
                        } else {
                            beanFU.setAccesoFormatoUnico(false);
                            beanFU.setStatusFui(2);
                            beanFU.setMensaje("Lo sentimos, has sobrepasado el número máximo de correcciones en tu Formato Único.");
                        }
                        break;
                    //No revisado
                    case 4:
                        beanFU.setAccesoFormatoUnico(false);
                        beanFU.setStatusFui(3);
                        beanFU.setMensaje("Tu Formato Único se encuentra en revisión.");
                        break;
                    //Descargado
                    case 5:
                        beanFU.setAccesoFormatoUnico(true);
                        beanFU.setStatusFui(3);
                        beanFU.setMensaje("Ya has generado y descargado tu Formato Único. Sólo falta que subas tu Formato Único escaneado y sellado.");
                        break;
                }
            }
        } else {
            beanFU.setAccesoFormatoUnico(false);
            beanFU.setMensaje("No puedes proceder a dar de alta tu Formato Único, dado que no asististe a la plática de inducción, favor comunicarse con el Jefe de la Oficina del Servicio Social.");
            beanFU.setStatusFui(2);
        }


        return beanFU;
    }
}
