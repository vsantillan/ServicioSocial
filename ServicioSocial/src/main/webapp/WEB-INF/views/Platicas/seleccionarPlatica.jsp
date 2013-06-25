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
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
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
                <table border="0">

                    <tr>
                        <td align="center">


                            <%--  <input type="text" id="Caja" value="Hola"></input>
    <button onclick=<%String x="document.write(document.getElementById('texto').value)";out.print(x);%>>Pasar valor</button>  --%>

                            <form:form action="folioPlatica.do" method="get"  id="MyForm">

                                <h1>Fechas Disponibles</h1>


                                <select name="fechas" id="fechas" onchange=""> 



                                    <%--   <%
                              Platica instancia=new Platica();
                              ArrayList<Platica> lista=instancia.ConsultarPlaticasSemestre(usuario, password);
                              String hora="";
                              String lugar="En:";
                                for (int i=0;i<lista.size();i++){
                                    int id=lista.get(i).getId_platica();
                                    String fecha=lista.get(i).getFecha();
                                   
                               
                              
                                    %>
                                    --%>
                                    <option value="0">1
                                        <%--   <%}
                                       if(lista.size()!=0){
                                      hora=lista.get(0).getHora();
                                      lugar+=lista.get(0).getLugar();}
                                       %> --%>
                                    </option>
                                </select><br>
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
