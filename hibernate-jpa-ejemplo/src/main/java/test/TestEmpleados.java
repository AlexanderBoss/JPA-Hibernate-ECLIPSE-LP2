package test;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.makigas.hibernate.Empleado;
import modelo.Direccion;

public class TestEmpleados {
	
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");;
	
	
	public static void main(String[] args) {
		EntityManager manager = emf.createEntityManager();
		Empleado e = new Empleado(10L,"Papuico","Alexander",LocalDate.of(1996, Month.MAY, 4));
		e.setDireccion(new Direccion(15L,"CALLE FALSA","Sprinfield","Sprinfield","EEUU"));
		manager.getTransaction().begin();
		manager.persist(e);
		manager.getTransaction().commit();
		manager.close();
		
		imprimirTodo();
		
		
		/*
		 * Para poder reemplazar al empleado se emple el siguiente codigo
		 * 
		manager=emf.createEntityManager();
		manager.getTransaction().begin();
		e = manager.merge(e);
		e.setNombre("Daniel");
		manager.merge(e);
		manager.remove(e);
		manager.getTransaction().commit();
		manager.close();
		
		imprimirTodo();
		
		*/
	}


	private static void insertInicial() {
		EntityManager manager = emf.createEntityManager();
		Empleado e = new Empleado(10L,"Papuico","Alexander",LocalDate.of(1996, Month.MAY, 4));
		manager.getTransaction().begin();
		manager.persist(e);
		manager.getTransaction().commit();
		manager.close();
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo(){
		EntityManager manager = emf.createEntityManager();
		List<Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("Hay " + emps.size()+" empleados en el sistema.");
		for(Empleado emp :emps) {
			System.out.println(emp.toString());
		}
		manager.close();
	}

}
