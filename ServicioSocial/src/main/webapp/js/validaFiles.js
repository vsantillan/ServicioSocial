$(document).ready(listo);

///////////////////////////////////////////////////////////////////////
//Para la implementación de esta validación son necesarias 3 cosas:  //
//1.-El input 'file' debera de contener el id="archivo"              //
//2.-El boton o  input con el que se envia el formulario debera de   //
//ser type=button y contener el id="enviarArchivo"                  //
//3.-Finalmente la etiqueta <form> debera de contener el id="subirArchivo"      //
///////////////////////////////////////////////////////////////////////

function listo() {
    $(document).on("click", "#enviarArchivo", validaFile);
    $(document).on("click", "#subeFui", validaFileFormatoUnico);
}

function validaFile() {
    var OK = true;
    if ($("#archivo").val() === "")
    {
        $('.error').show("slow").delay(2500).hide("slow");
        $('.error').html("<p>Agregue un archivo porfavor</p>");
        OK = false;
    }
    if (OK) {
        var extension = ($("#archivo").val().substring($("#archivo").val().lastIndexOf("."))).toLowerCase();
        switch (extension) {
            case ".jpg":
            case ".jpeg":
            case ".png":
            case ".pdf":
                $("#subirArchivo").submit();
                break;
            default :
                $('.error').show("slow").delay(2500).hide("slow");
                $('.error').html("<p>Recuerde agregar un archivo con extensi\u00F3n: '.jpg' ,'.jpeg' ,'.png' ,'.pdf' , </p>");
                break;
        }
    }
}

function validaFileFormatoUnico(){
        var OK = true;
    if ($("#idfile").val() === "")
    {
        $('.error').show("slow").delay(2500).hide("slow");
        $('.error').html("<p>Agregue un archivo porfavor</p>");
        OK = false;
    }
    if (OK) {
        var extension = ($("#idfile").val().substring($("#idfile").val().lastIndexOf("."))).toLowerCase();
        switch (extension) {
            case ".jpg":
            case ".jpeg":
            case ".png":
            case ".pdf":
                $("#frmSubirFui").submit();
                break;
            default :
                $('.error').show("slow").delay(2500).hide("slow");
                $('.error').html("<p>Recuerde agregar un archivo con extensi\u00F3n: '.jpg' ,'.jpeg' ,'.png' ,'.pdf' , </p>");
                break;
        }
    }
}


