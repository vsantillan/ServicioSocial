
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />       
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsModal.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>
        
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
        <title>Administraci&oacute;n de Noticias</title>
    </head>
    <body class="background" onmousedown="elemento(event);">
        <jsp:include page="../Template/banner.jsp" />

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                
                <h1>Listado Noticias</h1>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Acci&oacute;n</th>
                            <th>Fecha Creación</th> 
                            <th>Noticia</th>
                            <th>Título Noticia  </th>                                          
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${Noticias}" var="noticia">                                   
                                    <tr class='gradeX'>
                                    <td>
                                        <a href="#"> <img class="aceptar"  title="Aceptar" width="30" height="30"   src="imagenes/paloma.png" /></a>
                                        <a href="editarNoticia-${noticia.id}.do"> <img class="correccion"  title="Corrección" width="30" height="30" src="imagenes/editar.png" /></a>
                                        <a href="#"> <img class="rechazar"  title="Rechazar" width="30" height="30"   src="imagenes/tache.png" /></a>
                                        
                                    </td>
                                    <td>${noticia.fecha}</td>
                                    <td>
                                    <c:choose>
                                        <c:when test="${noticia.tipoServicio == 1}">
                                            Página Principal
                                        </c:when>
                                        <c:when test="${noticia.tipoServicio == 2}">
                                            Alumnos                                        </c:when>
                                        <c:when test="${noticia.tipoServicio == 3}">
                                            Organizaciones
                                        </c:when>
                                        <c:otherwise>
                                           Desconocido
                                        </c:otherwise>
                                    </c:choose>
                                    </td>
                                    <td>${noticia.titulo}</td>
                                    
                                    
                                    </tr>
                                </core:forEach>
                    </tbody>
                </table>
            </div>
            <div style="clear: both;"/>
        </div>
    </div>
    <jsp:include page="../Template/footer.jsp" />
</body>
</html>
