<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
/*importamos las librerías de JasperReports*/ 
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.*" %> 
<%@ page import="edu.servicio.toluca.login.Conexion"%>
<% /*
     * Parametros para realizar la conexión
     */

    Conexion conn = new Conexion();
    /*
     * Establecemos la ruta del reporte
     */
    File reportFile = new File(application.getRealPath("reportes//folioPlatica.jasper"));
    /*
     * No enviamos parámetros porque nuestro reporte no los necesita asi que escriba cualquier cadena de texto ya que
     * solo seguiremos el formato del método runReportToPdf
     */
    Map parameters = new HashMap();
    System.out.println(session.getAttribute("platica"));
    System.out.println(session.getAttribute("NCONTROL"));
    parameters.put("folio", session.getAttribute("platica").toString() + session.getAttribute("NCONTROL").toString());
    /*
     * Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)
     */
    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn.conectarAux("ges_vin", "gst05a"));
    /*
     * Indicamos que la respuesta va a ser en formato PDF
     */
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream ouputStream = response.getOutputStream();
    ouputStream.write(bytes, 0, bytes.length);
    /*
     * Limpiamos y cerramos flujos de salida
     */
    ouputStream.flush();
    ouputStream.close();
%>