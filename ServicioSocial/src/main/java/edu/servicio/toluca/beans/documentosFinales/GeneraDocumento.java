/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.documentosFinales;

import edu.servicio.toluca.login.Conexion;
import java.io.File;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import org.openide.util.Exceptions;

/**
 *
 * @author ekt
 */
public class GeneraDocumento {

    public void generar(String usu, String pass, String nombre_reporte, Map parameters, HttpServletRequest request, HttpServletResponse httpServletResponse) {
        try {
            Conexion conn = new Conexion();
            /*Establecemos la ruta del reporte*/
            File reportFile = new File(request.getRealPath("reportes//" + nombre_reporte + ".jasper"));
            /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn.conectarAux(usu, pass));
            /*Indicamos que la respuesta va a ser en formato PDF*/
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setContentLength(bytes.length);
            httpServletResponse.getOutputStream().write(bytes);

        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
