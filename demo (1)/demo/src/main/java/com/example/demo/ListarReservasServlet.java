package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listarReservas")
public class ListarReservasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Consulta HQL
            List<Reserva> reservas = session.createQuery(
                    "FROM Reserva r ORDER BY r.fecha DESC",
                    Reserva.class
            ).getResultList();

            // Enviar resultados al JSP
            request.setAttribute("reservas", reservas);

        } catch (Exception e) {
            request.setAttribute("error", "Error al obtener las reservas: " + e.getMessage());
        } finally {
            session.close();
        }

        // Redirige a la vista JSP
        request.getRequestDispatcher("listarReservas.jsp").forward(request, response);
    }
}

