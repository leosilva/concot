package concot

class Categoria {

	String nome

    static constraints = {
    	nome(nullable: false, blank: false, 
    		maxSize: 100, unique:true)
    }
}