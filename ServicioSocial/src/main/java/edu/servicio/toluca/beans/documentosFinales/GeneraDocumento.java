/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.documentosFinales;

import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.login.Conexion;
import java.io.File;
import java.util.HashMap;
import java.util.List;
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

    public GeneraDocumento() {
    }

    public void generar(String usu, String pass,String nombre_reporte,Map parameters, HttpServletRequest request,HttpServletResponse httpServletResponse) 
    {
        try {
            Conexion conn = new Conexion();
            /*Establecemos la ruta del reporte*/
            File reportFile = new File(request.getRealPath("reportes//"+nombre_reporte+".jasper"));
            /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
//            Map parameters = new HashMap();
//            //parameters.put("noControl", noControl);
//            //parameters.put("idProyecto", idProyecto);//idProyecto
//            for(int i=0;i<arr[0].length;i++)
//            {
//                //System.out.print("Nombre del parametro: "+arr[0][i]+"\t");
//                //System.out.print("Valor del parametro: "+arr[1][i]+"\t");
//                System.out.println("parameters.put(\"Nombre_parametro: "+arr[0][i]+"\", \"Valor_Parametro: "+arr[1][i]+"\");"); 
//                parameters.put(arr[0][i], arr[1][i]); 
//            }
            //parameters.put("Nombre_parametro", "Valor_Parametro"); 
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
    
//    public static void main(String[] args) {
//        
//        GeneraDocumento obj=new GeneraDocumento();
//        String[][] arr=new String [2][5];
//        arr[0][0]="no_control";
//        arr[1][0]="09280525";
//        arr[0][1]="idProyecto";
//        arr[1][1]="2";
//        obj.generar(arr, null, null);
//    }
}
