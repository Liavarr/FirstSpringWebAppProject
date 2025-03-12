package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	// Establecemos Author como la base para que no se creen 2 columnas author book - book author, solo se hace ahora 1 merging table
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();
	
	
	// Constructors
	public Author() {
	}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Author(String firstName, String lastName, Set<Book> books) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	// Getter y Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	// Devuelve un valor numérico basado en el id para que las colecciones como HashMap puedan organizar y acceder a los objetos.
	@Override
	public int hashCode() {
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
		Author author = (Author) obj;
		return id != null ? Objects.equals(id, author.id) : author.id == null;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + "]";
	}
	
	
	
}
