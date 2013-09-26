/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.formatoUnico;

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

    public FormatoUnicoPanelUsuarioBean validaPanelUsuario(FoliosPlaticaBean beanPlatica, FormatoUnico formatoUnico) {
        System.out.println("Validacion Formato Unico");
        FormatoUnicoPanelUsuarioBean beanFU = new FormatoUnicoPanelUsuarioBean();
        
        switch (Integer.parseInt(formatoUnico.getStatusServicio().toString())) {
            //Activo
            case 1:
                System.out.println("Activo");
                if (beanPlatica.isTienePlatica()) {
                    if (formatoUnico.getStatusFui() == null) {
                        beanFU.setAccesoFormatoUnico(true);
                        beanFU.setMensaje("No has dado de alta tu Formato Unico");
                        beanFU.setStatusFui(2);
                    } else {
                        int statusFui = Integer.parseInt(formatoUnico.getStatusFui().toString());
                        switch (statusFui) {
                            //Aceptado
                            case 1:
                                beanFU.setAccesoFormatoUnico(false);
                                beanFU.setStatusFui(1);
                                beanFU.setMensaje("Tu Formato Unico ha sido aceptado");
                                break;
                            //Rechazado
                            case 2:
                                beanFU.setAccesoFormatoUnico(true);
                                beanFU.setStatusFui(2);
                                beanFU.setMensaje("Tu Formato Unico fue rechazado.");
                                break;
                            //Correccion
                            case 3:
                                int revisionesFui=0;
                                try{
                                    revisionesFui=Integer.parseInt(formatoUnico.getRevisionesFui().toString());
                                }catch(Exception ex){}
                        
                                if (revisionesFui <= 5) {
                                    beanFU.setAccesoFormatoUnico(true);
                                    beanFU.setStatusFui(3);
                                    beanFU.setMensaje("Tu Formato Unico se encuentra en correccion. Por favor accede a la seccion de observaciones para saber que es lo que tienes que corregir en tu Formato Unico.");
                                } else {
                                    beanFU.setAccesoFormatoUnico(false);
                                    beanFU.setStatusFui(3);
                                    beanFU.setMensaje("Lo sentimos, has sobrepasado el numero maximo de correcciones en tu Formato Unico.");
                                }
                                break;
                            //No revisado
                            case 4:
                                beanFU.setAccesoFormatoUnico(false);
                                beanFU.setStatusFui(3);
                                beanFU.setMensaje("Tu Formato Unico se encuentra en revision.");
                                break;
                            //Descargado
                            case 5:
                                beanFU.setAccesoFormatoUnico(true);
                                beanFU.setStatusFui(3);
                                beanFU.setMensaje("Ya has generado y descargado tu Formato Unico. Solo falta que subas tu Formato Unico escaneado y sellado.");
                                break;
                        }
                    }
                } else {
                    beanFU.setAccesoFormatoUnico(false);
                    beanFU.setMensaje("No puedes proceder a dar de alta tu Formato Unico, dado que no asististe a la platica de induccion, favor comunicarse con el Jefe de la Oficina del Servicio Social.");
                    beanFU.setStatusFui(2);                    
                }
                break;
            //Cancelado
            case 2:
                beanFU.setAccesoFormatoUnico(false);
                beanFU.setMensaje("Tu servicio social ha sido cancelado");
                beanFU.setStatusFui(2);
                break;
            //Baja Temporal
            case 3:
                beanFU.setAccesoFormatoUnico(false);
                beanFU.setMensaje("Tu servicio social esta dado de baja temporalmente");
                beanFU.setStatusFui(2);
                break;
            //Terminado
            case 4:
                beanFU.setAccesoFormatoUnico(false);
                beanFU.setMensaje("Tu proceso de servicio social ya ha concluido.");
                beanFU.setStatusFui(2);
                break;
        }


        return beanFU;
    }
}
