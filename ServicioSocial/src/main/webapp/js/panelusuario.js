$(document).ready(function() {
    var observaciones = $("#noticias").find("div").length;
    $(".noticiasBadge").text(observaciones);
    var observaciones = $("#observaciones").find("div").length;
    $(".observacionesBadge").text(observaciones);
    var observaciones = $("#sanciones").find("div").length;
    $(".sancionesBadge").text(observaciones);

});
