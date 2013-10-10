<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="edu.servicio.toluca.login.Conexion"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="edu.servicio.toluca.beans.ClienteJasperReport, net.sf.jasperreports.engine.*,net.sf.jasperreports.engine.export.*"%>

<%
        Conexion conn =new Conexion ();
        /*Establecemos la ruta del reporte*/ 
         File reportFile = new File(application.getRealPath("reportes//plantilaReporteBimestral.jasper")); 
         /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
        Map parameters = new HashMap();
        parameters.put("no_control","09280536");
        parameters.put("no_reporte","1");
        //parameters.put("Nombre_parametro", "Valor_Parametro"); 
        /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
        byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (), parameters, conn.conectar("ges_vin", "gst05a"));
        /*Indicamos que la respuesta va a ser en formato PDF*/ 
        response.setContentType("application/pdf"); 
        response.setContentLength(bytes.length);
        ServletOutputStream ouputStream = response.getOutputStream(); 
        ouputStream.write(bytes, 0, bytes.length); 
        /*Limpiamos y cerramos flujos de salida*/ 
        ouputStream.flush(); 
        ouputStream.close();
%>