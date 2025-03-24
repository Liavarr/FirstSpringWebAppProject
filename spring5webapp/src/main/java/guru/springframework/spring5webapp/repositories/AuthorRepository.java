package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.model.Author;

// Creamos una interfaz extendiendo CRUDRepository que es el Crud por defecto que nos da hibernate, requiere un typo y un id, en este caso Author y Lonmg
public interface AuthorRepository extends CrudRepository<Author, Long>{
	
}
