package guru.springframework.spring5webapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

// Controller hace que esto sea un Spring Bean, por lo que auto creará el objeto automaticamente
@Controller
public class BookController {
	
	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// Linkeamos que si entramos a /books se obtiene esta info, ejemplo http://localhost:8080/books
	@RequestMapping("/books")
	// Model es un objeto que Spring usa para pasar datos a la vista Thymeleaf
	public String getBooks(Model model) {

		//  Añade al modelo bajo el nombre "books", para que la vista pueda acceder a ellos. Recuerda que aqui se 
		// autoinyecta bookRepository gracias a @Controller, y el bookrepository contiene el CRUD del objeto.
		model.addAttribute("books", bookRepository.findAll());
		
		// Devuelve el nombre de la vista books.html Spring buscará una plantilla con ese nombre en src/main/resources/templates/books.html (si usas Thymeleaf).
		return "books";
	}

}
