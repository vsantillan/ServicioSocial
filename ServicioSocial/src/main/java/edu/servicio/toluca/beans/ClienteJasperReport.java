/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.io.*;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import com.jaspersoft.ireport.jasperserver.JServer;
import com.jaspersoft.jasperserver.api.metadata.xml.domain.impl.ResourceDescriptor;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.openide.util.Exceptions;


/**
 *
 * @author ingluisestrada
 */
public class ClienteJasperReport {

     private JServer server = null;
    
     public ClienteJasperReport()
     {
         server = new JServer();
         server.setUrl("http://192.168.57.201:8080/jasperserver/services/repository");
         server.setUsername("jasperadmin");
         server.setPassword("jasperadmin");         
     }
     
     public java.util.List list(String uri) throws Exception
     {
        ResourceDescriptor rd = new ResourceDescriptor();
        rd.setWsType( ResourceDescriptor.TYPE_FOLDER);
        rd.setUriString(uri);
        return server.getWSClient().list(rd);
     }
     
     public ResourceDescriptor get(String uri) throws Exception
     {
        return get(uri, null);
     } 
     
     public ResourceDescriptor get(String uri, java.util.List args) throws Exception
     {
        ResourceDescriptor rd = new ResourceDescriptor();
        rd.setWsType( ResourceDescriptor.TYPE_REPORTUNIT);
        rd.setUriString(uri);
        return server.getWSClient().get(rd, null,args);
     } 
     
     public JasperPrint runReport(String reportUri, java.util.Map parameters) throws Exception
     {
        ResourceDescriptor rd = new ResourceDescriptor();
        rd.setWsType( ResourceDescriptor.TYPE_REPORTUNIT);
        rd.setUriString(reportUri);
      
        return server.getWSClient().runReport(rd, parameters);
     }
     
}

