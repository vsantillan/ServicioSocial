<%-- 
    Document   : demoAdministrador
    Created on : 07-jun-2013, 10:56:10
    Author     : bustedvillain
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <style type="text/css">
            .bs-example{margin: 20px;}
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h3 class="modal-title titulos-naranja">Motivos de Rechazo del Formato Único</h3>
                <div class="list-group">
                    <core:forEach items="${listadoObservaciones}" var="observacion">
                        <a href="#" class="list-group-item">
                            <div class="checkbox">
                                <label>
                                <h4 class="list-group-item-heading">${observacion.catalogoObservacionId.detalle}</h4>
                                </label>
                            </div>
                        </a>
                    </core:forEach>
                </div>
            </div>
        </div>
    </body>
</html>


        