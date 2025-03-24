package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.model.Publisher;
// Esta interfaz se encarga de implementar CRUD para el objeto que le pases
public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
