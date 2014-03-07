<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">

                <center><h2>Liberaciones Pendientes</h2></center>

                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'  width='100%'>
                    <thead>
                        <tr>
                            <td>Periodo</td>
                            <th>n. Control</th>
                            <th>Nombre</th>
                            

                        </tr>
                    </thead>
                    <tbody>
                        <tr class='gradeX'>
                            <td>Ene-Feb</td>
                            <td>09271024</td>
                            <td>Hector Guzman Nava</td>
                          
                        </tr>
                        <tr class='gradeX'>
                            <td>Ene-Feb</td>
                            <td>09271024</td>
                            <td>Hector Guzman Nava</td>
                            
                        </tr>
                        <tr class='gradeX'>
                            <td>Ene-Feb</td>
                            <td>09271024</td>
                            <td>Hector Guzman Nava</td>
                            
                        </tr>
                    </tbody>
                </table>


            </div>
            <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%-- fin del contenido --%>     
             
        <div class="modal-dialog" id="motivos" style="display: none;">
          <div class="modal-content">
            <div class="modal-header">
              <h3 class="modal-title titulos-naranja">Motivos de Rechazo del Formato Único</h3>
            </div>
            <form id="observacionesCat" action="#"  onsubmit="return  false;">
            <div class="modal-body">
              <div class="list-group">
              <core:forEach items="${listadoObservaciones}" var="observacion">
              <a href="#" class="list-group-item">
                  <div class="checkbox">
                      <label>
                      <input name="id[]" value="${observacion.id}" type="checkbox"/>
                      <h4 class="list-group-item-heading">${observacion.detalle}</h4>
                      </label>
                  </div>
              </a>
              </core:forEach>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal" onClick="$.fancybox.close();">Cancelar</button>
              <a href="javascript:void(0)" onclick="redirecciona('catalogoObservaciones.do');" class="btn btn-danger" role="button">Agregar Observación</a>
              <button id="guardarObservaciones" type="button" class="btn btn-primary">Guardar las observaciones de el Formato Único</button>
            </div>
            </form>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->

        
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" src="js/formatoUnicoAdmin.js"></script>
        <script type="text/javascript">
            $('#formatoUnico-tabla a:first').tab('show');
        </script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>