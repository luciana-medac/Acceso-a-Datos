package com.mycompany.mysqlcrub;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataBaseManager {
    
    private String url;
    private String user;
    private String password;
    private Connection conn;
    
    
    public DataBaseManager () throws SQLException{
        
        this.url = "jdbc:mysql://localhost:3306/tienda_db";
        this.user = "root";
        this.password = "Med@c";
        this.conn = DriverManager.getConnection(this.url, this.user, this.password);
        
    }
    
    public void cerrarConexion() throws SQLException {
        conn.close();
    }
    
    //CREAR UN NUEVO CLIENTE
    public void insertarCliente(String n, int e, String c) throws SQLException{
        
        String consulta = "INSERT INTO cliente(nombre, edad, ciudad) VALUES" +
                 " ('" + n + "','" + e + "','" + c + "');";
        
        PreparedStatement stmt = conn.prepareStatement(consulta);
        stmt.executeUpdate();
        
        stmt.close();
        System.out.println("se ha añadido con exito!");
       
    }
    
    //CREAR UN NUEVO PRODUCTO
    public void insertarProducto(String n, float p, String s) throws SQLException{
        
        String consulta = "INSERT INTO cliente(nombre, precio, stock) VALUES" +
                 " ('" + n + "','" + p + "','" + s+ "');";
        
        PreparedStatement stmt = conn.prepareStatement(consulta);
        stmt.executeUpdate();
        
        stmt.close();
        System.out.println("se ha añadido con exito!");
       
    }
    
    
    public void insertarPedido(int i) throws SQLException{
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActual = LocalDateTime.now().format(formato);
        
        String consulta = "INSERT INTO pedido(fecha, id_cliente) VALUES" +
                 " ('" + fechaActual + "','" + i + "');";
        
        PreparedStatement stmt = conn.prepareStatement(consulta);
        stmt.executeUpdate();
        
        stmt.close();
        
        System.out.println("se ha añadido el pedido!");
        
    }
    
    public void insertarPedidoProducto(int idPedido, int idProducto, int c) throws SQLException {
        
        String consulta = "INSERT INTO pedido_producto(id, precio, stock) VALUES" +
                 " ('" + idPedido + "','" + idProducto + "','" + c + "');";
        
        PreparedStatement stmt = conn.prepareStatement(consulta);
        stmt.executeUpdate();
        
        String consulta2 = "SELECT id_pedido, id_producto, cantidad FROM pedido_producto"
                + "WHERE id_pedido = " + idPedido;
        PreparedStatement stmt1 = conn.prepareStatement(consulta2);
        ResultSet rs = stmt1.executeQuery();
        
        
        
        String consulta3 = "SELECT stock FROM producto WHERE id=" + idProducto;
        PreparedStatement stmt2 = conn.prepareStatement(consulta3);
        ResultSet rs1 = stmt2.executeQuery();
        
        if(rs.next()){
            String consulta4 = "UPDATE producto SET stock=" + d + " WHERE id= " + p;
            PreparedStatement stmt3 = conn.prepareStatement(consulta2);
            stmt3.executeUpdate();
            stmt3.close();
            System.out.println("Stock modificado");
        } else {
            System.out.println("No se puede modificar el stock: no existe un producto"
                    + "con ese ID");
        
        
        
    }
    
    //CONSULTAR DETALLES DE UN PEDIDO POR ID
    
    
    //ELIMINAR UN PRODUCTO DE UN PEDIDO
    
    

}
