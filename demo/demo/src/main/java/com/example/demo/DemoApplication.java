package com.example.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class DemoApplication {

	public static void main(String[] args) {

		//Carga la configuración de Hibernate desde el archivo "hibernate.cfg.xml", lee el archivo
		//y carga todas las propiedades: conexión, dialecto, mapeos, etc
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		try (//Abrir una nueva sesión
		Session session = sessionFactory.openSession()) {
			//Iniciar transacción
			session.beginTransaction();

			//Crear un nuevo cliente
			Customer cliente1 = new Customer("Martin", "Fernandez");

			//Crear un producto
			Producto p1 = new Producto("Teclado");
			
			//Almacenar el cliente en la base de datos
			session.persist(cliente1);
			session.persist(p1);

			//Confirmar y cerrar
			session.getTransaction().commit();
			session.close();
		} catch (Exception e){
			System.out.println("Error");
		}
		
		System.out.println("Se ha creado el cliente");



	}

}
