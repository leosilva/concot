package concot

class Categoria {

	String nome

	static hasMany = [itens : Item]
	
    static constraints = {
    	nome(nullable: false, blank: false, 
    		maxSize: 100, unique:true)
    }
	
	public String toString() {
		nome
	}
	
}