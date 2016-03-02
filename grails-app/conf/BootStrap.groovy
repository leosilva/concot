import concot.Categoria
import concot.Item

class BootStrap {

    def init = { servletContext ->
		/*
		 * inserindo um registro no banco de dados
		 */
		def categoria = new Categoria(nome: "Categoria 1")
		categoria.save()
		def categoria2 = new Categoria(nome: "Categoria 2")
		categoria2.save(flush: true)
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
		cat.save()
		
		def item3 = new Item(nome: "Item 3")
		def item4 = new Item(nome: "Item 4")
		def cat2 = Categoria.findByNome("Categoria 2")
		cat2.addToItens(item3)
		cat2.addToItens(item4)
		cat2.save(flush: true)
    }
    def destroy = {
    }
}
