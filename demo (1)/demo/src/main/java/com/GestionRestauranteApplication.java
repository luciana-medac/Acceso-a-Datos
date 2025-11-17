package com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class GestionRestauranteApplication {

	public static void main(String[] args) {

		SessionFactory SessionFactory = new Configuration().configure().buildSessionFactory();
		Session session;

		try {

			Scanner sc = new Scanner(System.in);
			int opcion = 0;

			while (opcion != 7) {

				System.out.println("============ RESERVAS RESTAURANTE ==============");
				System.out.println("1. Crear un restaurante");
				System.out.println("2. Crear Mesa");
				System.out.println("3. Crear un cliente");
				System.out.println("4. Crear una reserva");
				System.out.println("5. Crear un servicio extra");
				System.out.println("6. Asignar servicios a la reserva");
				System.out.println("7. Cambiar fecha de Reserva");
				System.out.println("8. Salir");
				System.out.println("Elige una opción: ");
				opcion = Integer.parseInt(sc.nextLine());

				switch (opcion) {
					case 1:
						// Crear el restaurante
						session = SessionFactory.openSession();
						session.beginTransaction();

						System.out.println("Introduce el nombre del cliente: ");
						String nRestaurante = sc.nextLine();

						Restaurante r1 = new Restaurante(nRestaurante);
						session.persist(r1);
						session.getTransaction().commit();
						session.close();

						System.out.println("Se ha añadido correctamente el restaurante: " + nRestaurante);

						break;
					case 2:
						// Crear mesas
						session = SessionFactory.openSession();
						session.beginTransaction();

						String opcion2 = "";

						do {

							System.out.println("Introduce el número de la mesa");
							int numMesa = Integer.parseInt(sc.nextLine());

							System.out.println("Introduce el ID del Restaurante: ");
							int idRestaurante = Integer.parseInt(sc.nextLine());

							Restaurante r = session.get(Restaurante.class, idRestaurante);

							Mesa m1 = new Mesa(numMesa, r);

							session.persist(m1);
							session.getTransaction().commit();
							session.close();

							if (r == null) {
								System.out.println("El Restaurante con ID: " + idRestaurante + " no existe");

							} else {
								System.out.println("Se ha creado correctamente la mesa");
							}

							System.out.println("¿Quieres añadir más mesas?s/n");
							opcion2 = sc.nextLine();

						} while (!opcion2.equals("n"));

						break;
					case 3:
						// Crear un cliente
						session = SessionFactory.openSession();
						session.beginTransaction();

						System.out.println("Introduce el nombre del cliente: ");
						String nCliente = sc.nextLine();

						System.out.println("Introduce el teléfono del cliente: ");
						double tCliente = Double.parseDouble(sc.nextLine());

						Cliente c1 = new Cliente(nCliente, tCliente);
						session.persist(c1);
						session.getTransaction().commit();
						session.close();

						System.out.println("Se ha añadido correctamente el cliente");

						break;
					case 4:
						// Crear una reserva
						session = SessionFactory.openSession();
						session.beginTransaction();

						System.out.println("Introduce el ID de la Mesa:");
						int idMesa = Integer.parseInt(sc.nextLine());

						System.out.println("Introduce el ID del Cliente: ");
						int idClienteR = Integer.parseInt(sc.nextLine());

						Mesa m = session.get(Mesa.class, idMesa);
						Cliente c = session.get(Cliente.class, idClienteR);

						System.out.println("Introduce el día: ");

						System.out.println("Introduce la fecha (dd/MM/yyyy): ");
						String fechaTexto = sc.nextLine();

						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaR = sdf.parse(fechaTexto);

						Reserva R1 = new Reserva(fechaR, m, c);

						if (m == null || c == null) {

							System.out.println("No se ha podido crear la reserva");

						} else {
							System.out.println("Se ha añadido correctamente la reserva");
						}

						break;
					case 5:
						// Crear un servicio extra
						session = SessionFactory.openSession();
						session.beginTransaction();

						String opcion3 = "";
						
						do {
							System.out.println("Introduce el nombre del servicio:");
							String nServicio = sc.nextLine();

							ServicioExtra s1 = new ServicioExtra(nServicio);

							session.persist(s1);
							session.getTransaction().commit();
							session.close();

							System.out.println("El servicio se ha encontrado correctamente");
							
							System.out.println("¿Quieres seguir creando servicios? s/n");
							opcion3 = sc.nextLine();

						} while (!opcion3.equals("n"));
						break;
					case 6:
						// Asignar servicios a la reserva
						session = SessionFactory.openSession();
						session.beginTransaction();

						System.out.println("Introduce el ID de la reserva:");
						int idRes = Integer.parseInt(sc.nextLine());

						Reserva reserva = session.get(Reserva.class, idRes);

						if (reserva == null) {
							System.out.println("No existe la reserva con ID: " + idRes);
							session.close();
							break;
						}

						String seguir = "";

						do {
							System.out.println("Introduce el ID del servicio extra que deseas añadir:");
							int idServ = Integer.parseInt(sc.nextLine());

							ServicioExtra serv = session.get(ServicioExtra.class, idServ);

							if (serv == null) {
								System.out.println("No existe el servicio con ID: " + idServ);
							} else {
								// Asignar servicio a la reserva
								reserva.getServiciosExtras().add(serv);

								// Si es bidireccional, también:
								serv.getReservas().add(reserva);

								System.out.println("Servicio añadido correctamente.");
							}

							System.out.println("¿Deseas asignar otro servicio? (s/n)");
							seguir = sc.nextLine();

						} while (!seguir.equalsIgnoreCase("n"));

						session.persist(reserva);
						session.getTransaction().commit();
						session.close();

						break;

					case 7:
						// Cambiar la fecha de la Reserva
						session = SessionFactory.openSession();
						session.beginTransaction();

						System.out.println("Introduce el ID de la reserva: ");

						System.out.println("Introduce la nueva fecha (dd/MM/yyyy): ");
						String fechaNueva = sc.nextLine();

						SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaRN = sdf1.parse(fechaNueva);

						Query q = session.createQuery(
								"UPDATE Reserva set fecha=:fecha where id=:id");
						
						q.setParameter("fecha", fechaNueva);
						q.executeUpdate();

						session.getTransaction().commit();
						session.close();

						System.out.println("Se ha actualizado correctamente la fecha");

						break;
					case 8:
						System.out.println("Programa cerrado: ");

						break;

					default:
						break;
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
