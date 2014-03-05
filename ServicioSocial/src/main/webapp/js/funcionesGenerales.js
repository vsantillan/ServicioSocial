/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function redirecciona(url) {
    window.location = url;
}
/**
 * funciones timepicker y datepicker
 */
$(document).ready(function() {
    $('#timepicker1').timepicker();
    var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
    var checkin = $('.dp3').datepicker({
        onRender: function(date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function(ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date);
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
        }
        checkin.hide();
    }).data('datepicker');
    $('.dp3').datepicker()
            .datepicker('setValue', new Date());
    $('.dp2').datepicker({});
});