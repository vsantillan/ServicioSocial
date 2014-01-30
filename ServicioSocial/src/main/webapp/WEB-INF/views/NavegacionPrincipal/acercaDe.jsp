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
                <%@include file="../General/menuPrincipal.jsp"%> 
                <div class="row ">
                    <!---------------------------------------------Contenido------------------------------------------->                
                    <div id="contenido">
                        <center>
                            <br/>
                            <h1>Acerca de</h1>

                            <div class="MyForm" style="width:60%">
                                <p>El Sistema de Servicio Social, est&aacute; encargado de realizar la gesti&oacute;n del proceso del servicio social, de acuerdo al manual de operaci&oacute;n que otorga la DGEST.</p>
                                <p>v1.0</p>
                            </div>
                            <br/><br/>
                            <div class="MyForm" style="width:60%">
                                <p>Este sistema fue desarrollado por estudiantes de la carrera de Ingenier&iacute;a en Sistemas Computacionales perteneciente al Instituto Tecnol&oacute;gico de Toluca.</p>

                                <ul>
                                    <li>Ing. Maricela Santiago Cayetano</li>
                                    <li>Ing. Omar Nava Pulido</li>
                                    <li>Ing. Rodrigo L&oacute;pez Rosales</li>
                                    <li>Ing. Esteban Ismael Regules P&eacute;rez</li>
                                    <li>Ing. Hector Morales Palma</li>
                                    <li>Ing. Martin Jonatan D&iacute;az Plata</li>
                                    <li>Ing. Jos&eacute; Manuel Nieto G&oacute;mez</li>
                                    <li>Ing. Jes&uacute;s Guzm&aacute;n Mondrag&oacute;n</li>                            
                                </ul>
                            </div>
                            <br/><br/><br/><br/><br/><br/><br/>

                        </center>
                        <!--<div style="clear:both;"></div>-->
                    </div>



                    <!---------------------------------------------Fin Contenido------------------------------------------->                

                </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
