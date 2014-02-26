<%-- 
    Document   : administrarProyectos
    Created on : 4/06/2013, 02:17:29 PM
    Author     : roy
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>      
        <title>Administraci&oacute;n de Organizaciones
            <title>Administracion de Proyectos</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Validar Proyectos</h1></div>
                    <p>&nbsp;</p>
                    <div class="row">
                        <div class="alert alert-warning col-md-6  col-md-offset-3">
                            <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran los proyectos por validar.</h4></div>
                        </div>
                    </div>
                    <div id="div-validar-proyecto" style="display:none;">
                        <center>
                            <span class="glyphicon glyphicon-ok-circle sizeIconValid"></span>
                            <h2>Proyecto validado correctamente</h2>
                        </center>
                    </div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'  width='100%'>
                        <thead>
                            <tr>
                                <th>Acci&oacute;n</th>
                                <th>Ver proyecto</th>
                                <th>Nombre del proyecto</th>
                                <th>Organizaci&oacute;n</th>
                                <th>Numero de vacantes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${proyecto}" var="current">
                                <core:choose>
                                    <core:when test="${current.estatus==1}">
                                        <tr class='gradeX'>
                                            <td><a href="#" class="btn-validar-proyecto"><span class="editProy glyphicon glyphicon-ok sizeIcon" ide="${current.idProyecto}"></span></a><a href="#a" class="fancybox-effects-a mandaRetro" nombreProyecto="${current.nombre}" nombre="${current.idInstancia.nombre}" correo="${current.idInstancia.correo}" idO="${current.idProyecto}"><span class="glyphicon glyphicon-remove sizeIcon"></span></a></td>
                                            <td><a href="detalleProyecto.do?id=${current.idProyecto}" class="fancy"><span class="glyphicon glyphicon-search sizeIcon"></span></a></td>
                                            <td><core:out value="${current.nombre}" /></td>
                                            <td><core:out value="${current.idInstancia.nombre}" /></td>
                                            <td><core:out value="${current.vacantes}" /></td>                                      
                                        </tr>
                                    </core:when>
                                </core:choose>
                            </core:forEach>

                        </tbody>
                    </table>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <div id="a" style="display: none; font-size: 15px">
            <form:form commandName="borrarProyecto" id="MyForm" action="borrarProyecto.do" method="POST" onsubmit="return validarForm(this);">
                <h1>Envio de Retroalimentaci&oacute;n</h1>
                <h2>Motivos de Rechazo</h2>
                <table>
                    <tr>
                        <form:input hidden="hidden" type ="text"  id="idI" path="id" name="id" />                   
                        <form:input hidden="hidden" id="control" path="control" value="1" />
                        <td>Nombre del Proyecto:</td>
                        <td><form:input id="nombreProyecto" path="nombreProyecto" disabled="true"  /></td>
                    </tr>
                    <tr>
                        <td>Nombre de la Organizaci&oacute;n:</td>
                        <td><form:input id="nombre" path="nombreInstancia" disabled="true"  /></td>
                    </tr>
                    <tr>
                        <td>E-Mail:</td>
                        <td><form:input id="correo" path="email" disabled="true"  /></td>
                    </tr>
                    <tr>
                        <td>Descripci&oacute;n:</td>
                        <td><form:textarea rows="10" cols="70" id="descripcion" path="descripcion" maxlength="200" /></td>
                    </tr>
                    <tr>
                        <td>
                            <div class='error' style="display:none;">Error la descripcion esta vacia</div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Enviar Retroalimentaci&oacute;n" class="borrarProyecto" /></td>
                    </tr>
                </table>
            </form:form>
        </div>
        <%@include file="../General/js.jsp"%>
        <jsp:include page="../Template/headsModal.jsp" />
        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>
    </body>
</html>

