<%-- 
    Document   : consultasBajas
    Created on : 4/06/2013, 09:48:33 AM
    Author     : mary
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <script type="text/javascript" src="js/script2PlaticaEliminar.js"></script>
       <title>Consultas y Bajas de Pláticas</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <center> <h2 id="h1p">Consultas y Bajas de Pláticas</h2></center>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' >
                        <thead>
                            <tr>
                                <th class="elimina">Eliminar</th>
                                <th >Fecha</th>
                                <th>Hora</th>
                                <th>Lugar</th>
                                <th>Periodo</th>
                                <th>Año</th>
                                <th>Descripción</th>
                                <th>Tipo</th>
                                <th>Asistentes</th>
                                <th>Fecha máxima formato unico</th>
                                <th style="visibility: hidden">ID</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <core:forEach items="${platica}" var="platica">
                                <tr>
                                    <td><a class="elimina" href="#"> <span class="glyphicon glyphicon-trash center-block" style="font-size:30px; margin-top:5%"></span></a></td>
                                    <td style="width: 100px"><div  contenteditable >${platica.fecha}</div></td>
                                    <td><div  contenteditable >${platica.hora}</div></td>
                                    <td style="width: 150px"><div  contenteditable >${platica.idLugar.lugar}</div></td>
                                    <td><div  contenteditable >${platica.periodo}</div></td>
                                    <td><div  contenteditable >${platica.anio}</div></td>
                                    <td style="width: 150px"><div  contenteditable >${platica.descripcion}</div></td>
                                    <td ><div  contenteditable >${platica.tipo}</div></td>
                                    <td ALIGN="RIGHT"><div  contenteditable >${platica.numeroAsistentes}</div></td>
                                    <td style="width: 150px"><div  contenteditable >${platica.fechaMxFui}</div></td>
                                    <td style="visibility: hidden">${platica.id}</td>              
                                </tr>
                            </core:forEach>
                        </tbody>
                    </table>
                </div><!--/row--> 
                <%@include file="../General/footer.jsp"%> 
            </div>
            <!---------------------------------------------Contenido-------------------------------------------> 
        </div> <!-- /container -->

        <%@include file="../General/js.jsp"%>
    </body>

</html>
