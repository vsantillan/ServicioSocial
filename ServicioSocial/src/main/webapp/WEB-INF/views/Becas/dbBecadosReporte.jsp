<%-- 
    Document   : dbBecadosReporte
    Created on : 25/10/2013, 01:22:40 PM
    Author     : Jonny
--%>

<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
/*importamos las librerías de JasperReports*/ 
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.*" %> 
<%@ page import="edu.servicio.toluca.login.Conexion"%>
<% /*Parametros para realizar la conexión*/ 
    Conexion conn =new Conexion ();
/*Establecemos la ruta del reporte*/ 
 File reportFile = new File(application.getRealPath("reportes//db becados programa ssc.jasper")); 
 /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
Map parameters = new HashMap();
//parameters.put("folio",session.getAttribute("platica").toString()+session.getAttribute("NCONTROL").toString()); 
/*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (), parameters, conn.conectar("ges_vin", "gst05a"));
JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile.getPath(), parameters);
String xlsFilesSource = "/reportes/becados.xls";

//Creacion del XLS
JRXlsExporter exporter = new JRXlsExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,application.getRealPath(xlsFilesSource));
exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
exporter.exportReport();
/*Indicamos que la respuesta va a ser en formato XLS*/ 
//response.setContentType("application/vnd.ms-excel"); 
//response.setContentLength(bytes.length);
//ServletOutputStream ouputStream = response.getOutputStream(); 
//ouputStream.write(bytes, 0, bytes.length); 
///*Limpiamos y cerramos flujos de salida*/ 
//ouputStream.flush(); 
//ouputStream.close(); 
File f = new File (application.getRealPath(xlsFilesSource));

//Obtener el Nombre del archivo.
String name = f.getName().substring(f.getName().lastIndexOf("/") + 1,f.getName().length());

//Configurar cabecera y nombre de archivo a desplegar en DialogBox.
//response.setHeader("Content-Disposition", "attachment; filename=" " + name + "+"");
response.setContentType ("application/vnd.ms-excel");
response.setHeader ("Content-Disposition", "attachment;filename=\"" +name + "\""); //Configurar cabecera http
InputStream in = new FileInputStream(f);
ServletOutputStream outs = response.getOutputStream();

int bit = 256;
int i = 0;

while ((bit) >= 0) {
bit = in.read();
outs.write(bit);
}

outs.flush();
outs.close();
in.close();%>