<%-- 
    Document   : lugaresPlatica
    Created on : 3/07/2013, 01:27:11 PM
    Author     : mary
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <script type="text/javascript" language="javascript" src="js/lugares.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de lugares</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <h1>Administrar Lugares</h1>
                    <p>A continuaci&oacute;n se muestran los lugares dados de alta en el sistema.</p>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'>
                        <thead>
                            <tr>
                                <th>Acci&oacute;n</th>
                                <th>Lugar</th>                                            
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${lugares}" var="current">
                                <tr class='gradeX'>
                                    <th><a href="#editarL" data-toggle="modal"><span class="glyphicon glyphicon-edit editLugar sizeIcon" ide="${current.id}" id="${current.lugar}" title="Editar Lugar"></span></a>
                                        <a href="#" class="btn-validar-org"><span class="glyphicon glyphicon-trash cambiaStatusLugar sizeIcon" ide="${current.id}"  title="Borrar Lugar"></span></a></th>
                                    <th><core:out value="${current.lugar}" /></th>
                                </tr>
                            </core:forEach>
                        </tbody>
                        ${errorBlanco}
                    </table>
                    <table>
                        <tr>
                            <td><a href="#nuevoL" role="button" data-toggle="modal" id="nuevoLB"><button class="btn btn-primary glyphicon glyphicon-plus" id="nuevoLB" title="Agregar Lugar" > Agregar Lugar</button></a></td>
                        </tr>
                    </table>
                    </br>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <div id="nuevoL" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <%-- Formulario Nueva lugar para platica de inducción --%>
                        <h1>Agregar un Lugar</h1>
                        <p>Escriba la descripcion del lugar.</p>
                    </div>
                    <div class="modal-body">
                        <form:form commandName="lugar_i" id="nuevoLugar" action="nuevoLugar.do" method="POST">
                            <table>
                                <tr>
                                    <td> <p><label for="lugar">Descripci&oacute;n:</label> </p></td>
                                    <td>  <form:input id="lugar" class="lugares" name="lugar" path="lugar" rows="8" cols="50"  onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                                </tr>
                                <tr> 
                                    <td> <input type ="submit" value = "Guardar " /> </td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                    <div class="modal-footer">Instituto Tecnologico de Toluca</div>
                </div>
        </div>
        <div id="editarL" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <%-- Formulario editar lugar para platica de inducción --%>
                        <h1>Editar un Lugar</h1>
                        <p>Escriba la descripcion del lugar.</p>
                    </div>
                    <div class="modal-body">
                        <form:form commandName="lugar_i" id="editarLugar" action="editarLugar.do" method="POST">
                            <table>
                                <form:input hidden="hidden" id="id" name="name" path="id" />
                                <tr>
                                    <td> <p><label for="lugar">Descripci&oacute;n:</label> </p></td>
                                    <td>  <form:input id="lugar_s" class="lugares"  name="lugar" path="lugar" rows="8" cols="50"  onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                                </tr>
                                <tr> 
                                    <td> <input id="envioB" type ="submit" value = "Guardar " /> </td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                    <div class="modal-footer">Instituto Tecnologico de Toluca</div>
                </div>
            </div>
            <%@include file="../General/js.jsp"%>
    </body>
</html>
