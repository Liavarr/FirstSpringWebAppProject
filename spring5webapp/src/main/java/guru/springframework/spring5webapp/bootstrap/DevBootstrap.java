package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

// Creamos una nueva clase que se encargará de meter datos, para esto creamos un método initData para poner la info, 
// lo correcto es esto, que esté aparte en un package como este, llamado en este caso bootstrap

// Tenemos que implementar Apllication Listener y pasarle ContextRefreshedEvent para que la aplicacion cuando arranque o se actualiza inicializa datos

// @Component convierte esta clase en un componente de Spring, esto implemente la inyeccion de dependencias, esto hace que Spring ejecute el constructor y le pase los valores automaticamente
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	// Importamos los repositorios creando 2 variables
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	// Creamos un constructor, para la injeccion de dependencias para administrar objetos, en este caso ya podremos guardar en nuestro JPA (hibernate) los datos, ya que sin esto
	// Simplemente creariamos los objetos sin guardarlos en ningun lado, por eso añadiremos despues de cada objeto .save
	// Si no creamos el constructor nunca se inicializaria los Repository. Ya que esto lo que hace es Wired con la clase, si solo hay un constructor no hace falta usar @autowired
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}
	
	
	// iniData es un naming convention
	private void initData() {
		// Pablo
		Author pablo = new Author("Pablo", "Sanchez");
		Book spm = new Book("Sic Parvis Magna", "1234");
		Publisher ivrea = new Publisher("Ivrea", "Patata Street");
		pablo.getBooks().add(spm);
		spm.getAuthors().add(pablo);
		spm.setPublisher(ivrea);
		
		// Guarda los datos en la bbdd de hibernate, sin el codigo de arriba que implementa los repositorios esto no funcionaria
		authorRepository.save(pablo);
		bookRepository.save(spm);
		publisherRepository.save(ivrea);
		
		// Aida
		Author aida = new Author("Aida", "HR");
		Book ayc = new Book("Arte y conceptos", "2222");
		Publisher panini = new Publisher("Panini", "Italian Avenue");
		aida.getBooks().add(ayc);
		ayc.getAuthors().add(aida);
		ayc.setPublisher(panini);
		
		// Guardamos
		authorRepository.save(aida);
		bookRepository.save(ayc);
		publisherRepository.save(panini);
		
	}

	
}
