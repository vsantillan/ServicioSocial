<%-- 
    Document   : menuPanelUsuario
    Created on : 5/06/2013, 10:50:33 AM
    Author     : roy
--%>
<%--Requiere de los siguientes archivos--->

<%-- Css --%>

<!--        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />-->

<%-- JavaScript --%>
<!--    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
        <script type="text/javascript" src="js/ddsmoothmenu.js"></script>
        <script type="text/javascript">

            ddsmoothmenu.init({
                mainmenuid: "smoothmenu1", //Menu DIV id
                orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
                classname: 'ddsmoothmenu', //class added to menu's outer DIV
                method: 'hover', // set to 'hover' (default) or 'toggle'
                arrowswap: true, // enable rollover effect on menu arrow images?
                //customtheme: ["#804000", "#482400"],
                contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
            })

        </script>-->

<div id="menu">
    <div class="jquerycssmenu">
        <div id="smoothmenu1" class="ddsmoothmenu" >
            <ul>
                <li><a href="index.do">Inicio</a></li>
                <li><a href="convocatorias.do">Convocatorias</a></li>
                <li><a href="manualProcedimiento.do">Manual de Procedimiento</a></li>
                <li><a href="organizaciones.do">Organizaciones</a>
                    <ul>
                        <li><a href="loginOrganizaciones.do">Login</a></li>
                        <li><a href="registroOrganizaciones.do">Registro</a></li>
                   </ul>
                </li>
                <li><a href="ayuda.do">Ayuda</a>
                    <ul>
                        <li><a href="ayuda.do">Ayuda</a></li>
                        <li><a href="acercaDe.do">Acerca De</a></li>
                        <li><a href="preguntasFrecuentes.do">Preguntas Frecuentes</a></li>
                   </ul>
                </li>
                <li><a href="login.do">Login</a></li>
                
            </ul>
        </div>  
        <br style="clear: left" />
    </div>
</div>
