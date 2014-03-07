<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%--<%@include file="../General/banner.jsp"%>--%>  
                <%--<%@include file="../General/menuAdministrador.jsp"%>--%> 
                <div class="row col-md-12 center-block">

            <center><h2>${titulo}</h2></center>

            <br />
            <h4><b>Nombre: </b>${nombre}</h4>
            <h4><b>No. Control: </b>${noControl}</h4>
            <div style ="background: #B5EBF6;  border-radius:30px; border: 2px; padding: 5px;border-color: #862E26; padding-left: 30px;">
                <form>
                    <input id="idDatosPersonales" type="hidden" value="${datosPersonalesId.id}" />
                    <h3>Nueva sanci&oacute;n</h3>
                    <b>Sancion:</b>
                    <select id="idSancion" id="comboSancion">
                        <core:forEach items="${catalogoSanciones}" var="current">
                            <option  value="${current.id}"><core:out value="${current.detalle}" /></option>
                        </core:forEach>
                    </select>
                    <b>Horas:</b>
                    <input id="horas" type="number" value ="0"/>
                    <input type="button" onclick="nuevaSancion('${tipo}');" value="Asignar"/>
                </form>
            </div>

            <br/>
            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'  width='100%'>
                <thead>
                    <tr>
                        <th>Acciones</th>
                        <th>Fecha</th>
                        <th>Horas</th>
                        <th>Descripci&oacute;n</th>
                    </tr>
                </thead>
                <tbody>
                    <core:forEach items="${listaSanciones}" var="current">
                        <tr class='gradeX'>

                            <th><a href="#" onclick="quitaSancionAlumno(${current.id})"><i class="glyphicon glyphicon-remove"></i></a></th>
                            <th><core:out value="${current.fecha}" /></th>
                            <th><core:out value="${current.horasSancion}" /></th>
                            <th><core:out value="${current.catalogoSancionesId.detalle}" /></th>
                        </tr>
                    </core:forEach>
                </tbody>
            </table>

            <%-- fin del contenido --%>
        </div><!--/row--> 
                <%--<%@include file="../General/footer.jsp"%>--%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
