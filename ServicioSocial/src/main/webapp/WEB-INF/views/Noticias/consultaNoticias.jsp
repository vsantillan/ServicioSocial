

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Administraci&oacute;n de Noticias</title>
    </head>
    <body class="background">

        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">

                    <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-list"></span>Listado de Noticias</h2></div>
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
                                        <a href="#"><span ide="${noticia.id}" class="glyphicon glyphicon-trash sizeIcon eliminarNoticia"></span></a>
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
            <script type="text/javascript" language="javascript" src="js/noticias.js"></script>
        </div>
        
    </body>
</html>
