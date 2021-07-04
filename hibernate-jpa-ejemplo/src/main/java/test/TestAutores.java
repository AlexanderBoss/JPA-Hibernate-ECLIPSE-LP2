package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Autor;
import modelo.Libro;

public class TestAutores {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
 	public static void main(String[] args) {
		crearDatos();
		imprimirDatos();

	}
 	
 	
 	static void crearDatos() {
 		EntityManager em =emf.createEntityManager();
 		em.getTransaction().begin();
 		
 		Autor autor1 = new Autor(1L,"Pablo Perez","Español");
 	    Autor autor2 = new Autor(2L,"Elena Gomez","Mexicana");
 	    Autor autor3 = new Autor(3L,"Miguel Lopez","Chilena");
 	    em.persist(autor1);
 	    em.persist(autor2);
 	    em.persist(autor3);
 	    
 	    
 	    em.persist(new Libro(1L,"Programar en java es facil",autor2));
 	    em.persist(new Libro(2L,"Como vestirse con estilo",autor3));
 	   	em.persist(new Libro(3L,"Como cocinar sin quemar la cocina",autor1));
 	   	em.persist(new Libro(4L,"Programar en HTML es facil",autor2));
 	  	em.persist(new Libro(5L,"Programar en JavaScript no  es facil",autor2));
 		
 	  	
 	    em.getTransaction().commit();
 		em.close();
 		
 	}
 	
 	static void imprimirDatos() {
 		EntityManager em = emf.createEntityManager();
 		
 		Autor autor =em.find(Autor.class, 2L);
 		List<Libro> libros= autor.getLibros();
 		em.close();
 		
 		System.out.println(autor);
 		for(Libro libro : libros) {
 			System.out.println("* "+ libro.toString());
 		}
 		
 		
 				
 				
 		em.close();
 	}

}
