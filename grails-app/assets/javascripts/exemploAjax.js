/**
 * Arquivo contendo o exemplo de uma requisição Ajax.
 */

$(document).ready(function () {
	$('#categoria').on('change', function() {
		var element = $('#categoria');
		var dados = {'categoriaId': element.val()};
		$.ajax({
	        url: "/concot/categoria/recuperarItensPorCategoria",
	        type: "POST",
	        data : dados,
	        dataType: "JSON",
	        success: function(data) {
	        	var html = "<p>";
	        	$.each(data, function(index, value) {
	        		html += value.nome + "<br>";
	        	});
	        	console.log(data)
	        	html += "</p>"
        		console.log(html)
	        	$("#divItens").html(html);
	        },
	        error: function(data) {
	        	console.log("ocorreu algum erro durante a requisição.");
		    }
	    });
	});
});