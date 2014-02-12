

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>
        <%@include file="../General/head.jsp"%>
        <title>Administraci&oacute;n de Noticias</title>
    </head>
    <body class="background" onmousedown="elemento(event);">

        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">

                    <center> <h2 id="h1p">Listado de Noticias</h2></center>
                    <table  cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="example">
                        <thead>
                            <tr>
                                <th>Acci&oacute;n</th>
                                <th>Fecha Creación</th> 
                                <th>Tipo de Noticia</th>
                                <th>Título Noticia  </th>                                          
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${Noticias}" var="noticia">                                   
                                <tr class='gradeX'>
                                    <td>
                                        <a href="editarNoticia-${noticia.id}.do"><span class="glyphicon glyphicon-edit sizeIcon"></span></a>
                                        <a href="#"> <img class="rechazar"  title="Rechazar" /><span class="glyphicon glyphicon-trash sizeIcon"></span></a>
                                    </td>
                                    <td>${noticia.fecha}</td>
                                    <td>
                            <core:choose>
                                <core:when test="${noticia.tipoServicio == 1}">
                                    Página Principal
                                </core:when>
                                <core:when test="${noticia.tipoServicio == 2}">
                                    Alumnos                                        
                                </core:when>
                                <core:when test="${noticia.tipoServicio == 3}">
                                    Organizaciones
                                </core:when>
                                <core:otherwise>
                                    Desconocido
                                </core:otherwise>
                            </core:choose>
                            </td>
                            <td>${noticia.titulo}</td>
                            </tr>
                        </core:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
            <%@include file="../General/js.jsp"%>
        </div>
        
    </body>
</html>
