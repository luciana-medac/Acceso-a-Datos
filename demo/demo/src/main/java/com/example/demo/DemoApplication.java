package com.example.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;

public class DemoApplication {

	public static void main(String[] args) {

		// Carga la configuración de Hibernate desde el archivo "hibernate.cfg.xml", lee
		// el archivo
		// y carga todas las propiedades: conexión, dialecto, mapeos, etc
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		try (
			
			// Abrir una nueva sesión
			Session session = sessionFactory.openSession()) {
			// Iniciar transacción
			session.beginTransaction();
			Scanner sc = new Scanner(System.in);
			int opcion = 0;

			while (opcion != 7) {

				System.out.println("============ MENÚ ================");
				System.out.println("1. Crear cliente");
				System.out.println("2. Crear producto");
				System.out.println("3. Crear pedido");
				System.out.println("4. Actualizar precio de un producto");
				System.out.println("5. Borrar pedido");
				System.out.println("6. Listar pedidos de un cliente");
				System.out.println("7. Salir");
				System.out.println("Elige una opción: ");
				opcion = Integer.parseInt(sc.nextLine());

				switch (opcion) {
					case 1:
						// Aquí se crea el cliente
						System.out.println("Introduce el nombre del cliente: ");
						String nombre = sc.nextLine();

						System.out.println("Introduce el apellido del cliente: ");
						String apellido = sc.nextLine();
						
						Customer c1 = new Customer(nombre, apellido);
						session.persist(c1);
						session.getTransaction().commit();
						session.close();

						System.out.println("Se ha añadido el liente correctamente");

						break;
					case 2:
						// Aquí se crea el producto
						System.out.println("Introduce el nombre del producto: ");
						String nProducto = sc.nextLine();

						System.out.println("Introduce el precio: ");
						double precio = Double.parseDouble(sc.nextLine());

						Producto p1 = new Producto(nProducto, precio);
						session.persist(p1);
						session.getTransaction().commit();
						session.close();

						System.out.println("Se ha añadido el producto correctamente");

						break;
					case 3:
						// Aquí se crea el pedido
						System.out.println("Introduce el id del cliente: ");
						int idc= Integer.parseInt(sc.nextLine());

						System.out.println("Introduce el id del Producto: ");
						int idp= Integer.parseInt(sc.nextLine());

						System.out.println("Introduce la cantidad: ");
						int can = Integer.parseInt(sc.nextLine());
						
						Customer c = session.get(Customer.class, idc);
						Producto p = session.get(Producto.class, idp);

						double importe = can * p.getPrecio();

						Pedido ped = new Pedido();

						ped.setCustomer(c);
						ped.setProduct(p);
						ped.setCantidad(can);
						ped.setImporte(importe);
						ped.setFecha(new Date());

						session.persist(ped);
						session.getTransaction().commit();
						session.close();
						
						System.out.println("Se ha añadido el pedido correctamente");
						break;

					case 4:
						// Aquí se actualiza el precio del producto
					
						break;
					case 5:
						// Aquí se borra un pedido

						break;
					case 6:
						// Aquí se listan los pedidos de un cliente

						break;
					case 7:
						// Se cierra el programa
						System.out.println("Programa cerrado");
						break;
				}

			}

		}catch (Exception e) {
			System.out.println("Error general");
		}


	}

}
