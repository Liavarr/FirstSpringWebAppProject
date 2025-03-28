package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	//Mapeamos a /authors
	@RequestMapping("/authors")
	//Le pasamos el modelo
	public String getAuthors (Model model) {
		// Añadimos al modelo los autores, asignando a authors
		model.addAttribute("authors", authorRepository.findAll());
		return "authors";
	}
	
}

