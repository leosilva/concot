import concot.Categoria
import concot.Item

class BootStrap {

    def init = { servletContext ->
		/*
		 * inserindo um registro no banco de dados
		 */
		def categoria = new Categoria(nome: "Categoria 1")
		categoria.save(flush: true)
//		def categoria2 = new Categoria(nome: "Categoria 2")
//		categoria2.save(flush: true)
		/*
		 * Atualizando um registro
		 */
//		def cat = Categoria.findByNome("Categoria 1")
//		cat.nome = "Categoria 1 atualizada"
//		cat.save(flush:true)
		/*
		 * Apagando um registro
		 */
//		def cat = Categoria.findByNome("Categoria 1")
//		cat.delete(flush: true)
		/*
		 * Inserindo itens
		 */
		def item1 = new Item(nome: "Item 1")
		def item2 = new Item(nome: "Item 2")
		def cat = Categoria.findByNome("Categoria 1")
		cat.addToItens(item1)
		cat.addToItens(item2)
		cat.save(flush: true)
    }
    def destroy = {
    }
}
