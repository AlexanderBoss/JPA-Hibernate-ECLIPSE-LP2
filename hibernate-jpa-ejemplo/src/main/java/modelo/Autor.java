package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.query.FetchClauseType;

@Entity
@Table(name="AUTORES")
public class Autor {
	
	@Id
	@Column(name="AUTOR_ID")
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="Nacionalidad")
	private String nacionalidad;

	@OneToMany(mappedBy = "autor",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Libro> libros = new ArrayList<>();
	public Autor() {
		
	}

	public Autor(Long id, String nombre, String nacionalidad) {
		
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public List<Libro> getLibros() {
		return libros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, libros, nacionalidad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id) && Objects.equals(libros, other.libros)
				&& Objects.equals(nacionalidad, other.nacionalidad) && Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}
}
