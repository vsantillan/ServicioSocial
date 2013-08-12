<%-- 
    Document   : seleccionarPlatica
    Created on : 4/06/2013, 12:56:28 PM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <script>

            $(document).ready(function() {

                $('#formSelecciona').formly();
            });

        </script>
        <script language="javascript">
            function marcado() {
                var opcion = document.getElementById("aceptacionleer"); //acceso al botón

                //var platica=document.getElementById("fecha").html;
                var platica = $("#fecha option:selected").html();
                if (opcion.checked == true) { //botón seleccionado
                    //alert("Esta seguro de registrarse a la plática de inducción:\nFecha \t "+platica)
                    var statusConfirm = confirm("Está seguro de registrarse a la plática de inducción:\nFecha \t " + platica);
                    //  apprise('Está seguro de registrarse a la plática de inducción:\nFecha \t '+platica, {'verify':true, 'textYes':'Si!', 'textNo':'No'});
                    if (statusConfirm == true)
                    {
                        alert("A continuacion veras tu comprobante de registro");
                    }
                    else
                    {
                        // alert("Haces otra cos"); 
                        return false;
                    }
                }
                else {  //botón no seleccionado
                    alert("El formulario no ha podido enviarse. \n Debe aceptar haber leido el manual para poder enviar el formulario");
                    return false; //el formulario no se envia
                }

            }
        </script>
        <script src="js/actualizaPlatica.js"></script>
        <title>Selecciona Plática</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>
        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <center>

            <h1>Selecciona Plática</h1>

            <c:choose>


                <c:when test="${empty platicasPeriodo}">


                    <h1>No pláticas activas</h1>

                </c:when>

                <c:otherwise>

                    <table border="0">

                        <tr>
                            <td align="center">


                                <form:form action="folioPlatica.do" method="get"  id="formSelecciona" commandName="platica" onsubmit="return marcado();" name="seleccionaPlatica">

                                    <h1>Fechas Disponibles</h1>


                                    <form:select path="fecha" >

                                        <core:forEach items="${platicasPeriodo}" var="platicasPeriodo" >
                                            <form:option value="${platicasPeriodo.id}"><fmt:formatDate pattern="dd/MM/yyyy" value="${platicasPeriodo.fecha}" /></form:option>                                    
                                        </core:forEach>
                                    </form:select>
                                    <p></p>
<!--                                    <input type=text name="horat" id="hora" value="Hora:${platicasPeriodo.get(1).hora}   Lugar: ${platicasPeriodo.get(1).idLugar.lugar}  " readonly="readonly" style="background-color:#FFEBCD;border: 2px solid #CB8B07" size="48"><br>-->
                                    <textarea id="hora" rows="4" cols="50" disabled="true" style="background-color:#FFEBCD;border: 2px solid #CB8B07">Hora: ${platicasPeriodo.get(0).hora} Lugar: ${platicasPeriodo.get(0).idLugar.lugar}</textarea><br>
                                    <textarea  id="descripcion" rows="4" cols="50" disabled="true" style="background-color:#FFEBCD;border: 2px solid #CB8B07">Descripción:${platicasPeriodo.get(0).descripcion}</textarea><br>
<!--                                    <input type=text name="descripcion" id="descripcion" value="Descripción:${platicasPeriodo.get(0).descripcion}  " readonly="readonly" style="background-color:#FFEBCD;border: 2px solid #CB8B07" size="48"><br>-->
                                    <input type="checkbox" name="aceptacionleer" value="aceptacionleer" id="aceptacionleer"> Acépto haber leído el manual donde se describe el uso del<br>
                                    sistema via web sobre como dar de alta mi servicio social<p></p>
                                    <input type="submit" value="Generar Folio" /> <br>

                                </form:form>
                            </td>
                        </tr>
                        </tbody>
                    </table> 

                </c:otherwise>
            </c:choose>

            <div style="clear:both;"></div>
            </center>
        </div>

        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
        <script language=JavaScript>
            var mm = new Date();
            var m2 = mm.getMonth() + 1;
            var mesok = (m2 < 10) ? '0' + m2 : m2;
            var mesok = new Array(12);
            mesok[0] = "ENE-JUN";
            mesok[1] = "ENE-JUN";
            mesok[2] = "ENE-JUN";
            mesok[3] = "ENE-JUN";
            mesok[4] = "ENE-JUN";
            mesok[5] = "ENE-JUN";
            mesok[6] = "Julio";
            mesok[7] = "AGO-DIC";
            mesok[8] = "AGO-DIC";
            mesok[9] = "AGO-DIC";
            mesok[10] = "AGO-DIC";
            mesok[11] = "AGO-DIC";
            var mes = mesok[mm.getMonth()];

            //  document.algunNombre.texto.value = "\t\tPERIODO\t" + mes + "\t" + mm.getFullYear();
            //document.periodoActual.texto2.value = mm.getFullYear();
        </script>
    </body>

</html>
