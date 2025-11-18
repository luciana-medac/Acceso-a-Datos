package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.gestionRestaurante.demo.*;


public class ListarReservasServlet extends HttpServlet {

    private static SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Session session = sessionFactory.openSession();
        List<Reserva> reservas = session.createQuery("FROM Reserva", Reserva.class).list();
        session.close();

        // Enviar datos a la JSP
        req.setAttribute("listaReservas", reservas);

        // Redirigir
        req.getRequestDispatcher("listarReservas.jsp").forward(req, resp);
    }
}

