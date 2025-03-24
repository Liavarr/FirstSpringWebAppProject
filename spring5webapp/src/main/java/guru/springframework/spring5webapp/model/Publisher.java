package guru.springframework.spring5webapp.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	
	/*@OneToOne
	@JoinColumn(name = "books_id")
	private Book book;*/
	
	

	public Publisher() {
	}
	
	public Publisher(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
//	public Book getBook() {
//		return book;
//	}
//
//	public void setBook(Book book) {
//		this.book = book;
//	}

	
	// El id lo genera aparte, para que se compare por id y no por el identificador de clase
	@Override
	public int hashCode() {
		// Object.hash crea el identificador a partir del id
		return id != null ? Objects.hash(id) : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher publisher = (Publisher) obj;
		return id != null ? Objects.equals(id, publisher.id) : publisher.id == null;
	}
	
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	
	
}
