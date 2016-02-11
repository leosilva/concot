<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<!-- itera na variável 'categorias', que contém uma lista de categorias. A variável de cada iteração é 'cat' -->
		<g:each in="${categorias}" var="cat">
			<!-- imprime o nome da categoria em um parágrafo. -->
			<p>${cat.nome}</p>
		</g:each>
	</body>
</html>