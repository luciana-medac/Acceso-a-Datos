package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Ruta directa al archivo .odb
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("C:\\Users\\PC218\\Desktop\\objectdb-2.9.4\\db\\prueba.odb");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Departamento inf = new Departamento(1,"Informática");
        Departamento rrhh = new Departamento(2,"RRHH");

        // NUEVOS DEPARTAMENTOS 
        Departamento cont = new Departamento(3,"Contabilidad");
        Departamento inv = new Departamento(4, "Investigación");

        // CIUDADES
        Ciudad c1 = new Ciudad(1, "Madrid");
        Ciudad c2 = new Ciudad(2, "Valencia");
        Ciudad c3 = new Ciudad(3, "Burgos");
        Ciudad c4 = new Ciudad(4, "Sevilla");
        Ciudad c5 = new Ciudad(5, "Almeria");

        // AÑADIMOS LAS CIUDADES
        Empleado e1 = new Empleado(1,"Ana", 30, 1500, inf, c1);
        Empleado e2 = new Empleado(2,"Luis", 45, 2000, inf, c2);
        Empleado e3 = new Empleado(3,"Marta", 28, 1300, rrhh, c2);
        Empleado e4 = new Empleado(4,"Pedro", 32, 1200, rrhh, c5);

        // NUEVOS EMPLEADOS
        Empleado e5 = new Empleado(5,"Martin", 24, 2100, cont, c2);
        Empleado e6 = new Empleado(6,"Sara", 54, 1200, inv, c4);
        Empleado e7 = new Empleado(7,"Esperanza", 28, 1200, inv, c2);
        Empleado e8 = new Empleado(8,"Francisco", 46, 2000, cont, c3);

        // PERSONA
        Persona p1 = new Persona(1, "Florencia", 43);

        // PERSISTENTES DE CIUDAD
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(c5);

        em.persist(inf);
        em.persist(rrhh);

        // PERSISTENTES DEPARTAMENTOS AÑADIDOS
        em.persist(cont);
        em.persist(inv);

        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);

        // PERSISTENTES EMPLEADOS AÑADIDOS
        em.persist(e5);
        em.persist(e6);
        em.persist(e7);
        em.persist(e8);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Base de datos creada con éxito.");
    }
}