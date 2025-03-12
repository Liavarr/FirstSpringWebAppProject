package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Book {
	


	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	private String publisher;
	
	// Con esto le decimos que haga merce con la tabla de Author generada directamente, solo se hace ahora 1 merging table
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
	inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();
	
	
	// Constructors
	public Book() {
	}

	public Book(String title, String isbn, String publisher) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	
	public Book(String title, String isbn, String publisher, Set<Author> authors) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}
	
	// Getter & Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	
	// Devuelve un valor numérico basado en el id para que las colecciones como HashMap puedan organizar y acceder a los objetos.
	@Override
	public int hashCode() {
		// Object.hash crea el identificador a partir del id
		return id != null ? Objects.hash(id) : 0;
	}
	
	// Compara dos objetos y devuelve true si son iguales (es decir, tienen el mismo id en este caso).
	// Java de base compara objetos por un valor numerico asociado, aqui sobreescribimos y comparamos solo por ID

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book book = (Book) obj;
		//Compara si el 
		return id != null ? Objects.equals(id, book.id) : book.id == null;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + ", authors="
				+ authors + "]";
	}
	
	
}
