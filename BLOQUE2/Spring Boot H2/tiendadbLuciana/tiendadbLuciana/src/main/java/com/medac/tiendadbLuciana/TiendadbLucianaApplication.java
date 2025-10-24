package com.medac.tiendadbLuciana;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendadbLucianaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendadbLucianaApplication.class, args);

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        try{
            
            //Creamos la clase DataBaseManager
            DataBaseManager dBm = new DataBaseManager();
            
            while(opcion != 6){
                
                System.out.println("-------------------MENÚ INTERACTIVO------------------");
                System.out.println("Elige una opción: ");
                System.out.println("1. Crear nuevo cliente");
                System.out.println("2. Crear nuevo producto");
                System.out.println("3. Resgistrar un nuevo pedido");
                System.out.println("4. Consultar detalles de un pedido");
                System.out.println("5. Eliminar un producto de un pedido");
                System.out.println("6. Salir");
                opcion = Integer.parseInt(sc.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce el nombre del cliente: ");
                        String nombre = sc.nextLine();
                        System.out.println("Introduce la edad: ");
                        int edad = Integer.parseInt(sc.nextLine());
                        System.out.println("Introduce la ciudad: ");
                        String ciudad = sc.nextLine();
                        
                        dBm.insertarCliente(nombre, edad, ciudad);
                        break;
                    case 2:
                        
                        System.out.println("Introduce nombre del producto ");
                        String nombreProducto = sc.nextLine();
                        System.out.println("Indica el precio: ");
                        float precio = Float.parseFloat(sc.nextLine());
                        System.out.println("Indica el stock:");
                        int stock = Integer.parseInt(sc.nextLine());
                        
                        dBm.insertarProducto(nombreProducto, precio, stock);
                        break;
                    case 3:
                        //Creamos el pedido
                        System.out.println("Introduce el ID del cliente: ");
                        int idCliente = Integer.parseInt(sc.nextLine());
                        //Insertamos en la tabla pedido_producto
                        String eleccion;
                        int idPedido = dBm.insertarPedido(idCliente);
                        do {
                            System.out.println("Introduce ID del producto: ");
                            int idProducto = Integer.parseInt(sc.nextLine());
                            System.out.println("Indica la cantidad: ");
                            int cantidad = Integer.parseInt(sc.nextLine());
                            dBm.insertarPedidoProducto(idPedido, idProducto, cantidad);
                            
                            System.out.println("¿Quieres seguir insertando productos? s/n");
                            eleccion = sc.nextLine();
                        } while (!eleccion.equalsIgnoreCase("n"));
                        break;
                    case 4:
                        
                        System.out.println("Introduce el ID del pedido que quieres consultar: ");
                        int idPedidoConsulta = Integer.parseInt(sc.nextLine());
                        dBm.consultarPedido(idPedidoConsulta);
                        break;
                        
                    case 5:
                        
                        System.out.println("Introduce el ID del pedido: ");
                        int idPedidoEliminar = Integer.parseInt(sc.nextLine());
                        System.out.println("Introduce el ID del producto");
                        int idProductoEliminar = Integer.parseInt(sc.nextLine());
                        
                        dBm.eliminarProducto(idPedidoEliminar, idProductoEliminar);
                        break;
                    case 6:
                        System.out.println("Programa cerrado");
                        dBm.cerrarConexion();
                        break;
                    default:
                        System.out.println("No has introducido una de las opciones");
                }
            } 
        } catch (NumberFormatException e){
            System.out.println("Error: introduce un número válido");
        } catch (SQLException ex){
            
            System.out.println(ex.getMessage());
            
        } catch (Exception e){
            System.out.println("Error desconocido: " + e.getMessage());
        }
	
	}
}
