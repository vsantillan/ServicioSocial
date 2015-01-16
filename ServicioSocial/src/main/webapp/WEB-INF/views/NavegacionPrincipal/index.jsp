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
                <%@include file="../General/menuPrincipal.jsp"%> 
            </div><!--/row-->
            <div class="row col-md-12" id="noticiasPanelIndex">
                <br/>
                <!---------------------------------------------Contenido------------------------------------------->                

                <core:forEach items="${Noticias}" var="noticia">

                    <div class="col-md-6 col-md-offset-0">
                        <ul class="event-list">
                            <li>

                                <time datetime="2014-07-20">
                                    <span id="dayId" class="day"><fmt:formatDate pattern="dd" value="${noticia.fecha}"/></span>
<!--                                    <span id="monthId" class="month"></span>-->
                                    <script type="text/javascript">
                                        var mes = <fmt:formatDate pattern="MM" value="${noticia.fecha}"/>
                                        
                                        if (mes === 1) {
                                        
                                           document.write("<span class='month'>ENE</span>");  
                                        }
                                        if (mes === 2) {
                                            
                                           document.write("<span class='month'>FEB</span>");  
                                        }
                                        if (mes === 3) {
                                            
                                           document.write("<span class='month'>MAR</span>");  
                                        }
                                        if (mes === 4) {
                                            
                                           document.write("<span class='month'>ABR</span>");  
                                        }
                                        if (mes === 5) {
                                           
                                           document.write("<span class='month'>MAY</span>");  
                                        }
                                        if (mes === 6) {
                                           
                                           document.write("<span class='month'>JUN</span>");  
                                        }
                                        if (mes === 7) {
                                           
                                           document.write("<span class='month'>JUN</span>");  
                                        }
                                        if (mes === 8) {
                                           
                                           document.write("<span class='month'>JUL</span>");  
                                        }
                                        if (mes === 9) {
                                           
                                           document.write("<span class='month'>AGO</span>");  
                                        }
                                        if (mes === 10) {
                                           
                                           document.write("<span class='month'>SEP</span>");  
                                        }
                                        if (mes === 11) {
                                           
                                           document.write("<span class='month'>NOV</span>");  
                                        }
                                        if (mes === 12) {
                                           
                                           document.write("<span class='month'>DIC</span>");  
                                        }
                                        
                                    </script>
                                    <span class="year"><fmt:formatDate pattern="yyyy" value="${noticia.fecha}"/></span>
                                    <span class="time">ALL DAY</span>
                                </time>

                                <div class="info">
                                    <div class="col-md-10">
                                        <h4 class="title">${noticia.titulo}</h4>
                                        <p class="desc">${fn:substring(noticia.detalle, 0, 150)}<b><core:if test="${fn:length(noticia.detalle) > 150}">...&nbsp;</core:if></b></p>
                                        </div>
                                        <div class="col-md-2">
                                            <a class="mustraNoticiaCompleta btn btn-warning btn-xs"  idNoticia="${noticia.id}" data-toggle="modal" data-target="#detalle" role="button">Leer M&aacutes.</a>
                                        </div>
                                    </div>
                                        
                                </li>                            
                            </ul>
                        </div>

                </core:forEach>
                <!---------------------------------------------Fin Contenido------------------------------------------->                

            </div><!--/row--> 
            <div class="modal fade" id="detalle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="titulo"></h4>
                        </div>
                        <div class="modal-body" id="detalleNoticia">

                        </div>
                        <div class="modal-footer">
                            <p>Instituto Tecnológico de Toluca</p>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../General/footer.jsp"%>  
        </div>
        <%@include file="../General/js.jsp"%>         
    </div> <!-- /container -->

</body>
</html>