<%-- 
    Document   : perfilOrganizaciones
    Created on : Aug 18, 2014, 4:00:16 PM
    Author     : root
--%>


<%@include file="../General/jstl.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../General/head.jsp"%>
        <title>Perfil de Organizaci&oacute;n</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>
                <%@include file="../General/menuOrganizacion.jsp"%>
                <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

                <div class="container">
                    <div class="row well"><br>
                        <div class="col-md-12"> <!-- modified --> 
                            <div class="panel">
                                <div class="name"><b>Perfil</b> <%=nombre%> ${instancia.rfc}</div>
                                <!--<a href="#" class="btn btn-xs btn-primary pull-right" style="margin:10px;"><span class="glyphicon glyphicon-picture"></span> Change cover</a>-->
                            </div>
                            <script type="text/javascript">
                                $(function() {
                                    $('#myTab a:last').tab('show');
                                });
                            </script>
                            <div class="container col-md-12"> <!-- general -->
                                <div class="panel col-md-9"> <!-- datos -->
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class=" col-md-9 col-lg-9 "> 
                                                <table class="table table-responsive table-user-information">
                                                    <tbody>
                                                        <tr>
                                                            <td>RFC:</td>
                                                            <td>Programming</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Titular:</td>
                                                            <td>Programming</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Puesto:</td>
                                                            <td>06/23/2013</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Telefono:</td>
                                                            <td>01/24/1988</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Extension:</td>
                                                            <td>Male</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Email</td>
                                                            <td><a href="mailto:info@support.com">info@support.com</a></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Tipo de Instancia:</td>
                                                            <td>Metro Manila,Philippines</td>
                                                        </tr>
                                                    <td>Phone Number</td>
                                                    <td>123-4567-890(Landline)<br><br>555-4567-890(Mobile)
                                                    </td>

                                                    </tr>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel-tec col-md-9">
                                        <!--<a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>-->
                                        <span class="pull-right">
                                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i> Editar</a>
                                        </span>
                                    </div>
                                    <br><br>
                                </div>

                                <br><br><br>
                                <div class="col-md-12">
                                    <ul class="nav nav-tabs" id="myTab">
                                        <li class="active"><a href="#inbox" data-toggle="tab"><i class="fa fa-envelope-o"></i> Inbox</a></li>
                                        <li><a href="#sent" data-toggle="tab"><i class="fa fa-reply-all"></i> Sent</a></li>
                                        <li><a href="#assignment" data-toggle="tab"><i class="fa fa-file-text-o"></i> Assignment</a></li>
                                        <li><a href="#event" data-toggle="tab"><i class="fa fa-clock-o"></i> Event</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div class="tab-pane active" id="inbox">
                                            <a type="button" data-toggle="collapse" data-target="#a1">
                                                <div class="btn-toolbar well well-sm" role="toolbar"  style="margin:0px;">
                                                    <div class="btn-group"><input type="checkbox"></div>
                                                    <div class="btn-group col-md-3">Admin Kumar</div>
                                                    <div class="btn-group col-md-8"><b>Hi Check this new Bootstrap plugin</b> <div class="pull-right"><i class="glyphicon glyphicon-time"></i> 12:10 PM <button class="btn btn-primary btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg"><i class="fa fa-share-square-o"> Reply</i></button></div> </div>
                                                </div>
                                            </a>
                                            <div id="a1" class="collapse out well">This is the message body1</div>
                                            <br>
                                            <button class="btn btn-primary btn-xs"><i class="fa fa-check-square-o"></i> Delete Checked Item's</button>
                                        </div>

                                        <div class="tab-pane" id="sent">
                                            <a type="button" data-toggle="collapse" data-target="#s1">
                                                <div class="btn-toolbar well well-sm" role="toolbar"  style="margin:0px;">
                                                    <div class="btn-group"><input type="checkbox"></div>
                                                    <div class="btn-group col-md-3">Kumar</div>
                                                    <div class="btn-group col-md-8"><b>This is reply from Bootstrap plugin</b> <div class="pull-right"><i class="glyphicon glyphicon-time"></i> 12:30 AM</div> </div>
                                                </div>
                                            </a>
                                            <div id="s1" class="collapse out well">This is the message body1</div>
                                            <br>
                                            <button class="btn btn-primary btn-xs"><i class="fa fa-check-square-o"></i> Delete Checked Item's</button>
                                        </div>

                                        <div class="tab-pane" id="assignment">
                                            <a href=""><div class="well well-sm" style="margin:0px;">Open GL Assignments <span class="pull-right"><i class="glyphicon glyphicon-time"></i> 12:20 AM 20 Dec 2014 </span></div></a>        
                                        </div>

                                        <div class="tab-pane" id="event">
                                            <div class="media">
                                                <a class="pull-left" href="#">
                                                    <img class="media-object img-thumbnail" width="100" src="http://cfi-sinergia.epfl.ch/files/content/sites/cfi-sinergia/files/WORKSHOPS/Workshop1.jpg" alt="...">
                                                </a>
                                                <div class="media-body">
                                                    <h4 class="media-heading">Animation Workshop</h4>
                                                    2Days animation workshop to be conducted
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>




                    <!--                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content"><br/><br/>
                                                <form class="form-horizontal">
                                                    <fieldset>
                                                         Text input
                                                        <div class="form-group">
                                                            <label class="col-md-2 control-label" for="body">Body :</label>  
                                                            <div class="col-md-8">
                                                                <input id="body" name="body" type="text" placeholder="Message Body" class="form-control input-md">
                    
                                                            </div>
                                                        </div>
                    
                                                         Textarea 
                                                        <div class="form-group">
                                                            <label class="col-md-2 control-label" for="message">Message :</label>
                                                            <div class="col-md-8">                     
                                                                <textarea class="form-control" id="message" name="message"></textarea>
                                                            </div>
                                                        </div>
                    
                                                         Button 
                                                        <div class="form-group">
                                                            <label class="col-md-2 control-label" for="send"></label>
                                                            <div class="col-md-8">
                                                                <button id="send" name="send" class="btn btn-primary">Send</button>
                                                            </div>
                                                        </div>
                    
                                                    </fieldset>
                                                </form>
                    
                                            </div>
                                        </div>
                                        
                                    </div>-->
                    <div class="col-md-12">
                        <%@include file="../General/footer.jsp"%> 
                    </div>
                </div>
            </div>
            <%@include file="../General/js.jsp"%>
            <script src="js/jquery.codigos.postales.js"></script>       
            <script src="js/jquery.manolo.js"></script>
    </body>
</html>
