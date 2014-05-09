<%-- 
    Document   : documentosFinalesAlumno
    Created on : 1/11/2013, 10:19:14 AM
    Author     : ekt
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>
                <%@include file="../General/menuUsuario.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp; Documentos Finales</h1></div>
                    <p>&nbsp;</p>
                    <div class="row">
                        <div class="alert alert-warning col-md-9 col-md-offset-1">
                            <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;Tus documentos debe de tener un formato <code>pdf</code> para que pueda ser validado por el administrador.</h4></div>
                        </div>
                    </div>
                    <div class="panel panel-primary">
                        <div class="panel panel-heading">Seleccione sus documentos</div>
                        <div class="panel panel-body">
                            ${error}
                            <core:choose>
                                <core:when test="${planAlumno=='S'}">
                                    <form method="post" id="frmSubirCartaMotivos" action="guardarDocumentosFinales.do"  enctype="multipart/form-data">
                                        <table class='table table-striped table-bordered example'>
                                            <tr>
                                                <th>No. de Control</th>
                                                <td>
                                                    <input name ="no_control" id="no_control" value="${no_control}" readonly="true" class="form-control"/>
                                                    <form:hidden  name ="no_control" path="no_control" value="${no_control}" size="20"/>
                                                </td>
                                            </tr>
                                            ${muestraRF}
                                            ${error_fr}
                                            ${muestraCP}
                                            ${error_cp}
                                            ${muestraFUF}
                                            ${error_fuf}
                                            ${muestraRE}
                                            ${error_fe}
                                            <tr>
                                                <td></td>
                                                <td><input type='submit' class="btn btn-primary" value='Subir Archivos' /></td>
                                            </tr>
                                        </table>
                                    </form>
                                </core:when>
                                <core:when test="${planAlumno=='N'}">
                                    <form method="post" id="frmSubirCartaMotivos" action="guardarDocumentosFinalesAux.do"  enctype="multipart/form-data">
                                        <table class='table table-striped table-bordered example'>
                                            <tr>
                                                <th>No. de Control</th>
                                                <td>
                                                    <input name ="no_control" id="no_control" value="${no_control}" readonly="true"/>
                                                </td>
                                            </tr>
                                            ${muestraRF}
                                            ${error_fr}
                                            ${muestraCP}
                                            ${error_cp}
                                            ${muestraFUF}
                                            ${error_fuf}
                                            <tr>
                                                <td></td>
                                                <td><input type='submit' class="btn btn-primary" value='Subir Archivos' /></td>
                                            </tr>
                                        </table>
                                    </form>
                                </core:when>
                            </core:choose>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%>
            </div>
        </div>
    </body>
</html>
