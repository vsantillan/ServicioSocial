$(document).ready(function() {
    var noticias = $("#noticias").find("div").length;
    $(".noticiasBadge").text(noticias);
    var observaciones = $("#observaciones").find("div").length;
    $(".observacionesBadge").text(observaciones);
    var sanciones = $("#sanciones").find("div").length;
    $(".sancionesBadge").text(sanciones);
});
