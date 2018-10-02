$(document).ready(function(){
    $("#buscar").click(function(event) {

    	var busqueda = $("#busqueda").val();

    	$.getJSON("/consulta?busqueda="+busqueda, function(datos) {
    		
    		console.log(datos);
    		
    		var datosTweet = '';
    		
            $.each(datos.tweets, function (key, val) {
            	datosTweet += '<tr>';
            	datosTweet += "<td>" + val.textoAnalizar + "</td>";
            	datosTweet += "<td>" + val.score + "</td>";
            	datosTweet += "<td>" + val.magnitud + "</td>";
            	datosTweet += '</tr>';

            });
            $('#tablaT').append(datosTweet);

    	});
 
    });

});



