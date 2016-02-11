package concot



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CategoriaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Categoria.list(params), model:[categoriaInstanceCount: Categoria.count()]
    }

    def show(Categoria categoriaInstance) {
        respond categoriaInstance
    }

    def create() {
        respond new Categoria(params)
    }

    @Transactional
    def save(Categoria categoriaInstance) {
        if (categoriaInstance == null) {
            notFound()
            return
        }

        if (categoriaInstance.hasErrors()) {
            respond categoriaInstance.errors, view:'create'
            return
        }

        categoriaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoria.label', default: 'Categoria'), categoriaInstance.id])
                redirect categoriaInstance
            }
            '*' { respond categoriaInstance, [status: CREATED] }
        }
    }

    def edit(Categoria categoriaInstance) {
        respond categoriaInstance
    }
	
	/**
	 * Exemplo de action de busca por filtro. Esse filtro é passado por um parâmetro via GET (pode ser POST também, a forma de
	 * obte-lo é a mesma). Essa action pode ser chamada, por exemplo, pela URL http://localhost:8080/concot/categoria/buscarCategoriasPorNome?filtro=Cat 
	 * @return
	 */
	def buscarCategoriasPorNome() {
		// através do mapa 'params' o parâmetro do request é recuperado e atribuído a uma variável.
		def nome = params.filtro
		/* é renderizada a view 'listaCategoriasSimplificada' e um mapa é enviado pelo response. Nesse mapa existe uma única variável, 'categorias', que contém
		 * uma lista de categorias filtradas pelo nome.
		 */
		render view: "listaCategoriasSimplificada", model : [categorias : Categoria.findAllByNomeLike("%${nome}%")]
	}
	
	/**
	 * Exemplo de action de busca. Essa action pode ser chamada, por exemplo, pela URL http://localhost:8080/concot/categoria/listarTodasCategorias
	 * @return
	 */
	def listarTodasCategorias() {
		/* é renderizada a view 'listaCategoriasSimplificada' e um mapa é enviado pelo response. Nesse mapa existe uma única variável, 'categorias', que contém
		 * uma lista de todas as categoria.
		 */
		render view: "listaCategoriasSimplificada", model : [categorias : Categoria.list()]
	}

    @Transactional
    def update(Categoria categoriaInstance) {
        if (categoriaInstance == null) {
            notFound()
            return
        }

        if (categoriaInstance.hasErrors()) {
            respond categoriaInstance.errors, view:'edit'
            return
        }

        categoriaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Categoria.label', default: 'Categoria'), categoriaInstance.id])
                redirect categoriaInstance
            }
            '*'{ respond categoriaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Categoria categoriaInstance) {

        if (categoriaInstance == null) {
            notFound()
            return
        }

        categoriaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Categoria.label', default: 'Categoria'), categoriaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoria.label', default: 'Categoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
