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
        <title>Seleciona Plática</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>
        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <center> 
                <h1>Selecciona Plática</h1>

                <form name="algunNombre" action="" method="post">

                    <input type=text name="texto" id="texto" value="MES" readonly="readonly" style="background-color:#FFEBCD;border: 2px solid #CB8B07" size="48">
                    <br>

                </form>
                <core:forEach items="${platicasPeriodo}" var="platicasPeriodo" >
              
                ${platicasPeriodo.fecha} 
                ${platicasPeriodo.idLugar.lugar}  
                </core:forEach>
                
                
                <table border="0">

                    <tr>
                        <td align="center">


                            <%--  <input type="text" id="Caja" value="Hola"></input>
    <button onclick=<%String x="document.write(document.getElementById('texto').value)";out.print(x);%>>Pasar valor</button>  --%>

                            <form:form action="folioPlatica.do" method="post"  id="MyForm" commandName="platica" >

                                <h1>Fechas Disponibles</h1>


                                 <form:select path="fecha" >

                                        <core:forEach items="${platicasPeriodo}" var="platicasPeriodo" >
                                            <form:option value="${platicasPeriodo.id}">${platicasPeriodo.fecha}</form:option>
                                            <%--  <form:options items="${lugares}" itemValue="id" itemLabel="lugar" /> --%>
                                        </core:forEach>
                                    </form:select>
                                <br>
                                <input type=text name="hora" id="hora" value="Hora:" readonly="readonly" style="background-color:#FFEBCD;border: 2px solid #CB8B07" size="48"><br>
                                <input type="checkbox" name="aceptacionleer" value="aceptacionleer"> Acépto haber leído el manual donde se describe el uso del<br>
                                sistema via web sobre como dar de alta mi servicio social<br>
                                <input type="submit" value="Generar Folio" /> <br>

                            </form:form>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div style="clear:both;"></div>
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
//document.algunNombre.texto2.value=mm.getFullYear();

        </script>
    </body>

</html>
