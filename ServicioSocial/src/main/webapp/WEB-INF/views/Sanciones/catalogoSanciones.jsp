<%-- 
    Document   : catalogoSanciones
    Created on : 10/06/2013, 11:36:57 AM
    Author     : ekt
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
  // Create an ArrayList with test data
  ArrayList list = new ArrayList();
  Map sancion1 = new HashMap();
  sancion1.put("noSancion", "1");
  sancion1.put("descripcion", "No llenaste correctamente tu nombre");
  sancion1.put("horas", new Integer(20));
  list.add(sancion1);
  Map sancion2 = new HashMap();
  sancion2.put("noSancion", "2");
  sancion2.put("descripcion", "Parpadeaste 5 veces cuando contestabas tu formato unico");
  sancion2.put("horas", new Integer(10));
  list.add(sancion2);
  pageContext.setAttribute("sanciones", list);
%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--CSS-->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" />         
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 
        
        <!--        Scripts para tablas-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript" >
            $(document).ready(function() {
                $('#example').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script>
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="http://www.ittoluca.edu.mx/version10/index.php" onmouseout="MM_swapImgRestore();" ><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Cat&aacute;logo de Sanciones</h1>
                <p>A continuaci&oacute;n se muestran las sanciones.</p>
                <h2 style="position: absolute; margin-left:50%; margin-top:-5%;"><a href="ingresaSancion.do">Nueva Sanci&oacute;n</a></h2>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>No. Sanci&oacute;n</th>
                            <th>Descripci&oacute;n</th>
                            <th>Horas</th>
                            <th>Editar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${sanciones}" var="current">
                        <tr class='gradeX'>
                            <th><core:out value="${current.noSancion}" /></th>
                            <th><core:out value="${current.descripcion}" /></th>
                            <th><core:out value="${current.horas}" /></th>
                            <th><a href="editaSancion.do" rel="shadowbox">Editar Valores</a></th>
                        </tr>
                      </core:forEach>
                    </tbody>
                </table>

                <%-- fin del contenido --%>
            </div>
            <div style="clear: both;"/>
        </div>
    </div>
    <div id="footer">
        <img  src="imagenes/foter.png"/>
    </div>

</body>
</html>