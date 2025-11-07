package com.example.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class DemoApplication {

	public static void main(String[] args) {

		// Carga la configuración de Hibernate desde el archivo "hibernate.cfg.xml", lee
		// el archivo
		// y carga todas las propiedades: conexión, dialecto, mapeos, etc
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		try {
			Session session;
			// Iniciar transacción
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
						session = sessionFactory.openSession();
						session.beginTransaction();

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
						session = sessionFactory.openSession();
						session.beginTransaction();

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
						session = sessionFactory.openSession();
						session.beginTransaction();

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
						if (c == null || p == null) {
							System.out.println("El cliente o el producto no existe");
						} else {
							System.out.println("Se ha añadido el pedido correctamente");
						}
						break;
					case 4:
						session = sessionFactory.openSession();
						session.beginTransaction();

						System.out.println("Introduce el ID del producto: ");
						int idP = Integer.parseInt(sc.nextLine());
						System.out.println("Introduce el nuevo precio: ");
						double nuevoPrecio = Double.parseDouble(sc.nextLine());

						Query q = session.createQuery(
							"update Producto set precio=:precio where id=:id");

						q.setParameter("precio", nuevoPrecio);
						q.executeUpdate();
						session.getTransaction().commit();
						session.close();
						System.out.println("Se ha actualizado el precio");
						
						break;
					case 5:
						session = sessionFactory.openSession();
						session.beginTransaction();

						System.out.println("Introduce el ID del pedido: ");
						int idPed = Integer.parseInt(sc.nextLine());
						Pedido ped2 = session.get(Pedido.class, idPed);

						session.remove(ped2); //delete() está obsoleto --> se usa remove()
						session.getTransaction().commit();
						session.close();
						break;
					case 6:
						session = sessionFactory.openSession();
						session.beginTransaction();
						
						// Aquí se listan los pedidos de un cliente
						System.out.println("Introduce el ID del Cliente: ");
						int idCc2 = Integer.parseInt(sc.nextLine());

						List<Pedido> pedidos = session.createQuery(
							"FROM Pedido o WHERE o.customer.id =:id ORDER BY o.fecha DESC",
							Pedido.class)
							.setParameter("id", idCc2)
							.getResultList();
							for (Pedido pedido : pedidos) {
								Pedido o = (Pedido) pedido;
								System.out.println(
									"Pedido " + o.getId() +
									" - Producto: " + o.getProduct().getNombre() +
									" - Cantidad: " + o.getCantidad() +
									" - Importe: " + o.getImporte() +
									" - Fecha: " + o.getFecha()
								);
							}
							session.close();
						break;
					case 7:
						// Se cierra el programa
						System.out.println("Programa cerrado");
						break;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
