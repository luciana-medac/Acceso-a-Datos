<%@ page import="java.util.*, com.example.demo.Reserva, com.example.demo.ServicioExtra" %>

<html>
<head>
    <title>Listado de Reservas</title>
</head>
<body>

<h1>Listado de Reservas</h1>

<% 
    List<Reserva> reservas = (List<Reserva>) request.getAttribute("reservas");
    if (reservas == null || reservas.isEmpty()) {
%>
        <p>No hay reservas registradas.</p>
<%
    } else {
        for (Reserva r : reservas) {
%>
            <hr>
            <p><strong>ID Reserva:</strong> <%= r.getId() %></p>
            <p><strong>Fecha:</strong> <%= r.getFecha() %></p>
            <p><strong>Cliente:</strong> <%= r.getIdCliente().getNombre() %></p>
            <p><strong>Mesa:</strong> <%= r.getIdMesa().getNumMesa() %></p>

            <p><strong>Servicios extra:</strong></p>
            <ul>
            <%
                for (ServicioExtra s : r.getServiciosExtras()) {
            %>
                    <li><%= s.getNombre() %></li>
            <%
                }
            %>
            </ul>
<%
        }
    }
%>

</body>
</html>
