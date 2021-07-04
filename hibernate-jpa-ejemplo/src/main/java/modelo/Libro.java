package modelo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.query.FetchClauseType;

@Entity
@Table(name="LIBRO")
public class Libro {
	
	@Id
	@Column(name="LIBRO_ID")
	private Long id;
	
	@Column(name="TITULO")
	private String titulo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AUTOR_ID")
	private Autor autor;

	public Libro() {
		
	}

	public Libro(Long id, String titulo, Autor autor) {
		
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(id, other.id)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + "]";
	}
	
	
	
	
	
	
}
