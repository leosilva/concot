<html>
	<head>
		<meta name="layout" content="main">
		<asset:javascript src="exemploAjax.js"/>
	</head>
	<body>
		<g:select from="${categorias}" name="categoria" 
			optionKey="id"
			optionValue="nome" 
			noSelection="['': 'Selecione...']" />
		
		Itens:
		<div id="divItens">
		</div>
	</body>
</html>