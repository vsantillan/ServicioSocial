<%-- 
    Document   : acercaDe
    Created on : 20-sep-2013, 12:52:48
    Author     : bustedvillain
--%>

<%@page import="edu.servicio.toluca.beans.ValidaSesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">

            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%> 
                <div class="row ">
                    <!---------------------------------------------Contenido------------------------------------------->                
                  
                    
                    <div class="col-md-10 col-md-offset-1">
                        <h1>Acerca de</h1> 
                        <h4>El Sistema de Servicio Social, est&aacute; encargado de realizar la gesti&oacute;n del proceso del servicio social, de acuerdo al manual de operaci&oacute;n que otorga la DGEST.</h4>
                    <h4>v2.0</h3>
                        <h4>Este sistema fue desarrollado por estudiantes de la carrera de Ingenier&iacute;a en Sistemas Computacionales perteneciente al Instituto Tecnol&oacute;gico de Toluca.</h4>

                                <ul>
                                    <li><h5>Ing. Maricela Santiago Cayetano</h5></li>
                                    <li><h5>Ing. Omar Nava Pulido</h5></li>
                                    <li><h5>Ing. Rodrigo L&oacute;pez Rosales</h5></li>
                                    <li><h5>Ing. Esteban Ismael Regules P&eacute;rez</h5></li>
                                    <li><h5>Ing. Hector Morales Palma</h5></li>
                                    <li><h5>Ing. Martin Jonatan D&iacute;az Plata</h5></li>
                                    <li><h5>Ing. Jos&eacute; Manuel Nieto G&oacute;mez</h5></li>
                                    <li><h5>Ing. Jes&uacute;s Guzm&aacute;n Mondrag&oacute;n</h5></li>                            
                                </ul>
                                
                    </div>
                        
                           
                            <br/><br/><br/><br/><br/><br/><br/>
                   
                    <!---------------------------------------------Fin Contenido------------------------------------------->                

                 </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
