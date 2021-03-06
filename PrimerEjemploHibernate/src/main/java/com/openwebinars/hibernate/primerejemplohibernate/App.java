package com.openwebinars.hibernate.primerejemplohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Primer ejemplo con Hibernate Openwebinars.net
 *
 */
public class App {
	public static void main(String[] args) {
		// Inicializamos un objeto SessionFactory con la configuración
		// del fichero hibernate.cfg.xml
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// Iniciamos una sesión
		Session session = sf.openSession();

		// Construimos un objeto de tipo User
		User user1 = new User();
		user1.setId(1);
		user1.setUserName("Pepe");
		user1.setUserMessage("Hello world from Pepe");

		// Construimos otro objeto de tipo User
		User user2 = new User();
		user2.setId(2);
		user2.setUserName("Juan");
		user2.setUserMessage("Hello world from Juan");

		// Iniciamos una transacción dentro de la sesión
		session.beginTransaction();

		// Almacenamos los objetos
		session.save(user1);
		session.save(user2);

		// Commiteamos la transacción
		session.getTransaction().commit();

		// Cerramos todos los objetos
		session.close();
		sf.close();
	}
}
