<%@page import="edu.servicio.toluca.beans.ClienteJasperReport, net.sf.jasperreports.engine.*,net.sf.jasperreports.engine.export.*"%>
<%

    //Se define el nombre del reporte del jasperserver con su ruta
    String reporte = "/reports/sia/folio1";
    String idPlatica = request.getParameter("fecha");

    com.jaspersoft.jasperserver.api.metadata.xml.domain.impl.ResourceDescriptor reportUnit = null;
    java.io.OutputStream os = null;
    try {
        java.util.Map parametros = new java.util.HashMap();

        //se crea la lista de parametros del reporte
        parametros.put("id", idPlatica);

        ClienteJasperReport client = new ClienteJasperReport();
        JasperPrint print = client.runReport(reporte, parametros);
        net.sf.jasperreports.engine.JRExporter exporter = null;
        response.setContentType("application/pdf");
        exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
        os = response.getOutputStream();
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        exporter.exportReport();
        return;
    } catch (Exception ex) {
        ex.printStackTrace();
        if (os != null) {
            java.io.PrintWriter pw = new java.io.PrintWriter(os);
            pw.write("<h1>Error al ejecutar el reporte</h1><code>");
            ex.printStackTrace(pw);
            pw.write("</code>");
        } else {
            out.write("<h1>Error al ejecutar el reporte</h1><code>");
            out.write(ex.getMessage() + "<br><br>");
            ex.printStackTrace(new java.io.PrintWriter(out));
            out.write(ex.getMessage() + "</code>");

        }

        return;
    }
%>