package com.mycompany.mysqlcrub;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataBaseManager {

    private String url;
    private String user;
    private String password;
    private Connection conn;

    public DataBaseManager() throws SQLException {

        this.url = "jdbc:mysql://localhost:3306/tienda_db";
        this.user = "root";
        this.password = "Medac";
        this.conn = DriverManager.getConnection(this.url, this.user, this.password);

    }

    public void cerrarConexion() throws SQLException {
        conn.close();
    }

    //CREAR UN NUEVO CLIENTE
    public void insertarCliente(String n, int e, String c) throws SQLException {

        String consulta = "INSERT INTO cliente(nombre, edad, ciudad) VALUES"
                + " ('" + n + "','" + e + "','" + c + "');";

        PreparedStatement stmt = conn.prepareStatement(consulta);
        stmt.executeUpdate();

        stmt.close();
        System.out.println("se ha añadido con exito!");

    }

    //CREAR UN NUEVO PRODUCTO
    public void insertarProducto(String n, float p, int s) throws SQLException {

        String consulta = "INSERT INTO producto(nombre, precio, stock) VALUES"
                + " ('" + n + "','" + p + "','" + s + "');";

        PreparedStatement stmt = conn.prepareStatement(consulta);
        stmt.executeUpdate();

        stmt.close();
        System.out.println("se ha añadido con exito!");

    }

    //CREAR UN NUEVO PEDIDO
    public int  insertarPedido(int i) throws SQLException {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActual = LocalDateTime.now().format(formato);

        String consulta = "INSERT INTO pedido(fecha, id_cliente) VALUES"
                + " ('" + fechaActual + "','" + i + "');";
        
        //RESTUN_GENERATED_KEYS --> sirve para obtener el ID del último elemento insertado en la tabla
        PreparedStatement stmt = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
        int filas = stmt.executeUpdate();
        int idGenerado = -1;
        
        if (filas > 0) {
            //Obtiene el ID del nuevo pedido
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1); //Devuelve el primer valor que genere
                System.out.println("Pedido insertado con ID: " + idGenerado);
            }
        }
        stmt.close();
        return idGenerado;
    }

    //CREAR UN DATO EN PEDIDO_PRODUCTO
    public void insertarPedidoProducto(int idPedido, int idProducto, int c) throws SQLException {
        
        String consulta = "INSERT INTO pedido_producto(id_pedido, id_producto, cantidad) VALUES"
                + " ('" + idPedido + "','" + idProducto + "','" + c + "');";

        PreparedStatement stmt = conn.prepareStatement(consulta);
        stmt.executeUpdate();
        stmt.close();
        
        //Con esta consulta saco el stock del producto 
        String consulta3 = "SELECT stock FROM producto WHERE id=" + idProducto;
        PreparedStatement stmt2 = conn.prepareStatement(consulta3);
        ResultSet rs1 = stmt2.executeQuery();
        int stock = 0;
        while (rs1.next()) {
            stock = rs1.getInt("stock");
        }
        
        //Con esta consulta compruebo si se ha añadido y saco la cantidad
        String consulta2 = "SELECT id_pedido, id_producto, cantidad FROM pedido_producto WHERE id_pedido = " + idPedido;
        PreparedStatement stmt1 = conn.prepareStatement(consulta2);
        ResultSet rs = stmt1.executeQuery();
        int cantidad = 0;
        boolean existePedido = false;
        while (rs.next()) {
            cantidad = rs.getInt("cantidad");
            existePedido = true;
        }
        
        //Si la consulta2 devuelve true, actualiza el stock en la tabla de producto
        if (existePedido) {
            String consulta4 = "UPDATE producto SET stock=" + (stock - cantidad) + " WHERE id= " + idProducto;
            PreparedStatement stmt3 = conn.prepareStatement(consulta4);
            stmt3.executeUpdate();
            stmt3.close();
            System.out.println("Stock modificado");
        } else {
            System.out.println("No se puede modificar el stock: no existe un producto con ese ID");
        }
        
        rs.close();
        stmt1.close();
        rs1.close();
        stmt2.close();
    }

    public void consultarPedido(int idPedido) throws SQLException {

        String consulta = " SELECT cli.nombre, cli.ciudad, p.fecha, pr.nombre as producto, pp.cantidad, pr.precio FROM cliente as cli\n"
                + "INNER JOIN pedido as p ON p.id_cliente = cli.id \n"
                + "INNER JOIN pedido_producto as pp ON pp.id_pedido = p.id\n"
                + "INNER JOIN producto as pr ON pp.id_producto = pr.id\n"
                + "Where p.id =" + idPedido + "; ";
        PreparedStatement stmt = conn.prepareStatement(consulta);
        ResultSet rs = stmt.executeQuery();

        String nombre = "";
        String ciudad = "";
        String fecha = "";
        List<String> listaProductos = new ArrayList<>();
        double totalPedido = 0;

        while (rs.next()) {
            //Sacar el nombre y ciudad del cliente y la fecha del pedido
            nombre = rs.getString("nombre");
            ciudad = rs.getString("ciudad");
            fecha = rs.getDate("fecha").toString();

            //Datos del producto
            String producto = rs.getString("producto");
            int cantidad = rs.getInt("cantidad");
            double precio = rs.getDouble("precio");

            //Añadimos el producto a la listaProductos
            listaProductos.add("- " + producto + " (" + cantidad + " uds) -  " + precio + "€");
            
            //Sumamos el total
            totalPedido += cantidad * precio;
        }
        
        stmt.close();
        
        System.out.println("\nCliente: " + nombre + " (" + ciudad + ")");
        System.out.println("Fecha del pedido: " + fecha);
        System.out.println("Productos:");
        for (String producto : listaProductos) {
            System.out.println(producto);
        }
        System.out.println("Total del pedido: " + totalPedido);
    }
    
    public void eliminarProducto(int idPedido, int idProducto) throws SQLException{
        
        String consulta = "DELETE FROM pedido_producto WHERE id_pedido= " + idPedido + " AND  id_producto =  " + idProducto + ";";
        PreparedStatement stmt = conn.prepareStatement(consulta);
        int filas = stmt.executeUpdate();
        
        if (filas > 0) {
            System.out.println("Eliminado con exito");
        } else {
            System.out.println("No se ha podido eliminar");
        }
        stmt.close();
    }

}
